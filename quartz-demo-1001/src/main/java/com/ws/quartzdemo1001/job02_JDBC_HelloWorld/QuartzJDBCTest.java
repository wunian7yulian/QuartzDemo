package com.ws.quartzdemo1001.job02_JDBC_HelloWorld;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class QuartzJDBCTest {
    public static void main(String[] args) throws SchedulerException {
        //  1 创建  一个jobDetail 实例
        JobDetail jobDetail = JobBuilder.newJob(MyJobForJDBCQuartz.class)
                .withIdentity("jdbcJob_01", "jdbcGroup_01")
                .storeDurably(true)
                .build();
        // 2 创建  简单的调度器
        SimpleScheduleBuilder simpleScheduleBuilder = SimpleScheduleBuilder
                //设置执行次数
                .repeatSecondlyForTotalCount(5);
        // 3 创建  触发器 Trigger
        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("jdbcTrigger_01", "jdbcTriggerGroup_01")
                .startNow().withSchedule(simpleScheduleBuilder).build();
        // 4 获取  调度器
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        scheduler.start();
        // 5 执行  相关调度
        scheduler.scheduleJob(jobDetail, trigger);
        // 6 关闭  调度器
        scheduler.shutdown();
    }
}
