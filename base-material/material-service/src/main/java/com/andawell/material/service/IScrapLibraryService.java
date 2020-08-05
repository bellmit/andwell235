package com.andawell.material.service;

import com.andawell.material.dto.OutLibraryInfoDTO;
import com.andawell.material.dto.ScrapInforDTO;
import com.andawell.material.dto.WriteOffDTO;

/***
 * @author lhb
 * @Date: 2020/5/18 16:01
 * @Description:
 * @version : V1.0
 */
public interface IScrapLibraryService {

    /**
     * 报废入库
     * @param scrapInforDTO
     * @return
     */
    Boolean saveScrapContract(ScrapInforDTO scrapInforDTO);

    /**
     * 报废入库/外来器材报废
     * @param scrapInforDTO
     * @return
     */
    Boolean saveScrapForeign(ScrapInforDTO scrapInforDTO);

    /**
     *@Author: liuys
     *@Data: 2020/5/21
     *@Description: （冲销）全新可用转报废
     */
    Boolean writeNewOutnound(WriteOffDTO writeOffDTO);


    /**
     *@Author: liuys
     *@Data: 2020/5/23
     *@Description: 冲销报废出库
     */
    Boolean writeOutnound(WriteOffDTO writeOffDTO);
}
