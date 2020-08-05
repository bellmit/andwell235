package com.andawell.material.dto;

import com.andawell.material.dto.groups.First;
import com.andawell.material.entity.TDbDb;
import com.andawell.material.entity.TDbDbqd;
import com.andawell.material.utils.ValidableList;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;

/***
 * @author hwd
 * @Date: 2020-05-21 16:28
 * @Description:
 * @version : V1.0
 */
@Data
@ApiModel("机关调拨")
public class TDbDbAndQdDTO
{
    /**
     * T_DB_DB
     */
    @Valid
    private TDbDbDTO tDbDb;

    /**
     * T_DB_DBQD
     */
    @Valid
    private ValidableList<TDbDbqdDTO> tDbDbqds;
}
