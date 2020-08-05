package com.andawell.upms.query;

import com.andawell.common.entity.dto.PageDto;
import com.andawell.upms.enumeration.SysDictType;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/***
 * @ClassName: SysRoleInfo
 * @Description:
 * @Auther: PC
 * @Date: 2019/12/19 17:45
 * @version : V1.0
 */
@Data
@Accessors(chain = true)
public class SysDataDictQuery extends PageDto {
    private String id;
    @ApiModelProperty(value = "字典名称", name = "dictName", dataType = "String")
    private String dictName;
    @ApiModelProperty(value = "字典名称模糊搜索", name = "dictNameLike", dataType = "String")
    private String dictNameLike;
    @ApiModelProperty(value = "字典编号", name = "dictCode", dataType = "String")
    private String dictCode;
    @ApiModelProperty(value = "字典类型", name = "sysDictType", dataType = "SysDictType")
    private SysDictType sysDictType;
    @ApiModelProperty(value = "字典描述", name = "remark", dataType = "String")
    private String remark;
    @ApiModelProperty(value = "字典描述(模糊)", name = "remarkLike", dataType = "String")
    private String remarkLike;
}
