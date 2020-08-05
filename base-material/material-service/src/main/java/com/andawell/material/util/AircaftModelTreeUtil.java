package com.andawell.material.util;

import com.andawell.material.entity.TJhJx;
import com.andawell.material.vo.AircaftModelTreelVO;

import java.util.ArrayList;
import java.util.List;

/**
 * @Date： 2020/4/27 11:46
 */
public class AircaftModelTreeUtil {
    /**
     *父节点的数据转换
     * @param tJhJxeList
     * @return
     */
    public static List<AircaftModelTreelVO> buildTree(List<TJhJx> tJhJxeList, List<TJhJx> tJhJxes){
        List<AircaftModelTreelVO> list = new ArrayList<AircaftModelTreelVO>();
        for (TJhJx tJhJx : tJhJxeList) {
            AircaftModelTreelVO modeTreelVo = new AircaftModelTreelVO();
            modeTreelVo.setId(tJhJx.getId());
            modeTreelVo.setMce(tJhJx.getMce());
            modeTreelVo.setMc(tJhJx.getMc());
            modeTreelVo.setJm(tJhJx.getJm());
            modeTreelVo.setPid(tJhJx.getPid());
            modeTreelVo.setLb(tJhJx.getLb());
            modeTreelVo.setSl(tJhJx.getSl());
            modeTreelVo.setSgin(tJhJx.getSgin());
            findRoots(modeTreelVo,tJhJxes);
            list.add(modeTreelVo);
        }

        return list;
    }

    /**
     * 将子节点添加到父节点中
     * @param
     * @return
     */
    private static AircaftModelTreelVO findRoots(AircaftModelTreelVO aircaftModeTreelVo, List<TJhJx> tJhJxes) {
        List<AircaftModelTreelVO> list = new ArrayList<AircaftModelTreelVO>();
        for (int i = 0; i < tJhJxes.size(); i++) {
            if (aircaftModeTreelVo.getId().equals(tJhJxes.get(i).getPid())){
                AircaftModelTreelVO modeTreelVo = new AircaftModelTreelVO();
                modeTreelVo.setId(tJhJxes.get(i).getId());
                modeTreelVo.setMce(tJhJxes.get(i).getMce());
                modeTreelVo.setMc(tJhJxes.get(i).getMc());
                modeTreelVo.setJm(tJhJxes.get(i).getJm());
                modeTreelVo.setPid(tJhJxes.get(i).getPid());
                modeTreelVo.setLb(tJhJxes.get(i).getLb());
                modeTreelVo.setSl(tJhJxes.get(i).getSl());
                modeTreelVo.setSgin(tJhJxes.get(i).getSgin());
                tJhJxes.remove(i);
                list.add(modeTreelVo);
            }
        }
        aircaftModeTreelVo.setModeTreelVos(list);
        return aircaftModeTreelVo;
    }
}
