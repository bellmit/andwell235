package com.andawell.material.dto;

import com.andawell.material.entity.TTzzCk;
import com.andawell.material.entity.TTzzCrk;
import com.andawell.material.entity.TTzzCrkqd;
import lombok.*;


import java.util.List;

/**
 * @Author:PCJ
 * @Date:2020/5/18
 * @Version:V1.0.0
 */
@Setter
@Getter
public class TTzzWzCrkDto {

    private List<TTzzCk> tTzzCkList;

    private TTzzCrk tTzzCrk;

    private List<TTzzCrkqd> tTzzCrkqdList;

}
