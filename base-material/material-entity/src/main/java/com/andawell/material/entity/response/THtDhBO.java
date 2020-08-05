package com.andawell.material.entity.response;

import com.andawell.material.entity.THtDh;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Date： 2020/4/30 9:53
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class THtDhBO extends THtDh {

    /**
     * 来货单位（T_CF查询出来）
     */
    private String cfmc;
}

