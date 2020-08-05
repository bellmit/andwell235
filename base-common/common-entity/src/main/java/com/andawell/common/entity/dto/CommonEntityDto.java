package com.andawell.common.entity.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/***
 * @ClassName: 公共实体类信息
 * @Description:
 * @author DCY
 * @Date: 2019/12/17 16:15
 * @version : V1.0
 */
@Data
public class CommonEntityDto {
    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public Date createTime;
    /**
     * 更新时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public Date updateTime;
    /**
     * 删除时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public Date deleteTime;
    /**
     * 删除标识
     */
    public String delFlag;
    /**
     * 创建人
     */
    public String creator;
    /**
     * 修改人
     */
    public String modifier;
    /**
     * 删除人
     */
    public String deleter;
}
