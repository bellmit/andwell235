package com.andawell.material.dto;/**
 * @Date： 2020/5/18 16:55
 */

import com.andawell.material.utils.ValidableList;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import java.util.List;

/**
 *@Auther:liuys
 *@Date:2020/5/18 16:55
 *@Description:
 */
@Data
@ApiModel("排故归还信息")
public class ReturnShootingDTO {

    //排故缓存信息
    @Valid
    private ValidableList<TCkPglyqdDTO> list;
  
}
