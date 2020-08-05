package com.andawell.upms.query;

import com.andawell.common.entity.dto.PageDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/***
 * @ClassName: SysOrganInfo
 * @Description:
 * @Auther: PC
 * @Date: 2019/12/19 17:45
 * @version : V1.0
 */
@Data
@Accessors(chain = true)
public class SysOrganInfoQuery extends PageDto {
    private String id;
    @ApiModelProperty(value = "部门编号", name = "organCode", dataType = "String")
    private String organCode;
    @ApiModelProperty(value = "组织机构名称", name = "organName", dataType = "String")
    private String organName;
    @ApiModelProperty(value = "父级ID", name = "pid", dataType = "String")
    private String pid;
    @ApiModelProperty(value = "部门描述", name = "remark", dataType = "String")
    private String remark;
}
