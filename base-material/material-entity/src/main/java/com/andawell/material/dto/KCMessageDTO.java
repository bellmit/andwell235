package com.andawell.material.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

/***
 * @author hwd
 * @Date: 2020-05-18 10:35
 * @Description:
 * @version : V1.0
 */
@Data
@ApiModel("库存信息修改")
public class KCMessageDTO
{
    /**
     * 单位ID
     */
    @NotBlank(message = "单位Id不能为空")
    @ApiModelProperty(value = "单位id",required = true)
    private String dwid;

    /**
     * 机型
     */
    @NotBlank(message = "机型不能为空")
    @ApiModelProperty(value = "机型",required = true)
    private String jx;

    /**
     * 件号
     */
    @NotBlank(message = "件号不能为空")
    @ApiModelProperty(value = "件号",required = true)
    private String jh;

    /**
     * 新序号
     */
    @NotBlank(message = "新序号不能为空")
    @ApiModelProperty(value = "序号",required = true)
    private String xh;


    /**
     * 旧序号
     */
    @NotBlank(message = "旧序号不能为空")
    @ApiModelProperty(value = "序号",required = true)
    private String oldxh;


    /**
     * 质量
     */
    @NotBlank(message = "质量不能为空")
    @ApiModelProperty(value = "质量",required = true)
    private String zl;

    /**
     * 选择标志位
     */
    @NotBlank(message = "选择不能为空")
    @ApiModelProperty(value = "选择",required = true)
    private String xz;

    /**
     * 数量
     */
    private Long sl;

    /**
     * 单价
     */
    @NotNull(message = "单价不能为空")
    private BigDecimal dj;

    /**
     * 总价
     */
    private BigDecimal zj;

    /**
     * 出厂日期
     */

    private Date ccrq;



    /**
     * 验收日期
     */

    private Date ysrq;

    /**
     * 寿命状态
     */
    private String smzt;

    /**
     * 入库日期
     */

    private Date rkrq;

    /**
     * 总寿命年
     */
    private Integer zsmn;

    /**
     * 总寿命小时
     */
    private Integer zsmxs;

    /**
     * 总寿命循环
     */
    private Integer zsmxh;

    /**
     * 总寿命起落
     */
    private Integer zsmql;

    /**
     * 总翻修次数
     */
    private Integer zfxcs;

    /**
     * 油封日期
     */
    private Date yfrq;

    /**
     * 总油封次数
     */
    private Integer zyfcs;

    /**
     * 油封次数
     */
    private Integer yfcs;

    /**
     * 翻修日期
     */
    private Date fxrq;

    /**
     * 翻修寿命年
     */
    private Integer fxsmn;

    /**
     * 翻修寿命小时
     */
    private Integer fxsmxs;

    /**
     * 翻修次数
     */
    private Integer fxcs;

    /**
     * 商保期限年
     */
    private Integer sbqxn;

    /**
     * 商保期限小时
     */
    private Integer sbqxxs;

    /**
     * 备注
     */
    private String bz;

    /**
     * 总飞行小时
     */
    private Integer zfxxs;

    /**
     * 本次总飞行小时
     */
    private Integer bczfxxs;

    /**
     * 本次飞行小时
     */
    private Integer bcfxxs;

    /**
     * 总循环次数
     */
    private Integer zxhcs;

    /**
     * 本次总循环次数
     */
    private Integer bczxhcs;

    /**
     * 本次循环次数
     */
    private Integer bcxhcs;

    /**
     * 总起落次数
     */
    private Integer zqlcs;

    /**
     * 本次总起落次数
     */
    private Integer bczqlcs;

    /**
     * 本次起落次数
     */
    private Integer bcqlcs;

    /**
     * 单位
     */
    private String dw;

    /**
     * 架位号
     */
    private String jwh;

    /**
     * 管理方式
     */
    private Long glfs;

    /**
     * 仓库代码
     */
    private String ckdm;

    /**
     * 汇率
     */
    private BigDecimal hl;

    /**
     * 币种
     */
    private Integer bbz;

    /**
     * 飞机号
     */
    private String fjh;

    /**
     * 首翻日历期
     */
    private Integer sfrlq;

    /**
     * 总日历期
     */
    private Integer zrlq;

    /**
     * 总翻修次数
     */
    private Integer zfanxcs;

    /**
     * 翻修次数
     */
    private Integer fanxcs;

    /**
     * 修复日期
     */
    private Date xfrq;

    /**
     * 首翻期寿命
     */
    private Integer sfqsm;

    /**
     * 首翻期剩余寿命
     */
    private Integer sfqsysm;

    /**
     * 航材类别
     */
    private Integer hclb;

    /**
     * 计价
     */
    private BigDecimal jj;

    /**
     * 资源类别
     */
    private Integer zylb;

    /**
     * 总供气次数
     */
    private Integer zgqcs;

    /**
     * 供气次数
     */
    private Integer gqcs;

    /**
     * 首翻期小时
     */
    private Integer sfqxs;

    /**
     * 油封期限
     */
    private BigDecimal yfqx;

    /**
     * 间修期年
     */
    private Integer jxqn;

    /**
     * 间修期小时
     */
    private Integer jxqxs;

    /**
     * rfid卡号
     */
    private String rfid;

    /**
     * 验收id包装号
     */
    private String ysid;

    /**
     * 器材类别 1：周转器材；2：战备器材
     */
    private String qclb;



}
