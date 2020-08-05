package com.andawell.material.query;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TJhGzQuery {

    /**
     * 件号
     */
    @ApiModelProperty(name = "jh", value = "件号", dataType = "String")
    private String jh;
    /**
     * 机型
     */
    @ApiModelProperty(name = "jx", value = "机型", dataType = "String")
    private String jx;


    /**
     * yhid
     */
    @ApiModelProperty(name = "yhid", value = "用户id", dataType = "String")
    private String yhid;

    /**
     * 类型
     */
    @NotNull(message = "类型不能为空")
    @ApiModelProperty(name = "lx", value = "类型", dataType = "Integer")
    private Integer lx;
}
