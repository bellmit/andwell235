package com.andawell.material.util;/**
 * @Date： 2020/5/25 18:02
 */

import com.andawell.common.util.BusinessException;
import com.andawell.material.entity.TDbDb;
import com.andawell.material.mapper.TDbDbMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *@Auther:liuys
 *@Date:2020/5/25 18:02
 *@Description: 编号的工具类
 */
public class NumberUtils {

    /**
     * 流水号 固定长度为 三位
     */
    private static final String STR_FORMAT_BH = "000";
    /**
     * 流水号 固定长度为 四位
     */
    private static final String STR_FORMAT_DH = "0000";

    /**
     *@Author: liuys
     *@Data: 2020/5/25
     *@Description: 生成调拨单号
     */
    public static String getAllocationNO(String dbdh,String sbf){
        if (dbdh==null){
            return null;
        }
        String substring = dbdh.substring(dbdh.length()-5,dbdh.length()-1);
        Integer integer = Integer.valueOf(substring);
        integer++;
        String dh=sbf+"第"+String.format("%04d",integer)+"号";
        return dh;
    }


    public static String getdbdhnumber(String lastbh)
    {
        String sbf="DB-LH"+Utils.getSysYear();
        if (lastbh==null){
            return sbf+"第0001号";
        }
        return NumberUtils.getAllocationNO(lastbh,sbf);
    }

    public static StringBuffer getDBBhPrefix(String type)
    {
        StringBuffer bh=new StringBuffer();
        String sysYear = Utils.getSysYear();
        bh.append(sysYear);
        String documentNo = "";

        if(type.equals("1")) {
            //部队调拨
            //编号规则：4位年度+.+3位流水
            //示例：2020.004
            bh.append(".");
        }else if(type.equals("2")) {
            //工厂调拨
            //编号规则：4位年度+GC+3位流水
            //2020GC001
            bh.append("GC");
        }else {
            throw  new BusinessException("入参错误");
        }
        return bh;
    }


    /**
     * hwd
     * 封装流水号3
     * @return
     */
    public static String getDocumentNo(StringBuffer sbf,String bh)
    {
        try {
            //3位流水
            String number = bh.substring
                    (bh.length()-3,bh.length());
            DecimalFormat df = new DecimalFormat(STR_FORMAT_BH);
            sbf.append(df.format(Integer.parseInt(number)+1));
        }catch (Exception e){
            sbf.append("001");
        }
        return sbf.toString();
    }

    /**
     * hwd
     * 封装流水号4
     * @return
     */
    public  static String getDocumentNos(StringBuffer sbf,String bh)
    {
        try {
            //4位流水
            String number = bh.substring
                    (bh.length()-5,bh.length()-1);
            DecimalFormat df = new DecimalFormat(STR_FORMAT_DH);
            sbf.append("第"+df.format(Integer.parseInt(number)+1)+"号");
        }catch (Exception e){
            sbf.append("第0001号");
        }
        return sbf.toString();
    }

    /**
     * 获取下个月的今天
     * @return
     */
    public static Date  getNextMonthDate()
    {
        Date date = new Date();
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        instance.add(Calendar.DATE,31);
        date=instance.getTime();
        return date;
    }

}
