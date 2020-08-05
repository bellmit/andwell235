package com.andawell.material.service;

import com.andawell.material.entity.TCkCk;
import com.andawell.material.entity.TCkDx;
import com.andawell.material.entity.TCkSx;
import com.andawell.material.entity.TSjCs;
import com.andawell.material.vo.TDataStateVO;
import com.andawell.material.vo.TDataVO;
import com.andawell.material.vo.TSjCsVO;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/***
 * @author shs
 * @Date: 2020/5/29 16:01
 * @Description: 数据导入导出
 * @version : V1.0
 */
public interface ISjClService {
    /**
     * 向sqlite插入数据
     *
     * @return
     */
    void insert(HttpServletResponse response, List<String> list);

    /**
     * 向oracle插入数据
     *
     * @return
     */
    void insertOracle(List<String> list, String upload);

    /**
     * 从sqlitem获取单位id和 三个库存的信息
     *
     * @return
     */
    TDataVO dataStatelist(String url);
    /**
     * 动态展示参数表信息
     *
     * @return
     */
    List<TSjCsVO> cslist();
    /**
     * 参数数据导出
     *
     * @return
     */
    void derivation(HttpServletResponse response, List<String> list);
    /**
     * 参数数据导入
     *
     * @return
     */
    void uploading(List<String> list, String replace);
    /**
     * 参数数据db文件导入表数据判断
     *
     * @return
     */
    List<TSjCs> filelist(String upload);
}
