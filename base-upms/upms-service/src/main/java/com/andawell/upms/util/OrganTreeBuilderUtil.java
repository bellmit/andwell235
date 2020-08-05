package com.andawell.upms.util;

import com.andawell.upms.entity.SysOrganInfo;
import lombok.experimental.UtilityClass;
import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/***
 * @ClassName: MenuTreeBuilderUtil
 * @Description:
 * @Auther: PC
 * @Date: 2020/1/7 13:47
 * @version : V1.0
 */
@UtilityClass
public class OrganTreeBuilderUtil {
    /**
     * 通过通过SysMenuInfo创建树形菜单
     *
     * @param organInfos
     * @return
     */
    public List<SysOrganInfo> buildTree(List<SysOrganInfo> organInfos) {
        return buildListToTree(organInfos);
    }


    private List<SysOrganInfo> buildListToTree(List<SysOrganInfo> dirs) {
        List<SysOrganInfo> roots = findRoots(dirs);
        List<SysOrganInfo> notRoots = (List<SysOrganInfo>) CollectionUtils
                .subtract(dirs, roots);
        for (SysOrganInfo root : roots) {
            root.setChildren(findChildren(root, notRoots));
        }
        return roots;
    }

    public List<SysOrganInfo> findRoots(List<SysOrganInfo> allSysOrganInfos) {
        List<SysOrganInfo> results = new ArrayList<SysOrganInfo>();
        for (SysOrganInfo node : allSysOrganInfos) {
            boolean isRoot = true;
            for (SysOrganInfo comparedOne : allSysOrganInfos) {
                if (comparedOne.getId().equals(node.getPid())) {
                    isRoot = false;
                    break;
                }
            }
            if (isRoot) {
                results.add(node);
            }
        }
        return results;
    }

    public List<SysOrganInfo> findChildren(SysOrganInfo root, List<SysOrganInfo> allMenuVos) {
        List<SysOrganInfo> children = new ArrayList<SysOrganInfo>();
        for (SysOrganInfo comparedOne : allMenuVos) {
            if (root.getId().equals(comparedOne.getPid())) {
                children.add(comparedOne);
            }
        }
        List<SysOrganInfo> notChildren = (List<SysOrganInfo>) CollectionUtils.subtract(allMenuVos, children);
        for (SysOrganInfo child : children) {
            List<SysOrganInfo> tmpChildren = findChildren(child, notChildren);
            child.setChildren(tmpChildren);
        }
        return children;
    }

}
