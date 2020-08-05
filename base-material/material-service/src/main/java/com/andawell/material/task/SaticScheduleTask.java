package com.andawell.material.task;/**
 * @Date： 2020/6/16 13:29
 */

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

/**
 *@Auther:liuys
 *@Date:2020/6/16 13:29
 *@Description:
 */
@Slf4j
@Configuration  //主要用于标记配置类
@EnableScheduling   //开启定时任务
public class SaticScheduleTask {

   /* @Scheduled(cron = "0 0 1 * * ?")
    private void configureTasks(){

    }*/

}
