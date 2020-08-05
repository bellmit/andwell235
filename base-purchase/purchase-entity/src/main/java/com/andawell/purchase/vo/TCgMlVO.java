package com.andawell.purchase.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
* @ClassName: TCgMl
* @Description: 
* @author: Mybatis Generator
* @date 2020年05月29日 下午03:37:01
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TCgMlVO {
    /**
     * 自增id
     */
    @ApiModelProperty(value = "自增id")
    private Long id;

    /**
     * 目录编号
     */
    @ApiModelProperty(value = "目录编号")
    private String mlBh;

    /**
     * 目录版本
     */
    @ApiModelProperty(value = "目录版本")
    private String mlBb;

    /**
     * 目录子版本
     */
    @ApiModelProperty(value = "目录子版本")
    private Integer mlZb;

    /**
     * 目录发布日期
     */
    @ApiModelProperty(value = "目录发布日期")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date mlFbRq;

    /**
     * 目录修改日期
     */
    @ApiModelProperty(value = "目录修改日期")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date mlXgRq;

    /**
     * 目录颁布单位
     */
    @ApiModelProperty(value = "目录颁布单位")
    private String mlBbDw;

    /**
     * 目录说明
     */
    @ApiModelProperty(value = "目录说明")
    private String mlSm;

    /**
     * 目录状态(1.生效，2.无效，3.修订中，4.已删除)
     */
    @ApiModelProperty(value = "目录状态")
    private int status;

}