package com.andawell.upms.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/***
 * @ClassName: CommonAuthInfo
 * @Description:
 * @Auther: PC
 * @Date: 2019/12/30 14:11
 * @version : V1.0
 */
@Data
@Getter
@Setter
@ToString
@ApiModel("公共权限信息对象")
public class CommonAuthInfo {
    @ApiModelProperty(value = "ID", name = "id", dataType = "String")
    private String id;
    @ApiModelProperty(value = "名称", name = "name", dataType = "String")
    private String name;
}
