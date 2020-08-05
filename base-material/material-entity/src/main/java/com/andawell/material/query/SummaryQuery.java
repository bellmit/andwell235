package com.andawell.material.query;/**
 * @Date： 2020/7/7 10:36
 */

import com.andawell.common.entity.dto.PageDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 *@Auther:liuys
 *@Date:2020/7/7 10:36
 *@Description:
 */
@ApiModel("综合查询")
@Accessors(chain = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SummaryQuery extends PageDto {

    @ApiModelProperty(value = "机型",name = "jx")
    private String jx;

    @ApiModelProperty(value = "件号",name = "jh")
    private String jh;

    @ApiModelProperty(value = "质量",name = "zl")
    private String zl;

    /**
     * 用户单位ID
     */
    @ApiModelProperty(value = "用户单位ID")
    private String dwid;

    @ApiModelProperty(value = "用户userId")
    private String userId;

}
