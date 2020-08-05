package com.andawell.material.dto;/**
 * @Date： 2020/5/15 17:07
 */

import com.andawell.material.utils.ValidableList;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 *@Auther:liuys
 *@Date:2020/5/15 17:07
 *@Description:
 */
@Data
@ApiModel("排故详细信息")
public class TroubleShootingDTO {



    //排故主信息
    @Valid
    private TCkPglyDTO tCkPglyDTO;

    //排故缓存信息
    @Valid
    private ValidableList<TCkPglyqdDTO> list;

    /**
     * 系统编号入参
     */
    @Valid
    private SystemNoDetailDTO systemNoDetailDTO;


}
