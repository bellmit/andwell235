package com.andawell.common.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author PC
 * 默认储存地信息
 */
@Getter
@Setter
@ToString
public class DefaultInventory implements Serializable {
    private static final long serialVersionUID = 1428713129016325491L;
    private String id;
    private String name;
}
