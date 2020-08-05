package com.andawell.material.vo;/**
 * @Date： 2020/5/9 11:19
 */

import com.andawell.common.entity.dto.PageDto;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 *@Auther:gzh
 *@Date:2020/5/9 11:19
 *@Description:
 */
@Data
@ApiModel("全新可用库存统计")
public class NewRepertoryCountVO extends PageDto {

    /**
     * 机型
     * */
    private String jx;

    /**
     * 机型名称
     * */
    private String jxmc;


    /**
     * 件号
     * */
    private String jh;

    /**
     * 件号名称
     * */
    private String jhmc;

    /**
     * 质量名称
     * */
    private String zl;

    /**
     * 总价
     * */
    private String zj;

    /**
     * 总数
     * */
    private String zs;

    /**
     * 战区dwid
     * */
    private String dwid;

    /**
     * 战区
     * */
    private String sszq;

    /**
     * 数量
     * */
    private Integer sl;



}
