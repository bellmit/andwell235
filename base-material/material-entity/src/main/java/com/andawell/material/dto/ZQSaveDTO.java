package com.andawell.material.dto;

import com.andawell.material.vo.TDbLtsqAndQDVO;
import com.andawell.material.vo.TDbSjsqAndQDVO;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.List;

/***
 * @author hwd
 * @Date: 2020-06-18 09:44
 * @Description:战区保存DTO
 * @version : V1.0
 */
@Data
@ApiModel("战区保存")
public class ZQSaveDTO {
    /**
     * 旅团申请清单信息
     */
    private List<TDbLtsqAndQDVO> tDbLtsqAndQDVOS;

    /**
     * 机关信息清单
     */
    private List<TDbSjsqAndQDVO> tDbSjsqAndQDVOS;


    /**
     * 类型
     */
    @NotBlank(message = "类型不能为空")
    private String style;
}
