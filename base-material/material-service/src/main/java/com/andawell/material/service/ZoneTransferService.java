package com.andawell.material.service;

import com.andawell.common.entity.vo.ListPageVo;
import com.andawell.material.dto.*;
import com.andawell.material.entity.VDw;
import com.andawell.material.query.TCkDxQuery;
import com.andawell.material.query.TDbLtsqQuery;
import com.andawell.material.query.TSjSqQuery;
import com.andawell.material.vo.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/***
 * @author hwd
 * @Date: 2020-05-22 14:28
 * @Description:
 * @version : V1.0
 */
public interface ZoneTransferService {

    List<BursaryVO> getLTSQQDList(String bh);

    /**
     *@Author: liuys
     *@Data: 2020/5/25
     *@Description: 战区调拨申请保存
     */
    Boolean saveTheaterAllocation(TheaterAllocationDTO theaterAllocationDTO);

    /**
     * 显示战区调拨申请明细
     */

    List<BursaryVO> getBursary(TDbLtsqqdMessageVO tDbLtsqqdMessageVO,String sqdh,String jx, String jh);

    /**
     *@Author: liuys
     *@Data: 2020/5/26
     *@Description: 查询战区下旅团下的申请
     */
    ListPageVo<TDbLtsqQuery, TDbLtsqVO> getAllocationList(TDbLtsqQuery tDbLtsqQuery);


    //获取用户下属单位 id 为单位id
    List<VDw> getUserBranchDw();


    ListPageVo<TSjSqQuery, TDbJgdbVO> getTDbJgdbList(TSjSqQuery tSjSqQuery);

    Boolean saveSuperiorApplication(TDbsjSqDTO tDbsjSqDTO);

    Boolean updateSuperior(List<ReviseZqdbDTO> reviseZqDbDTOS);

    Boolean fileLTLeading(HttpServletResponse response, List<DeliverDTO> deliverDTOS);

    Boolean saveSuperiorApplication(TheaterAllocationDTO theaterAllocationDTO);


    Boolean fileJGLeading(HttpServletResponse response, List<DeliverDTO> deliverDTOS);


    List<TDbLtsqAndQDVO> FileLTUpload(MultipartFile multipartFile);

    List<TDbSjsqAndQDVO> FileSJUpload(MultipartFile multipartFile);


    Boolean saveMessage(ZQSaveDTO zqSaveDTO);

    Boolean deleteMessage(List<String> sqdh, String style);
}
