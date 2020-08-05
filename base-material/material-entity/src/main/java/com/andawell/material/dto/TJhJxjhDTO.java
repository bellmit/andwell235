package com.andawell.material.dto;

import com.andawell.material.utils.ValidableList;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;


/**
 * @Date： 2020/5/6 18:00
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class  TJhJxjhDTO {
    /**
     * 机型
     */
    @NotBlank(message = "机型代码不能为空")
    @ApiModelProperty(name = "jx;", value = "机型代码",required = true)
    private String jx;

    /**
     * 件号
     */
    @NotNull(message = "件号代码不能为空")
    @ApiModelProperty(name = "jh;", value = "机型代码",required = true)
    private List<String> jh;

    @ApiModelProperty(name = "isAll;", value = "是否全部增",required = true)
    private boolean isAll;

}
