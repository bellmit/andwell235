package com.andawell.material.service.impl;

import com.andawell.common.entity.search.ListPageCommon;
import com.andawell.common.entity.vo.ListPageVo;
import com.andawell.common.util.BusinessException;
import com.andawell.common.util.FileUtils;
import com.andawell.common.util.SQLiteUtils;
import com.andawell.common.util.SysUserUtils;
import com.andawell.material.config.SQLiteConfig;
import com.andawell.material.dto.*;
import com.andawell.material.entity.*;
import com.andawell.material.enumeration.TableNameStyle;
import com.andawell.material.enumeration.WeholeNumberStyle;
import com.andawell.material.mapper.*;
import com.andawell.material.query.*;
import com.andawell.material.service.ITDbLtsqService;
import com.andawell.material.service.ZoneTransferService;
import com.andawell.material.util.BeanUtils;
import com.andawell.material.util.NumberUtils;
import com.andawell.material.util.Utils;
import com.andawell.material.vo.*;
import com.github.pagehelper.util.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static com.andawell.material.constant.NoticeConstant.RESPONSE_NOTFOUND_MESSAGE;


/***
 * @author hwd
 * @Date: 2020-05-22 14:28
 * @Description: 战区调拨
 * @version : V1.0
 */
@Service
@Slf4j
public class ZoneTransferServiceImpl implements ZoneTransferService {


    @Autowired
    private TDbLtsqMapper tDbLtsqMapper;


    @Autowired
    private TDbLtsqqdMapper tDbLtsqqdMapper;

    @Autowired
    private VDwMapper vDwMapper;

    @Autowired
    ITDbLtsqService itDbLtsqService;

    @Autowired
    ITDbLtsqService tDbLtsqService;

    @Autowired
    TQxDwMapper tQxDwMapper;

    @Autowired
    TDbSjsqMapper tDbSjsqMapper;

    @Autowired
    TDbSjsqqdMapper tDbSjsqqdMapper;

    @Autowired
    TDbZqdbMapper tDbZqdbMapper;

    @Autowired
    TDbZqdbqdMapper tDbZqdbqdMapper;

    @Value("${upload.path}")
    private String filepath;


    @Autowired
    TDbLtsqTempMapper tDbLtsqTempMapper;

    @Autowired
    TDbLtsqqdTempMapper tDbLtsqqdTempMapper;

    @Autowired
    TDbSjsqTempMapper tDbSjsqTempMapper;

    @Autowired
    TDbSjsqqdTempMapper tDbSjsqqdTempMapper;


    /**
     * 查询旅团调拨申请信息
     */
    public List<BursaryVO> getLTSQQDList(String bh) {
        if (bh.isEmpty()){
            throw new BusinessException("编号不能为空");
        }
        List<BursaryVO> put = new ArrayList<>();
        List<TDbLtsqqdMessageVO> getlist = tDbLtsqqdMapper.getlist(bh);
        if (getlist != null && getlist.size() > 0) {
            for (TDbLtsqqdMessageVO tDbLtsqqdMessageVO : getlist) {
                //封装库房信息
                List<BursaryVO> bursary = getBursary(tDbLtsqqdMessageVO, bh, tDbLtsqqdMessageVO.getJx(), tDbLtsqqdMessageVO.getJh());
                //tDbLtsqqdMessageVO.setBursaryVOs(bursary);
                bursary.stream().forEach((q) -> put.add(q));
            }
        }
        return put;
    }

    public Boolean packageMasterZQDB(TDbDbDTO tDbDbDTO, String number) {
        TDbZqdb tDbZqdb = BeanUtils.dtoTODO(tDbDbDTO, TDbZqdb.class);
        //调拨单号
        tDbZqdb.setDbdh(number);
        //获取调拨编号
        String dbbhNumber = getDBBHNumber(tDbZqdb.getDblx().toString());
        //调拨编号
        tDbZqdb.setDbbh(dbbhNumber);
        //下发状态 0未下发，1以下发
        tDbZqdb.setXfzt(WeholeNumberStyle.ZERO.getName());
        //处理状态 0未处理，1以处理 已处理
        tDbZqdb.setClzt(WeholeNumberStyle.ZERO.getName());
        //上传状态 0 1
        tDbZqdb.setCszt(WeholeNumberStyle.ZERO.getName());
        tDbZqdb.setRq(new Date());
        //封装发付单位 主信息表的发付单位是战区单位
        tDbZqdb.setFfdw(Integer.parseInt(getUserDW()));
        //封装接收单位
        tDbZqdb.setJsdw(tDbDbDTO.getSqdw());
        //封装申请单号
        tDbZqdb.setSqdh(tDbDbDTO.getLtsqdh());

        int i = tDbZqdbMapper.insertSelective(tDbZqdb);
        return i > 0 ? true : false;
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean saveTheaterAllocation(TheaterAllocationDTO theaterAllocationDTO) {
        //生成调拨单号
        String number = itDbLtsqService.getNumber();
        Boolean aBoolean = packageMasterZQDB(theaterAllocationDTO.getTDbDbDTO(), number);
        if (!aBoolean) {
            return false;
        }
        //调拨编号清单 明细表中的发付单位 如果战区能处理，发付单位对应页面的仓库id
        //不能处理 发付单位对应的是战区单位
        for (TDbDbqdDTO tDbDbqdDTO : theaterAllocationDTO.getTDbDbqdDTO()) {
            TDbZqdbqd tDbZqdbqd = BeanUtils.dtoTODO(tDbDbqdDTO, TDbZqdbqd.class);
            tDbZqdbqd.setZl(WeholeNumberStyle.ELEVEN.getName());
            tDbZqdbqd.setDbdh(number);
            //封装最迟发付时间
            tDbZqdbqd.setZcffrq(NumberUtils.getNextMonthDate());
            //封装接收单位
            tDbZqdbqd.setJsdw(theaterAllocationDTO.getTDbDbDTO().getSqdw() + "");
            //封装申请原因
            tDbZqdbqd.setSqyy(tDbDbqdDTO.getGhyy());
            boolean style = true;
            if (tDbDbqdDTO.getSjsq() != null && tDbDbqdDTO.getSjsq() > 0) {
                //上级申请
                tDbZqdbqd.setSjsq(WeholeNumberStyle.ONE.getName());
                //申请状态
                tDbZqdbqd.setSqzt(WeholeNumberStyle.ZERO.getName());
                //封装发付单位
                tDbZqdbqd.setFfdw(getUserDW());
                tDbZqdbqd.setSl(tDbDbqdDTO.getSjsq());
                //上级申请调拨单
                tDbZqdbqdMapper.insertSelective(tDbZqdbqd);
            }
            if (tDbDbqdDTO.getDcsl() != null && tDbDbqdDTO.getDcsl() > 0) {
                //不需要上级申请
                tDbZqdbqd.setSjsq(WeholeNumberStyle.ZERO.getName());
                //封装发付单位
                tDbZqdbqd.setFfdw(tDbDbqdDTO.getDwid());
                //封装数量
                tDbZqdbqd.setSl(tDbDbqdDTO.getDcsl());
                //旅团调拨单
                tDbZqdbqdMapper.insertSelective(tDbZqdbqd);
            }
        }
        //修改申请状态
        TDbLtsq tDbLtsq = new TDbLtsq();
        tDbLtsq.setClzt("2");
        tDbLtsq.setLtsqdh(theaterAllocationDTO.getTDbDbDTO().getLtsqdh());
        tDbLtsqMapper.updateByPrimaryKeySelective(tDbLtsq);
        return true;
    }

    @Override
    public ListPageVo<TDbLtsqQuery, TDbLtsqVO> getAllocationList(TDbLtsqQuery tDbLtsqQuery) {
        //测试
        //tDbLtsqQuery.setDwid(getUserDW());
        return new ListPageCommon<TDbLtsqQuery, TDbLtsqVO>(tDbLtsqQuery,
                (q) -> tDbLtsqMapper.getAllocationList(q)).getVo();
    }

    /**
     * 根据机型 件号  用户id  查询对应的库房信息
     *
     * @param jx
     * @param jh
     * @return
     */
    @Override
    public List<BursaryVO> getBursary(TDbLtsqqdMessageVO tDbLtsqqdMessageVO, String sqdh, String jx, String jh) {
        List<BursaryVO> bursary = tDbLtsqMapper.getBursary(getUserDW().substring(0, 2), jx, jh);
        AllotQuery allotQuery = new AllotQuery();
        if (bursary != null && bursary.size() > 0) {
            //封装可调拨数
            for (BursaryVO bursaryVO : bursary) {

                allotQuery.setFfdw(bursaryVO.getDwid());
                allotQuery.setUserdw(getUserDW());
                allotQuery.setJx(jx);
                allotQuery.setJh(jh);
                //查询总调拨数
                Integer toteDBSL = tDbZqdbqdMapper.getToteDBSL(allotQuery);
                //封装可调拨数
                bursaryVO.setSysl(bursaryVO.getZsl() == 0 || bursaryVO.getZsl() == null ? 0 : bursaryVO.getZsl() - toteDBSL);

                //封装调拨数量
                //查询是否有该调拨单
                allotQuery.setSqdh(sqdh);

                Integer dbSummber = tDbZqdbqdMapper.getDBSummber(allotQuery);
                bursaryVO.setDcsl(dbSummber == null ? 0 : dbSummber);
                //查询是否存在上级申请调拨单
                allotQuery.setFfdw(getUserDW());
                Integer sjsq = tDbZqdbqdMapper.getDBSummber(allotQuery);
                bursaryVO.setSjsq(sjsq == null ? 0 : sjsq);
                org.springframework.beans.BeanUtils.copyProperties(tDbLtsqqdMessageVO, bursaryVO);
            }
        } else {
            bursary = new ArrayList<>();
            bursary.add(BeanUtils.dtoTODO(tDbLtsqqdMessageVO, BursaryVO.class));

        }
        return bursary;
    }


    @Override
    public List<VDw> getUserBranchDw() {
        //获取用户id
        String deptId = getUserDW().substring(0, 2);
        //获取用户下属单位
        List<VDw> vDws = vDwMapper.getUserBranchDW(deptId);
        return vDws;
    }

    @Override
    public ListPageVo<TSjSqQuery, TDbJgdbVO> getTDbJgdbList(TSjSqQuery tSjSqQuery) {
        //查询数据库 T_DB_DB 首先按照登录人的dwid查询，在按照机型查询编号 找到qd表中 SJSQ等于1的数据
        tSjSqQuery.setFfdw(getUserDW());
        return new ListPageCommon<TSjSqQuery, TDbJgdbVO>(tSjSqQuery,
                (q) -> tDbZqdbqdMapper.getUpAskList(q)).getVo();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean saveSuperiorApplication(TDbsjSqDTO tDbsjSqDTO) {
        //在TDBSJSQ中 查询上一个bh
        String dbdh = getDBDHNumber();
        TDbSjsq tDbSjsq = BeanUtils.dtoTODO(tDbsjSqDTO, TDbSjsq.class);
        //封装调拨单号
        tDbSjsq.setDbdh(dbdh);
        //封装申请单号
        String sqdh = getSQDHNumber();
        tDbSjsq.setSqdh(sqdh);
        //封装处理状态 0 未处理
        tDbSjsq.setClzt(WeholeNumberStyle.ZERO.getName());
        //申请人
        tDbSjsq.setSqr(SysUserUtils.getUserId());
        //日期
        tDbSjsq.setRq(new Date());
        //调拨编号
        //tDbSjsq.setDbdh();
        //申请单位
        tDbSjsq.setSqdw(getUserDW());
        //下发状态
        tDbSjsq.setXfzt(WeholeNumberStyle.ZERO.getName());
        //未处理
        tDbSjsq.setClzt(WeholeNumberStyle.ZERO.getName());
        //未上传
        tDbSjsq.setSczt(WeholeNumberStyle.ZERO.getName());
        tDbSjsqMapper.insertSelective(tDbSjsq);
        for (TDbSjsqQdDTO tDbSjsqQdDTO : tDbsjSqDTO.getTDbSjsqQdDTOS()) {
            //封装明细
            TDbSjsqqd tDbSjsqqd = BeanUtils.dtoTODO(tDbSjsqQdDTO, TDbSjsqqd.class);
            //封装调拨单号
            tDbSjsqqd.setDbdh(dbdh);
            //封装发付单位
            tDbSjsqqd.setFfdw(getUserDW());
            //封装申请单号
            tDbSjsqqd.setSqdh(sqdh);
            //封装日期
            tDbSjsqqd.setRq(new Date());
            tDbSjsqqdMapper.insertSelective(tDbSjsqqd);
            //修改T_DB_zqdbQD中的状态
            TDbZqdbqd tDbZqdbqd = BeanUtils.dtoTODO(tDbSjsqQdDTO, TDbZqdbqd.class);

            tDbZqdbqd.setFfdw(getUserDW());
            //已上传
            tDbZqdbqd.setSqzt(WeholeNumberStyle.ONE.getName());
            tDbZqdbqdMapper.updateByPrimaryKeySelective(tDbZqdbqd);
        }
        return true;
    }

    /**
     * 手动修改战区调拨状态 改为已处理
     *
     * @param reviseZqDbDTOS
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean updateSuperior(List<ReviseZqdbDTO> reviseZqDbDTOS) {
        List<TDbZqdb> tDbZqdbs = BeanUtils.copyList(reviseZqDbDTOS, TDbZqdb.class);
        try {
            for (TDbZqdb tDbZqdb : tDbZqdbs) {
                tDbZqdb.setClzt("1");
                int i = tDbZqdbMapper.updateByPrimaryKeySelective(tDbZqdb);
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
            throw new BusinessException(String.format(RESPONSE_NOTFOUND_MESSAGE));
        }

        return true;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean fileLTLeading(HttpServletResponse response, List<DeliverDTO> deliverDTOS) {
        TDbLtsqQuery tDbLtsqQuery = new TDbLtsqQuery();
        //初始化参数
        SQLiteConfig.initial();
        Boolean copy = FileUtils.copy();
        if (copy) {
            try {
                for (DeliverDTO deliverDTO : deliverDTOS) {
                    //根据调拨单号查询T_DB_LTSQ
                    tDbLtsqQuery.setLtsqdh(deliverDTO.getLtsqdh());
                    List<TDbLtsq> tDbLtsqs = tDbLtsqMapper.selectByQuery(tDbLtsqQuery);
                    //修改为已下发
                    //正常情况下这个list为一个值
                    SQLiteUtils.transmission(tDbLtsqs, TableNameStyle.T_DB_LTSQ.getName());
                    // 通过调拨单号找到清单表中数据
                    List<TDbLtsqqd> tDbLtsqqds = tDbLtsqqdMapper.list(tDbLtsqQuery);
                    SQLiteUtils.transmission(tDbLtsqqds, TableNameStyle.T_DB_LTSQQD.getName());
                }
                FileUtils.download(response);
                //删除数据db
                FileUtils.deleteFile();
            } catch (Exception e) {
                e.printStackTrace();
                log.error(e.getMessage());
                throw new BusinessException("下发失败");
            }
        }
        return null;

    }

    @Override
    public Boolean saveSuperiorApplication(TheaterAllocationDTO theaterAllocationDTO) {
        //生成调拨单号
        String number = itDbLtsqService.getNumber();
        AllotQuery allotQuery = new AllotQuery();
        Boolean aBoolean = packageMasterZQDB(theaterAllocationDTO.getTDbDbDTO(), number);
        if (!aBoolean) {
            return false;
        }
        //调拨编号清单 明细表中的发付单位 如果战区能处理，发付单位对应页面的仓库id
        //不能处理 发付单位对应的是战区单位
        for (TDbDbqdDTO tDbDbqdDTO : theaterAllocationDTO.getTDbDbqdDTO()) {
            TDbZqdbqd tDbZqdbqd = BeanUtils.dtoTODO(tDbDbqdDTO, TDbZqdbqd.class);
            tDbZqdbqd.setZl(WeholeNumberStyle.ELEVEN.getName());
            tDbZqdbqd.setDbdh(number);
            //封装最迟发付时间
            tDbZqdbqd.setZcffrq(NumberUtils.getNextMonthDate());
            //封装接收单位
            tDbZqdbqd.setJsdw(theaterAllocationDTO.getTDbDbDTO().getSqdw() + "");
            //封装申请原因
            tDbZqdbqd.setSqyy(tDbDbqdDTO.getGhyy());
            //查询是否已经存储了调拨单 根据 jx jh dbdh zl ffdw
            //封装查询条件
            allotQuery.setJh(tDbDbqdDTO.getJh());
            allotQuery.setJx(tDbDbqdDTO.getJx());
            allotQuery.setDbdh(number);
            allotQuery.setFfdw(getUserDW());
            allotQuery.setZl(WeholeNumberStyle.ELEVEN.getName());
            Integer isExistByPrimaryKey = tDbZqdbqdMapper.getIsExistByPrimaryKey(allotQuery);
            if (isExistByPrimaryKey != null && isExistByPrimaryKey > 0) {
                continue;
            }
            //生成上级申请调拨单
            //上级申请
            tDbZqdbqd.setSjsq(WeholeNumberStyle.ONE.getName());
            //申请状态
            tDbZqdbqd.setSqzt(WeholeNumberStyle.ZERO.getName());
            //封装发付单位
            tDbZqdbqd.setFfdw(getUserDW());
            //封装数量
            if (StringUtil.isNotEmpty(tDbDbqdDTO.getSqsl())) {
                tDbZqdbqd.setSl(Integer.parseInt(tDbDbqdDTO.getSqsl()));
                //上级申请调拨单
                tDbZqdbqdMapper.insertSelective(tDbZqdbqd);
            }
        }
        //修改申请状态
        TDbLtsq tDbLtsq = new TDbLtsq();
        tDbLtsq.setClzt("2");
        tDbLtsq.setLtsqdh(theaterAllocationDTO.getTDbDbDTO().getLtsqdh());
        tDbLtsqMapper.updateByPrimaryKeySelective(tDbLtsq);
        return true;

    }

    @Override
    public Boolean fileJGLeading(HttpServletResponse response, List<DeliverDTO> deliverDTOS) {
        TDbSjsqQuery tDbLtsqQuery = new TDbSjsqQuery();
        TDbSjsqqdQuery tDbSjsqqdQuery = new TDbSjsqqdQuery();
        //初始化参数
        SQLiteConfig.initial();
        //拷贝db文件
        Boolean copy = FileUtils.copy();
        if (copy) {
            try {
                for (DeliverDTO deliverDTO : deliverDTOS) {
                    //根据调拨单号查询T_DB_LTSQ
                    tDbLtsqQuery.setSqdh(deliverDTO.getLtsqdh());
                    tDbSjsqqdQuery.setSqdh(deliverDTO.getLtsqdh());
                    List<TDbSjsq> tDbLtsqs = tDbSjsqMapper.selectByQuery(tDbLtsqQuery);
                    //正常情况下这个list为一个值
                    for (TDbSjsq tDbSjsq : tDbLtsqs) {
                        tDbSjsq.setSczt(WeholeNumberStyle.ONE.getName());
                        //修改状态 已上传
                        tDbSjsqMapper.updateByPrimaryKeySelective(tDbSjsq);
                    }
                    SQLiteUtils.transmission(tDbLtsqs, TableNameStyle.T_DB_SJSQ.getName());
                    //通过调拨单号找到清单表中数据
                    List<TDbSjsqqd> tDbLtsqqds = tDbSjsqqdMapper.selectByQuery(tDbSjsqqdQuery);
                    SQLiteUtils.transmission(tDbLtsqqds, TableNameStyle.T_DB_SJSQQD.getName());
                }
                FileUtils.download(response);
                //删除db文件
                FileUtils.deleteFile();
            } catch (Exception e) {
                e.printStackTrace();
                log.error(e.getMessage());
                throw new BusinessException("下发失败");
            }

        }

        return null;
    }


    public String getUserDW() {
        return SysUserUtils.getUser().getDeptId();
    }

    /**
     * T_DB_SJSQ调拨单号获取
     *
     * @return
     */
    public String getDBDHNumber() {
        String sbf = "DB-LH" + Utils.getSysYear();
        TDbSjsq tDbSjsq = this.getsjsq(sbf, "1");
        String number = NumberUtils.getdbdhnumber(tDbSjsq == null ? null : tDbSjsq.getDbdh());
        return number;
    }

    /**
     * 上级申请申请单号
     *
     * @return
     */
    public String getSQDHNumber() {
        Calendar date = Calendar.getInstance();
        //获取用户单位简码
        String user = SysUserUtils.getUser().getDeptId();
        //判断是机关还是战区 1.是旅团申请，2.是工厂，3.是机关
        String str = "HCSQ" + date.get(Calendar.YEAR) + user;
        //查询最新的
        TDbSjsq tDbSjsq = this.getsjsq(str, "2");
        if (tDbSjsq == null) {
            return str + "001";
        }
        String sqdh = tDbSjsq.getSqdh();
        String substring = sqdh.substring(sqdh.length() - 3, sqdh.length());
        Integer integer = Integer.valueOf(substring);
        integer++;
        return str + String.format("%03d", integer);
    }

    public TDbSjsq getsjsq(String sbf, String type) {
        return tDbSjsqMapper.selectByNew(sbf, type);
    }

    /**
     * 上级申请调拨编号
     *
     * @return
     */
    public String getDBBHNumber(String type) {
        StringBuffer dbBh = NumberUtils.getDBBhPrefix(type);
        //获取在上级申请中的上一个调拨编号
        TDbSjsq getsjsq = this.getsjsq(dbBh.toString(), "3");
        String documentNo = NumberUtils.getDocumentNo(dbBh, getsjsq == null ? null : getsjsq.getDbbh().toString());
        return documentNo;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<TDbLtsqAndQDVO> FileLTUpload(MultipartFile multipartFile) {
        //读取db文件数据
        List<TDbLtsqAndQDVO> put = new ArrayList<>();
        try {
            //上传文件
            String upload1 = FileUtils.upload(multipartFile, filepath);
            SQLiteUtils.setPath(upload1);
            //将db中的数据取出
            List<TDbLtsq> upload = SQLiteUtils.upload(new TDbLtsq(), TableNameStyle.T_DB_LTSQ.getName(), upload1);
            List<TDbLtsqqd> tDbLtsqqds = SQLiteUtils.upload(new TDbLtsqqd(), TableNameStyle.T_DB_LTSQQD.getName(), upload1);
            for (TDbLtsq tDbLtsq : upload) {
                TDbLtsqAndQDVO tDbLtsqAndQDVO = BeanUtils.dtoTODO(tDbLtsq, TDbLtsqAndQDVO.class);
                //inset
//                tDbLtsqTempMapper.insertSelective(BeanUtils.dtoTODO(tDbLtsq, TDbLtsqTemp.class));
                List<TDbLtsqqd> collect = tDbLtsqqds.stream().filter((q) -> {
                    return q.getLtsqdh().equals(tDbLtsq.getLtsqdh());
                }).collect(Collectors.toList());
                tDbLtsqAndQDVO.setTDbLtsqqds(collect);
                put.add(tDbLtsqAndQDVO);
            }
//            for (TDbLtsqqd tDbLtsqqd : tDbLtsqqds) {
////                tDbLtsqqdTempMapper.insertSelective(BeanUtils.dtoTODO(tDbLtsqqd, TDbLtsqqdTemp.class));
//            }
            //存入
//            List<TDbSjsq> upload2 = SQLiteUtils.upload(new TDbSjsq(), TableNameStyle.T_DB_SJSQ.getName(), upload1);
//            List<TDbSjsqqd> tDbSjsqqds = SQLiteUtils.upload(new TDbSjsqqd(), TableNameStyle.T_DB_SJSQQD.getName(), upload1);
//            for (TDbSjsq tDbSjsq : upload2) {
//                //update
//                tDbSjsqTempMapper.insertSelective(BeanUtils.dtoTODO(tDbSjsq, TDbSjsqTemp.class));
//            }
//            for (TDbSjsqqd tDbSjsqqd : tDbSjsqqds) {
//                tDbSjsqqdTempMapper.insertSelective(BeanUtils.dtoTODO(tDbSjsqqd, TDbSjsqqdTemp.class));
//            }

            //删除临时db
            FileUtils.deleteFile(upload1);
        } catch (Exception e) {
            e.printStackTrace();
            throw new BusinessException("导入失败");
        }
        return put;
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public  List<TDbSjsqAndQDVO> FileSJUpload(MultipartFile multipartFile) {
        //读取db文件数据
        List<TDbSjsqAndQDVO> put = new ArrayList<>();
        try {
            //上传文件
            String upload1 = FileUtils.upload(multipartFile, filepath);
            SQLiteUtils.setPath(upload1);
            //将db中的数据取出
            List<TDbSjsq> upload2 = SQLiteUtils.upload(new TDbSjsq(), TableNameStyle.T_DB_SJSQ.getName(), upload1);
            List<TDbSjsqqd> tDbSjsqqds = SQLiteUtils.upload(new TDbSjsqqd(), TableNameStyle.T_DB_SJSQQD.getName(), upload1);
            for (TDbSjsq tDbSjsq : upload2) {
                TDbSjsqAndQDVO tDbSjsqAndQDVO = BeanUtils.dtoTODO(tDbSjsq, TDbSjsqAndQDVO.class);
                List<TDbSjsqqd> collect = tDbSjsqqds.stream().filter((q) -> {
                    return q.getSqdh().equals(tDbSjsq.getSqdh());
                }).collect(Collectors.toList());
                tDbSjsqAndQDVO.setTDbSjsqqds(collect);
                put.add(tDbSjsqAndQDVO);
            }

            //删除临时db
            FileUtils.deleteFile(upload1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return put;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean saveMessage(ZQSaveDTO zqSaveDTO) {
        //将信息保存到逻辑库中
        try {
            if (zqSaveDTO.getStyle().equals("1")) {
                //将ltsq的数据存入到逻辑库和历史库中
                List<TDbLtsqAndQDVO> tDbLtsqAndQDVOS = zqSaveDTO.getTDbLtsqAndQDVOS();
                for (TDbLtsqAndQDVO tDbLtsqAndQDVO : tDbLtsqAndQDVOS) {
                    //将数据保存到逻辑库中
                    TDbLtsq tDbLtsq = BeanUtils.dtoTODO(tDbLtsqAndQDVO, TDbLtsq.class);
                    try {
                        tDbLtsqMapper.insertSelective(tDbLtsq);
                    }catch (Exception e)
                    {
                        tDbLtsqMapper.updateByPrimaryKeySelective(tDbLtsq);
                    }

                    //将数据加入到历史表中
                    TDbLtsqTemp tDbLtsqTemp = BeanUtils.dtoTODO(tDbLtsqAndQDVO, TDbLtsqTemp.class);
                    try {
                        tDbLtsqTempMapper.insertSelective(tDbLtsqTemp);
                    }catch (Exception e)
                    {
                        tDbLtsqTempMapper.updateByPrimaryKeySelective(tDbLtsqTemp);
                    }

                    //将对应的清单数据保存到数据库
                    for (TDbLtsqqd tDbLtsqqd : tDbLtsqAndQDVO.getTDbLtsqqds()) {
                        //存入逻辑库
                        try {
                            tDbLtsqqdMapper.insertSelective(tDbLtsqqd);
                        }catch (Exception e)
                        {
                            tDbLtsqqdMapper.updateByPrimaryKeySelective(tDbLtsqqd);
                        }

                        //存入历史表
                        TDbLtsqqdTemp tDbLtsqqdTemp = BeanUtils.dtoTODO(tDbLtsqqd, TDbLtsqqdTemp.class);
                        try {
                            tDbLtsqqdTempMapper.insertSelective(tDbLtsqqdTemp);
                        }catch (Exception e)
                        {
                            tDbLtsqqdTempMapper.updateByPrimaryKeySelective(tDbLtsqqdTemp);
                        }

                    }
                }
            } else if (zqSaveDTO.getStyle().equals("2")) {
                //将sjsq的数据存入到历史库中,并且修改逻辑库中数据
                List<TDbSjsqAndQDVO> tDbSjsqAndQDVOS = zqSaveDTO.getTDbSjsqAndQDVOS();
                for (TDbSjsqAndQDVO tDbSjsqAndQDVO : tDbSjsqAndQDVOS) {
                    //将逻辑库中数据进行修改
                    tDbSjsqMapper.updateByPrimaryKeySelective(BeanUtils.dtoTODO(tDbSjsqAndQDVO, TDbSjsq.class));
                    //将数据存入到历史库中
                    try {
                        tDbSjsqTempMapper.insertSelective(BeanUtils.dtoTODO(tDbSjsqAndQDVO, TDbSjsqTemp.class));
                    }catch (Exception e)
                    {
                        tDbSjsqTempMapper.updateByPrimaryKeySelective(BeanUtils.dtoTODO(tDbSjsqAndQDVO, TDbSjsqTemp.class));
                    }

                    for (TDbSjsqqd tDbSjsqqd : tDbSjsqAndQDVO.getTDbSjsqqds()) {
                        //将逻辑库中数据进行修改
                        tDbSjsqqdMapper.updateByPrimaryKeySelective(tDbSjsqqd);
                        //将信息存入到历史库中
                        try {
                            tDbSjsqqdTempMapper.insertSelective(BeanUtils.dtoTODO(tDbSjsqqd, TDbSjsqqdTemp.class));
                        }catch (Exception e)
                        {
                            tDbSjsqqdTempMapper.updateByPrimaryKeySelective(BeanUtils.dtoTODO(tDbSjsqqd, TDbSjsqqdTemp.class));
                        }

                    }
                }
            } else {
                return false;
            }
        }catch (Exception e)
        {
            e.printStackTrace();
            log.error(e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean deleteMessage(List<String> sqdh, String style) {
        if (style.equals("1")) {
            for (String s : sqdh) {
                tDbLtsqTempMapper.deleteByPrimaryKey(s);
                tDbLtsqqdTempMapper.deleteByPrimaryKey(s);
            }

        } else if (style.equals("2")) {
            for (String s : sqdh) {
                tDbSjsqTempMapper.deleteByPrimaryKey(s);
                tDbSjsqqdTempMapper.deleteBySQDH(s);
            }
        }

        return true;
    }


}
