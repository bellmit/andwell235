package com.andawell.purchase.service.impl;

import com.andawell.common.util.*;
import com.andawell.purchase.config.SQLLIteConfig;
import com.andawell.purchase.config.SQLiteInstance;
import com.andawell.purchase.dto.TCkCrkXfDTO;
import com.andawell.purchase.dto.THtDTO;
import com.andawell.purchase.dto.THtXfDTO;
import com.andawell.purchase.entity.*;
import com.andawell.purchase.enumeration.SqlLiteTableNameEnum;
import com.andawell.purchase.mapper.*;
import com.andawell.purchase.service.OrgansBrigadeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * @Author:gzh
 * @Date:2020/5/29
 * @Version:V1.0.0
 */
@Service
@Slf4j
public class OrgansBrigadeServiceImpl implements OrgansBrigadeService {

    @Autowired
    THtMapper tHtMapper;

    @Autowired
    THtQdMapper tHtQdMapper;

    @Autowired
    THtTempMapper tHtTempMapper;

    @Autowired
    THtQdTempMapper tHtQdTempMapper;

    @Autowired
    THtDhMapper tHtDhMapper;

    @Autowired
    THtDhqdMapper tHtDhqdMapper;

    @Autowired
    TCkCrkDrTempMapper tCkCrkDrTempMapper;

    @Autowired
    TCkCrkqdDrTempMapper tCkCrkqdDrTempMapper;

    @Autowired
    TCkCrkMapper tCkCrkMapper;

    @Autowired
    TCkCrkqdMapper tCkCrkqdMapper;

    @Autowired
    SQLLIteConfig sqllIteConfig;

    @Value("${upload.path}")
    private String filepath;

    /**
     * 机关生成合同下发旅团返回DB文件
     *初始 sqlit path
     * 清除数据  db文件中对应表的数据
     * 遍历tHtXfDTOS 根据T_HT表主键查出对应数据
     * 根据T_HT表主键去T_HT_QD表查出对应数据
     * @param response
     * @param tHtXfDTOS
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean transmission(HttpServletResponse response, ValidableList<THtXfDTO> tHtXfDTOS) {
        try {

            // 初始 sqlit path
            String downloadPath = initCopyUserDbPathAndGet();

            //清除数据  db文件中对应表的数据
            SQLiteUtils.closezb(SqlLiteTableNameEnum.T_HT.getCode());
            SQLiteUtils.closezb(SqlLiteTableNameEnum.T_HT_QD.getCode());
            //遍历tHtXfDTOS 根据T_HT表主键查出对应数据
            for (THtXfDTO tHtXfDTO : tHtXfDTOS) {
                THt tHt = tHtMapper.selectByPrimaryKey(tHtXfDTO.getHth(), tHtXfDTO.getJhbh());
                //根据T_HT表主键去T_HT_QD表查出对应数据
                List<THtQd> tHtQds = tHtQdMapper.selectListByPrimaryHthJhbh(tHt.getHth(), tHt.getJhbh());
                SQLiteInstance.getInstance().transmission(tHt,SqlLiteTableNameEnum.T_HT.getCode());
                for (THtQd tHtQd :tHtQds) {
                    SQLiteInstance.getInstance().transmission(tHtQd,SqlLiteTableNameEnum.T_HT_QD.getCode());
                }
            }
            FileUtils.downloadByLocalPath(response,downloadPath);
            FileUtils.deleteFile(downloadPath);
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            log.info(e.getMessage());
        }
        return null;
    }

    /**
     * 旅团合同入库单上报
     *清除数据  db文件中对应表的数据
     * 遍历tCkCrkXfDTOS 根据T_CK_CRK.表主键查出对应数据
     * 根据bh 查  T_CK_CRKqd表对应数据
     * 根据HTBH 查  T_HT_DH表对应数据
     * 根据HTBH 查  T_HT_DHQD表对应数据
     * @param response
     * @param tCkCrkXfDTOS
     */
    @Override
    public Boolean ntransmission(HttpServletResponse response, ValidableList<TCkCrkXfDTO> tCkCrkXfDTOS) {
        try {
            String downloadPath = initCopyUserDbPathAndGet();
            // FileUtils.createDbFile();
            //清除数据  db文件中对应表的数据
            SQLiteUtils.closezb(SqlLiteTableNameEnum.T_HT_DH.getCode());
            SQLiteUtils.closezb(SqlLiteTableNameEnum.T_HT_DHQD.getCode());
            SQLiteUtils.closezb(SqlLiteTableNameEnum.T_CK_CRK.getCode());
            SQLiteUtils.closezb(SqlLiteTableNameEnum.T_CK_CRKQD.getCode());
            //遍历tCkCrkXfDTOS 根据T_CK_CRK.表主键查出对应数据
            for (TCkCrkXfDTO oneTCkCrk: tCkCrkXfDTOS) {
                TCkCrk tCkCrk = tCkCrkMapper.selectByPrimaryKey(oneTCkCrk.getBh(),oneTCkCrk.getDwid());
                SQLiteUtils.transmission(tCkCrk,SqlLiteTableNameEnum.T_CK_CRK.getCode());
                //根据bh 查  T_CK_CRKqd表对应数据
                List<TCkCrkqd> tCkCrkqds = tCkCrkqdMapper.selectByBh(oneTCkCrk.getBh());
                for (TCkCrkqd oneTCkCrkqd: tCkCrkqds) {
                    SQLiteUtils.transmission(oneTCkCrkqd,SqlLiteTableNameEnum.T_CK_CRKQD.getCode());
                }
                //根据HTBH 查  T_HT_DH表对应数据
                THtDh tHtDh = tHtDhMapper.selectByPrimaryKey(oneTCkCrk.getYj());
                if(tHtDh == null){
                    throw new Exception("合同不存在，无法上报，请选择合同入库单数据");
                }
                SQLiteUtils.transmission(tHtDh,SqlLiteTableNameEnum.T_HT_DH.getCode());
                //根据HTBH 查  T_HT_DHQD表对应数据
                List<THtDhqd> tHtDhqds =  tHtDhqdMapper.selectByHtbh(oneTCkCrk.getYj());
                for (THtDhqd oneththdq:tHtDhqds) {
                    SQLiteUtils.transmission(oneththdq,SqlLiteTableNameEnum.T_HT_DHQD.getCode());
                }

            }
            FileUtils.downloadByLocalPath(response,downloadPath);
            FileUtils.deleteFile(downloadPath);
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            log.info(e.getMessage());
        }
        return null;
    }

    /**
     * 合同，旅团接收数据
     *
     * @param multipartFile
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean ltReceiveData(MultipartFile multipartFile) {
        List<THt> hts=null;
        List<THtQd> htQdList=null;
        String upload1 = FileUtils.upload(multipartFile,filepath);
        try {
            //将db文件中数据存放到临时库中，存放之前先删除[全部删除]
/*            tHtTempMapper.deleteAll();
            tHtQdTempMapper.deleteAll();*/
            //查询db文件中的信息
            SQLiteUtils.setPath(upload1);
            hts = SQLiteUtils.upload(new THt(), SqlLiteTableNameEnum.T_HT.getCode(),upload1);
            htQdList = SQLiteUtils.upload(new THtQd(), SqlLiteTableNameEnum.T_HT_QD.getCode(),upload1);
            for (THt tHt : hts) {
                THtTemp tHtTemp =  BeanUtils.dtoTODO(tHt, THtTemp.class);
                THtTemp tHtTemp1 = tHtTempMapper.selectByPrimaryKey(tHtTemp.getHth(),tHtTemp.getJhbh());
                if(tHtTemp1 == null){
                    tHtTempMapper.insertSelective(tHtTemp);
                }else {
                    tHtTempMapper.updateByPrimaryKey(tHtTemp);
                }
            }
            for (THtQd tHtQd : htQdList) {

                THtQdTemp tHtQdTemp =  BeanUtils.dtoTODO(tHtQd, THtQdTemp.class);
                THtQdTemp tHtQdTemp1 = tHtQdTempMapper.selectByPrimaryKey(tHtQd.getHth(),
                        tHtQd.getJhbh(),
                        tHtQd.getJx(),tHtQd.getJh());
                if(tHtQdTemp1 == null){
                    tHtQdTempMapper.insertSelective(tHtQdTemp);
                }else {
                    tHtQdTempMapper.updateByPrimaryKey(tHtQdTemp);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.info(e.getMessage());
            throw new BusinessException("导入错误");
        }
        return true;
    }

    /**
     * 采购数据机关接收
     *
     * @param multipartFile
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean jgReceiveCgData(MultipartFile multipartFile) {
        List<TCkCrk> crkList=null;
        List<TCkCrkqd> crkqdList=null;
        String upload1 = FileUtils.upload(multipartFile,filepath);
        try {
            //将db文件中数据存放到临时库中，存放之前先删除[全部删除]
/*            tHtTempMapper.deleteAll();
            tHtQdTempMapper.deleteAll();*/
            //查询db文件中的信息
            SQLiteUtils.setPath(upload1);
            crkList = SQLiteUtils.upload(new TCkCrk(), SqlLiteTableNameEnum.T_CK_CRK.getCode(),upload1);
            crkqdList = SQLiteUtils.upload(new TCkCrkqd(), SqlLiteTableNameEnum.T_CK_CRKQD.getCode(),upload1);

            for (TCkCrk ckCrk : crkList) {
                TCkCrkDrTemp ckCrkDrTemp =  BeanUtils.dtoTODO(ckCrk, TCkCrkDrTemp.class);
                TCkCrkDrTemp tCkCrkDrTemp = tCkCrkDrTempMapper.selectByPrimaryKey(ckCrk.getBh(),
                        ckCrk.getDwid());
                if(tCkCrkDrTemp == null){
                    tCkCrkDrTempMapper.insertSelective(ckCrkDrTemp);
                }else {
                    tCkCrkDrTempMapper.updateByPrimaryKey(ckCrkDrTemp);
                }
            }
            for (TCkCrkqd tCkCrkqd : crkqdList) {

                TCkCrkqdDrTemp ckCrkDrTemp =  BeanUtils.dtoTODO(tCkCrkqd, TCkCrkqdDrTemp.class);
                TCkCrkqdDrTemp tCkCrkqdDrTemp = tCkCrkqdDrTempMapper.selectByPrimaryKey(tCkCrkqd.getBh(),
                        tCkCrkqd.getJh(),
                        tCkCrkqd.getJx(),
                        tCkCrkqd.getXh(),
                        tCkCrkqd.getCxsgin(),
                        tCkCrkqd.getDwid(),
                        tCkCrkqd.getXz());
                if(tCkCrkqdDrTemp == null){
                    tCkCrkqdDrTempMapper.insertSelective(ckCrkDrTemp);
                }else {
                    tCkCrkqdDrTempMapper.updateByPrimaryKey(ckCrkDrTemp);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.info(e.getMessage());
            throw new BusinessException("不可重复导入");
        }
        return true;
    }

    /**
     * 保存下发数据
     *
     * @param list
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean saveReceiveData(List<THtDTO> list) {
       // 保存数据
        for (THtDTO tHtDTO : list) {


            List<THtQdTemp> tHtQdTempList =
                    tHtQdTempMapper.getList(tHtDTO.getHth(),tHtDTO.getJhbh());

            tHtQdTempList.stream().forEach(this::accept);
            THtDh tHtDh = new THtDh();

            org.springframework.beans.BeanUtils.copyProperties
                    (tHtDTO, tHtDh);
            tHtDh.setHtbh(tHtDTO.getHth());
            tHtDh.setJhdd(tHtDTO.getQddd());
            tHtDh.setGb("0");
            tHtDh.setCzf(tHtDTO.getCjid());
            //tHtDh.set
            // 增加主信息 删除缓存
            try {
                THtDh htDh = tHtDhMapper.selectByPrimaryKey(tHtDh.getHtbh());

                if(htDh == null){
                    tHtDhMapper.insertSelective(tHtDh);
                }else {
                    tHtDhMapper.updateByPrimaryKey(tHtDh);
                }

            }catch (Exception e){
                e.printStackTrace();
                throw new BusinessException("插入或更新错误");
            }
            tHtTempMapper.deleteByPrimaryKey(tHtDh.getHtbh(),tHtDh.getJhbh());
        }
        return true;
    }

    /**
     * 机关保存上报的采购数据
     *
     * @param list
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean saveJgCgData(List<TCkCrkXfDTO> list) {
        // 保存数据
        for (TCkCrkXfDTO tCkCrkXfDTO : list) {


            List<TCkCrkqdDrTemp> tCkCrkqdDrTemps =
                    tCkCrkqdDrTempMapper.getList(new TCkCrkqdDrTemp(tCkCrkXfDTO.getBh(),
                            tCkCrkXfDTO.getDwid()));

            tCkCrkqdDrTemps.stream().forEach(this::crkqd);
            TCkCrk tCkCrk = new TCkCrk();
            TCkCrkDrTemp tCkCrkDrTemp = tCkCrkDrTempMapper.selectByPrimaryKey(tCkCrkXfDTO.getBh(),
                    tCkCrkXfDTO.getDwid());
            org.springframework.beans.BeanUtils.copyProperties
                    (tCkCrkDrTemp, tCkCrk);
            // 增加主信息 删除缓存
            try {
                tCkCrkMapper.insertSelective(tCkCrk);
            }catch (Exception e){
                e.printStackTrace();
                throw new BusinessException("不可重复保存");
            }
            tCkCrkDrTempMapper.deleteByPrimaryKey(tCkCrkXfDTO.getBh(),tCkCrkXfDTO.getDwid());

        }
        return true;
    }

    private void crkqd(TCkCrkqdDrTemp tCkCrkqdDrTemp) {
        TCkCrkqd tCkCrkqd = new TCkCrkqd();
        org.springframework.beans.BeanUtils.copyProperties
                (tCkCrkqdDrTemp, tCkCrkqd);
        try {
            tCkCrkqdMapper.insertSelective(tCkCrkqd);
        }catch (Exception e){
            e.printStackTrace();
            throw new BusinessException("不可重复保存");
        }
        tCkCrkqdDrTempMapper.deleteByPrimaryKey(tCkCrkqdDrTemp);
    }

    /**
     * 删除选定数据
     *
     * @param list
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean deleteReceiveData(List<THtDTO> list) {
        for (THtDTO tHtDTO : list) {

            List<THtQdTemp> tHtQdTempList =
                    tHtQdTempMapper.getList(tHtDTO.getHth(),tHtDTO.getJhbh());

            tHtQdTempList.stream().forEach(temp->
                    tHtQdTempMapper.deleteByPrimaryKey(temp));
            // 增加主信息 删除缓存
            tHtTempMapper.deleteByPrimaryKey(tHtDTO.getHth(),tHtDTO.getJhbh());
        }
        return true;
    }

    /**
     * 删除选定数据
     *
     * @param list
     * @return
     */
    @Override
    public Boolean deleteJgReceiveData(List<TCkCrkXfDTO> list) {
        for (TCkCrkXfDTO tCkCrkXfDTO : list) {
            List<TCkCrkqdDrTemp> tCkCrkqdDrTemps =
                    tCkCrkqdDrTempMapper.getList(new TCkCrkqdDrTemp(tCkCrkXfDTO.getBh(),
                            tCkCrkXfDTO.getDwid()));

            tCkCrkqdDrTemps.stream().forEach(temp->
                    tCkCrkqdDrTempMapper.deleteByPrimaryKey(temp));
            // 增加主信息 删除缓存
            tCkCrkDrTempMapper.deleteByPrimaryKey(tCkCrkXfDTO.getBh(),tCkCrkXfDTO.getDwid());
        }
        return true;
    }

    private void accept(THtQdTemp tHtQdTemp) {
        THtDhqd tHtDhqd = new THtDhqd();
         org.springframework.beans.BeanUtils.copyProperties
                (tHtQdTemp, tHtDhqd);
         try {
             tHtDhqd.setHtbh(tHtQdTemp.getHth());
             tHtDhqd.setDhsl(tHtQdTemp.getSl());
             tHtDhqd.setZj(new BigDecimal(tHtQdTemp.getZj()));

             THtDhqd tHtDhqd1 =  tHtDhqdMapper.selectByPrimaryKey(tHtDhqd.getHtbh(),tHtDhqd.getJx(),tHtDhqd.getJh());
             if(tHtDhqd1 == null){
                 tHtDhqdMapper.insertSelective(tHtDhqd);
             }else {
                 tHtDhqdMapper.updateByPrimaryKeySelective(tHtDhqd);
             }
         }catch (Exception e){
             e.printStackTrace();
             throw new BusinessException("不可重复保存清单");
         }
        tHtQdTempMapper.deleteByPrimaryKey(tHtQdTemp);
    }

    private String initCopyUserDbPathAndGet() throws IOException {
        // db 文件绝对地址
        // String templateDbPathAbsolutePath = SQLiteInstance.templateDbPathAbsolutePath;

        // 获取db 的流

        ClassPathResource classPath = new ClassPathResource(sqllIteConfig.getPath());
        InputStream is = classPath.getInputStream();
       /* BufferedOutputStream os = new BufferedOutputStream(new FileOutputStream(newFile));

        BufferedInputStream bufferedInputStream =
                (BufferedInputStream) this.getClass().getResourceAsStream("/"+sqllIteConfig.getPath());*/

        // 用户地址动态db 地址
        String userTempPath = SQLiteInstance.getUserTempPath(SQLiteInstance.tempDbFilePath);

        // 复制文件夹
        Boolean success = FileUtils.copy(is,
                userTempPath);

        if (!success) {
            throw new BusinessException("备份db 文件复制错误");
        }

        // 设置sqlite 连接地址
        SQLiteUtils.setPath(userTempPath);

        return userTempPath;
    }
}
