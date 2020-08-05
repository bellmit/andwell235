package com.andawell.material.service.impl;

import com.andawell.common.entity.search.ListPageCommon;
import com.andawell.common.entity.vo.ListPageVo;
import com.andawell.common.util.BusinessException;
import com.andawell.common.util.SysUserUtils;
import com.andawell.material.dto.*;
import com.andawell.material.entity.TCkCk;
import com.andawell.material.entity.TCkYfk;
import com.andawell.material.enumeration.WeholeNumberStyle;
import com.andawell.material.mapper.TCkCkMapper;
import com.andawell.material.mapper.TCkYfkMapper;
import com.andawell.material.query.TCkCkQuery;
import com.andawell.material.query.YFPlanQuery;
import com.andawell.material.service.TCkCkSerivce;
import com.andawell.material.vo.TCkCkPlanVO;
import com.andawell.material.vo.TCkCkVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/***
 * @author hwd
 * @Date: 2020-05-09 17:47
 * @Description:
 * @version : V1.0
 */
@Service
@Transactional
@Slf4j
public class TCkCkSerivceImpl implements TCkCkSerivce
{

    @Autowired
    private TCkCkMapper tCkCkMapper;

    @Autowired
    private TCkYfkMapper tCkYfkMapper;

    @Autowired
    BaseLibraryService baseLibraryService;

    /**
     * 内部油封计划
     */
    @Override
    public List<TCkCkPlanVO> getList(YFPlanQuery yfPlanQuery) {

        List<TCkCkPlanVO> planList = tCkCkMapper.getPlanList(yfPlanQuery);
        return planList;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveFkMessage(List<TCkCkPlanDTO>  tCkCkPlanDTO) {
        for (TCkCkPlanDTO ckCkPlanDTO : tCkCkPlanDTO) {
            //获取编号
            String systemNumber = baseLibraryService.getSystemNumber(new SystemNoDetailDTO(ckCkPlanDTO.getJm(), ckCkPlanDTO.getDwid()));
            ckCkPlanDTO.setBh(systemNumber);
            TCkYfk tCkYfk = new TCkYfk();
            BeanUtils.copyProperties(ckCkPlanDTO,tCkYfk);
            tCkYfk.setXz("0");
            try {
                tCkYfkMapper.insertSelective(tCkYfk);
            }catch (Exception e)
            {
                e.printStackTrace();
                log.error(e.getMessage());
                throw  new BusinessException(ckCkPlanDTO.getJhmc()+"保存数据失败");
            }
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveYFData(List<YFDataAffirmDTO> yfDataAffirmDTOs) {
        for (YFDataAffirmDTO yfDataAffirmDTO : yfDataAffirmDTOs) {

            //查找数据
            TCkYfk tCkYfk = tCkYfkMapper.selectByPrimaryKey(yfDataAffirmDTO.getBh(), yfDataAffirmDTO.getDwid(), yfDataAffirmDTO.getJx(), yfDataAffirmDTO.getJh(), yfDataAffirmDTO.getXh(), yfDataAffirmDTO.getZl(), yfDataAffirmDTO.getXz());
            TCkCk tCkCk = tCkCkMapper.selectByPrimaryKey(yfDataAffirmDTO.getDwid(), yfDataAffirmDTO.getJx(), yfDataAffirmDTO.getJh(), yfDataAffirmDTO.getXh(), yfDataAffirmDTO.getZl(), yfDataAffirmDTO.getXz());
            if (tCkYfk != null&& tCkCk != null) {
                try {
                    //修改T_CK_YFK将xz改为1，将备注信息改为：原备注+最新备注
                    //修改数据
                    tCkYfk.setXzs("1");
                    if(yfDataAffirmDTO.getBz()!=null)
                    {
                        tCkYfk.setBz("原备注:" + (tCkYfk.getBz()!=null?tCkYfk.getBz():"") + ",最新备注:" +
                                yfDataAffirmDTO.getBz());
                    }

                    //update
                    tCkYfkMapper.updateByPrimaryKeySelective(tCkYfk);

                    //修改T_CK_CK  将xz改为1  将YFCS加1  将JWH改为‘正在油封’
                    tCkCk.setXzs("1");
                    tCkCk.setYfcs(tCkCk.getYfcs()==null?1:tCkCk.getYfcs()+1);
                    tCkCk.setJwh("正在油封");
                    tCkCkMapper.updateByPrimaryKeySelective(tCkCk);
                }catch (Exception e)
                {
                    e.printStackTrace();
                    log.error(e.getMessage());
                    throw  new BusinessException(yfDataAffirmDTO.getJh()+"修改失败");
                }
            }else
            {
                throw  new BusinessException(yfDataAffirmDTO.getJh()+"TCkYfk或者tCkCk未有该数据");
            }

        }
    }

    @Override
    public void putYFData(List<PutYFDataDTO> putYFDataDTOS) {
        for (PutYFDataDTO putYFDataDTO : putYFDataDTOS) {
            TCkYfk tCkYfk = tCkYfkMapper.selectByPrimaryKey(putYFDataDTO.getBh(), putYFDataDTO.getDwid(), putYFDataDTO.getJx(), putYFDataDTO.getJh(), putYFDataDTO.getXh(), putYFDataDTO.getZl(), putYFDataDTO.getXz());
            TCkCk tCkCk = tCkCkMapper.selectByPrimaryKey(putYFDataDTO.getDwid(), putYFDataDTO.getJx(), putYFDataDTO.getJh(), putYFDataDTO.getXh(), putYFDataDTO.getZl(), putYFDataDTO.getXz());
            if(tCkYfk!=null&&tCkCk!=null) {
                //封装信息
                tCkYfk.setYfrq(putYFDataDTO.getYfrq());
                tCkYfk.setYfqx(putYFDataDTO.getYfqx());
                tCkYfk.setSyyl(putYFDataDTO.getSyyl());
                tCkYfk.setFcff(putYFDataDTO.getFcff());
                tCkYfk.setBz(putYFDataDTO.getBz());
                tCkYfk.setXzs("2");
                tCkYfk.setYfqx(tCkYfk.getYfqx().setScale(2, BigDecimal.ROUND_UP));

                //修改tckck，将状态改为2
                tCkCk.setXzs("2");
                try {
                    tCkYfkMapper.updateByPrimaryKeySelective(tCkYfk);
                    tCkCkMapper.updateByPrimaryKeySelective(tCkCk);
                } catch (Exception e)
                {
                    e.printStackTrace();
                    log.error(e.getMessage());
                    throw  new BusinessException(putYFDataDTO.getJh()+"修改异常");
                }

            }else {
                throw  new BusinessException(putYFDataDTO.getJh()+"没有该数据");
            }
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void confirmYFReceive(List<ConfirmYFReceiveDTO> confirmYFReceiveDTOs) {
        for (ConfirmYFReceiveDTO confirmYFReceiveDTO : confirmYFReceiveDTOs) {

            //查找数据
            TCkYfk tCkYfk = tCkYfkMapper.selectByPrimaryKey(confirmYFReceiveDTO.getBh(), confirmYFReceiveDTO.getDwid(), confirmYFReceiveDTO.getJx(), confirmYFReceiveDTO.getJh(), confirmYFReceiveDTO.getXh(), confirmYFReceiveDTO.getZl(), confirmYFReceiveDTO.getXz());
            TCkCk tCkCk = tCkCkMapper.selectByPrimaryKey(confirmYFReceiveDTO.getDwid(), confirmYFReceiveDTO.getJx(), confirmYFReceiveDTO.getJh(), confirmYFReceiveDTO.getXh(), confirmYFReceiveDTO.getZl(), confirmYFReceiveDTO.getXz());
            if(tCkYfk!=null && tCkCk!=null)
            {
                try {
                    //修改T_CK_YFK  将xz改为3 并将ckrq改为当天日期
                    tCkYfk.setXzs("3");
                    tCkYfk.setCkrq(new Date());
                    tCkYfkMapper.updateByPrimaryKeySelective(tCkYfk);
                    //修改T_CK_CK 将xz改为0 并修改YFRQ  YFQX
                    tCkCk.setXzs("0");
                    //修改yfrq yfqx
                    tCkCk.setYfrq(confirmYFReceiveDTO.getYfrq());
                    tCkCk.setYfqx(confirmYFReceiveDTO.getYfqx());
                    tCkCkMapper.updateByPrimaryKeySelective(tCkCk);
                }catch (Exception e)
                {
                    e.printStackTrace();
                    log.error(e.getMessage());
                    throw  new BusinessException(confirmYFReceiveDTO.getJh()+"修改失败");
                }

            }else
            {
                throw  new BusinessException(confirmYFReceiveDTO.getJh()+"没有该数据");
            }


        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void YFCompletedShelves(List<YFCompletedShelvesDTO> yfCompletedShelvesDTOS) {
        for (YFCompletedShelvesDTO yfCompletedShelvesDTO : yfCompletedShelvesDTOS) {

            //查找数据
            TCkYfk tCkYfk = tCkYfkMapper.selectByPrimaryKey(yfCompletedShelvesDTO.getBh(),yfCompletedShelvesDTO.getDwid(),yfCompletedShelvesDTO.getJx(),yfCompletedShelvesDTO.getJh(),yfCompletedShelvesDTO.getXh(),yfCompletedShelvesDTO.getZl(),yfCompletedShelvesDTO.getXz());
            TCkCk tCkCk = tCkCkMapper.selectByPrimaryKey(yfCompletedShelvesDTO.getDwid(), yfCompletedShelvesDTO.getJx(), yfCompletedShelvesDTO.getJh(), yfCompletedShelvesDTO.getXh(), yfCompletedShelvesDTO.getZl(), WeholeNumberStyle.ZERO.getName());
            if (tCkYfk != null && tCkCk!=null)
            {
                try {
                    //修改T_CK_YFK  修改xz=4
                    tCkYfk.setXzs("4");
                    tCkYfkMapper.updateByPrimaryKeySelective(tCkYfk);

                    //修改T_CK_CK 修改jwh
                    if(yfCompletedShelvesDTO.getJwh()!=null)
                    {
                        tCkCk.setJwh(yfCompletedShelvesDTO.getJwh());

                    }
                    if(yfCompletedShelvesDTO.getBz()!=null)
                    {
                        tCkCk.setBz(yfCompletedShelvesDTO.getBz());
                    }
                    tCkCkMapper.updateByPrimaryKeySelective(tCkCk);
                }catch (Exception e)
                {
                    e.printStackTrace();
                    log.error(e.getMessage());
                    throw  new BusinessException(yfCompletedShelvesDTO.getJh()+"修改异常");
                }

            }else
            {
                throw  new BusinessException(yfCompletedShelvesDTO.getJh()+"没有该数据");
            }
        }
    }

    @Override
    public ListPageVo<TCkCkQuery, TCkCkVO> listAllGz(TCkCkQuery query) {
        return new ListPageCommon<TCkCkQuery, TCkCkVO>(query,(q)->tCkCkMapper.listAllGz(q)).getVo();
    }

    @Override
    public ListPageVo<TCkCkQuery, TCkCkVO> listUserGz(TCkCkQuery query) {
        String id = SysUserUtils.getUserId();
        query.setYhid(id);
        return new ListPageCommon<TCkCkQuery, TCkCkVO>(query,(q)->tCkCkMapper.listUserGz(q)).getVo();
    }

}
