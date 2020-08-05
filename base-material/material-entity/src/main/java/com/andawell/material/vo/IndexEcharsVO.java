package com.andawell.material.vo;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author: yzy
 * @Description:
 * @Date: created in 2020/7/6 17:26
 */
@Data
@ApiModel("首页Echars统计")
@NoArgsConstructor
@AllArgsConstructor
public class IndexEcharsVO {

    private String mouth;
    private Integer ckCount;
    private Integer rkCount;
}
