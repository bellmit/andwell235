package com.andawell.purchase.query;

import com.andawell.common.entity.dto.PageDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
* @ClassName: TCsJglx
* @Description: 
* @author: Mybatis Generator
* @date 2020年06月06日 上午10:18:19
*/
@Data
@Accessors(chain = true)
public class TCsJglxQuery extends PageDto {
    /**
     * 价格依据ID
     */
    private String id;

    /**
     * 价格依据名称
     */
    private String mc;

    /**
     * 价格依据简码
     */
    private String jm;
}