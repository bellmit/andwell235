package com.andawell.material.feign.fallback;/**
 * @Date： 2020/6/3 17:18
 */

import com.andawell.common.entity.vo.RestResultVo;
import com.andawell.material.entity.TJhJx;
import com.andawell.material.feign.CrKQdFeignService;
import com.andawell.material.feign.TJhJxFeignService;
import com.andawell.material.vo.TCkCrkqdVO;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *@Auther:liuys
 *@Date:2020/6/3 17:18
 *@Description:
 */
@Component
@Slf4j
public class TJhJXFeignFallbackImpl implements TJhJxFeignService {

    @Setter
    private Throwable cause;



    /**
     * 获取库存统计数量
     *
     * @param jxId
     * @Author: liuys
     * @Data: 2020/6/3
     * @Description:
     */
    @Override
    public RestResultVo<TJhJx> getTJhJxById(String jxId) {
        log.error("feign 查询机型失败", cause);
        return null;
    }
}
