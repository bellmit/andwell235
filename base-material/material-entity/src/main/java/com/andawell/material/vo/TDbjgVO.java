package com.andawell.material.vo;

import com.andawell.material.entity.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author: zje
 * @date: 2020/6/9
 * @description:
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TDbjgVO {

    List<TDbSjsq> tDbSjsqs;

    List<TDbSjsqqd> tDbSjsqqds;
}
