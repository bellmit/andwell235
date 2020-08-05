package com.andawell.material.query;/**
 * @Date： 2020/6/22 14:28
 */

import com.andawell.material.dto.InAndOutLibraryDetailDTO;
import com.andawell.material.dto.LibraryMasterDTO;
import com.andawell.material.dto.OutLibraryDetailDTO;
import com.andawell.material.dto.SystemNoDetailDTO;
import com.andawell.material.utils.ValidableList;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.Valid;

/**
 *@Auther:liuys
 *@Date:2020/6/22 14:28
 *@Description:
 */
@Data
@Accessors(chain = true)
public class OutAccessPreviewQuery {
    /**
     * 保存主表，T_CK_CRK
     */
    @Valid
    private LibraryMasterDTO libraryMasterDTO;

    /**
     * T_CK_CK和T_CK_CRKQD
     */
    @Valid
    private ValidableList<OutLibraryDetailDTO> list;

    @Valid
    private SystemNoDetailDTO systemNoDetailDTO;
}
