package com.andawell.material.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

/**
* @ClassName: TJhImage
* @Description: 
* @author: Mybatis Generator
* @date 2020年05月07日 下午03:28:07
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TJhImage {
    /**
     * null
     */
    @NotBlank(message = "件号id不能为空")
    private String jh;

    /**
     * null
     */
    private byte[] image;
}