package com.andawell.upms.util;

import com.andawell.upms.entity.SysMenuInfo;
import com.andawell.upms.vo.MenuTreeVo;
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
public class MenuTreeBuilderUtil {
    /**
     * 通过通过SysMenuInfo创建树形菜单
     *
     * @param menus
     * @return
     */
    public List<MenuTreeVo> buildTree(List<SysMenuInfo> menus) {
        List<MenuTreeVo> trees = new ArrayList<>();
        for (SysMenuInfo menu : menus) {
            MenuTreeVo node = new MenuTreeVo();
            node.setId(menu.getId());
            node.setPid(menu.getPid());
            node.setName(menu.getName());
            node.setIcon(menu.getIcon());
            node.setJump(menu.getPath());
            trees.add(node);
        }
        return buildListToTree(trees);
    }


    private List<MenuTreeVo> buildListToTree(List<MenuTreeVo> dirs) {
        List<MenuTreeVo> roots = findRoots(dirs);
        List<MenuTreeVo> notRoots = (List<MenuTreeVo>) CollectionUtils
                .subtract(dirs, roots);
        for (MenuTreeVo root : roots) {
            root.setChildren(findChildren(root, notRoots));
        }
        return roots;
    }

    public List<MenuTreeVo> findRoots(List<MenuTreeVo> allMenuTreeVos) {
        List<MenuTreeVo> results = new ArrayList<MenuTreeVo>();
        for (MenuTreeVo node : allMenuTreeVos) {
            boolean isRoot = true;
            for (MenuTreeVo comparedOne : allMenuTreeVos) {
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

    public List<MenuTreeVo> findChildren(MenuTreeVo root, List<MenuTreeVo> allMenuVos) {
        List<MenuTreeVo> children = new ArrayList<MenuTreeVo>();
        for (MenuTreeVo comparedOne : allMenuVos) {
            if (root.getId().equals(comparedOne.getPid())) {
                children.add(comparedOne);
            }
        }
        List<MenuTreeVo> notChildren = (List<MenuTreeVo>) CollectionUtils.subtract(allMenuVos, children);
        for (MenuTreeVo child : children) {
            List<MenuTreeVo> tmpChildren = findChildren(child, notChildren);
            child.setChildren(tmpChildren);
        }
        return children;
    }

}
