package com.andawell.upms.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/***
 * @ClassName: SelectStatusMenuTreeVo
 * @Description:
 * @Auther: PC
 * @Date: 2020/1/7 9:37
 * @version : V1.0
 */
@Getter
@Setter
@ToString
public class SelectStatusMenuTreeVo {
    private List<String> isCheckedAuth;
    private List<MenuTreeVo> menuTreeVoList;
}
