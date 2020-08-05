package com.andawell.material.dto;

import com.andawell.material.utils.ValidableList;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.swing.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;

/***
 * @author lhb
 * @Date: 2020/4/28 14:32
 * @Description:
 * @version : V1.0
 */
@Data
@ApiModel("入库信息")
public class LibraryInfoDTO {

    /**
     * 保存主表，T_CK_CRK
     */
    @Valid
    private LibraryMasterDTO libraryMasterDTO;

    /**
     * T_CK_CK和T_CK_CRKQD
     */
      @Valid
    private ValidableList<InAndOutLibraryDetailDTO> list;

    /**
     * 系统编号入参
     */
    @Valid
    private SystemNoDetailDTO systemNoDetailDTO;
}