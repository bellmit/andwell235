package com.andawell.material.dto;

import com.andawell.material.entity.TZyBz;
import com.andawell.material.entity.TZyBzmx;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

/***
 * @author hwd
 * @Date: 2020-05-20 16:48
 * @Description:手动常见
 * @version : V1.0
 */
@Data
@ApiModel("手动创建")
public class ManualCreationDTO {
    /**
     * 机型
     */
    @NotBlank(message = "机型不能为空")
    @ApiModelProperty(value = "机型",required = true)
    private String jx;

    /**
     * 地域
     */
    @NotNull(message = "地域不能为空")
    @ApiModelProperty(value = "地域",required = true)
    private Integer dy;

    /**
     * 任务性质
     */
    @NotNull(message = "任务性质不能为空")
    @ApiModelProperty( value = "任务性质",required = true)
    private Integer rwxz;

    /**
     * 飞机数
     */
    @NotNull(message = "飞机数不能为空")
    @ApiModelProperty(value = "飞机数",required = true)
    private Integer fjs;

    /**
     * 任务时长
     */
    @NotNull(message = "任务时长不能为空")
    @ApiModelProperty(value = "任务时长",required = true)
    private Integer rwsc;


    private List<TZyBzmx> tZyBzmxes;



}
