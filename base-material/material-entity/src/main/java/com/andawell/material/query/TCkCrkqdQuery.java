package com.andawell.material.query;

import com.andawell.common.entity.dto.PageDto;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
* @ClassName: TCkCrkqd
* @Description: 
* @author: Mybatis Generator
* @date 2020年05月06日 下午04:28:25
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TCkCrkqdQuery {
    /**
     * 编号
     */
    @ApiModelProperty(value = "编号")
    private String bh;
    /**
     * 机型
     */
    @ApiModelProperty(value = "jx")
    private String jx;
    /**
     * 件号
     */
    @ApiModelProperty(value = "jh")
    private String jh;

    /**
     * 红冲标示  默认是0 未冲销, 1是已冲销，-1 增加的冲销记录
     */
    @ApiModelProperty(value = "红冲标示  默认是0 未冲销, 1是已冲销，-1 增加的冲销记录",required = true)
    private String cxsgin;
    /**
     * 单位ID
     */
    @ApiModelProperty(value = "单位ID")
    private String dwid;

    /**
     * 类别ID
     */
    @ApiModelProperty(value = "类别ID")
    private String lb;

    /**
     * 选择
     */
    @ApiModelProperty(value = "选择")
    private String xz;

    /**
     * 质量
     */
    @ApiModelProperty(value = "质量")
    private String zl;
}