package com.andawell.material.service.impl;

import com.andawell.material.dto.TCkCrkDTO;
import com.andawell.material.dto.TGzHzDTO;
import com.andawell.material.entity.TCkCrk;
import com.andawell.material.entity.TGzHz;
import com.andawell.material.mapper.TCkCrkMapper;
import com.andawell.material.mapper.TGzHzMapper;
import com.andawell.material.service.ITGzHzService;
import com.andawell.material.util.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/***
 * @author shs
 * @Date: 2020/5/7 15:42
 * @Description:
 * @version : V1.0
 */
@Service
public class TGzHzServiceImpl implements ITGzHzService {
    @Autowired
    private TGzHzMapper tGzHzMapper;
    @Autowired
    private TCkCrkMapper tCkCrkMapper;
    /***
     * @author shs
     * @Date: 2020/7/2 17:29
     * @Description:
     * 1.生成入库编号，每次生成获取最大编号，依次累加，编号规则（LH_HZD20200002）
     *   如果为空从0001开始
     * 2.传入日期，份数，页数，发单人，备注
     * 3.执行添加操作
     * 4.添加成功返回前端
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insert(List<TGzHz> list) {
        for (int i = 0; i < list.size(); i++) {
            String IDd;
            //获取项目名
            String one = "LH_HZD";
            //获取时间年份
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
            Date date1 = new Date();
            Integer date = Integer.parseInt(sdf.format(date1));
            TGzHz tGzHz = list.get(i);
            //获取尾号
            String Id = tGzHzMapper.maxId();
            if (Id.equals(null) || Id.equals("")){
                Id=one+date+"0001";
                tGzHz.setId(Id);
                tGzHzMapper.insertSelective(list.get(i));
            }
            String PJ = "0";
            //取后三位
            String ID = Id.substring(Id.length() - 4, Id.length());
            Integer replace = Integer.parseInt(ID);
            Integer serial = Integer.valueOf(replace + 1);
            DecimalFormat decimalFormat = new DecimalFormat("0000");
            String format = decimalFormat.format(serial);
            IDd = one + date + format;
            tGzHz.setId(IDd);
            tGzHzMapper.insertSelective(list.get(i));
        }
    }

    @Override
    public void updateTCkCrk(TCkCrkDTO tCkCrkDTO) {
        TCkCrk tckcrk = BeanUtils.dtoTODO(tCkCrkDTO, TCkCrk.class);
        tCkCrkMapper.updateByPrimaryKeySelective(tckcrk);
    }
    /***
     * @author shs
     * @Date: 2020/7/2 17:29
     * @Description:
     * 1.根据前端传入的日期，承运单位，运单号，发运人进行修改
     * 2.调用修改接口
     * 3.修改成功返回前端
     */
    @Override
    public void updaterkhz(TGzHzDTO tGzHzDTOS) {
        TGzHz tGzHz = BeanUtils.dtoTODO(tGzHzDTOS, TGzHz.class);
        tGzHzMapper.updateByPrimaryKeySelective(tGzHz);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void inserttgzhz(List<TGzHzDTO> tGzHzDTO) {
        tGzHzDTO.stream().forEach(one -> {
            TGzHz tGzHz = BeanUtils.dtoTODO(one, TGzHz.class);
            tGzHzMapper.insertSelective(tGzHz);
        });
    }

}
