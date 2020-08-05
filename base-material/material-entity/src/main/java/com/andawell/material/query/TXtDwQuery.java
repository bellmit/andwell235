package com.andawell.material.query;/**
 * @Date： 2020/7/7 13:36
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *@Auther:liuys
 *@Date:2020/7/7 13:36
 *@Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TXtDwQuery {

    /**
     *@Author: liuys
     *@Data: 2020/7/7
     *@Description: 根据id向右模糊查询
     */
    private String rightLikeId;
}
