package com.andawell.material.util;

import com.andawell.material.entity.*;
import com.andawell.material.vo.TDataStateVO;
import com.andawell.material.vo.TDataVO;
import com.andawell.material.vo.TSqliteFfVO;
import javassist.bytecode.stackmap.TypeData;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SjdcUtile {

    public static List<TCkS> ckSxlist(String url) throws Exception {
        // 0 连接SQLite的JDBC
        Class.forName("org.sqlite.JDBC");
        // 1 建立一个数据库名demo.db的连接，如果不存在就在当前目录下创建之
        Connection conn = null;
        Statement stat = null;
        String sql = "jdbc:sqlite://" + url;
        conn = DriverManager.getConnection(sql);
        String ckck = "select BH, JH, XH, DWID, JX, XZ, FJH, BZ, ZL, CKDM, FHD, CXDW, SXRQ, SXLB, HTBH, SL, DXBH, \n" +
                "    ZXSL, PSZT, HCLB, ZYLB, GZYY, JXQN, JXQXS, RFID, YSID, SBBH, SBRQ, JZRQ, PFZT, SCCJ, \n" +
                "    SYSJ, CLJG, CLSJ, CLBH from T_CK_SX";
        PreparedStatement preparedStatement = conn.prepareStatement(ckck);
        ResultSet ps = preparedStatement.executeQuery();
        //创建对象集合
        List<TCkS> list = new ArrayList<>();
        //处理结果集
        while (ps.next()) {
            TCkS tCkSx = new TCkS();
            tCkSx.setBh(ps.getString("BH"));
            tCkSx.setJh(ps.getString("JH"));
            tCkSx.setXh(ps.getString("XH"));
            tCkSx.setFjh(ps.getString("FJH"));
            tCkSx.setBz(ps.getString("BZ"));
            tCkSx.setZl(ps.getString("ZL"));
            tCkSx.setJx(ps.getString("JX"));
            tCkSx.setCkdm(ps.getString("CKDM"));
            tCkSx.setFhd(ps.getString("FHD"));
            tCkSx.setCxdw(ps.getString("CXDW"));
            tCkSx.setSxrq(DateUtil.transition(ps.getString("SXRQ")));
            tCkSx.setSxlb(ps.getString("SXLB"));
            tCkSx.setHtbh(ps.getString("HTBH"));
            tCkSx.setXz(ps.getString("XZ"));
            tCkSx.setSl(ps.getLong("SL"));
            tCkSx.setDxbh(ps.getString("DXBH"));
            tCkSx.setZxsl(ps.getInt("ZXSL"));
            tCkSx.setPszt(ps.getString("PSZT"));
            tCkSx.setDwid(ps.getString("DWID"));
            tCkSx.setHclb(ps.getInt("HCLB"));
            tCkSx.setZylb(ps.getInt("ZYLB"));
            tCkSx.setGzyy(ps.getString("GZYY"));
            tCkSx.setJxqn(ps.getInt("JXQN"));
            tCkSx.setJxqxs(ps.getInt("JXQXS"));
            tCkSx.setRfid(ps.getString("RFID"));
            tCkSx.setYsid(ps.getString("YSID"));
            tCkSx.setSbbh(ps.getString("SBBH"));
            tCkSx.setSbrq(DateUtil.transition(ps.getString("SBRQ")));
            tCkSx.setJzrq(DateUtil.transition(ps.getString("JZRQ")));
            tCkSx.setPfzt(ps.getString("PFZT"));
            tCkSx.setSccj(ps.getString("SCCJ"));
            tCkSx.setSysj(ps.getString("SYSJ"));
            tCkSx.setCljg(ps.getString("CLJG"));
            tCkSx.setSysj(ps.getString("CLSJ"));
            tCkSx.setClbh(ps.getString("CLBH"));
            list.add(tCkSx);
        }
        for (TCkS tCkSx : list) {
            System.out.println(tCkSx);
        }
        System.out.println("查询成功");
        conn.close(); // 结束数据库的连接*/
        preparedStatement.close();
        ps.close();
        return list;
    }


    public static TDataVO dataStatelist(String url) throws Exception {
        Integer count=0;
        // 0 连接SQLite的JDBC
        Class.forName("org.sqlite.JDBC");
        // 1 建立一个数据库名demo.db的连接，如果不存在就在当前目录下创建之
        Connection conn = null;
        Statement stat = null;
        String sql = "jdbc:sqlite://" + url;
        conn = DriverManager.getConnection(sql);
        TDataVO tDataVOS = new TDataVO();
        String dwid=null;
        //判断是否库存信息是否为空
        String ckck = "select count(*) count from t_ck_ck";
        PreparedStatement ckckdata = conn.prepareStatement(ckck);
        ResultSet ckcksj = ckckdata.executeQuery();
        while (ckcksj.next()) {
            Integer id = ckcksj.getInt("count");
            count=id;
        }
        //如果库存表存在数据则返回false
        if (count>=1){
            tDataVOS.setT_CK_CK(true);
            String Dwid = "select distinct DWID from T_CK_CK";
            dwid=Dwid;
        }else {
            tDataVOS.setT_CK_CK(false);
        }
        //判断待修信息是否为空
        String ckdx = "select count(*) count from t_ck_dx";
        PreparedStatement ckdxdata = conn.prepareStatement(ckdx);
        ResultSet ckdxsj = ckdxdata.executeQuery();
        while (ckdxsj.next()) {
            Integer id = ckdxsj.getInt("count");
            count=id;
        }
        //如果库存表存在数据则返回false
        if (count>=1){
            tDataVOS.setT_CK_DX(true);
            String Dwid = "select distinct DWID from T_CK_Dx";
            dwid=Dwid;
        }else {
            tDataVOS.setT_CK_DX(false);
        }
        //判断送修信息是否为空
        String cksx = "select count(*)count from t_ck_sx";
        PreparedStatement cksxdata = conn.prepareStatement(cksx);
        ResultSet cksxsj = cksxdata.executeQuery();
        while (cksxsj.next()) {
            Integer id = cksxsj.getInt("count");
            count=id;
        }
        //如果库存表存在数据则返回false
        if (count>=1){
            tDataVOS.setT_CK_SX(true);
            String Dwid = "select distinct DWID from T_CK_Sx";
            dwid=Dwid;
        }else {
            tDataVOS.setT_CK_SX(false);
        }
        PreparedStatement dwiddata = conn.prepareStatement(dwid);
        ResultSet dwidsj = dwiddata.executeQuery();
        //创建对象集合
        List<TDataStateVO> tDataStateVO = new ArrayList<>();
        //查询所有单位id的集合
        while (dwidsj.next()) {
            TDataStateVO tDataStateVO1 = new TDataStateVO();
            String id = dwidsj.getString("DWID");
            tDataStateVO1.setDwid(id);
            tDataStateVO.add(tDataStateVO1);
        }
        tDataVOS.setDwmc(tDataStateVO);
        System.out.println("查询成功");
        conn.close(); // 结束数据库的连接*/
        dwiddata.close();
        ckckdata.close();
        ckdxdata.close();
        cksxdata.close();
        dwidsj.close();
        ckcksj.close();
        ckdxsj.close();
        cksxsj.close();
        return tDataVOS;
    }
}


