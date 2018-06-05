package com.ws.quartzdemo1001.job01_HelloWorld;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;


public class HelloQuartz {
    private static Logger logger = LoggerFactory.getLogger(HelloQuartz.class);

    public static void main(String[] args) throws SchedulerException {
        // 1 创建 Scheduler 的工厂
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        // 2 从工厂中获取调度器 的实例
        Scheduler scheduler = schedulerFactory.getScheduler();
        // 3 创建JobDetail
        JobDetail jobDetail = JobBuilder.newJob(HelloJob.class)
                .withDescription("this is my first job01_HelloWorld ")  // 设置job相关描述
                .withIdentity("hello job01_HelloWorld", "normal job01_HelloWorld") // 设置任务 名称和组名
                .build(); //创建 JobDetail
        // 4 创建 trigger
        CronTrigger trigger = TriggerBuilder.newTrigger()
                .withDescription("this is my first trigger") //设置 trigger 相关描述
                .withIdentity("say hello trigger", "cron trigger") //设置 当前触发其 名字 和归属组名
                .startAt(new Date()) // 设置任务启动时间
                .withSchedule(CronScheduleBuilder.cronSchedule("0/10 * * * * ?"))
                .build();
        // 5 将 job01_HelloWorld 和 trigger 绑定 并注册到 调度器
        scheduler.scheduleJob(jobDetail, trigger);
        // 6 启动 调度器
        scheduler.start();
        logger.info(new Date() + "    <<<<<<  启动");
    }
}
