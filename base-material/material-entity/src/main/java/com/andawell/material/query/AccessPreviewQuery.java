package com.andawell.material.query;/**
 * @Date： 2020/6/18 9:48
 */

import com.andawell.material.dto.InAndOutLibraryDetailDTO;
import com.andawell.material.dto.LibraryMasterDTO;
import com.andawell.material.dto.SystemNoDetailDTO;
import com.andawell.material.utils.ValidableList;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.Valid;

/**
 *@Auther:liuys
 *@Date:2020/6/18 09:48
 *@Description:
 */
@Data
@Accessors(chain = true)
public class AccessPreviewQuery {

    private Boolean state;
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

    @Valid
    private SystemNoDetailDTO systemNoDetailDTO;
}
