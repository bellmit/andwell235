package com.andawell.material.service.impl;

import com.andawell.material.dto.TDbJgdbDTO;
import com.andawell.material.dto.TDbJgdbqdDTO;
import com.andawell.material.entity.TDbJgdb;
import com.andawell.material.entity.TDbJgdbqd;
import com.andawell.material.entity.TDbSjsq;
import com.andawell.material.mapper.*;
import com.andawell.material.query.AllotQuery;
import com.andawell.material.query.TCkCkQuery;
import com.andawell.material.service.ITDbJgdbService;
import com.andawell.material.service.ITDbJgdbqdService;
import com.andawell.material.util.BeanUtils;
import com.andawell.material.vo.TDbSjsqqdVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: zje
 * @date: 2020/5/28
 * @description:
 */

@Service
public class TDbJgdbqdServiceImpl implements ITDbJgdbqdService {

    @Autowired
    private TDbJgdbqdMapper tDbJgdbqdMapper;

    @Autowired
    private TDbJgdbMapper tDbJgdbMapper;

    @Autowired
    private TCkCkMapper tCkCkMapper;

    @Autowired
    private ITDbJgdbService dbJgdbService;

    @Autowired
    private TDbSjsqMapper tDbSjsqMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<TDbSjsqqdVO> list(String sqdh) {
        List<TDbSjsqqdVO> tDbSjsqqdVOS = tDbJgdbqdMapper.list(sqdh);
        if(!tDbSjsqqdVOS.isEmpty()){
            tDbSjsqqdVOS.stream().forEach(tDbSjsqqdVO -> {
                TCkCkQuery ckCkQuery = new TCkCkQuery();
                ckCkQuery.setJx(tDbSjsqqdVO.getJx());
                ckCkQuery.setJh(tDbSjsqqdVO.getJh());
                Integer kc = tCkCkMapper.selectByCount(ckCkQuery);
                if (kc==null){
                    kc = 0;
                }
                tDbSjsqqdVO.setKc(kc);
                AllotQuery allotQuery = new AllotQuery();
                allotQuery.setFfdw(tDbSjsqqdVO.getFfdw());
                allotQuery.setJx(tDbSjsqqdVO.getJx());
                allotQuery.setJh(tDbSjsqqdVO.getJh());
                Integer sl = tDbJgdbqdMapper.getToteDBSL(allotQuery);
                int kdbsl =0;
                if (sl != null){
                    if (kc>sl){
                        kdbsl= kc-sl;
                    }
                }
                kdbsl=kc;
                tDbSjsqqdVO.setKdbsl(kdbsl);
                tDbSjsqqdVO.setDbsl(kc-kdbsl);
            });
            return tDbSjsqqdVOS;
        }
        return null;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insert(TDbJgdbDTO dbJgdbDTO) {

            TDbJgdb tDbJgdb = BeanUtils.dtoTODO(dbJgdbDTO, TDbJgdb.class);
            Integer dblx = tDbJgdb.getDblx();
            String allotBh = dbJgdbService.getAllotBh(dblx);
            tDbJgdb.setDbbh(allotBh);
            tDbJgdb.setClzt("0");
            tDbJgdb.setXfzt("0");
            tDbJgdb.setCszt("0");
            tDbJgdb.setRq(new Date());
            tDbJgdbMapper.insertSelective(tDbJgdb);
        TDbSjsq tDbSjsq = tDbSjsqMapper.selectByPrimaryKey(dbJgdbDTO.getSqdh());
        tDbSjsq.setClzt("1");
        tDbSjsqMapper.updateByPrimaryKeySelective(tDbSjsq);
        List<TDbJgdbqdDTO> dbJgdbqdDTOS = dbJgdbDTO.getDbJgdbqdDTOS();
            dbJgdbqdDTOS.stream().forEach(dbJgdbqdDTO -> {
                TDbJgdbqd tDbJgdbqd = BeanUtils.dtoTODO(dbJgdbqdDTO, TDbJgdbqd.class);
                tDbJgdbqdMapper.insertSelective(tDbJgdbqd);

            });
    }

    @Override
    public List<TDbJgdbqd> getJgdbqd(TDbJgdbDTO dbJgdbDTO) {
        List<TDbJgdbqdDTO> dbJgdbqdDTOS = dbJgdbDTO.getDbJgdbqdDTOS();
        List<TDbJgdbqd> tDbJgdbqds = dbJgdbqdDTOS.stream().map(dbJgdbqdDTO -> {
            TDbJgdbqd dbJgdbqd = tDbJgdbqdMapper.selectByPrimaryKey(dbJgdbqdDTO.getDbdh(), dbJgdbqdDTO.getJh(), dbJgdbqdDTO.getZl(), dbJgdbqdDTO.getJx());
            return dbJgdbqd;
        }).collect(Collectors.toList());
        return tDbJgdbqds;
    }

}
