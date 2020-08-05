package com.andawell.material.dto;

import com.andawell.material.query.TCkCkUpdateQuery;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * @author: zje
 * @date: 2020/5/26
 * @description:
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TCkCrkqdDTO {



    private String fjlx;

    private String wh;

    private String yj;

    private Date rq;

    private String ysr;

    List<TCkCkUpdateQuery> ckcrkqds;


}
