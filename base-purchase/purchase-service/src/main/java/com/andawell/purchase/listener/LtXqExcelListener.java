package com.andawell.purchase.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.andawell.common.util.BeanUtils;
import com.andawell.purchase.dto.excel.LtXqExcelDTO;
import com.andawell.purchase.entity.TDhLtxq;
import com.andawell.purchase.entity.TDhLtxqTemp;
import com.andawell.purchase.service.ITDhJhQdService;
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
public class LtXqExcelListener extends AnalysisEventListener<LtXqExcelDTO> {


    private ITDhJhQdService dhJhQdService;

    private String bh;

    public LtXqExcelListener(ITDhJhQdService dhJhQdService, String bh) {
        this.dhJhQdService = dhJhQdService;
        this.bh = bh;
    }

    public LtXqExcelListener() {

    }

    /**
     * 批处理阈值为2000
     * @param basic
     * @param analysisContext
     */
    private static final int BATCH_COUNT = 2000;
    List<LtXqExcelDTO> list = new ArrayList<LtXqExcelDTO>();


    @Override
    public void invoke(LtXqExcelDTO ltXqExcelDTO, AnalysisContext context) {

        // 获取对应的行数
        list.add(ltXqExcelDTO);
        // 达到batch_count ，需要存储一次数据库 ，防止数据几万条数据在内存，容易OOM
        if(list.size() >= BATCH_COUNT){
            saveData();
            list.clear();
        }
    }

    private void saveData(){
        // 调用savleData 方法
        dhJhQdService.leadingIn
                (BeanUtils.copyList(list, TDhLtxqTemp.class),bh);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        saveData();
    }
}
