package com.andawell.material.query;/**
 * @Date： 2020/5/9 10:42
 */

import com.andawell.common.entity.dto.PageDto;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

/**
 *@Auther:liuys
 *@Date:2020/5/9 10:42
 *@Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TCkSxLikeQuery extends PageDto {
    /**
     * 机型
     */
    @NotBlank(message = "机型不能为空")
    @ApiModelProperty(name = "jx", value = "机型")
    private String jx;

    /**
     * 件号
     */
    @NotBlank(message = "件号不能为空")
    @ApiModelProperty(name = "jh", value = "件号")
    private String jh;
}
