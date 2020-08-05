package com.andawell.common.util;/**
 * @Date： 2020/6/1 14:06
 */



import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.*;


/**
 * @Auther:liuys
 * @Date:2020/6/1 14:06
 * @Description:
 */
@Slf4j
public class SQLiteUtils {

    private static String className;

    private static String jdbcDriver;

    private static String path;


    /**
     * @Author: liuys
     * @Data: 2020/6/2
     * @Description: 下发调用
     */
    public static int transmission(Object object, String surface) {
        /*closezb(surface);
        System.out.println("清除成功");*/
        int count = 0;
        try {
            Connection conn = createConnection();
            //设置手动事务
            conn.setAutoCommit(false);
            String sql = sqlStatement(object, surface);
            PreparedStatement preparedStatement = null;
            count = 0;
            try {
//                preparedStatement.executeBatch();
                preparedStatement = conn.prepareStatement(sql);
                count = preparedStatement.executeUpdate();
                //提交
                conn.commit();
            } catch (SQLException e) {
                e.printStackTrace();
                //回滚
                conn.rollback();
            }finally {
//                preparedStatement.clearBatch();
                //关闭手动事务
                conn.setAutoCommit(true);
            }
//            preparedStatement.clearBatch();
            preparedStatement.cancel();
            connect(conn);
        } catch (Exception e) {
            e.printStackTrace();
            return count;
        }
        System.out.println("插入成功");
        return count;
    }

    public static int transmission(List<?> list, String surface){
        /*closezb(surface);
        System.out.println("清除成功");*/
        int count = 0;
        try {
            Connection conn = createConnection();
            //设置手动事务
            conn.setAutoCommit(false);
            PreparedStatement preparedStatement = null;
            try {
                for (Object object : list) {
//                    preparedStatement.executeBatch();
                    String sql = sqlStatement(object, surface);
                    preparedStatement = conn.prepareStatement(sql);
                    count += preparedStatement.executeUpdate();
                }
            } catch (SQLException e) {
                e.printStackTrace();
                //回滚
                conn.rollback();
            }finally {
                //提交数据
                if (count!=0){
                    conn.commit();
                }
//                preparedStatement.clearBatch();
                //关闭手动事务
                conn.setAutoCommit(true);
            }
//            preparedStatement.clearBatch();
            preparedStatement.cancel();
            connect(conn);
            System.out.println("插入成功");
        } catch (Exception e) {
            e.printStackTrace();
            new SQLException();

        }
        return count;
    }


    /**
     * @Author: shs
     * @Data: 2020/6/12
     * @Description: 判断表是否有数据
     */
    public static Integer code(String surface) {
        Integer count=0;
        try {
            Connection conn = createConnection();
            String sql = "select count(*) from " + surface;
            PreparedStatement preparedStatement1 = conn.prepareStatement(sql);
            ResultSet resultSet = preparedStatement1.executeQuery();
            count = resultSet.getInt(1);
            preparedStatement1.close();
            connect(conn);
        } catch (Exception e) {
            e.printStackTrace();
            throw new PropertyException();
        }
        return count;
    }

    /**
     * @Author: shs
     * @Data: 2020/6/12
     * @Description: 修改表状态
     */
    public static void update(String surface) {
        try {
            Connection conn = createConnection();
            //update T_SJ_CS SET CODE= "false" where TABAL_NAME ="T_QX_ZYLB"
            String sql = "update T_SJ_CS SET CODE = 'false' where TABALNAME=" + "\"" + surface + "\"";
            PreparedStatement preparedStatement1 = conn.prepareStatement(sql);
            preparedStatement1.executeUpdate();
            preparedStatement1.close();
            connect(conn);
        } catch (Exception e) {
            e.printStackTrace();
            throw new PropertyException();
        }
    }





    /**
     * @Author: liuys
     * @Data: 2020/6/4
     * @Description: 上传返回数据
     */
    public static <T> List<T> upload(T classEntity, String surface,String file) throws Exception {
        List<T> list = new ArrayList<T>();
        Connection conn = createConnection();
        try {
            ResultSet rs = selectAll(surface, conn);
            list = reflectionValue(classEntity, rs);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } finally {
            connect(conn);
        }
        return list;
    }

    /**
     * @Author: liuys
     * @Data: 2020/6/4
     * @Description: 将查询的数据返回
     */
    private static <T> List<T> reflectionValue(T classEntity, ResultSet ps) throws SQLException, IllegalAccessException, InvocationTargetException, NoSuchMethodException, ParseException, InstantiationException {
        List<T> list = new ArrayList<T>();
        Class<?> objClass = classEntity.getClass();
        Field[] fields = objClass.getDeclaredFields();
        while (ps.next()) {
            Object o = objClass.newInstance();
            for (Field field : fields) {
                String name = field.getName();
                Class<?> type = field.getType();
                String value = ps.getString(name);
                Object setObject;
                if (value.equals("null")){
                    setObject = null;
                }else {
                    setObject = conversion(type, value);
                }
                String property = name.substring(0, 1).toUpperCase() + name.substring(1);
                Method method = objClass.getDeclaredMethod("set" + property, type);
                method.invoke(o, setObject);
            }
            classEntity = (T) o;
            list.add(classEntity);
        }
        return list;
    }


    /**
     * @Author: liuys
     * @Data: 2020/6/4
     * @Description: sql语句查询所有数据
     */
    private static ResultSet selectAll(String surface, Connection conn) throws SQLException {
        String sql = "select * from " + surface;
        Statement statement = conn.createStatement();
        return statement.executeQuery(sql);
    }

    /**
     * @Author: liuys
     * @Data: 2020/6/2
     * @Description: 先清除数据
     */
    public static void closezb(String surface){
        try {
            Connection conn = createConnection();
            String sql = "delete from " + surface;
            PreparedStatement preparedStatement1 = conn.prepareStatement(sql);
            preparedStatement1.executeUpdate();
            preparedStatement1.close();
            connect(conn);
        } catch (Exception e) {
            e.printStackTrace();
            new Exception();
        }
    }

    /**
     * @Author: liuys
     * @Data: 2020/6/1
     * @Description: sql语句->查询出来的list 映射的实体 表名称
     */
    private static String sqlStatement(List<?> list, String surface) throws Exception {
        String sql = "insert into " + surface + " (";
        List<SQLData> sqlList = getNameAndType(list);
        SQLData sqlData = sqlList.get(0);
        List<String> names = sqlData.getName();
        for (int i = 0; i < names.size(); i++) {
            if (i != names.size() - 1) {
                sql = sql + names.get(i) + ",";
            } else {
                sql = sql + names.get(i) + ")";
            }
        }
        sql = sql + " values (";
        int size = 1;
        for (SQLData sqlDatas : sqlList) {
            List<Object> datas = sqlDatas.getData();
            for (int i = 0; i < datas.size(); i++) {
                if (size != datas.size() * sqlList.size()) {
                    sql = sql + datas.get(i) + ",";
                } else {
                    sql = sql + datas.get(i);
                }
            }
        }
        sql = sql + ")";
        return sql;
    }

    private static String sqlStatement(Object object, String surface) throws Exception {
        String sql = "insert into " + surface + " (";
        SQLData sqlData = getNameAndType(object);
        List<String> names = sqlData.getName();
        for (int i = 0; i < names.size(); i++) {
            if (i != names.size() - 1) {
                sql = sql + names.get(i) + ",";
            } else {
                sql = sql + names.get(i) + ")";
            }
        }
        sql = sql + " values (";
        List<Object> datas = sqlData.getData();
        for (int i = 0; i < datas.size(); i++) {
            Object value = datas.get(i);
            if(StringUtils.isBlank(value.toString())){
                value = "\"\"";
            }
            if (i != datas.size() - 1) {
                sql = sql + value + ",";
            } else {
                sql = sql + value;
            }
        }
        sql = sql + ")";
        return sql;
    }

    /**
     * @Author: liuys
     * @Data: 2020/6/2
     * @Description: 获取属性名称，类型和值
     */
    private static List<SQLData> getNameAndType(List<?> list) throws Exception {
        List<SQLData> sqlList = new ArrayList<SQLData>();
        for (Object object : list) {
            SQLData sqlData = getNameAndType(object);
            sqlList.add(sqlData);
        }
        return sqlList;
    }

    private static SQLData getNameAndType(Object object) throws Exception {
        Class<?> classEntity = object.getClass();
        Field[] fields = classEntity.getDeclaredFields();
        SQLData sqlData = new SQLData();
        List<String> nameList = new ArrayList<>();
        List<String> typeList = new ArrayList<>();
        List<Object> dataList = new ArrayList<>();
        for (Field field : fields) {
            String name = getName(field);
            nameList.add(name);
            sqlData.setName(nameList);
            String type = getType(field);
            typeList.add(type);
            sqlData.setType(typeList);
            String data = getData(object, classEntity, name);
            Object conversion = conversion(type, data);
            dataList.add(conversion);
            sqlData.setData(dataList);
        }
        return sqlData;
    }

    /**
     * @Author: liuys
     * @Data: 2020/6/1
     * @Description: 创建链接池（使用先创建）
     */
    public static Connection createConnection() {
        Connection conn = null;
        /*String abso = SQLiteUtils.class.getResource("/").getPath();
        String replace = abso.substring(1);
        replace = replace.substring(0, 1).toLowerCase() + replace.substring(1);*/
        try {
            Class.forName(className);
            conn = DriverManager.getConnection(jdbcDriver + path);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static Connection createConnection(String file) {
        Connection conn = null;
        try {
            Class.forName(className);
            conn = DriverManager.getConnection(jdbcDriver + file);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * @Author: liuys
     * @Data: 2020/6/1
     * @Description: 关闭数据库连接->创建后关闭流
     */
    public static void connect(Connection connection) throws Exception {
        if (connection != null) {
            connection.close();
        }
    }

    /**
     * @Author: liuys
     * @Data: 2020/6/2
     * @Description: 获取属性名称
     */
    private static String getName(Field field) {
        String name = field.getName();
        return name;
    }

    /**
     * @Author: liuys
     * @Data: 2020/6/2
     * @Description: 获取类型
     */
    private static String getType(Field field) {
        String types = field.getType().toString();
        int one = types.lastIndexOf(".");
        String type = types.substring(one + 1, types.length());
        return type;
    }

    /**
     * @Author: liuys
     * @Data: 2020/6/2
     * @Description: 获取参数
     */
    private static String getData(Object object, Class<?> classEntity, String name) throws IllegalAccessException, InvocationTargetException {
        String property = name.substring(0, 1).toUpperCase() + name.substring(1);
        Method method = null;
        try {
            method = classEntity.getMethod("get" + property);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        String value;
        try {
            value = method.invoke(object).toString();
        } catch (NullPointerException e) {
            value = null;
        }
        return value;
    }


    /**
     * @Author: liuys
     * @Data: 2020/6/2
     * @Description: sql类型转换
     */
    public static Object conversion(String type, String value)throws Exception {
        if (type.equals("Date")) {
            if (value == null)
                return "";
            if (value != null) {
                Date parse = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.US).parse(value);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                return "'" + simpleDateFormat.format(parse) + "'";
            }
        } else if (type.equals("Integer")) {
            if (value == null)
                return 0;
            if (value != null) {
                Integer integer = 0;
                try {
                    integer = Integer.valueOf(value);
                } catch (NumberFormatException e) {
                    integer = 0;
                }
                return integer;
            }
        } else if (type.equals("Long")) {
            if (value == null)
                return 0L;
            return new Long(value);
        }else if (type.equals("Short")) {
            if (value == null)
                return 0;
            return Short.valueOf(value);
        } else if (type.equals("BigDecimal")) {
            if (value == null)
                return new BigDecimal(0);
            return new BigDecimal(value);
        } else {
            if (value==null){
                return "";
            }
            return "'" + value + "'";
        }
        return value;
    }


    public static Object conversion(Class<?> type, String value) throws ParseException, NumberFormatException {
        if (value.isEmpty()) {
            return null;
        }
        String types = type.toString();
        int one = types.lastIndexOf(".");
        String attr = types.substring(one + 1, types.length());
        if (attr.equals("String")) {
            return value;
        }
        if (attr.equals("Date")) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            Date date = dateFormat.parse(value);
            return date;
        }
        if (attr.equals("Long")) {
            return new Long(value);
        }
        if (attr.equals("BigDecimal")) {
            return new BigDecimal(value);
        }
        if (attr.equals("Integer")) {
            Integer integer = Integer.valueOf(value);
            return integer;
        }
        if (attr.equals("Short")) {
            if (value.isEmpty() || value==""){
                return value;
            }
            return Short.valueOf(value);
        }
        if (attr.equals("byte[]")) {
            return value.getBytes();
        }
        return null;
    }

    public SQLiteUtils(String className,String jdbcDriver) {
        SQLiteUtils.className = className;
        SQLiteUtils.jdbcDriver = jdbcDriver;
    }

    public SQLiteUtils(String className,String jdbcDriver,String path) {
        SQLiteUtils.className = className;
        SQLiteUtils.jdbcDriver = jdbcDriver;
        SQLiteUtils.path = path;
    }

    public static void setPath(String path) {
        SQLiteUtils.path = path;
    }

    public static void setClassName(String className) {
        SQLiteUtils.className = className;
    }

    public static void setJdbcDriver(String jdbcDriver) {
        SQLiteUtils.jdbcDriver = jdbcDriver;
    }
}
