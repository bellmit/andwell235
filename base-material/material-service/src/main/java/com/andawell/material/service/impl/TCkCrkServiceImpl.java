package com.andawell.material.service.impl;

import com.andawell.common.util.FileUtils;
import com.andawell.common.util.SQLiteUtils;
import com.andawell.material.config.SQLiteConfig;
import com.andawell.material.dto.TCkCrkDTO;
import com.andawell.material.entity.*;
import com.andawell.material.enumeration.TableNameStyle;
import com.andawell.material.util.*;
import com.andawell.material.dto.TCkCrksDTO;
import com.andawell.material.mapper.TCkCrkMapper;
import com.andawell.material.mapper.TCkCrkqdMapper;
import com.andawell.material.mapper.TSqliteFfMapper;
import com.andawell.material.mapper.TSqliteFfqdMapper;
import com.andawell.material.service.ITCkCrkService;
import com.andawell.material.vo.TFfsjDcVO;
import com.andawell.material.vo.TSqliteFfVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/***
 * @author shs
 * @Date: 2020/5/7 15:42
 * @Description:
 * @version : V1.0
 */
@Service
@Slf4j
public class TCkCrkServiceImpl implements ITCkCrkService {
    @Autowired
    private TCkCrkMapper tCkCrkMapper;
    @Autowired
    private TCkCrkqdMapper tCkCrkqdMapper;
    @Autowired
    private TSqliteFfMapper tSqliteFfMapper;
    @Autowired
    private TSqliteFfqdMapper tSqliteFfqdMapper;
    @Value("${upload.path}")
    private String filepath;

    /***
     * @author shs
     * @Date: 2020/5/7 15:42
     * @Description:
     *  1.初始化文件
     *  2.复制一份db模板
     *  3.清除模板主表和明细表的数据
     *  4.查出主表信息
     *  5.把主表信息插入对应db文件
     *  6.查询明细信息
     *  7.把明细表信息插入对应db
     *  8.下载添加数据的db文件
     *  9.清除db模板文件
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insert(HttpServletResponse response, List<TCkCrksDTO> tCkCrks) throws Exception {
        //初始化参数
        SQLiteConfig.initial();
        Boolean copy = FileUtils.copy();
        if (copy) {
            //清除明细表数据
            SQLiteUtils.closezb(TableNameStyle.T_SQLite_FF.getName());
            //清除明细表数据
            SQLiteUtils.closezb(TableNameStyle.T_SQLite_FFQD.getName());
            //存储主表信息
            for (int i = 0; i < tCkCrks.size(); i++) {
                TCkCrksDTO tCkCrksDTO = tCkCrks.get(i);
                TFfsjDcVO tCkCrk = null;
                tCkCrk = tCkCrkMapper.select(tCkCrksDTO.getBh());
                //查出主表进行数据插入
                SQLiteUtils.transmission(tCkCrk, TableNameStyle.T_SQLite_FF.getName());
                //明细数据查询
                List<TSqliteFfqd> tSqliteFfqds = null;
                tSqliteFfqds = tCkCrkqdMapper.select(tCkCrksDTO.getBh());
                //查出明细表进行数据插入
                SQLiteUtils.transmission(tSqliteFfqds, TableNameStyle.T_SQLite_FFQD.getName());
            }
        }
        FileUtils.download(response);
        FileUtils.deleteFile();
    }


    /***
     * @author shs
     * @Date: 2020/5/7 17:42
     * @Description:
     *  1.判断传入的数据是否已经存在，存在提示添加重复
     *  2.数据不存在则获取文件路径
     *  3.根据编号在db文件中查询出主表信息
     *  4.将主表信息添加进数据库
     *  5.根据编号在db查询明细表信息
     *  6.将明细表数据插入数据库
     *  7.添加成功返回提示
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insertOracle(List<TCkCrksDTO> tCkCrks) throws Exception {
        for (TCkCrksDTO tCkCrk : tCkCrks) {
            TSqliteFf tSqliteFf = BeanUtils.dtoTODO(tCkCrk, TSqliteFf.class);
            if (tSqliteFfMapper.countBh(tSqliteFf) >= 1) {
                return 1;
            }
        }
        String newFile = FileUtils.getNewFile(filepath);
        String replace = newFile.replace("\\", "/");
        for (int i = 0; i < tCkCrks.size(); i++) {
            TCkCrksDTO tCkCrksDTO = tCkCrks.get(i);
            TSqliteFf tSqliteFf = SqliteUtil.fflist(tCkCrksDTO.getBh(), replace);
            //判断oracle数据库是否有要添加的数据
            try {
                tSqliteFfMapper.insertSelective(tSqliteFf);
            } catch (Exception e) {
                log.error(tSqliteFf.toString());
                e.printStackTrace();
            }
            List<TSqliteFfqd> tSqliteFfqds = SqliteUtil.ffqd(tCkCrksDTO.getBh(), replace);
            if (tSqliteFfqds != null && tSqliteFfqds.size() > 0) {
                for (TSqliteFfqd tSqliteFfqd : tSqliteFfqds) {
                    try {
                        tSqliteFfqdMapper.insertSelective(tSqliteFfqd);
                    } catch (Exception e) {
                        log.error(tSqliteFfqd.toString());
                        e.printStackTrace();
                    }
                }
            }
        }
        return 2;
    }

    /***
     * @author shs
     * @Date: 2020/5/7 18:42
     * @Description:
     *  1.获得文件路径
     *  2.查询出db文件主表信息数据
     *  3.返回给前端显示
     */
    @Override
    public List<TSqliteFfVO> CrCrklist(String url) {
        //获得路径
        SQLiteUtils.setPath(url);
        List<TSqliteFfVO> tSqliteFfVOS = null;
        try {
            tSqliteFfVOS = SQLiteUtils.upload(new TSqliteFfVO(), TableNameStyle.T_SQLite_FF.getName(), url);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tSqliteFfVOS;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(TCkCrksDTO tCkCrks) {
        String bh = tCkCrks.getBh();
        try {
            //删除主表信息
            tSqliteFfMapper.deleteByPrimaryKey(bh);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            //删除清单信息
            tSqliteFfqdMapper.deleteByPrimaryKey(bh);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /***
     * @author shs
     * @Date: 2020/5/7 18:42
     * @Description:
     *  1.接收编号，回执接收人，回执状态，回执时间
     *  2.调用修改接口
     *  3.返回给前端显示
     */
    @Override
    public void updateTCkCrk(TCkCrkDTO tCkCrkDTO) {
        TCkCrk tCkCrk = BeanUtils.dtoTODO(tCkCrkDTO, TCkCrk.class);
        try {
            tCkCrkMapper.updateSelective(tCkCrk);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


