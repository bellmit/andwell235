package com.andawell.material.dto;

import com.andawell.material.utils.ValidableList;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

/**
* @ClassName: TCkJsd
* @Description: 
* @author: Mybatis Generator
* @date 2020年06月02日 上午11:29:35
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TCkJsdBcDTO {
    /**
     * 结算单编号
     */
    @NotBlank(message = "结算单编号不能为空")
    @ApiModelProperty(value ="结算单编号",required = true)
    private String bh;


    /**
     * 合同号
     */
    @NotBlank(message = "合同号ID不能为空")
    @ApiModelProperty(value ="合同号",required = true)
    private String yj;


    /**
     *结算单
     */
    private TCkJsdDTO tCkJsdDTO;

    /**
     *结算清单  多条或单条
     */
    private ValidableList<TCkJsdqdDTO>  tCkJsdqdDTO;





}