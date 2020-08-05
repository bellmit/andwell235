package com.andawell.material.service.impl;

import com.andawell.material.entity.TGzFh;
import com.andawell.material.mapper.TGzFhMapper;
import com.andawell.material.service.ITGzFhService;
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
public class TGzFhServiceImpl implements ITGzFhService {

    @Autowired
    TGzFhMapper tGzFhMapper;

    /***
     * @author shs
     * @Date: 2020/7/2 17:29
     * @Description:
     * 1.生成发货编号，每次生成获取最大编号，依次累加，编号规则（LH_FH20200001）
     *   如果为空从0001开始
     * 2.传入机型，出库文号，收获单位，日期，运输方式，箱数，重量，出库编号，发货人，备注等
     * 3.执行添加操作
     * 4.添加成功返回前端
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insert(List<TGzFh> list) {

        for (int i = 0; i < list.size(); i++) {
            String IDd;
            //获取项目名
            String one = "LH_FH";
            //获取时间年份
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
            Date date1 = new Date();
            Integer date = Integer.parseInt(sdf.format(date1));
            TGzFh tGzFh = list.get(i);
            //获取尾号
            String Id = tGzFhMapper.maxId();
            if (Id.equals(null) ||Id.equals("")){
                Id=one+date+"0001";
                tGzFh.setId(Id);
                tGzFhMapper.insertSelective(tGzFh);
            }
            String PJ = "0";
            //取后三位
            String ID = Id.substring(Id.length() - 4, Id.length());
            Integer replace = Integer.parseInt(ID);
            Integer serial = Integer.valueOf(replace + 1);
            DecimalFormat decimalFormat = new DecimalFormat("0000");
            String format = decimalFormat.format(serial);
            IDd = one + date + format;
            tGzFh.setId(IDd);
            tGzFh.setZt(9);
            tGzFhMapper.insertSelective(tGzFh);
        }
    }
    /***
     * @author shs
     * @Date: 2020/7/3 17:29
     * @Description:
     * 1.根据前端传入编号
     * 2.调用修改接口
     * 3.修改状态为已完成（3代表已完成）
     * 4.修改成功返回前端
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            tGzFhMapper.update(list.get(i));
        }
    }
}
