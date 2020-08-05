package com.andawell.upms.entity;

import com.andawell.common.entity.dto.CommonEntityDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/***
 * @ClassName: SysOrganInfo
 * @Description:
 * @Auther: PC
 * @Date: 2019/12/19 17:45
 * @version : V1.0
 */
@Data
@ApiModel("系统组织机构信息")
public class SysOrganInfo extends CommonEntityDto {
    private String id;
    @ApiModelProperty(value = "部门编号", name = "organCode", dataType = "String")
    private String organCode;
    @ApiModelProperty(value = "组织机构名称", name = "organName", dataType = "String")
    private String organName;
    @ApiModelProperty(value = "父级ID", name = "pid", dataType = "String")
    private String pid;
    @ApiModelProperty(value = "部门描述", name = "remark", dataType = "String")
    private String remark;

    private List<SysOrganInfo> children;
}
