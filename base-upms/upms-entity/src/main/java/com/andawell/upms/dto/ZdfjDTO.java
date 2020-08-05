package com.andawell.upms.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

/**
 * @ClassName: TXtZdfj
 * @Description:
 * @author: Mybatis Generator
 * @date 2020年05月08日 下午06:02:29
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ZdfjDTO {
    /**
     * 单位代码
     */
    @NotBlank(message = "单位id不能为空")
    private String dwid;

    /**
     * 中队代码
     */
    @NotBlank(message = "中队id不能为空")
    private String zdid;

    /**
     * 原飞机号
     */
    @NotBlank(message = "原飞机号不能为空")
    private String ymc;

    /**
     * 新飞机号
     */
    @NotBlank(message = "新飞机号不能为空")
    private String xmc;
}