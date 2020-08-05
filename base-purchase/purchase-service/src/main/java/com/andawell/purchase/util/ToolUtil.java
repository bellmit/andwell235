package com.andawell.purchase.util;

import com.andawell.common.util.SysUserUtils;
import com.andawell.material.query.SystemNumberQuery;
import com.andawell.purchase.entity.TDhJh;
import com.andawell.purchase.entity.TDhJhqd;
import com.andawell.purchase.vo.TDhJhqdVO;
import lombok.extern.slf4j.Slf4j;

import java.text.DecimalFormat;
import java.time.Year;
import java.util.Calendar;
import java.util.GregorianCalendar;

/***
 * @author lhb
 * @Date: 2020/6/4 15:55
 * @Description:
 * @version : V1.0
 */
@Slf4j
public class ToolUtil {


    /**
     * 流水号 固定长度为 四位
     */
    private static final String STR_FORMAT = "0000";
    /**
     * 流水号 固定长度为 三位
     */
    private static final String STR_FORMAT_WH = "000";

    public static final String SING = "-";

    private static final String LH = "LH";

    /**
     * 获取年份
     * @return
     */
    public static int getYear(){
        GregorianCalendar g = new GregorianCalendar();
        int year = (int)g.get(Calendar.YEAR);
        return year;
    }


    /**
     * 获取拼接 系统编号
     * @param tDhJhqdVO
     * @return
     */

    public static String getHtBh (TDhJhqd tDhJhqdVO){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getYear());
        stringBuilder.append("LH");
        stringBuilder.append(tDhJhqdVO.getHtjxjm());
        stringBuilder.append(SING);
        stringBuilder.append(tDhJhqdVO.getCjmc());
        // 价格类型拼接
        if(tDhJhqdVO.getJglxmc()!= null && tDhJhqdVO.getJglxmc().equals("暂定价")){
            stringBuilder.append("-1");
        }
        return stringBuilder.toString();
    }

    /**
     * 生成计划编号
     * @param tDhJh
     * @return
     */
    public static String getJhBh(TDhJh tDhJh,String nf){

        StringBuilder systemNumber = new StringBuilder();

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("JHBH");
        stringBuilder.append("-");
        stringBuilder.append(SysUserUtils.getUser().getDeptId());
        stringBuilder.append("LH");
        stringBuilder.append(nf);
        // 出入库类别简码+'-'+单位编码4位+'-'+LH+年度4位+'第'+4位流水号+'号'
        // 系统编码特殊规则 DBRK-1016-LH2012第0003号   HCCK-1016-LH2016第0001号
        stringBuilder.append("第");
        stringBuilder.append(haoAddOne(tDhJh));
        stringBuilder.append("号");
        return stringBuilder.toString();
    }

    public static String haoAddOne(TDhJh tDhJh){

        Integer intHao =0 ;

        if(tDhJh!=null){
          String lastSystemNumber = tDhJh.getBh();
            try {
                // 获取系统编码 流水号
                String serialNumber =
                        tDhJh.getBh().substring(lastSystemNumber.length()-5,lastSystemNumber.length()-1);

                intHao = Integer.parseInt(serialNumber);
                // 获取系统编码 年号
                if(!tDhJh.getJhnf().equals(lastSystemNumber.substring(
                        // 年号不相等从0 开始算起
                        lastSystemNumber.length()-10,lastSystemNumber.length()-6))){
                    intHao= 0;
                }
            }catch (Exception e){
                log.error("lastSystemNumber format error",e);
            }
        }
        intHao++;
        DecimalFormat df = new DecimalFormat(STR_FORMAT);
        return df.format(intHao);
    }
}
