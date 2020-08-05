package com.andawell.material.dto;

import com.andawell.material.entity.TDbSjsq;
import com.andawell.material.entity.TDbSjsqqd;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author: zje
 * @date: 2020/6/10
 * @description:
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TDbjgDTO {

    List<TDbSjsq> tDbSjsqs;

    List<TDbSjsqqd> tDbSjsqqds;
}
