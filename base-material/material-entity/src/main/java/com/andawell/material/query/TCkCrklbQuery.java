package com.andawell.material.query;

import com.andawell.common.entity.dto.PageDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/***
 * @author lhb
 * @Date: 2020/5/6 17:10
 * @Description:
 * @version : V1.0
 */
@Data
@ApiModel("出入库类别查询信息")
public class TCkCrklbQuery extends PageDto {

    /**
     * 出入库类别代码
     */
    @ApiModelProperty(value = "出入库类别代码")
    private String id;

    /**
     * 出入库名称
     */
    @ApiModelProperty(value = "出入库名称")
    private String mc;

    /**
     * 出入库简码
     */
    @ApiModelProperty(value = "出入库简码")
    private String jm;

    /**
     * 上级代码
     */
    @ApiModelProperty(value = "上级代码")
    private String pid;

    /**
     * 对于入库  1表示新增一条记录，0表示更新原有记录 对于出库  1表示减少一条记录，0表示更新原有记录
     */
    @ApiModelProperty(value = "对于入库  1表示新增一条记录，0表示更新原有记录 对于出库  1表示减少一条记录，0表示更新原有记录")
    private String xz;

    @ApiModelProperty(value = "id数组，进行多个id查询",name = "ids")
    List<String> ids;
}
