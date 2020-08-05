package com.andawell.common.util;/**
 * @Date： 2020/6/2 13:31
 */

import lombok.Data;

import java.util.List;

/**
 *@Auther:liuys
 *@Date:2020/6/2 13:31
 *@Description:
 */
@Data
public class SQLData {
    private List<String> name;
    private List<String> type;
    private List<Object> data;
}
