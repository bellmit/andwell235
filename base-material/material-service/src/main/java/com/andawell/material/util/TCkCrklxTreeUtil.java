package com.andawell.material.util;
/**
 * @Date： 2020/5/12 9:52
 */

import com.andawell.material.entity.TCkCrklx;
import com.andawell.material.entity.VDw;
import com.andawell.material.vo.CompanyVO;
import com.andawell.material.vo.TCkCrklxVO;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *@Auther:liuys
 *@Date:2020/5/12 09:52
 *@Description:
 */
public class TCkCrklxTreeUtil {
    public static List<TCkCrklxVO> buildTree(List<TCkCrklx> vDwList) {
        if (vDwList.isEmpty()) {
            return null;
        }
        ArrayList<TCkCrklxVO> companyList = new ArrayList<TCkCrklxVO>();

        Iterator<TCkCrklx> iterator = vDwList.iterator();
        //查询所有父级
        while (iterator.hasNext()){
            TCkCrklx vDw =iterator.next();
            if (vDw.getId().length() == 2) {
                TCkCrklxVO companyVO = BeanUtils.dtoTODO(vDw, TCkCrklxVO.class);
                companyList.add(companyVO);
                iterator.remove();
            }
        }
        //添加所有的子节点
        List<TCkCrklxVO> list = findRoots(companyList, vDwList);

        return list;
    }

    /**
     * 将字节点添加到父节点
     *
     * @param companyList
     * @param vDwList
     * @return
     */
    private static List<TCkCrklxVO> findRoots(ArrayList<TCkCrklxVO> companyList, List<TCkCrklx> vDwList) {
        if (vDwList.isEmpty()) {
            return null;
        }
        for (TCkCrklxVO companyVO : companyList) {
            ArrayList<TCkCrklxVO> vDws = new ArrayList<TCkCrklxVO>();
            Iterator<TCkCrklx> it = vDwList.iterator();
            while (it.hasNext()){
                TCkCrklx vDw =it.next();
                String vDwId = vDw.getId();
                if (vDwId.length() > 2) {
                    String substring = vDwId.substring(0,2);
                    if (substring.length() > 0) {
                        if (companyVO.getId().equals(substring)) {
                            TCkCrklxVO dtoTODO = BeanUtils.dtoTODO(vDw, TCkCrklxVO.class);
                            vDws.add(dtoTODO);
                            it.remove();
                        }
                    }
                }
            }
            companyVO.setList(vDws);
        }
        return companyList;
    }
}
