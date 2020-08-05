package com.andawell.material.dto;

import com.andawell.common.entity.search.ListCommon;
import com.andawell.material.utils.ValidableList;
import com.andawell.material.vo.TCkDxStatusVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.List;

/***
 * @author hwd
 * @Date: 2020-05-08 08:15
 * @Description:批量转换入参
 * @version : V1.0
 */
@Data
@ApiModel("批量转换入参")
public class BatchChangeDTO {

    /**
     * 有可能是多参
     * 质量转换入参
     */
    @Valid
    private ValidableList<TCkDxStatusDTO> tCkDxStatusDTOS;

    @NotBlank(message = "转换说明不能为空")
    @ApiModelProperty(name = "zhsm", value = "转换说明")
    private String  zhsm;


    @ApiModelProperty(name = "zhrq", value = "转换日期")
    private Date zhrq;


    private String style;
}
