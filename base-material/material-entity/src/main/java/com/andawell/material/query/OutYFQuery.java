package com.andawell.material.query;

import com.andawell.common.entity.dto.PageDto;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

/***
 * @author hwd
 * @Date: 2020-05-09 10:18
 * @Description:
 * @version : V1.0
 */
@Data
@ApiModel("外部油封查询")
public class OutYFQuery {

    /**
     * 开始日期
     */
    @ApiModelProperty(name = "startDate", value = "开始日期(yyyy-MM-dd HH:mm:ss)")
    private String  startDate;
    /**
     * 结束日期
     */
    @ApiModelProperty(name = "endDate", value = "结束日期(yyyy-MM-dd HH:mm:ss)")
    private String endDate;

    /**
     * 机型
     */
    @ApiModelProperty(name = "jx", value = "机型")
    private String jx;

    /**
     * 件号
     */
    @ApiModelProperty(name = "jh", value = "件号")
    private String jh;

    /**
     * 交付单位
     */
    @ApiModelProperty(name = "ffdw", value = "交付单位")
    private String ffdw;


}
