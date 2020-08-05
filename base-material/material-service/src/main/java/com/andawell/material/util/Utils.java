package com.andawell.material.util;

import com.andawell.common.entity.enumeration.RestStatus;
import com.andawell.common.entity.vo.RestResultVo;
import com.andawell.material.constant.NoticeConstant;
import com.andawell.material.entity.TCkCrk;
import com.andawell.material.entity.TJhJx;
import com.andawell.material.query.SystemNumberQuery;
import lombok.extern.slf4j.Slf4j;

import java.text.DecimalFormat;
import java.util.Calendar;

/***
 * @author lhb
 * @Date: 2020/4/30 13:57
 * @Description:
 * @version : V1.0
 */
@Slf4j
public class Utils {

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
     * 获取当前年份
     * @return
     */
    public static String getSysYear(){

        Calendar date = Calendar.getInstance();

        String year = String.valueOf(date.get(Calendar.YEAR));

        return year;
    }


    public static String haoAddOne(String lastSystemNumber){

        Integer intHao =0 ;

        if(lastSystemNumber!=null){

            try {
                // 获取系统编码 流水号
                String serialNumber =
                        lastSystemNumber.substring(lastSystemNumber.length()-5,lastSystemNumber.length()-1);

                intHao = Integer.parseInt(serialNumber);
                // 获取系统编码 年号
                if(!getSysYear().equals(lastSystemNumber.substring(
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

    /**
     * 根据第一个编号，获取一个编号 ，流水号加一
     * @param systemNo
     * @return
     */
    public static String getNextNoBySystemNo(String systemNo){
        if (systemNo.isEmpty()){
            return null;
        }
        String[] s = systemNo.split("第");
        String[] s1 = s[1].split("号");
        String s2 = s1[0];
        //TODO 四位流水
        Integer integer = Integer.valueOf(s2);
        integer++;
        return s[0]+"第"+String.format("%04d",integer)+"号";
    }

    /**
     * 生成编号
     * @param systemNumberQuery
     * @param lastSystemNumber
     * @return
     */
    public static String getSystemNumberByRule(SystemNumberQuery systemNumberQuery,String lastSystemNumber){

        StringBuilder systemNumber = new StringBuilder();

        systemNumber.append(systemNumberQuery.getLb().toUpperCase());
        systemNumber.append(SING);
        systemNumber.append(systemNumberQuery.getDwid().toUpperCase());
        systemNumber.append(SING);
        systemNumber.append(LH);
        systemNumber.append(getSysYear());
        // 出入库类别简码+'-'+单位编码4位+'-'+LH+年度4位+'第'+4位流水号+'号'
        // 系统编码特殊规则 DBRK-1016-LH2012第0003号   HCCK-1016-LH2016第0001号
        systemNumber.append("第");
        systemNumber.append(haoAddOne(lastSystemNumber));
        systemNumber.append("号");
        return systemNumber.toString();
    }

    /**
     * 生成序列文号
     * @param tJhJx
     * @param wh
     * @param zllb
     * @return
     */
    public static String getDocumentNo(TJhJx tJhJx, String wh, String zllb){

        StringBuilder documentNo = new StringBuilder();

        // 机型简码+入库质量类别+年度2位+3位流水
        documentNo.append(tJhJx.getJm().toUpperCase());
        documentNo.append(zllb.toUpperCase());
        documentNo.append(getSysYear().substring(2,getSysYear().length()));
        try {
            //3位流水
            String number = wh.substring
                    (wh.length()-3,wh.length());

            DecimalFormat df = new DecimalFormat(STR_FORMAT_WH);
            documentNo.append(df.format(Integer.parseInt(number)+1));
        }catch (Exception e){
            documentNo.append("001");
        }
        return documentNo.toString();
    }

    /**
     * 添加成功失败
     * @param isSuccess
     * @return
     */
    public static RestResultVo getAddResult(Boolean isSuccess){
        RestResultVo<Boolean> responseResult;
        if (isSuccess) {
            responseResult = new RestResultVo<Boolean>(RestStatus.SUCCESS,
                    NoticeConstant.RESPONSE_ADD_SUCCESS_MESSAGE);
        } else {
            responseResult = new RestResultVo<Boolean>(RestStatus.ERROR,
                    NoticeConstant.RESPONSE_ADD_ERROR_MESSAGE);
        }
        return responseResult;
    }

    /**
     * 修改成功失败
     * @param isSuccess
     * @return
     */
    public static RestResultVo getReciseResult(Boolean isSuccess){
        RestResultVo<Boolean> responseResult;
        if (isSuccess) {
            responseResult = new RestResultVo<Boolean>(RestStatus.SUCCESS,
                    NoticeConstant.RESPONSE_UPDATE_SUCCESS_MESSAGE);
        } else {
            responseResult = new RestResultVo<Boolean>(RestStatus.ERROR,
                    NoticeConstant.RESPONSE_UPDATE_ERROR_MESSAGE);
        }
        return responseResult;
    }


    /**
     * 导入成功失败
     * @param isSuccess
     * @return
     */
    public static RestResultVo getLeadResult(Boolean isSuccess){
        RestResultVo<Boolean> responseResult;
        if (isSuccess) {
            responseResult = new RestResultVo<Boolean>(RestStatus.SUCCESS,
                    NoticeConstant.RESPONSE_IMPORT_SUCCESS_MESSAGE);
        } else {
            responseResult = new RestResultVo<Boolean>(RestStatus.ERROR,
                    NoticeConstant.RESPONSE_IMPORT_ERROR_MESSAGE);
        }
        return responseResult;
    }

    /**
     * 删除成功失败
     * @param isSuccess
     * @return
     */
    public static RestResultVo deleteDataResult(Boolean isSuccess){
        RestResultVo<Boolean> responseResult;
        if (isSuccess) {
            responseResult = new RestResultVo<Boolean>(RestStatus.SUCCESS,
                    NoticeConstant.RESPONSE_DELETE_SUCCESS_MESSAGE);
        } else {
            responseResult = new RestResultVo<Boolean>(RestStatus.ERROR,
                    NoticeConstant.RESPONSE_DELETE_ERROR_MESSAGE);
        }
        return responseResult;
    }

}
