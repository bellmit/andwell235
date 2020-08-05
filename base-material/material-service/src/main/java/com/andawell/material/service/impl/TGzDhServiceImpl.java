package com.andawell.material.service.impl;

import com.andawell.material.dto.TGzDhDTO;
import com.andawell.material.entity.TDbLtsqqd;
import com.andawell.material.entity.TGzDh;
import com.andawell.material.mapper.TGzDhMapper;
import com.andawell.material.service.ITGzDhService;
import com.andawell.material.util.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/***
 * @author shs
 * @Date: 2020/5/7 15:42
 * @Description:
 * @version : V1.0
 */
@Service
public class TGzDhServiceImpl implements ITGzDhService {

    @Autowired
    TGzDhMapper tGzDhMapper;

    /***
     * @author shs
     * @Date: 2020/7/2 17:29
     * @Description:
     * 1.生承到货流水号（LH_DH20200031）
     * 2.前端传入的多条数据循环插入
     * 3.插入成功返回
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insertTGzDhList(List<TGzDh> list) {
//        后端自动生成，参考示例：LH_DH20160008
        for (int i = 0; i < list.size(); i++) {
            String IDd;
            //获取项目名
            String one = "LH_DH";
            //获取时间年份
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
            Date date1 = new Date();
            Integer date = Integer.parseInt(sdf.format(date1));
            TGzDh tGzDh = list.get(i);
            //获取尾号
            String Id = tGzDhMapper.maxId();
            if (Id.equals(null) ||Id.equals("")){
                Id=one+date+"0001";
                tGzDh.setId(Id);
                tGzDhMapper.insert(tGzDh);
            }
            String PJ = "0";
            //取后三位
            String ID = Id.substring(Id.length() - 4, Id.length());
            Integer replace = Integer.parseInt(ID);
            Integer serial = Integer.valueOf(replace + 1);
            DecimalFormat decimalFormat = new DecimalFormat("0000");
            String format = decimalFormat.format(serial);
            IDd = one + date + format;
            tGzDh.setId(IDd);
            tGzDhMapper.insert(tGzDh);
        }
    }
    /***
     * @author shs
     * @Date: 2020/7/2 17:29
     * @Description:
     * 1.根据编号，修改入库文号，入库日期，状态
     * 2.修改航材到货数据
     * 3.修改成功返回给前端
     */
    @Override
    public void updateTGzDh(TGzDhDTO tGzDhDTO) {
        TGzDh tGzDh = BeanUtils.dtoTODO(tGzDhDTO, TGzDh.class);
        tGzDhMapper.updateByPrimaryKeySelective(tGzDh);
    }


}
