package com.andawell.material.service.impl;

import com.andawell.common.entity.search.ListCommon;
import com.andawell.common.util.BusinessException;
import com.andawell.common.util.SysUserUtils;
import com.andawell.material.constant.NoticeConstant;
import com.andawell.material.dto.SystemNoDetailDTO;
import com.andawell.material.dto.TXhpCrkDTO;
import com.andawell.material.dto.TXhpRkBcDTO;
import com.andawell.material.entity.*;
import com.andawell.material.mapper.TCkCrklbMapper;
import com.andawell.material.mapper.TXhpCkMapper;
import com.andawell.material.mapper.TXhpCrkMapper;
import com.andawell.material.mapper.TXhpCrkqdMapper;
import com.andawell.material.query.*;
import com.andawell.material.service.IBaseLibraryService;
import com.andawell.material.service.ITXhpCkService;
import com.andawell.material.util.BeanUtils;
import com.andawell.material.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class TXhpCkServiceImpl implements ITXhpCkService {

    @Autowired
    TXhpCkMapper tXhpCkMapper;
    @Autowired
    TXhpCrkMapper tXhpCrkMapper;
    @Autowired
    TXhpCrkqdMapper tXhpCrkqdMapper;

    @Autowired
    TCkCrklbMapper tCkCrklbMapper;



    @Override
    public List<TXhpCk> list() {
        return tXhpCkMapper.list();
    }



    /**
     * 通过mc，gg，pch核减数量
     * @param query
     * @return
     */
    @Override
    public int txhpCkUpdateByMcGgPch(TXhpCkHjQuery query) {
        return tXhpCkMapper.updateByMcAndGgAndPch(query);
    }



    /**
     *@Auther:gzh
     *@Date:2020/5/18 13:45
     *@Description:  五金入库保存
     * 生成编号，封装
     * 插入T_XHP_CRK，T_XHP_CK，T_XHP_CRKQD
     *@Param:TXhpRkBcDTO
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void rkbc(TXhpRkBcDTO tXhpRkBcDTO) {
        Date date = new Date();
        TXhpRkBcDTO xhpRkBcDTO = scBhWh(tXhpRkBcDTO); //封装编号
        //增加1行，数据来源是【入库主信息】。  插入T_XHP_CRK
     /*   TXhpCrk  tXhpCrk = tXhpCrkMapper.selectByPrimaryKey(xhpRkBcDTO.getTXhpCrkDTO().getBh());*/
            xhpRkBcDTO.getTXhpCrkDTO().setPch(tXhpRkBcDTO.getTXhpCkDTO().get(0).getPch());//封装批次号
            tXhpCrkMapper.insert(BeanUtils.dtoTODO(xhpRkBcDTO.getTXhpCrkDTO(),TXhpCrk.class));

        //增加1行或多行，由【缓存表】中的数据来确定。  插入T_XHP_CK
        xhpRkBcDTO.getTXhpCkDTO().stream().forEach(oneTXhpCkDTO->{
            TXhpCk tXhpCk = tXhpCkMapper.selectByPrimaryKey(oneTXhpCkDTO.getPch(), oneTXhpCkDTO.getMc(), oneTXhpCkDTO.getGg());
            if(tXhpCk==null){
                oneTXhpCkDTO.setRkrq(date);
                tXhpCkMapper.insert(BeanUtils.dtoTODO(oneTXhpCkDTO,TXhpCk.class));
            }
        });
        //增加1行或多行，由【缓存表】中的数据来确定。  插入T_XHP_CRKQD
        xhpRkBcDTO.getTXhpCrkqdDTO().stream().forEach(oneTXhpCrkqdDTO->{
            oneTXhpCrkqdDTO.setBh(xhpRkBcDTO.getTXhpCrkDTO().getBh());
            oneTXhpCrkqdDTO.setRq(date);
            tXhpCrkqdMapper.insert(BeanUtils.dtoTODO(oneTXhpCrkqdDTO,TXhpCrkqd.class));
        });

    }


    /**
     *@Auther:gzh
     *@Date:2020/5/19 10:39
     *@Description: 五金出库保存
     *@Param: tXhpRkBcDTO
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void ckbc(TXhpRkBcDTO tXhpRkBcDTO) {
        Date date = new Date();
        TXhpRkBcDTO xhpRkBcDTO = scBhWh(tXhpRkBcDTO); //封装编号文号


        //由【缓存表】中的数据来确定。 核减T_XHP_CK
        xhpRkBcDTO.getTXhpCkDTO().stream().forEach(oneTXhpCkDTO->{
            tXhpCkMapper.updateByMcAndGgAndPch(oneTXhpCkDTO);
        });


        //增加1行，数据来源是【出库主信息】。  插入T_XHP_CRK
        tXhpCrkMapper.insert(BeanUtils.dtoTODO(xhpRkBcDTO.getTXhpCrkDTO(),TXhpCrk.class));

        //增加1行或多行，由【缓存表】中的数据来确定。  插入T_XHP_CRKQD
        xhpRkBcDTO.getTXhpCrkqdDTO().stream().forEach(oneTXhpCrkqdDTO->{
            oneTXhpCrkqdDTO.setBh(xhpRkBcDTO.getTXhpCrkDTO().getBh());
            oneTXhpCrkqdDTO.setRq(date);
            tXhpCrkqdMapper.insert(BeanUtils.dtoTODO(oneTXhpCrkqdDTO,TXhpCrkqd.class));
        });
    }




    /**
     *@Auther:gzh
     *@Date:2020/5/19 10:46
     *@Description: 生成TXhpRkBcDTO的编号和文号
     *@Param: TXhpRkBcDTO
     *@return: TXhpRkBcDTO
     */
    public TXhpRkBcDTO scBhWh(TXhpRkBcDTO tXhpRkBcDTO){
        DecimalFormat decimalFormat = new DecimalFormat("0000");
        //获取当前年度
        Calendar date = Calendar.getInstance();
        String year = String.valueOf(date.get(Calendar.YEAR));

        //获取最大编号并封装
        TCkCrklb tCkCrklb = tCkCrklbMapper.selectByPrimaryKey(tXhpRkBcDTO.getTXhpCrkDTO().getLb());
        System.out.println(tCkCrklb.getJm()+"-"+SysUserUtils.getUser().getDeptId()+"-LH"+year+"第");
        String MaxBh = tXhpCrkqdMapper.maxBh(tCkCrklb.getJm()+"-"+SysUserUtils.getUser().getDeptId()+"-LH"+year+"第");
        if(MaxBh==null){
            tXhpRkBcDTO.getTXhpCrkDTO().setBh(tCkCrklb.getJm()+"-"+SysUserUtils.getUser().getDeptId()+"-LH"+year+"第0001号");
        }else{
        int maxBh = Integer.parseInt(MaxBh.substring(MaxBh.length() - 5, MaxBh.length()-1))+1; //编号四位流水
        tXhpRkBcDTO.getTXhpCrkDTO().setBh(tCkCrklb.getJm()+"-"+SysUserUtils.getUser().getDeptId()+"-LH"+year+"第"+decimalFormat.format(maxBh)+"号");//封装编号
        }
      /*  //获取最大文号并封装
        String Maxwh = tXhpCrkqdMapper.maxWh();
        int maxWh = Integer.parseInt(Maxwh.substring(Maxwh.length() - 4, Maxwh.length()))+1;  //文号四位流水
        tXhpRkBcDTO.getTXhpCrkDTO().setWh(tXhpRkBcDTO.getTXhpCrkDTO().getLb()+year+decimalFormat.format(maxWh)); //封装系统文号*/
        return tXhpRkBcDTO;
    }


}
