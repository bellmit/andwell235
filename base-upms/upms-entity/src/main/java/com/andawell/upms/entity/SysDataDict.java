package com.andawell.upms.entity;

import com.andawell.common.entity.dto.CommonEntityDto;
import com.andawell.upms.enumeration.SysDictType;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/***
 * @ClassName: SysDataDict
 * @Description:
 * @author DCY
 * @Date: 2020/1/2 10:29
 * @version : V1.0
 */
@Data
@Setter
@Getter
@ToString
public class SysDataDict extends CommonEntityDto {
    private String id;
    private String pid;
    private String dictName;
    private String dictCode;
    private SysDictType sysDictType;
    private String remark;
}
