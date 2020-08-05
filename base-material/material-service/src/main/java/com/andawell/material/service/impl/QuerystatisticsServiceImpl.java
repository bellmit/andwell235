package com.andawell.material.service.impl;

import com.andawell.common.entity.search.ListPageCommon;
import com.andawell.common.entity.vo.ListPageVo;
import com.andawell.common.util.SysUserUtils;
import com.andawell.material.dto.TCkSxXLNLDTO;
import com.andawell.material.entity.TXtDw;
import com.andawell.material.mapper.*;
import com.andawell.material.query.*;
import com.andawell.material.service.ICompanyService;
import com.andawell.material.service.IQueryStatisticsService;
import com.andawell.material.service.ITCkSxService;
import com.andawell.material.vo.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class QuerystatisticsServiceImpl implements IQueryStatisticsService
{


    @Autowired
    TCkCrkqdMapper tCkCrkqdMapper;

    @Autowired
    TCkSxMapper tCkSxMapper;

    @Autowired
    private TCkCkMapper tCkCkMapper;

    @Autowired
    TXtDwMapper tXtDwMapper;

    @Autowired
    ITCkSxService tCkSxService;

    @Autowired
    TCkDxMapper tCkDxMapper;


    /**
     * 航材全新，待修，在修，报废的项数目、件数统计
     *
     * @param
     * @return： 查询统计数量
     */

    @Autowired
    private ICompanyService iCompanyService;

    @Autowired
    TCkBfkMapper tCkBfkMapper;

    /**
     * 航材全新，待修，在修，报废的项数目、件数统计
     *
     * @param
     * @return： 查询统计数量
     */
    @Override
    public List<TCkSyVO> getCout() {
        List<TCkSyVO> tCkSyVO = new ArrayList<>();
        TCkSyVO hcQxKyVO = tCkCkMapper.qxkyCount();
        hcQxKyVO.setMc("航材全新可用件");
        TCkSyVO hcDxVO = tCkCkMapper.dxCount();
        hcDxVO.setMc("航材待修件");
        TCkSyVO hcZxVO = tCkCkMapper.zxCount();
        hcZxVO.setMc("航材在修件");
        TCkSyVO hcDbfVO = tCkCkMapper.hcdbf();
        hcDbfVO.setMc("航材报废件");
        tCkSyVO.add(hcQxKyVO);
        tCkSyVO.add(hcDxVO);
        tCkSyVO.add(hcZxVO);
        tCkSyVO.add(hcDbfVO);
        return tCkSyVO;
    }

    /**
     * 全新可用库存统计
     *
     * @param query@return
     */
    @Override
    public ListPageVo<NewPrpertoryCountQuery, Map> getNewPrpertoryCountQuery(NewPrpertoryCountQuery query, String dwid) {
        //封装当前登录人的机关id
        query.setDwid(dwid);
        //查询出当前登陆人所在机关的战区及旅团数据
        //TODO 按照战区的数据分页
        ListPageVo<NewPrpertoryCountQuery, NewRepertoryCountVO> listPageCommon =
                new ListPageCommon<NewPrpertoryCountQuery, NewRepertoryCountVO>(query, (q) -> tCkCkMapper.listTJ(q)).getVo();

        List<NewRepertoryCountVO> list = listPageCommon.getList();
        //查询出总数 总价
        list.stream().forEach(one -> {
            NewPrpertoryCountQuery q = new NewPrpertoryCountQuery();
            q.setJx(one.getJx());
            q.setJh(one.getJh());
/*            String substring = one.getDwid().substring(0, 2);*/
/*            q.setDwid(substring);*/
         /*   String zs = tCkCkMapper.selectBySumZs(q);*/
            String zj = tCkCkMapper.selectBySumZj(q);
       /*     one.setZs(zs);*/
            one.setZj(zj);
        });
        //准备一个返回数据的集合
        List<Map> mapList = new ArrayList<>();
        for (NewRepertoryCountVO NewRepertoryCountVO : list) {
            Map map = new HashMap();
            //获取当前登陆人下的所有的机关
            List<TXtDw> dwList = iCompanyService.getChildren();
            // 动态不确定的数据
            for (TXtDw tXtDw : dwList) {
                int num = 0;
                NewPrpertoryCountQuery q = new NewPrpertoryCountQuery();
                q.setJx(NewRepertoryCountVO.getJx());
                q.setJh(NewRepertoryCountVO.getJh());
                q.setDwid(tXtDw.getId());
                List<NewRepertoryCountVO> domeVOList = tCkCkMapper.listTJ(q);
                if (domeVOList != null && domeVOList.size() > 0) {
                    NewRepertoryCountVO newRepertoryCountVO = domeVOList.get(0);
                    if (null != newRepertoryCountVO.getSl()) {
                        num = newRepertoryCountVO.getSl();
                    }
                }
                map.put("dwId" + tXtDw.getId(), tXtDw.getMc());
                map.put("dwId" + tXtDw.getId() + "sl", num);
                map.put("jx", NewRepertoryCountVO.getJx());
                map.put("jxmc", NewRepertoryCountVO.getJxmc());
                map.put("jh", NewRepertoryCountVO.getJh());
                map.put("jhmc", NewRepertoryCountVO.getJhmc());
              /*  map.put("zs", NewRepertoryCountVO.getZs());*/
                map.put("zs", NewRepertoryCountVO.getSl());
                map.put("zj", NewRepertoryCountVO.getZj());
                map.put("zl", NewRepertoryCountVO.getZl());


            }
            mapList.add(map);

        }
       ListPageVo<NewPrpertoryCountQuery, Map> listPageVo = new  ListPageCommon<NewPrpertoryCountQuery, Map>(query, (q) -> mapList).getVo();
       listPageVo.setPage(listPageCommon.getPage());

           /* new ListPageCommon<NewPrpertoryCountQuery,Map>(query, (q) -> null).getVo();*/
      /*  listPageVo.setList(mapList);*/
   /*     ListPageVo<NewPrpertoryCountQuery, mapList>*/
        /* listPageCommon.setList(mapList);*/
        return listPageVo;
    }
    /**
     * 航材收货统计
     *
     * @param query@return
     */
    @Override
    public ListPageVo<HcSfCxTjQuery, Map> shtjlist(String parentId, HcSfCxTjQuery query) {
        //封装当前登录人的机关id
        query.setDwid(parentId);
        //查询出当前登陆人所在机关的战区及旅团数据
        ListPageVo<HcSfCxTjQuery, HcShTjVO> listPageCommon =
                new ListPageCommon<HcSfCxTjQuery, HcShTjVO>(query, (q) -> tCkCkMapper.listShTJ(q)).getVo();
        List<HcShTjVO> list = listPageCommon.getList();
        //查询出总数 总价
        list.stream().forEach(one -> {
            HcSfCxTjQuery q = new HcSfCxTjQuery();
            q.setJx(one.getJx());
            q.setJh(one.getJh());
            String substring = one.getDwid().substring(0, 2);
            q.setDwid(substring);
            String zs = tCkCkMapper.selectsHZs(q);
            one.setZs(zs);
        });
        //准备一个返回数据的集合
        List<Map> mapList = new ArrayList<>();
        for (HcShTjVO hcShTjVO : list) {
            Map map = new HashMap();
            //获取当前登陆人下的所有的机关
            List<TXtDw> dwList = iCompanyService.getChildren();
            // 动态不确定的数据
            for (TXtDw tXtDw : dwList) {
                int num = 0;
                if (list != null && list.size() > 0) {
                    HcShTjVO hcShTjVO1 = list.get(0);
                    if (null != hcShTjVO1.getSl()) {
                        num = hcShTjVO1.getSl();
                    }

                }
                map.put("dwId" + tXtDw.getId(), tXtDw.getMc());
                map.put("dwId" + tXtDw.getId() + "sl", num);
                map.put("jx", hcShTjVO.getJx());
                map.put("jxmc", hcShTjVO.getJxmc());
                map.put("jh", hcShTjVO.getJh());
                map.put("jhmc", hcShTjVO.getJhmc());
                map.put("zs", hcShTjVO.getZs());
                map.put("zl", hcShTjVO.getZl());
            }
            mapList.add(map);
        }
        ListPageVo<HcSfCxTjQuery, Map> listPageVo = new  ListPageCommon<HcSfCxTjQuery, Map>(query, (q) -> mapList).getVo();
        listPageVo.setPage(listPageCommon.getPage());
        return listPageVo;
    }
    /**
     * 报废库存统计
     *
     * @param @return
     */
    @Override
    public ListPageVo<HcSfCxTjQuery, Map> bfkctjlist(HcSfCxTjQuery query, String parentId) {
        //封装当前登录人的机关id
        query.setDwid(parentId);
        //查询出当前登陆人所在机关的战区及旅团数据
        ListPageVo<HcSfCxTjQuery, BfKcVO> listPageCommon =
                new ListPageCommon<HcSfCxTjQuery, BfKcVO>(query, (q) -> tCkCkMapper.listBfTJ(q)).getVo();
        List<BfKcVO> list = listPageCommon.getList();
        //查询出总数 总价
/*        list.stream().forEach(one -> {
            HcSfCxTjQuery q = new HcSfCxTjQuery();
            q.setJx(one.getJx());
            q.setJh(one.getJh());
            String substring = one.getDwid().substring(0, 2);
            q.setDwid(substring);
            String zs = tCkCkMapper.selectbFZs(q);
            one.setZs(zs);
        });*/
        //准备一个返回数据的集合
        List<Map> mapList = new ArrayList<>();
        for (BfKcVO bfKcVO : list) {
            Map map = new HashMap();
            //获取当前登陆人下的所有的机关
            List<TXtDw> dwList = iCompanyService.getChildren();
            // 动态不确定的数据
            for (TXtDw tXtDw : dwList) {
                int num = 0;
                if (list != null && list.size() > 0) {
                    BfKcVO bfKcVO1 = list.get(0);
                    if (null != bfKcVO1.getSl()) {
                        num = bfKcVO1.getSl();
                    }

                }
                map.put("dwId" + tXtDw.getId(), tXtDw.getMc());
                map.put("dwId" + tXtDw.getId() + "sl", num);
                map.put("jx", bfKcVO.getJx());
                map.put("jxmc", bfKcVO.getJxmc());
                map.put("jh", bfKcVO.getJh());
                map.put("jhmc", bfKcVO.getJhmc());
                map.put("zs", bfKcVO.getZs());
                map.put("zl", bfKcVO.getZl());
            }
            mapList.add(map);
        }
        ListPageVo<HcSfCxTjQuery, Map> listPageVo = new  ListPageCommon<HcSfCxTjQuery, Map>(query, (q) -> mapList).getVo();
        listPageVo.setPage(listPageCommon.getPage());
        return listPageVo;
    }
    /**
     * 航材发货统计
     *
     * @param query@return
     */
    @Override
    public ListPageVo<HcSfCxTjQuery, Map>  fhtjlist(String parentId, HcSfCxTjQuery query) {
        //封装当前登录人的机关id
        query.setDwid(parentId);
        //查询出当前登陆人所在机关的战区及旅团数据
        ListPageVo<HcSfCxTjQuery, HcShTjVO> listPageCommon =
                new ListPageCommon<HcSfCxTjQuery, HcShTjVO>(query, (q) -> tCkCkMapper.listfhTJ(q)).getVo();
        List<HcShTjVO> list = listPageCommon.getList();
        //查询出总数 总价
        list.stream().forEach(one -> {
            HcSfCxTjQuery q = new HcSfCxTjQuery();
            q.setJx(one.getJx());
            q.setJh(one.getJh());
            String substring = one.getDwid().substring(0, 2);
            q.setDwid(substring);
            String zs = tCkCkMapper.selectsHZs(q);
            one.setZs(zs);
        });
        //准备一个返回数据的集合
        List<Map> mapList = new ArrayList<>();
        for (HcShTjVO hcShTjVO : list) {
            Map map = new HashMap();
            //获取当前登陆人下的所有的机关
            List<TXtDw> dwList = iCompanyService.getChildren();
            // 动态不确定的数据
            for (TXtDw tXtDw : dwList) {
                int num = 0;
                if (list != null && list.size() > 0) {
                    HcShTjVO hcShTjVO1 = list.get(0);
                    if (null != hcShTjVO1.getSl()) {
                        num = hcShTjVO1.getSl();
                    }

                }
                map.put("dwId" + tXtDw.getId(), tXtDw.getMc());
                map.put("dwId" + tXtDw.getId() + "sl", num);
                map.put("jx", hcShTjVO.getJx());
                map.put("jxmc", hcShTjVO.getJxmc());
                map.put("jh", hcShTjVO.getJh());
                map.put("jhmc", hcShTjVO.getJhmc());
                map.put("zs", hcShTjVO.getZs());
                map.put("zl", hcShTjVO.getZl());
            }
            mapList.add(map);
        }
        ListPageVo<HcSfCxTjQuery, Map> listPageVo = new  ListPageCommon<HcSfCxTjQuery, Map>(query, (q) -> mapList).getVo();
        listPageVo.setPage(listPageCommon.getPage());
        return listPageVo;
    }



    /**
     * 全新可用库存明细
     * gzh
     *
     * @param query
     * @param parentId
     * @return
     */
    @Override
    public ListPageVo<NewPrpertoryCountQuery, NewRepertoryCountMxVO> getNewPrpertoryCountMxQuery(NewPrpertoryCountQuery query, String parentId) {
        //准备一个存放返回数据的容器
        List<NewRepertoryCountMxVO> list = new ArrayList<>();
        //判断前端是否传入dwid，如果没有用当前用户的战区id
        if (StringUtils.isEmpty(query.getDwid())) {
            query.setDwid(parentId);
        }
        //查询出来该用户战区下的所有数据
        ListPageVo<NewPrpertoryCountQuery, NewRepertoryCountMxVO> listPageCommon =
                new ListPageCommon<NewPrpertoryCountQuery, NewRepertoryCountMxVO>(query, (q) -> tCkCkMapper.listMx(q)).getVo();
        //判断是否拥有旅团的数据  如果拥有旅团的数据把旅团上级战区的战区名替换掉旅团名
        listPageCommon.getList().stream().forEach(One -> {
            //判断是否是旅团级
            if (One.getDwid().length() > 4) {
                //截取旅团的前四位  ---上级战区id
                String id = One.getDwid().substring(0, 4);
                //根据战区id去t_xt_dw表中把上级战区的数据查询出来
                TXtDw tXtDw = tXtDwMapper.selectByid(id);
                //用战区名替换掉旅团名
                One.setSszq(tXtDw.getMc());
            }
            list.add(One);
        });

        listPageCommon.setList(list);

        return listPageCommon;
    }

    /**
     * 航材收货查询
     * shs
     *
     * @param
     * @param parentId
     * @return
     */
    @Override
    public ListPageVo<HcSfCxMxQuery, HcShMxVO> shmxlist(HcSfCxMxQuery hcSfCxMxQuery, String parentId) {
        //准备一个存放返回数据的容器
        List<HcShMxVO> list = new ArrayList<>();
        //判断前端是否传入dwid，如果没有用当前用户的战区id
        if (StringUtils.isEmpty(hcSfCxMxQuery.getDwid())) {
            hcSfCxMxQuery.setDwid(parentId);
        }
        //查询出来该用户战区下的所有数据
        ListPageVo<HcSfCxMxQuery, HcShMxVO> listPageCommon =
                new ListPageCommon<HcSfCxMxQuery, HcShMxVO>(hcSfCxMxQuery, (q) -> tCkCkMapper.ShMx(q)).getVo();
        //判断是否拥有旅团的数据  如果拥有旅团的数据把旅团上级战区的战区名替换掉旅团名
        listPageCommon.getList().stream().forEach(One -> {
            //判断是否是旅团级
            if (One.getDwid().length() > 4) {
                //截取旅团的前四位  ---上级战区id
                String id = One.getDwid().substring(0, 4);
                //根据战区id去t_xt_dw表中把上级战区的数据查询出来
                TXtDw tXtDw = tXtDwMapper.selectByid(id);
                //用战区名替换掉旅团名
                One.setSszq(tXtDw.getMc());
            }
            list.add(One);
        });

        listPageCommon.setList(list);
        return listPageCommon;
    }

    @Override
    public ListPageVo<HcSfCxMxQuery, HcFhMxVO> fhmxlist(HcSfCxMxQuery hcSfCxMxQuery, String parentId) {
        //准备一个存放返回数据的容器
        List<HcFhMxVO> list = new ArrayList<>();
        //判断前端是否传入dwid，如果没有用当前用户的战区id
        if (StringUtils.isEmpty(hcSfCxMxQuery.getDwid())) {
            hcSfCxMxQuery.setDwid(parentId);
        }
        //查询出来该用户战区下的所有数据
        ListPageVo<HcSfCxMxQuery, HcFhMxVO> listPageCommon =
                new ListPageCommon<HcSfCxMxQuery, HcFhMxVO>(hcSfCxMxQuery, (q) -> tCkCkMapper.FhMx(q)).getVo();
        //判断是否拥有旅团的数据  如果拥有旅团的数据把旅团上级战区的战区名替换掉旅团名
        listPageCommon.getList().stream().forEach(One -> {
            //判断是否是旅团级
            if (One.getDwid().length() > 4) {
                //截取旅团的前四位  ---上级战区id
                String id = One.getDwid().substring(0, 4);
                //根据战区id去t_xt_dw表中把上级战区的数据查询出来
                TXtDw tXtDw = tXtDwMapper.selectByid(id);
                //用战区名替换掉旅团名
                One.setSszq(tXtDw.getMc());
            }
            list.add(One);
        });

        listPageCommon.setList(list);
        return listPageCommon;
    }




    /**
     * @param query
     * @Author: gzh
     * @Data: 2020/7/10
     * @Description: 库存查询-待修库存统计
     */
    @Override
    public ListPageVo<NewPrpertoryCountQuery, Map> getRepairKcQuery(NewPrpertoryCountQuery query, String dwid) {
        //封装当前登录人的机关id
        query.setDwid(dwid);
        //TODO 按照战区的数据分页
        ListPageVo<NewPrpertoryCountQuery, NewRepertoryCountVO> listPageCommon =
                new ListPageCommon<NewPrpertoryCountQuery, NewRepertoryCountVO>(query, (q) -> tCkDxMapper.listTJ(q)).getVo();
        List<NewRepertoryCountVO> list = listPageCommon.getList();
        //准备一个返回数据的集合
        List<Map> mapList = new ArrayList<>();
        for (NewRepertoryCountVO NewRepertoryCountVO : list) {
            Map map = new HashMap();
            //获取当前登陆人下的所有的机关
            List<TXtDw> dwList = iCompanyService.getChildren();
            // 动态不确定的数据
            for (TXtDw tXtDw : dwList) {
                int num = 0;
                NewPrpertoryCountQuery q = new NewPrpertoryCountQuery();
                q.setDwid(tXtDw.getId());
                q.setJh(NewRepertoryCountVO.getJh());
                q.setJx(NewRepertoryCountVO.getJx());
                List<NewRepertoryCountVO> domeVOList = tCkDxMapper.listTJ(q);
                if (domeVOList != null && domeVOList.size() > 0) {
                    NewRepertoryCountVO newRepertoryCountVO = domeVOList.get(0);
                    if (null != newRepertoryCountVO.getSl()) {
                        num = newRepertoryCountVO.getSl();
                    }
                }
                map.put("dwId" + tXtDw.getId(), tXtDw.getMc());
                map.put("dwId" + tXtDw.getId() + "sl", num);
                map.put("jx", NewRepertoryCountVO.getJx());
                map.put("jxmc", NewRepertoryCountVO.getJxmc());
                map.put("jh", NewRepertoryCountVO.getJh());
                map.put("jhmc", NewRepertoryCountVO.getJhmc());
                map.put("zs", NewRepertoryCountVO.getSl());
                map.put("zl", NewRepertoryCountVO.getZl());
            }
            mapList.add(map);
        }
        ListPageVo<NewPrpertoryCountQuery, Map> listPageVo = new  ListPageCommon<NewPrpertoryCountQuery, Map>(query, (q) -> mapList).getVo();
        listPageVo.setPage(listPageCommon.getPage());

        return listPageVo;
    }


    /**
     * 待修库存明细
     * gzh
     *
     * @param query
     * @param parentId
     * @return
     */
    @Override
    public ListPageVo<NewPrpertoryCountQuery, RepairKcMxVO> getDaiXiuKcMxQuery(NewPrpertoryCountQuery query, String parentId) {
        //准备一个存放返回数据的容器
        List<RepairKcMxVO> list = new ArrayList<>();
        //判断前端是否传入dwid，如果没有用当前用户的战区id
        if (StringUtils.isEmpty(query.getDwid())) {
            query.setDwid(parentId);
        }
        ListPageVo<NewPrpertoryCountQuery, RepairKcMxVO> listPageCommon =
                new ListPageCommon<NewPrpertoryCountQuery, RepairKcMxVO>(query, (q) -> tCkDxMapper.listMx(q)).getVo();

        listPageCommon.getList().stream().forEach(One -> {
            //判断是否是旅团级
            if (One.getDwid().length() > 4) {
                //截取旅团的前四位  ---上级战区id
                String id = One.getDwid().substring(0, 4);
                //根据战区id去t_xt_dw表中把上级战区的数据查询出来
                TXtDw tXtDw = tXtDwMapper.selectByid(id);
                //用战区名替换掉旅团名
                One.setSszq(tXtDw.getMc());
            }
            list.add(One);
        });

        listPageCommon.setList(list);

        return listPageCommon;

    }


    /**
     * 报废库存明细
     * gzh
     *
     * @param query
     * @param parentId
     * @return
     */
    @Override
    public ListPageVo<NewPrpertoryCountQuery, ScrapKcMxVO> getScrapKcMxQuery(NewPrpertoryCountQuery query, String parentId) {
        //准备一个存放返回数据的容器
        List<ScrapKcMxVO> list = new ArrayList<>();
        //判断前端是否传入dwid，如果没有用当前用户的战区id
        if (StringUtils.isEmpty(query.getDwid())) {
            query.setDwid(parentId);
        }
        ListPageVo<NewPrpertoryCountQuery, ScrapKcMxVO> listPageCommon =
                new ListPageCommon<NewPrpertoryCountQuery, ScrapKcMxVO>(query, (q) -> tCkBfkMapper.listMx(q)).getVo();

        listPageCommon.getList().stream().forEach(One -> {
            //判断是否是旅团级
            if (One.getDwid().length() > 4) {
                //截取旅团的前四位  ---上级战区id
                String id = One.getDwid().substring(0, 4);
                //根据战区id去t_xt_dw表中把上级战区的数据查询出来
                TXtDw tXtDw = tXtDwMapper.selectByid(id);
                //用战区名替换掉旅团名
                One.setSszq(tXtDw.getMc());
            }
            list.add(One);
        });

        listPageCommon.setList(list);

        return listPageCommon;

    }

    /**
     *@Author: liuys
     *@Data: 2020/7/10
     *@Description: 报废查询 统计
     */
    @Override
    public List<Map> getScrapStatistics(SummaryQuery query) {
        String deptId = SysUserUtils.getUser().getDeptId();
        if (deptId.isEmpty()){
            return null;
        }
        //根据机关单位向下查询
        query.setDwid(deptId.substring(0,2));
        //查询所有的 机型 件号   根据机型 件号 时间
        ListPageVo<SummaryQuery, TCkDxVO> listPageVo = new ListPageCommon<SummaryQuery, TCkDxVO>
                (query, (q) -> tCkDxMapper.getStatistics(q)).getVo();
        //查询所有的战区
        List<TXtDw> children = iCompanyService.getChildren();
        //查询所有的战区下的信息  并把数量添加进去
        List<Map> list = new ArrayList<>();
        for (TCkDxVO tCkDx : listPageVo.getList()) {
            HashMap map = new HashMap();
            Integer zs=0;
            map.put("zl", "待修");
            map.put("jx", tCkDx.getJx());
            map.put("jh", tCkDx.getJh());
            map.put("jhmc", tCkDx.getJhmc());
            map.put("jxmc", tCkDx.getJxmc());
            for (TXtDw tXtDw : children) {
                map.put("dwId" + tXtDw.getId(), tXtDw.getMc());
                //战区单位
                query.setDwid(tXtDw.getId());
                query.setJx(tCkDx.getJx());
                query.setJh(tCkDx.getJh());
                Integer sl=tCkDxMapper.getRepairedStatistics(query);
                sl=sl==null?0:sl;
                map.put("dwId" + tXtDw.getId() + "sl", sl);
                zs=sl+zs;
            }
            map.put("zs", zs);
            list.add(map);
        }
        return list;
    }

    @Override
    public List<SszqVO> getSszq(String parentId) {
        return tCkCkMapper.getSszq(parentId);
    }



    /**
     * @Author: liuys
     * @Data: 2020/7/10
     * @Description: 待修查询统计
     */
    @Override
    public List<Map> getRepairedStatistics(SummaryQuery query) {
        String deptId = SysUserUtils.getUser().getDeptId();
        if (deptId.isEmpty()){
            return null;
        }
        //根据机关单位向下查询
        query.setDwid(deptId.substring(0,2));
        //查询所有的 机型 件号   根据机型 件号 时间
        ListPageVo<SummaryQuery, TCkBfkVO> listPageVo = new ListPageCommon<SummaryQuery, TCkBfkVO>
                (query, (q) -> tCkBfkMapper.getStatistics(q)).getVo();
        //查询所有的战区
        List<TXtDw> children = iCompanyService.getChildren();
        //查询所有的战区下的信息  并把数量添加进去
        List<Map> list = new ArrayList<>();
        for (TCkBfkVO tCkDx : listPageVo.getList()) {
            HashMap map = new HashMap();
            Integer zs=0;
            map.put("zl", "待修");
            map.put("jx", tCkDx.getJx());
            map.put("jh", tCkDx.getJh());
            map.put("jhmc", tCkDx.getJhmc());
            map.put("jxmc", tCkDx.getJxmc());
            for (TXtDw tXtDw : children) {
                map.put("dwId" + tXtDw.getId(), tXtDw.getMc());
                //战区单位
                query.setDwid(tXtDw.getId());
                query.setJx(tCkDx.getJx());
                query.setJh(tCkDx.getJh());
                Integer sl=tCkBfkMapper.getRepairedStatistics(query);
                sl=sl==null?0:sl;
                map.put("dwId" + tXtDw.getId() + "sl", sl);
                zs=sl+zs;
            }
            map.put("zs", zs);
            list.add(map);
        }
        return list;
    }

    /**
     * 获取dome  list
     *
     * @param dwid
     * @return
     */
    @Override
    public List<Map> getListDome(String dwid, SummaryQuery summaryQuery) {
        //获取当前用户机关，传入件号，机型查询，查询出所属战区的vo信息
        List<StatisticsDomeVO> list = tCkCkMapper.getStatisticDome(dwid, summaryQuery.getJx(), summaryQuery.getJh());
        //创建map容器
        List<Map> mapList = new ArrayList<>();
        //遍历所属战区所有相关信息
        for (StatisticsDomeVO statisticsDomeVO : list) {
            Map map = new HashMap();
            //改用户所属战区，每个旅团相关的所有信息
            List<TXtDw> dwList = iCompanyService.getChildren();
            // 动态不确定的数据
            for (TXtDw tXtDw : dwList) {
                int num = 0;
                //获取当前该战区或旅团下所有的所需数据
                List<StatisticsDomeVO> domeVOList =
                        tCkCkMapper.getStatisticDome(tXtDw.getId(), statisticsDomeVO.getJx(),
                                statisticsDomeVO.getJh());
                //如果战区所属以下有数据
                if (domeVOList != null && domeVOList.size() > 0) {
                    //获取到战区每一条西悉尼
                    StatisticsDomeVO statisticsDomeVOS = domeVOList.get(0);
                    //如果数量不为null，进行累加
                    if (null != statisticsDomeVOS.getSl()) {
                        num = statisticsDomeVOS.getSl();
                    }
                }
                //把战区或旅团对应id和名称放入
                map.put("dwId" + tXtDw.getId(), tXtDw.getMc());
                //把战区或旅团对应id和统计数加入容器
                map.put("dwId" + tXtDw.getId() + "sl", num);
            }
            mapList.add(map);
        }
        return mapList;
    }

    /**
     * 查询在修统计
     *
     * @param summaryQuery
     * @return
     */
    @Override
    public ListPageVo<SummaryQuery, Map> getStatisticsUnderRepair(SummaryQuery summaryQuery) {
        // List<StatisticsDomeVO> list = tCkSxMapper.getStatisticsUnderRepairList(summaryQuery);
        ListPageVo<SummaryQuery, Map> listPageVo = new ListPageCommon<SummaryQuery, Map>
                (summaryQuery, (q) -> tCkSxMapper.getStatisticsUnderRepairList(q)).getVo();
        for (Map map : listPageVo.getList()) {
            List<TXtDw> dwList = iCompanyService.getChildren();
            // 动态不确定的数据
            for (TXtDw tXtDw : dwList) {
                int num = 0;
                SummaryQuery summaryQuery1 = new SummaryQuery();
                summaryQuery1.setDwid(tXtDw.getId());
                summaryQuery1.setJh(map.get("jh").toString());
                summaryQuery1.setJx(map.get("jx").toString());
                List<Map> domeVOList =
                        tCkSxMapper.getStatisticsUnderRepairList(summaryQuery1);
                if(domeVOList!=null && domeVOList.size()>0){
                    Map statisticsDomeVOS = domeVOList.get(0);
                    if(null != statisticsDomeVOS.get("sl")){
                        num = Integer.parseInt(statisticsDomeVOS.get("sl").toString());
                    }
                }
                map.put("dwId" + tXtDw.getId(), tXtDw.getMc());
                map.put("dwId" + tXtDw.getId() + "sl", num);
            }
        }
        return listPageVo;
    }

    /**
     * 查询在关注件儿
     *
     * @param summaryQuery
     * @return
     */
    @Override
    public ListPageVo<SummaryQuery, Map> getPersonalConcernsStatistics(SummaryQuery summaryQuery) {
        ListPageVo<SummaryQuery, Map> listPageVo = new ListPageCommon<SummaryQuery, Map>
                (summaryQuery, (q) -> tCkCkMapper.getPersonalConcernsStatistics(q)).getVo();
        for (Map map : listPageVo.getList()) {
            List<TXtDw> dwList = iCompanyService.getChildren();
            // 动态不确定的数据
            for (TXtDw tXtDw : dwList) {
                int num = 0;
                SummaryQuery summaryQuery1 = new SummaryQuery();
                summaryQuery1.setDwid(tXtDw.getId());
                summaryQuery1.setJh(map.get("jh").toString());
                summaryQuery1.setUserId(SysUserUtils.getUserId());
                summaryQuery1.setJx(map.get("jx").toString());
                List<Map> domeVOList =
                        tCkCkMapper.getPersonalConcernsStatistics(summaryQuery1);
                if (domeVOList != null && domeVOList.size() > 0) {
                    Map statisticsDomeVOS = domeVOList.get(0);
                    if (null != statisticsDomeVOS.get("sl")) {
                        num = (int) statisticsDomeVOS.get("sl");
                    }
                }
                map.put("dwId" + tXtDw.getId(), tXtDw.getMc());
                map.put("dwId" + tXtDw.getId() + "sl", num);
            }
        }
        return listPageVo;
    }

    /**
     * 航材预警统计
     *
     * @param summaryQuery
     * @return
     */
    @Override
    public ListPageVo<SummaryQuery, Map> getWarningStatistics(SummaryQuery summaryQuery) {
        ListPageVo<SummaryQuery,Map> listPageVo =  new ListPageCommon<SummaryQuery, Map>
                (summaryQuery, (q) -> tCkCkMapper.getWarningStatistics(q)).getVo();
        for (Map map : listPageVo.getList()) {
            List<TXtDw> dwList = iCompanyService.getChildren();
            // 动态不确定的数据
            for (TXtDw tXtDw : dwList) {
                int num = 0;
                SummaryQuery summaryQuery1 = new SummaryQuery();
                summaryQuery1.setDwid(tXtDw.getId());
                summaryQuery1.setJh(map.get("jh").toString());
                summaryQuery1.setUserId(SysUserUtils.getUserId());
                summaryQuery1.setJx(map.get("jx").toString());
                List<Map> domeVOList =
                        tCkCkMapper.getWarningStatistics(summaryQuery1);
                if(domeVOList!=null && domeVOList.size()>0){
                    Map statisticsDomeVOS = domeVOList.get(0);
                    if(null != statisticsDomeVOS.get("sl")){
                        num = (int) statisticsDomeVOS.get("sl");
                    }
                }
                map.put("dwId"+tXtDw.getId(),tXtDw.getMc());
                map.put("dwId"+tXtDw.getId()+"sl",num);
            }
        }
        return listPageVo;
    }


    @Override
    public List<Map> getXLNLListData(TCkSxXLNLQuery tCkSxXLNLQuery) {
        List<TcksxXLNLTJVO> xlnlListData = tCkSxMapper.getXLNLListData(tCkSxXLNLQuery.getJx(), tCkSxXLNLQuery.getJh());
        List<Map> mapList = new ArrayList<>();
        for (TcksxXLNLTJVO tcksxXLNLTJVO : xlnlListData) {
            System.out.println(tcksxXLNLTJVO.toString());
            Map map = new HashMap();
            List<TCkSxXLNLDTO> list = tCkSxService.getList();
            // 动态不确定的数据
            for (TCkSxXLNLDTO tCkSxXLNLDTO : list) {
                map.put("dwId" + tCkSxXLNLDTO.getDwid(), tcksxXLNLTJVO.getDwmc());
                map.put("dwId" + tCkSxXLNLDTO.getDwid() + "avgTime", tcksxXLNLTJVO.getAvgTime());
                map.put("dwId" + tCkSxXLNLDTO.getDwid() + "maxTime", tcksxXLNLTJVO.getMaxTime());
            }
            map.put("jxmc", tcksxXLNLTJVO.getJxmc());
            map.put("jhmc", tcksxXLNLTJVO.getJhmc());
            map.put("jh", tcksxXLNLTJVO.getJh());
            mapList.add(map);
        }

        return mapList;
    }


/*    @Override
    public List<TcksxXLNLMXVO> selectXLNLMX(TCkSxXLNLQuery tCkSxXLNLQuery) {
        List<TcksxXLNLMXVO> tcksxXLNLMXVOS = tCkSxMapper.selectXLNLMX(tCkSxXLNLQuery);
        return tcksxXLNLMXVOS;
    }*/

    /**
     * 分组条件
     *
     * @param statisticsDomeVO
     * @return
     */
    private String getZqDwId(StatisticsDomeVO statisticsDomeVO) {
        return statisticsDomeVO.getDwid().substring(0, 4) + statisticsDomeVO.getJx() + statisticsDomeVO.getJh();
    }

    @Override
    public List<IndexEcharsVO> getIndexEchats(TCkCrkqdIndexQuery tCkCrkqdIndexQuery) {
        List<IndexEcharsVO> indexEcharsVOS = tCkCrkqdMapper.selectCkEcharts(tCkCrkqdIndexQuery);
        String startDate1 = tCkCrkqdIndexQuery.getStartDate();
        String endDate1 = tCkCrkqdIndexQuery.getEndDate();
        String startYear = startDate1.substring(0, 4);
        String endYear = endDate1.substring(0, 4);
        Integer startMouth = Integer.parseInt(startDate1.substring(5, 7));
        Integer endMouth = Integer.parseInt(endDate1.substring(5, 7));
        if (!startYear.equals(endYear)) {
            endMouth += 12;
        }
        List<IndexEcharsVO> list = new ArrayList<>();

        for (int i = startMouth; i <= endMouth; i++) {
            for (int j = 0; j < indexEcharsVOS.size(); j++) {
                int i1 = Integer.parseInt(indexEcharsVOS.get(j).getMouth().substring(5, 7));
                if (i == i1) {
                    list.add(indexEcharsVOS.get(j));
                }
            }
            if (list.size() <= (i - startMouth)) {
                if (i > 12) {
                    String mouth = "";
                    if ((i - 12) < 10) {
                        mouth = endYear + "-0" + (i - 12);
                    } else {
                        mouth = endYear + "-" + (i - 12);
                    }
                    list.add(new IndexEcharsVO(mouth, 0, 0));
                } else {
                    String mouth = "";
                    if (i < 10) {
                        mouth = startYear + "-0" + i;
                    } else {
                        mouth = startYear + "-" + i;
                    }

                    list.add(new IndexEcharsVO(mouth, 0, 0));
                }

            }
        }
        return list;
    }
}
