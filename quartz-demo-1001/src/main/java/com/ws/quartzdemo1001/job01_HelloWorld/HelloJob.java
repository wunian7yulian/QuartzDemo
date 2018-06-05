package com.ws.quartzdemo1001.job01_HelloWorld;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 实现 quartz 对使用人员开放的 Job接口
 */
public class HelloJob implements Job {

    private static Logger log = LoggerFactory.getLogger(HelloJob.class);

    @Override
    public void execute(JobExecutionContext jobExecutionContext)
            throws JobExecutionException {
        log.info("Hello Quartz - Job");
    }
}
