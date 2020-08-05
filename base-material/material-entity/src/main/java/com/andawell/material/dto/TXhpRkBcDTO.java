package com.andawell.material.dto;

import com.andawell.material.utils.ValidableList;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 *@Auther:gzh
 *@Date:2020/5/18 10:11
 *@Description: 五金入库保存
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TXhpRkBcDTO {

    /**
     * 五金入库保存
     *插入T_XHP_CK
     *增加1行或多行，由【缓存表】中的数据来确定。
     */
    private ValidableList<TXhpCkDTO> tXhpCkDTO;

    /**
     * 五金入库保存
     *插入T_XHP_CRK
     *增加1行，数据来源是【入库主信息】。
     */
    private TXhpCrkDTO tXhpCrkDTO;

    /**
     * 五金入库保存
     *插入T_XHP_CRKQD
     *增加1行或多行，由【缓存表】中的数据来确定。
     */
    private ValidableList<TXhpCrkqdDTO> tXhpCrkqdDTO;













}
