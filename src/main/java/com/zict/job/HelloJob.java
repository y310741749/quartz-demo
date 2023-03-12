package com.zict.job;

import org.quartz.*;

import java.text.SimpleDateFormat;
import java.util.Date;

@PersistJobDataAfterExecution //jobdataMap数据持久化
public class HelloJob implements Job {
    private Integer count;

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        JobDataMap jobDataMap = jobExecutionContext.getJobDetail().getJobDataMap();
        JobDataMap jobDataMap1 = jobExecutionContext.getTrigger().getJobDataMap();
        System.out.println("jobDataMap:"+jobDataMap.get("job"));
        System.out.println("jobDataMap1:"+jobDataMap1.get("trigger"));
        System.out.println("当前时间:"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        ++count;
        System.out.println(count);
        jobExecutionContext.getJobDetail().getJobDataMap().put("count",count);
    }
}
