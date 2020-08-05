package com.andawell.purchase.controller;

import com.andawell.purchase.query.HTPrintQuery;
import com.andawell.purchase.service.ITHtPrintService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @Author: yzy
 * @Description:
 * @Date: created in 2020/6/10 9:27
 */
@Api(value = "合同打印", tags = "合同打印")
@RestController
@RequestMapping(value = "sys/htprint")
@Slf4j
public class THtPrintController {

    @Autowired
    ITHtPrintService htPrintService;

    @PostMapping("/print")
    public void printHT(@RequestBody List<HTPrintQuery> htPrintQueryList, HttpServletResponse response){
        htPrintService.printHT(htPrintQueryList,response);
    }
}
