package com.andawell.material.dto;

import com.andawell.material.dto.groups.First;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/***
 * @author lhb
 * @Date: 2020/5/4 18:27
 * @Description:
 * @version : V1.0
 */
@Data
@AllArgsConstructor
@ApiModel("系统编号文号请求入参")
public class SystemNoDetailDTO {


    @NotBlank(message = "出入库类别简码不为空")
    @ApiModelProperty(name = "lbjm", value = "出入库类别简码",required = true)
    private String lbjm;

    @NotBlank(message = "单位Id不为空")
    @ApiModelProperty(name = "dwid", value = "单位Id",required = true)
    private String dwid;

    @NotBlank(message = "机型id不为空")
    @ApiModelProperty(name = "jxid", value = "机型id",required = true)
    private String jxid;


    @NotBlank(message = "质量类别不为空")
    @ApiModelProperty(name = "zllb", value = "质量类别别简码",required = true)
    private String zllb;


    @NotBlank(message = "机型简码不为空")
    @ApiModelProperty(name = "jm", value = "机型简码",required = true)
    private String jm;

    @ApiModelProperty(name = "isGetSystemNo", value = "报废入库状态")
    private Boolean isGetSystemNo=false;


    @ApiModelProperty(name = "isUpdate", value = "是否重新获取")
    private Boolean isUpdate=true;

    @ApiModelProperty(name = "state", value = "编号")
    private String state;

    public SystemNoDetailDTO(String jxid, String zllb,String jm) {
        this.jxid = jxid;
        this.zllb = zllb;
        this.jm = jm;
    }

    public SystemNoDetailDTO(String lbjm, String dwid) {
        this.lbjm = lbjm;
        this.dwid = dwid;
    }
}
