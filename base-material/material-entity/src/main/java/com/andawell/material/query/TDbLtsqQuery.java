package com.andawell.material.query;

import com.andawell.common.entity.dto.PageDto;
import com.andawell.material.dto.groups.First;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import java.util.List;

/***
 * @author shs
 * @Date: 2020/5/14 15:54
 * @Description:
 * @version : V1.0
 */
@Data
@Accessors(chain = true)
public class TDbLtsqQuery extends PageDto {
    /**
     * 申请单号
     */
    @ApiModelProperty(value = "申请单号", name = "ltsqdh", dataType = "String")
    private String ltsqdh;

    /**
     *@Author: liuys
     *@Data: 2020/5/26
     *@Description: 登录人单位id
     */
    @ApiModelProperty(value = "dwid", name = "登录人单位id", dataType = "String")
    private String dwid;


    /**
     * 申请单号
     */
    @ApiModelProperty(value = "多个申请单号", name = "ltsqdhs", dataType = "list")
    private List<String> ltsqdhs;

    /**
     * 状态
     */
    private String style;

}
