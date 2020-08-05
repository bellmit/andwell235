package com.andawell.purchase.service.impl;

import com.andawell.purchase.dto.htprint.THtInfoDTO;
import com.andawell.purchase.dto.htprint.THtPrintDTO;
import com.andawell.purchase.mapper.THtPrintMapper;
import com.andawell.purchase.query.HTPrintQuery;
import com.andawell.purchase.service.ITHtPrintService;

import com.andawell.purchase.util.RMBUtils;
import com.andawell.purchase.util.doc.Doc;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Author: yzy
 * @Description:
 * @Date: created in 2020/6/9 14:51
 */
@Service
public class THtPrintServiceImpl implements ITHtPrintService {

    @Autowired
    THtPrintMapper tHtPrintMapper;

    @Value(value = "${doc.path}")
    String  docPath;

    @Value(value = "${doc.backPath}")
    String backPath;

    @Override
    public Map<String, String> bookmarkMap(String hth, String jhbh) {
        THtPrintDTO select = tHtPrintMapper.select(hth, jhbh);
        List<Map<String, String>> maps = tHtPrintMapper.qdList(hth, jhbh);
        THtInfoDTO info = tHtPrintMapper.info(hth, jhbh);
        Map<String, String> bookmarkMap = new HashMap<>();
        DecimalFormat df = new DecimalFormat("0.00");

        BigDecimal zje = new  BigDecimal((info.getZje()!=null)?info.getZje():0);
        String zje1 = df.format(zje);
//        Double zje1 = info.getZje();
//        String zje1 = df.format(info.getZje());
//        String zje1 = df.format(info.getZje()!=null?info.getZje():0);
        bookmarkMap.put("jhbh", StringUtils.isNotEmpty(select.getJhbh())?select.getJhbh():"");
        if (info.getZts() > 1) {
            bookmarkMap.put("t_cpmc", maps.get(0).get("JXMC") + maps.get(0).get("JHMC") + "等" + info.getZts() + "项" + info.getZsl() + "件航材");
        } else {
            bookmarkMap.put("t_cpmc", maps.get(0).get("JXMC") + maps.get(0).get("JHMC") + info.getZts() + "项" + info.getZsl() + "件航材");
        }
        bookmarkMap.put("t_nd", StringUtils.isNotEmpty(select.getNd() ) ?  select.getNd() + "":"");
        bookmarkMap.put("t_hj_sl_1", StringUtils.isNotEmpty(info.getZsl() + "") ? info.getZsl() + "":"");
        bookmarkMap.put("t_hj_je_1", StringUtils.isNotEmpty(zje1 + "")?zje1 + "":"");
        bookmarkMap.put("t_a_mc", StringUtils.isNotEmpty(select.getCgfmc())?select.getCgfmc():"");
        bookmarkMap.put("t_a_dz", StringUtils.isNotEmpty(select.getCgfdz())?select.getCgfdz():"");
        bookmarkMap.put("t_a_dh", StringUtils.isNotEmpty(select.getCgfdh())?select.getCgfdh():"");
        bookmarkMap.put("t_a_khmc", StringUtils.isNotEmpty(select.getCgfkhmc())?select.getCgfkhmc():"" );
        bookmarkMap.put("t_a_khyh", StringUtils.isNotEmpty(select.getCgfkhyh())?select.getCgfkhyh():"");
        bookmarkMap.put("t_a_yhzh", StringUtils.isNotEmpty(select.getCgfyhzh())?select.getCgfyhzh():"");
        bookmarkMap.put("t_b_mc", StringUtils.isNotEmpty(select.getCfmc())?select.getCfmc():"");
        bookmarkMap.put("t_b_dz", StringUtils.isNotEmpty(select.getCfdz())?select.getCfdz():"");
        bookmarkMap.put("t_b_dh", StringUtils.isNotEmpty(select.getCfdh())?select.getCfdh():"");
        bookmarkMap.put("t_b_khmc", StringUtils.isNotEmpty(select.getCfkhmc())?select.getCfkhmc():"");
        bookmarkMap.put("t_b_khyh", StringUtils.isNotEmpty(select.getCfkhyh())?select.getCfkhyh():"");
        bookmarkMap.put("t_b_yhzh", StringUtils.isNotEmpty(select.getCfyhzh())?select.getCfyhzh() :"");
        bookmarkMap.put("t_c_mc", StringUtils.isNotEmpty(select.getJgfmc())?select.getJgfmc():"");
        bookmarkMap.put("t_c_dz", StringUtils.isNotEmpty(select.getJgfdz())?select.getJgfdz():"");
        bookmarkMap.put("t_c_yzbm", StringUtils.isNotEmpty(select.getJgfyb())?select.getJgfyb():"");
        bookmarkMap.put("t_c_dh", StringUtils.isNotEmpty(select.getJgfdh())?select.getJgfdh():"");
        bookmarkMap.put("t_hj_je_2", StringUtils.isNotEmpty(zje1 + "")?zje1 + "":"");
        bookmarkMap.put("t_cfjc", StringUtils.isNotEmpty(select.getCfjc())?select.getCfjc():"");
        bookmarkMap.put("t_hj_je_3", StringUtils.isNotEmpty(zje1 + "")?zje1 + "":"");
        bookmarkMap.put("t_hj_je_4", StringUtils.isNotEmpty(zje1 + "")?zje1 + "":"");
        bookmarkMap.put("t_hj_je_5", StringUtils.isNotEmpty(zje1 + "")?zje1 + "":"");
        bookmarkMap.put("t_hj_sl_2", StringUtils.isNotEmpty(info.getZsl() + "")?info.getZsl() + "":"");
        bookmarkMap.put("t_hj_xjs", "共" + info.getZts() + "项" + info.getZsl() + "件");
        bookmarkMap.put("t_hj_xjs_2", "共" + info.getZts() + "项" + info.getZsl() + "件");
        bookmarkMap.put("t_htbh_1", StringUtils.isNotEmpty(select.getHth())?select.getHth():"");
        bookmarkMap.put("t_htbh_2", StringUtils.isNotEmpty(select.getHth())?select.getHth():"");
        //合同依据
        bookmarkMap.put("t_htyj", StringUtils.isNotEmpty(select.getHtyj())?select.getHtyj():"");
        //价格条款
        if (select.getJglx() == 1) {
            bookmarkMap.put("t_jgtk", "价格按批价签订合同，并在合同明细中注明价格类型。");
        } else {
            bookmarkMap.put("t_jgtk", "价格按计划中给定的暂定价签订合同，并在合同明细中注明价格类型，待审价后办理补差。");
        }
        bookmarkMap.put("t_qddd", StringUtils.isNotEmpty(select.getQddd() + "")?select.getQddd():"");
        SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日");
        String qdrq = format.format(select.getQdrq());
        bookmarkMap.put("t_qdrq", StringUtils.isNotEmpty(qdrq)? qdrq:"");
        //人民币大写需要方法封装
        try {
            bookmarkMap.put("t_rmbje_dx_1", RMBUtils.number2RMB(zje));
            //人民币大写需要方法封装
            bookmarkMap.put("t_rmbje_dx_2", RMBUtils.number2RMB(zje));
        } catch (Exception e) {
            e.printStackTrace();
        }
        //运输方式循环方式处理
        String ysfs = select.getYsfs();
        for (int i = 0; i < ysfs.length(); i++) {
            String substring = ysfs.substring(i, i + 1);
            if ("1".equals(substring)) {
                bookmarkMap.put("t_y" + (i + 1), "■");
            } else {
                bookmarkMap.put("t_y" + (i + 1), "□");
            }
        }
        return bookmarkMap;
    }

    @Override
    public List<Map<String, String>> list(String hth, String jhbh) {

        THtPrintDTO select = tHtPrintMapper.select(hth, jhbh);
        List<Map<String, String>> maps = tHtPrintMapper.qdList(hth, jhbh);
        for (Map<String, String> map : maps) {
            if (select.getJglx() == 1) {
                map.put("JGLX", "批价");
            } else {
                map.put("JGLX", "暂定价");
            }
            String dj = map.get("DJ");
            String zj = map.get("ZJ");
            DecimalFormat df = new DecimalFormat("0.00");
            dj = df.format(Double.parseDouble(dj));
            zj = df.format(Double.parseDouble(zj));
            map.put("DJ", dj);
            map.put("ZJ", zj);
        }
        System.out.println(maps.toString());
        return maps;
    }


    @Override
    public void printHT(List<HTPrintQuery> htPrintQueryList, HttpServletResponse response) {

        List<Map<String, Object>> list1 = new ArrayList<>();
        for (HTPrintQuery htPrintQuery : htPrintQueryList) {
            THtPrintDTO select = tHtPrintMapper.select(htPrintQuery.getHth(), htPrintQuery.getJhbh());
            //查询标签
            Map<String, String> map = bookmarkMap(htPrintQuery.getHth(), htPrintQuery.getJhbh());
            //查询列表
            List<Map<String, String>> list = list(htPrintQuery.getHth(), htPrintQuery.getJhbh());
            for (int i = 0; i < list.size(); i++) {
                list.get(i).put("num", (i + 1) + "");
            }
            String cgfyhzh = select.getCgfyhzh();
            System.out.println(cgfyhzh);
            String filePath = map.get("t_htbh_1")+map.get("t_cfjc")+"-"+select.getJglx();
            String path = map.get("t_cfjc");
            Map<String, Object> map1 = new HashMap<>();
            map1.put("params", map);    //文档中替换标签的map
            map1.put("list", list);     //文档中的列表
            map1.put("filePath", filePath);  //合同号和厂方简称的路径
            map1.put("path", path);          //厂方简称的路径
            map1.put("tempFilepath", docPath);  //模板文件路径
            list1.add(map1);
        }
        try {
            //打印合同压缩包入口
            Doc.printHT(list1,response,backPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
