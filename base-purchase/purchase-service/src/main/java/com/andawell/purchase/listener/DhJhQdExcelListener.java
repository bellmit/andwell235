package com.andawell.purchase.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.andawell.common.util.BeanUtils;
import com.andawell.purchase.dto.excel.LtXqExcelDTO;
import com.andawell.purchase.dto.excel.TDhJhqdExcelDTO;
import com.andawell.purchase.entity.TDhJhqd;
import com.andawell.purchase.entity.TDhLtxq;
import com.andawell.purchase.service.ITDhJhQdService;
import com.andawell.purchase.vo.TDhJhqdVO;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/***
 * @author lhb
 * @Date: 2020/6/2 13:45
 * @Description:
 * @version : V1.0
 */
@Slf4j
public class DhJhQdExcelListener extends AnalysisEventListener<TDhJhqdVO> {


    private ITDhJhQdService dhJhQdService;

    private String bh;

    public DhJhQdExcelListener(ITDhJhQdService dhJhQdService, String bh) {
        this.dhJhQdService = dhJhQdService;
        this.bh = bh;
    }

    public DhJhQdExcelListener() {

    }

    /**
     * 批处理阈值为2000
     * @param basic
     * @param analysisContext
     */
    private static final int BATCH_COUNT = 2000;
    List<TDhJhqdVO> list = new ArrayList<TDhJhqdVO>();


    @Override
    public void invoke(TDhJhqdVO tDhJhqdVO, AnalysisContext context) {

        // 获取对应的行数
        list.add(tDhJhqdVO);
        // 达到batch_count ，需要存储一次数据库 ，防止数据几万条数据在内存，容易OOM
        if(list.size() >= BATCH_COUNT){
            saveData();
            list.clear();
        }
    }

    private void saveData(){
        // 调用savleData 方法
        dhJhQdService.leadingInDhJh(
                list,
                bh);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        saveData();
    }
}
