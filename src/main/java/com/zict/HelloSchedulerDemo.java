package com.zict;

import com.zict.job.HelloJob;
import org.quartz.*;
import org.quartz.impl.StdScheduler;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.spi.MutableTrigger;

import static org.quartz.SimpleScheduleBuilder.simpleSchedule;

public class HelloSchedulerDemo{
    public static void main(String[] args)  throws Exception{
        //调度器
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        //任务实例
        JobDetail build = JobBuilder.newJob(HelloJob.class).withIdentity("job1", "group1").usingJobData("job","job数据").usingJobData("count",0).build();
        //触发器
        Trigger sbtTriggerBuilder =  TriggerBuilder.newTrigger().withIdentity("trigger1", "group1").withSchedule(simpleSchedule().withIntervalInSeconds(5).repeatForever()).usingJobData("trigger","trigger数据").startNow().build();
        //
        scheduler.scheduleJob(build,sbtTriggerBuilder);
        scheduler.start();
    }
}
