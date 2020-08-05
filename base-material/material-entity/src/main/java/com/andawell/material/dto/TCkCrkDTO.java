package com.andawell.material.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @ClassName: TCkCrk
 * @Description:
 * @author: Mybatis Generator
 * @date 2020年05月06日 下午04:28:25
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TCkCrkDTO {

    /**
     * 编号
     */
    @NotBlank(message = "编号不能为空")
    @ApiModelProperty(name = "bh", value = "编号不能为空", required = true)
    private String bh;

    /**
     * 回执接收人
     */
    @NotBlank(message = "回执接收人不能为空")
    @ApiModelProperty(name = "hzjsr", value = "回执接收人不能为空", required = true)
    private String hzjsr;
    /**
     * 回执状态0:未收到；1:已收到
     */
    @NotBlank(message = "回执状态不能为空")
    @ApiModelProperty(name = "hzzt", value = "回执状态不能为空", required = true)
    private String hzzt;
    /**
     * 回执时间
     */
    @NotNull(message = "回执时间不能为空")
    @ApiModelProperty(name = "hzsj", value = "回执时间不能为空", required = true)
    private Date hzsj;

}