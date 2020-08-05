package com.andawell.material.service;

import com.andawell.common.entity.vo.ListPageVo;
import com.andawell.material.dto.TDbLtsqDTO;
import com.andawell.material.dto.ZQSaveDTO;
import com.andawell.material.entity.TDbLtsq;
import com.andawell.material.entity.TDbLtsqqd;
import com.andawell.material.query.*;
import com.andawell.material.vo.*;
import org.springframework.web.multipart.MultipartFile;
import com.andawell.material.query.TCkCkQuery;
import com.andawell.material.query.TCkCrkQuery;
import com.andawell.material.query.TCkCrkqdQuery;
import com.andawell.material.query.TDbLtsqQuery;
import com.andawell.material.vo.ReasonVO;
import com.andawell.material.vo.StockVO;
import com.andawell.material.vo.TDbLtsqVO;
import com.andawell.material.vo.TDbLtsqqdVO;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @Date： 2020/5/27 8:58
 */
public interface IBrigadeApplyService {
    /**
     *@Author: liuys
     *@Data: 2020/5/26
     *@Description: 查询战区下旅团下的申请
     */
    List<TDbLtsqVO> getAllocationList(TDbLtsqQuery tDbLtsqQuery);


    /**
     *@Author: liuys
     *@Data: 2020/5/27
     *@Description: 查询全新-可用-待修-在修数量
     */
    StockVO getStatistics(TCkCkQuery tCkCkQuery);

    /**
     *@Author: liuys
     *@Data: 2020/5/27
     *@Description: 旅团申请保存
     */
    Boolean insert(TDbLtsqDTO tDbLtsqDTO);

    /**
     *@Author: liuys
     *@Data: 2020/5/27
     *@Description: 旅团申请单号
     */
    String getNumber();

    /**
     *@Author: liuys
     *@Data: 2020/5/27
     *@Description: 获取最新的一条数据
     */
    TDbLtsq getLatest(TDbLtsqQuery query);

    /**
     *@Author: liuys
     *@Data: 2020/5/29
     *@Description: 申请原因
     */
    List<ReasonVO> getReason();

    Boolean transmission(HttpServletResponse response, List<String> ltsqdh);

    /**
     *@Author: liuys
     *@Data: 2020/6/8
     *@Description: 上传
     */
    List<TDbLtsqAndQDVO> upload(MultipartFile multipartFile);

    ListPageVo<TDbLtsqQuery, TDbLtsqqd> getList(TDbLtsqQuery tDbLtsqQuery);


    Boolean saveToLtHistory(List<String> ltsqdh);

    Boolean deleteToLtHistory(List<String> ltsqdh);

    Boolean saveToLtSQ(ZQSaveDTO zqSaveDTO);
}
