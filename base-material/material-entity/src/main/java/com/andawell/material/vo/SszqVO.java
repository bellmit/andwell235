package com.andawell.material.vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 *@Auther:shs
 *@Date:2020/7/13 08:59
 *@Description:
 */
@Data
@ApiModel("个人所属战区")
public class SszqVO {
    //单位id
    private String dwid;
    //所属战区
    private String  sszq;
}
