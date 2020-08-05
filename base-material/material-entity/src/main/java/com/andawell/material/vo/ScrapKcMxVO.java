package com.andawell.material.vo;/**
 * @Date： 2020/5/9 11:19
 */

import cn.hutool.db.DaoTemplate;
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
@ApiModel("报废库存明细")
public class ScrapKcMxVO extends PageDto {

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
     * 所属战区dwid
     * */
    private String dwid;

    /**
     * 所属战区
     * */
    private String sszq;

    /**
     * 报废原因
     * */
    private String bfyy;

    /**
     * 保费日期
     * */
    private Date bfrq;


}
