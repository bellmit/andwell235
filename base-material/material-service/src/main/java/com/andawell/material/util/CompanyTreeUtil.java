package com.andawell.material.util;

import com.andawell.material.entity.VDw;
import com.andawell.material.vo.CompanyVO;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Date： 2020/4/27 14:58
 */
@Slf4j
public class CompanyTreeUtil {

    public static List<CompanyVO> buildTree(List<VDw> vDwList) {
        if (vDwList.isEmpty()) {
            return null;
        }
        ArrayList<CompanyVO> companyList = new ArrayList<CompanyVO>();

        Iterator<VDw> iterator = vDwList.iterator();
        //查询所有父级
        while (iterator.hasNext()){
            VDw vDw =iterator.next();
            if (vDw.getId().length() == 2) {
                CompanyVO companyVO = BeanUtils.dtoTODO(vDw, CompanyVO.class);
                companyList.add(companyVO);
                iterator.remove();
            }
        }
        //添加所有的子节点
        List<CompanyVO> list = findRoots(companyList, vDwList);

        return list;
    }

    /**
     * 将字节点添加到父节点
     *
     * @param companyList
     * @param vDwList
     * @return
     */
    private static List<CompanyVO> findRoots(ArrayList<CompanyVO> companyList, List<VDw> vDwList) {
        if (vDwList.isEmpty()) {
            return null;
        }
        for (CompanyVO companyVO : companyList) {
            ArrayList<CompanyVO> vDws = new ArrayList<CompanyVO>();
            Iterator<VDw> it = vDwList.iterator();
            while (it.hasNext()){
                VDw vDw =it.next();
                String vDwId = vDw.getId();
                if (vDwId.length() > 2) {
                    String substring = vDwId.substring(0,2);
                    if (substring.length() > 0) {
                        if (companyVO.getId().equals(substring)) {
                            CompanyVO dtoTODO = BeanUtils.dtoTODO(vDw, CompanyVO.class);
                            vDws.add(dtoTODO);
                            it.remove();
                        }
                    }
                }
            }
            companyVO.setCompanyVOList(vDws);
        }
        return companyList;
    }
}
