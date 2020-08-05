package com.andawell.material.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiParam;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @Date： 2020/5/6 17:57
 */
@Data
@Accessors(chain = true)
@ApiModel("交旧单位")
public class TJhJxQuery {
    /**
     * 0为根节点，1位子节点
     */
    @ApiParam(value = "序号指向", name = "Sgin")
    private Integer Sgin;
    /**
     * 父级id
     */
    @ApiParam(value = "父级id", name = "pid")
    private String pid;

    /**
     * 多个id
     */
    @ApiParam(value = "多个id", name = "pid")
    private List<String> ids;
}
