package com.ws.quartzdemo1001.job02_JDBC_HelloWorld;

import com.ws.quartzdemo1001.job01_HelloWorld.HelloJob;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyJobForJDBCQuartz implements Job {

    private static Logger log = LoggerFactory.getLogger(MyJobForJDBCQuartz.class);

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        log.info("MyJobForJDBCQuartz  is start ..................");

        log.info("Hello JDBC Quartz !!! " +
                new SimpleDateFormat("yyyy-MM-dd HH:mm:ss ").format(new Date()));

        log.info("MyJobForJDBCQuartz  is end .....................");
    }
}
