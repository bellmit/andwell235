package com.andawell.material.query;/**
 * @Date： 2020/5/18 10:22
 */

import com.andawell.common.entity.dto.PageDto;
import com.andawell.material.dto.groups.First;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import java.util.Date;

/**
 *@Auther:liuys
 *@Date:2020/5/18 10:22
 *@Description:
 */
@Data
@Accessors(chain = true)
public class TCkPglyQuery extends PageDto {
    /**
     * 机型
     */
    @NotBlank(message = "机型不能为空")
    @ApiModelProperty(name = "jx", value = "机型")
    private String jx;

    /**
     * 开始时间
     */
    @NotBlank(message = "开始时间不能为空",groups = {First.class})
    @ApiModelProperty(name = "startTime", value = "开始时间")
    private String startTime;

    /**
     * 结束时间
     */
    @NotBlank(message = "结束时间不能为空",groups = {First.class})
    @ApiModelProperty(name = "endTime", value = "结束时间")
    private String endTime;
}
