package com.andawell.material.query;/**
 * @Date： 2020/5/19 14:20
 */

import com.andawell.common.entity.dto.PageDto;
import com.andawell.material.dto.groups.First;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 *@Auther:liuys
 *@Date:2020/5/19 14:20
 *@Description:
 */
@Data
public class TCkPglyqdQuery extends PageDto {

    /**
     * 机型
     */
    @NotBlank(message = "机型不能为空")
    @ApiModelProperty(value = "机型", name = "jx", dataType = "String")
    private String jx;

    /**
     * 件号
     */
    @NotBlank(message = "件号不能为空",groups = {First.class})
    @ApiModelProperty(value = "件号", name = "jh", dataType = "String")
    private String jh;

    /**
     * 序号(批次号)
     */
    @ApiModelProperty(value = "序号", name = "xh", dataType = "String")
    private String xh;

    /**
     * 红冲标示
     */
    @ApiModelProperty(value = "红冲标示", name = "cxsgin", dataType = "String")
    private String cxsgin="0";

    /**
     * 单位ID
     */
    @ApiModelProperty(value = "单位ID", name = "dwid", dataType = "String")
    private String dwid;

    /**
     * 0:借用状态(初始状态);1:已归还;2:已转领出
     */
    @ApiModelProperty(value = "选择", name = "xz", dataType = "String")
    private String xz="2";

    /**
     * 编号
     */
    @NotBlank(message = "编号不能为空",groups = {First.class})
    @ApiModelProperty(value = "编号", name = "bh", dataType = "String")
    private String bh;
/**
 *排故领用清单
 */

    /**
     * 开始时间
     */
    @ApiModelProperty(name = "startTime", value = "开始时间")
    private String startTime;

    /**
     * 结束时间
     */
    @ApiModelProperty(name = "endTime", value = "结束时间")
    private String endTime;
}
