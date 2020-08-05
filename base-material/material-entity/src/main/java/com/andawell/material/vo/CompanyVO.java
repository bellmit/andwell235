package com.andawell.material.vo;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;

import java.util.List;

/**
 * @Date： 2020/4/27 14:32
 */
@Data
@ApiModel("所有单位树型信息")
public class CompanyVO {
    @ApiModelProperty(name = "id", value = "id", dataType = "String")
    private String id;

    @ApiModelProperty(name = "mc", value = "名称", dataType = "String")
    private String mc;

    @ApiModelProperty(name = "fh", value = "fh", dataType = "String")
    private String fh;

    @ApiModelProperty(name = "jm", value = "简码", dataType = "String")
    private String jm;

    @ApiModelProperty(name = "ejm", value = "ejm", dataType = "String")
    private String ejm;

    @ApiModelProperty(name = "pid", value = "pid", dataType = "String")
    private String pid;

    @ApiModelProperty(name = "jc", value = "简称", dataType = "String")
    private String jc;

    @ApiModelProperty(name = "companyVOList", value = "字节点", dataType = "String")
    private List<CompanyVO> companyVOList;
}
