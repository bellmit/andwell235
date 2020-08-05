package com.andawell.material.query;

import com.andawell.common.entity.dto.PageDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;
import org.checkerframework.checker.units.qual.min;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/***
 * @author lhb
 * @Date: 2020/4/26 17:26
 * @Description:
 * @version : V1.0
 */
@Data
@Accessors(chain = true)
@ApiModel("件号儿查询接口")
public class TJhJhQuery {

    @ApiModelProperty(name = "id", value = "id", dataType = "String")
    private String id;

    @ApiModelProperty(value = "每页记录数", dataType = "int")
    private Integer pageSize;

}
