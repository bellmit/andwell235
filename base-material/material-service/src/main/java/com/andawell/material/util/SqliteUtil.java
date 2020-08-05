package com.andawell.material.util;

import cn.hutool.extra.servlet.multipart.UploadFile;
import com.andawell.material.entity.TSqliteFf;
import com.andawell.material.entity.TSqliteFfqd;
import com.andawell.material.vo.TSqliteFfVO;
import org.springframework.beans.factory.annotation.Value;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SqliteUtil {

    public static List<TSqliteFfVO> select(String url) throws Exception {
        // 0 连接SQLite的JDBC
        Class.forName("org.sqlite.JDBC");
        // 1 建立一个数据库名demo.db的连接，如果不存在就在当前目录下创建之
        Connection conn = null;
        Statement stat = null;
        String sql = "jdbc:sqlite://"+ url;
        conn = DriverManager.getConnection(sql);
        String crcrk = "select bh,jx,jxmc,wh,ysfs,ysfsmc,rq,ffdw,jsdw,ffdwmc,jsdwmc from t_sqlite_ff";
        PreparedStatement preparedStatement = conn.prepareStatement(crcrk);
        ResultSet ps = preparedStatement.executeQuery();
        //创建对象集合
        List<TSqliteFfVO> list = new ArrayList<>();
        //处理结果集
        while (ps.next()) {
            TSqliteFfVO tSqliteFfVO = new TSqliteFfVO();
            tSqliteFfVO.setBh(ps.getString("BH"));
            tSqliteFfVO.setJx(ps.getString("JX"));
            tSqliteFfVO.setJxmc(ps.getString("JXMC"));
            tSqliteFfVO.setWh(ps.getString("WH"));
            tSqliteFfVO.setYsfs(ps.getString("YSFS"));
            tSqliteFfVO.setYsfsmc(ps.getString("YSFSMC"));
            tSqliteFfVO.setCkrq(ps.getString("RQ"));
            tSqliteFfVO.setFfdw(ps.getString("FFDW"));
            tSqliteFfVO.setJsdw(ps.getString("JSDW"));
            tSqliteFfVO.setFfdwmc(ps.getString("FFDWMC"));
            tSqliteFfVO.setJsdwmc(ps.getString("JSDWMC"));
            list.add(tSqliteFfVO);
        }
        for (TSqliteFfVO tSqliteFfVO : list) {
            System.out.println(tSqliteFfVO);
        }
        System.out.println("查询成功");
        conn.close(); // 结束数据库的连接*/
        preparedStatement.close();
        ps.close();
        return list;
    }
    @Value("a.b")
    private String a;
    public static TSqliteFf fflist(String bh,String url) throws Exception {
        // 0 连接SQLite的JDBC
        Class.forName("org.sqlite.JDBC");
        // 1 建立一个数据库名demo.db的连接，如果不存在就在当前目录下创建之
        Connection conn = null;
        Statement stat = null;
        String sql = "jdbc:sqlite://" + url;
        conn = DriverManager.getConnection(sql);
        String crcrk = "select bh,jx,jxmc,wh,ysfs,ysfsmc,ckrq,ffdw,jsdw,ffdwmc,jsdwmc from t_sqlite_ff where bh=?";
        PreparedStatement preparedStatement = conn.prepareStatement(crcrk);
        preparedStatement.setString(1, bh);
        ResultSet rs = preparedStatement.executeQuery();
        //创建对象集合
        TSqliteFf tSqliteFf = new TSqliteFf();
        //处理结果集
        while (rs.next()) {
            tSqliteFf.setBh(rs.getString("BH"));
            tSqliteFf.setJx(rs.getString("JX"));
            tSqliteFf.setJxmc(rs.getString("JXMC"));
            tSqliteFf.setWh(rs.getString("WH"));
            tSqliteFf.setYsfs(rs.getString("YSFS"));
            tSqliteFf.setYsfsmc(rs.getString("YSFSMC"));

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            if (rs.getString("CKRQ").equals("")) {
                tSqliteFf.setCkrq(null);
            } else {
                Date date = simpleDateFormat.parse(rs.getString("CKRQ"));
                tSqliteFf.setCkrq(date);
            }
            tSqliteFf.setFfdw(rs.getString("FFDW"));
            tSqliteFf.setJsdw(rs.getString("JSDW"));
            tSqliteFf.setFfdwmc(rs.getString("FFDWMC"));
            tSqliteFf.setJsdwmc(rs.getString("JSDWMC"));
        }
        System.out.println("查询成功");
        conn.close(); // 结束数据库的连接*/
        rs.close();
        return tSqliteFf;
    }

    public static List<TSqliteFfqd> ffqd(String bh,String url) throws Exception {
        // 0 连接SQLite的JDBC
        Class.forName("org.sqlite.JDBC");
        // 1 建立一个数据库名demo.db的连接，如果不存在就在当前目录下创建之
        Connection conn = null;
        Statement stat = null;
        String sql = "jdbc:sqlite://" + url;
        conn = DriverManager.getConnection(sql);
        String crcrk = "select BH,JX,JH,XH,SL,ZL,DJ,ZJ,CCRQ,YSRQ,SMZT,RKRQ,ZSMN,ZSMXS,ZSMXH,ZSMQL,ZFXCS" +
                ",YFRQ,FXRQ,FXSMN,FXSMXS,FXCS,SBQXN,SBQXXS,BZ,ZFXXS,BCZFXXS,BCFXXS,ZXHCS,BCZXHCS,BCXHCS,ZQLCS,BCZQLCS,BCQLCS" +
                ",CJRQ,YFCS,ZYFCS,XSBZ,XZ,HL,DWID,LB,RQ,JJ,HCLB,BBZ,ZYLB,ZGQCS,GQCS,YFQX,JXQN,JXQXS,RFID,YSID from t_sqlite_ffqd where bh=?";
        PreparedStatement preparedStatement = conn.prepareStatement(crcrk);
        preparedStatement.setString(1, bh);
        ResultSet ps = preparedStatement.executeQuery();
        //创建对象集合
        List<TSqliteFfqd> list = new ArrayList<>();
        //处理结果集
        while (ps.next()) {
            TSqliteFfqd tSqliteFfqd = new TSqliteFfqd();
            tSqliteFfqd.setBh(ps.getString("BH"));
            tSqliteFfqd.setJx(ps.getString("JX"));
            tSqliteFfqd.setJh(ps.getString("JH"));

            tSqliteFfqd.setXh(ps.getString("XH"));
            tSqliteFfqd.setSl(ps.getInt("SL"));
            tSqliteFfqd.setZl(ps.getString("ZL"));
            tSqliteFfqd.setDj(ps.getInt("DJ"));
            tSqliteFfqd.setZj(ps.getInt("ZJ"));

            tSqliteFfqd.setCcrq(DateUtil.transition(ps.getString("CCRQ")));
            tSqliteFfqd.setYsrq(DateUtil.transition(ps.getString("YSRQ")));
            tSqliteFfqd.setSmzt(ps.getString("SMZT"));
            tSqliteFfqd.setRkrq(DateUtil.transition(ps.getString("RKRQ")));
            tSqliteFfqd.setZsmn(ps.getInt("ZSMN"));
            tSqliteFfqd.setZsmxs(ps.getInt("ZSMXS"));
            tSqliteFfqd.setZsmxh(ps.getInt("ZSMXH"));
            tSqliteFfqd.setZsmql(ps.getInt("ZSMQL"));

            tSqliteFfqd.setZfxcs(ps.getInt("ZFXCS"));
            tSqliteFfqd.setYfrq(DateUtil.transition(ps.getString("YFRQ")));
            tSqliteFfqd.setYfrq(DateUtil.transition(ps.getString("FXRQ")));
            tSqliteFfqd.setFxsmn(ps.getInt("FXSMN"));
            tSqliteFfqd.setFxsmxs(ps.getInt("FXSMXS"));
            tSqliteFfqd.setFxcs(ps.getInt("FXCS"));

            tSqliteFfqd.setSbqxn(ps.getInt("SBQXN"));
            tSqliteFfqd.setSbqxxs(ps.getInt("SBQXXS"));
            tSqliteFfqd.setBz(ps.getString("BZ"));
            tSqliteFfqd.setZfxxs(ps.getInt("ZFXXS"));

            tSqliteFfqd.setBczfxxs(ps.getInt("BCZFXXS"));
            tSqliteFfqd.setBcfxxs(ps.getInt("BCFXXS"));
            tSqliteFfqd.setZxhcs(ps.getInt("ZXHCS"));
            tSqliteFfqd.setBczxhcs(ps.getInt("BCZXHCS"));
            tSqliteFfqd.setBcxhcs(ps.getInt("BCXHCS"));
            tSqliteFfqd.setZqlcs(ps.getInt("ZQLCS"));

            tSqliteFfqd.setBczqlcs(ps.getInt("BCZQLCS"));
            tSqliteFfqd.setBcqlcs(ps.getInt("BCQLCS"));
            tSqliteFfqd.setCjrq(DateUtil.transition(ps.getString("CJRQ")));
            tSqliteFfqd.setYfcs(ps.getInt("YFCS"));
            tSqliteFfqd.setZyfcs(ps.getInt("ZYFCS"));
            tSqliteFfqd.setXsbz(ps.getString("XSBZ"));

            tSqliteFfqd.setXz(ps.getString("XZ"));
            tSqliteFfqd.setHl(ps.getInt("HL"));
            tSqliteFfqd.setDwid(ps.getString("DWID"));
            tSqliteFfqd.setLb(ps.getString("LB"));
            tSqliteFfqd.setRq(DateUtil.transition(ps.getString("RQ")));
            tSqliteFfqd.setJj(ps.getInt("JJ"));

            tSqliteFfqd.setHclb(ps.getInt("HCLB"));
            tSqliteFfqd.setBbz(ps.getInt("BBZ"));
            tSqliteFfqd.setZylb(ps.getInt("ZYLB"));
            tSqliteFfqd.setZgqcs(ps.getInt("ZGQCS"));
            tSqliteFfqd.setGqcs(ps.getInt("GQCS"));
            tSqliteFfqd.setYfqx(ps.getInt("YFQX"));

            tSqliteFfqd.setJxqn(ps.getInt("JXQN"));
            tSqliteFfqd.setJxqxs(ps.getInt("JXQXS"));
            tSqliteFfqd.setRfid(ps.getString("RFID"));
            tSqliteFfqd.setYsid(ps.getString("YSID"));
            list.add(tSqliteFfqd);
        }
        for (TSqliteFfqd tSqliteFfqd : list) {
            System.out.println(tSqliteFfqd);
        }
        System.out.println("查询成功");
        conn.close(); // 结束数据库的连接*/
        preparedStatement.close();
        ps.close();
        return list;
    }

}
