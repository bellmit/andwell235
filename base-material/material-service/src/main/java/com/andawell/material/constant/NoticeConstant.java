package com.andawell.material.constant;

import com.andawell.common.entity.constant.RestResultMessageConstant;

/**
 * @author DCY
 */
public class NoticeConstant extends RestResultMessageConstant {

    public static final String RESPONSE_COLUMNS_ERROR_MESSAGE = "字段不符合约束条件";
    public static final String RESPONSE_CONTEXT_ERROR_MESSAGE = "传入对象缺失";
    public static final String RESPONSE_CHILDREN_NOTNULL_MESSAGE = "子级不为空，不能删除";
    public static final String RESPONSE_FULL_ID_MESSAGE = "本级数量达到最大值9，不能继续增加";
    public static final String RESPONSE_NOTFOUND_MESSAGE="未找到该记录";
    public static final String RESPONSE_EXIST_ALREADY_MESSAGE="该条记录已存在";
    public static final String RESPONSE_NUMBER_ERROR_MESSAGE="输入数量错误";
    public static final String RESPONSE_NOT_ENOUGH_MESSAGE="库存不足";
    public static final String RESPONSE_NAME_EXIST_MESSAGE="名称已存在";
    public static final String RESPONSE_INPUT_SUCCESS_MESSAGE="入库成功";
    public static final String RESPONSE_OUTPUT_SUCCESS_MESSAGE="出库成功";
    public static final String RESPONSE_INPUT_ERROR_MESSAGE="入库失败";
    public static final String RESPONSE_OUTPUT_ERROR_MESSAGE="出库失败";

}
