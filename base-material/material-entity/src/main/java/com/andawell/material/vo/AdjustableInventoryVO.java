package com.andawell.material.vo;/**
 * @Date： 2020/5/26 18:40
 */

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 *@Auther:liuys
 *@Date:2020/5/26 18:40
 *@Description:
 */
@Data
@ApiModel("库存信息")
public class AdjustableInventoryVO {

    /**
     *仓库
     */
    private String dwid;

    /**
     *仓库可调数
     */
    private String kdsl;

}
