package com.andawell.common.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
public class DateDeptPermission implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private String name;
}
