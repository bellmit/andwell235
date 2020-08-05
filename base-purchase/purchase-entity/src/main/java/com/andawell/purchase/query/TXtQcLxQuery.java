package com.andawell.purchase.query;

import com.andawell.common.entity.dto.PageDto;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@Accessors(chain = true)
public class TXtQcLxQuery extends PageDto {
    /**
     * 主键Id
     */
    private String id;

    /**
     * 名称
     */
    private String qcMc;

    /**
     * 状态主键（预留字段）
     */
    private Integer status;

}
