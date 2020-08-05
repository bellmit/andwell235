package com.andawell.purchase.dto;

import com.andawell.purchase.dto.groups.Insert;
import com.andawell.purchase.dto.groups.Update;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import java.util.Date;

/**
 * @Author:PCJ
 * @Date:2020/5/29
 * @Version:V1.0.0
 */
@Data
@Accessors(chain = true)
@ApiModel("采购目录")
@NoArgsConstructor
@AllArgsConstructor
public class TCgMlDTO {

    /**
     * 自增id
     */
    @ApiModelProperty(value = "自增id")
    private Long id;

    /**
     * 目录编号
     */
    @ApiModelProperty(value = "目录编号")
    private String mlbh;

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
    @ApiModelProperty(value = "目录颁布单位",required = true)
    @NotBlank(message = "颁布单位不为NULl",groups = {Insert.class})
    private String mlBbDw;

    /**
     * 目录说明
     */
    @ApiModelProperty(value = "目录说明",required = true)
    @NotBlank(message = "目录说明,不为NULl",groups = {Insert.class})
    private String mlSm;

    /**
     * 目录状态(1.生效，2.无效，3.修订中，4.已删除)
     */
    @ApiModelProperty(value = "目录状态(1.生效，2.无效，3.修订中，4.已删除)")
    private Short status;

}
