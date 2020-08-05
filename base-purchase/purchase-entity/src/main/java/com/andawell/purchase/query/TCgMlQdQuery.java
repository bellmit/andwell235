package com.andawell.purchase.query;

import com.andawell.common.entity.dto.PageDto;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @Author:PCJ
 * @Date:2020/5/30
 * @Version:V1.0.0
 */
@Data
@Accessors(chain = true)
public class TCgMlQdQuery extends PageDto {

    /**
     * null
     */
    private Long id;

    /**
     * 目录编号
     */
    private String mlbh;

    /**
     * 机型Id
     */
    private String jx;

    /**
     * 件号
     */
    private String jh;

    /**
     * 单价
     */
    private String dj;

    /**
     * 厂家
     */
    private String cj;

    /**
     * 价格依据
     */
    private String jgyy;

    /**
     * 价格类型
     */
    private String jglx;

    /**
     * 监管单位
     */
    private String jgdw;

    /**
     * 憋住
     */
    private String bz;

    /**
     * 创建时间
     */
    private Date cjrq;

    /**
     * 更新时间
     */
    private Date gxrq;

    /**
     * 器材类别
     */
    private String qclx;
}
