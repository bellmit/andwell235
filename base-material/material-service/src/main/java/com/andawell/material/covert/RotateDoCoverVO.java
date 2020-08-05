package com.andawell.material.covert;

import com.andawell.material.dto.InAndOutLibraryDetailDTO;
import com.andawell.material.dto.LibraryMasterDTO;
import com.andawell.material.entity.TCkCk;
import com.andawell.material.entity.TZclhHbjl;
import com.andawell.material.vo.RotateVO;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/***
 * @author lhb
 * @Date: 2020/4/29 16:11
 * @Description:
 * @version : V1.0
 */
public class RotateDoCoverVO {

    /*public static List<RotateVO> getRotateVOList(List<TZclhHbjl>
                                                         tZclhHbjlList){
        List<RotateVO> rotateVOS = new ArrayList<>();
        try {
            for (TZclhHbjl tZclhHbjl: tZclhHbjlList) {
                RotateVO rotateVO = new RotateVO();
                BeanUtils.copyProperties(tZclhHbjl,rotateVO);

            }

        }catch (Exception e){
            e.printStackTrace();
            log.error("转换异常",e);
        }
        return tCkCkList;
    }*/
}
