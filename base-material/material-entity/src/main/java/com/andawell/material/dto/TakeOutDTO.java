package com.andawell.material.dto;/**
 * @Date： 2020/5/20 11:24
 */

import com.andawell.material.utils.ValidableList;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.validation.Valid;

/**
 *@Auther:liuys
 *@Date:2020/5/20 11:24
 *@Description:
 */
@Data
@ApiModel("领出")
public class TakeOutDTO {
    /**
     * T_CK_CK和T_CK_CRKQD
     */
    @Valid
    private ValidableList<OutLibraryDetailDTO> list;

    /**
     * 系统编号入参
     */
    @Valid
    private SystemNoDetailDTO systemNoDetailDTO;
}
