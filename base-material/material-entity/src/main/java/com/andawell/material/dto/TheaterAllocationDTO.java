package com.andawell.material.dto;/**
 * @Date： 2020/5/25 16:54
 */

import com.andawell.material.utils.ValidableList;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;

/**
 *@Auther:liuys
 *@Date:2020/5/25 16:54
 *@Description:
 */
@Data
@ApiModel("战区和机关调拨")
public class TheaterAllocationDTO {

    @Valid
    TDbDbDTO tDbDbDTO;

    @Valid
    ValidableList<TDbDbqdDTO> tDbDbqdDTO;
}
