package com.andawell.material.service;

import com.andawell.material.dto.TDbjgDTO;
import com.andawell.material.dto.ZQSaveDTO;
import com.andawell.material.entity.TDbJgdb;
import com.andawell.material.query.TDbJgdbQuery;
import com.andawell.material.vo.TDbSjsqAndQDVO;
import com.andawell.material.vo.TDbSjsqVO;
import com.andawell.material.vo.TDbjgVO;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author: zje
 * @date: 2020/5/28
 * @description:
 */
public interface ITDbJgdbService {


    String getAllotBh(Integer type);

    TDbJgdb getJGDB(String sqdh);


    Boolean transmission(HttpServletResponse response, List<String> sqdh);

    List<TDbSjsqAndQDVO> listSqlite(MultipartFile multipartFile);

    Boolean insert(ZQSaveDTO zqSaveDTO);

    void delete(List<String> sqdh);

    void update(String sqdh);

//    void insertTemp(TDbjgDTO tDbjgDTO);
}
