package com.andawell.purchase.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.andawell.purchase.entity.TCgMlQdDrmx;
import com.andawell.purchase.service.ITCgMlQdDrmxService;
import com.andawell.purchase.service.ITDhJhQdService;
import com.andawell.purchase.vo.TDhJhqdVO;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/***
 * @author gzh
 * @Date: 2020/6/2 13:45
 * @Description:
 * @version : V1.0
 */
@Slf4j
public class TCgMlQdDrmxExcelListener extends AnalysisEventListener<TCgMlQdDrmx> {


    private ITCgMlQdDrmxService iTCgMlQdDrmxService;

    private String mlbh;

    public TCgMlQdDrmxExcelListener(ITCgMlQdDrmxService iTCgMlQdDrmxService, String mlbh) {
        this.iTCgMlQdDrmxService = iTCgMlQdDrmxService;
        this.mlbh = mlbh;
    }

    public TCgMlQdDrmxExcelListener() {

    }

    /**
     * 批处理阈值为2000
     * @param basic
     * @param analysisContext
     */
    private static final int BATCH_COUNT = 2000;
    List<TCgMlQdDrmx> list = new ArrayList<TCgMlQdDrmx>();


    @Override
    public void invoke(TCgMlQdDrmx tCgMlQdDrmx, AnalysisContext context) {

        // 获取对应的行数
        list.add(tCgMlQdDrmx);
        // 达到batch_count ，需要存储一次数据库 ，防止数据几万条数据在内存，容易OOM
        if(list.size() >= BATCH_COUNT){
            saveData();
            list.clear();
        }
    }

   private void saveData(){
        // 调用savleData 方法
        iTCgMlQdDrmxService.leadingInDrmx(
                list,
                mlbh);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        saveData();
    }
}
