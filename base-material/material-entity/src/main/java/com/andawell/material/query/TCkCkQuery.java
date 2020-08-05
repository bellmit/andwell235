package com.andawell.material.query;/**
 * @Date： 2020/5/27 9:35
 */

import com.andawell.common.entity.dto.PageDto;
import com.andawell.material.dto.groups.First;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 *@Auther:liuys
 *@Date:2020/5/27 09:35
 *@Description: ckck查询条件
 */
@Data
@ApiModel("ckck查询条件")
@Accessors(chain = true)
public class TCkCkQuery extends PageDto {

    /**
     * 0是在库中
     */
    @ApiModelProperty(name = "xz", value = "选择", dataType = "String")
    private String xz;

    /**
     * 质量 21:待修 24:待报废 必须匹配
     */
    @ApiModelProperty(name = "zl", value = "质量", dataType = "String")
    private String zl;


    /**
     * 机型 必须匹配
     */
    @NotBlank(message = "机型不能为空",groups = {First.class})
    @ApiModelProperty(name = "jx", value = "机型", dataType = "String")
    private String jx;



    /**
     * 件号 必须匹配
     */
    @NotBlank(message = "件号不能为空",groups = {First.class})
    @ApiModelProperty(name = "jh", value = "件号", dataType = "String")
    private String jh;

    /**
     * 件号名称
     */

    @ApiModelProperty(name = "jhmc", value = "件号名称", dataType = "String")
    private String jhmc;

    private String xh;

    @ApiModelProperty(name = "zls", value = "多个质量的传输，如果只传一个质量使用zl", dataType = "List")
    private List<String> zls;

    /**
     * 当前登陆用户id
     */

    @ApiModelProperty(name = "yhid", value = "当前登陆用户id", dataType = "String")
    private String yhid;
}
