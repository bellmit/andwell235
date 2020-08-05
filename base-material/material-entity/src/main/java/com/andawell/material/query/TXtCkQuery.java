package com.andawell.material.query;

import com.andawell.common.entity.dto.PageDto;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/***
 * @author lhb
 * @Date: 2020/4/26 17:26
 * @Description:
 * @version : V1.0
 */
@Data
@Accessors(chain = true)
@AllArgsConstructor
public class TXtCkQuery extends PageDto {

    @ApiModelProperty(value = "dwid", name = "单位代码", dataType = "String")
    private String dwid;
    @ApiModelProperty(value = "ckid", name = "仓库代码", dataType = "String")
    private String ckid;
    @ApiModelProperty(value = "mc", name = "仓库名称", dataType = "String")
    private String mc;
    @ApiModelProperty(value = "lx", name = "仓库类型 0普通;1密集", dataType = "Long")
    private Long lx;

    private List<String> ckids;
}
