package com.andawell.material.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* @ClassName: TJhJxjh
* @Description: 
* @author: Mybatis Generator
* @date 2020年05月07日 下午04:07:10
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TJhJxjh {
    /**
     * 机型
     */
    private String jx;

    /**
     * 件号
     */
    private String jh;


    /**
     * 单机安装数
     **/
    private  Integer djazs;

/*    public TJhJxjh(String jx, String jh) {
        this.jx = jx;
        this.jh = jh;
    }

    public TJhJxjh() {
    }*/
}