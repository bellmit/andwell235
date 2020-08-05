package com.andawell.material.vo;/**
 * @Date： 2020/5/9 11:19
 */

import com.andawell.common.entity.dto.PageDto;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.Date;

/**
 *@Auther:gzh
 *@Date:2020/5/9 11:19
 *@Description:
 */
@Data
@ApiModel("全新可用库存明细")
public class NewRepertoryCountMxVO extends PageDto {

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
     * 序号
     * */
    private String xh;

    /**
     * 质量名称
     * */
    private String zl;

    /**
     * 计量单位
     * */
    private String jldw;

    /**
     * 单价
     * */
    private String dj;

    /**
     * 所属战区dwid
     * */
    private String dwid;

    /**
     * 所属战区
     * */
    private String sszq;

    /**
     * 入库日期
     * */
    private Date rkrq;



}
