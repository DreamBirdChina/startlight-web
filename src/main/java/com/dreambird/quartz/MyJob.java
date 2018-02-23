package com.dreambird.quartz;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;
import org.quartz.TriggerKey;

public class MyJob implements Job{
	
	private static String pattern = "yyyy-MM-dd HH:mm:ss";

    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
    	
        System.out.println(getCurrentDate() + "---------------start---------------");
        
        //��ȡ����������Ϣ
        JobKey jobKey = jobExecutionContext.getJobDetail().getKey();
        System.out.println("my job name and groupName are:"+jobKey.getName()+"-"+jobKey.getGroup());
        
        //��ȡ������������Ϣ
        TriggerKey trigger = jobExecutionContext.getTrigger().getKey();
        System.out.println("my trigger name and groupName are:"+trigger.getName()+"-"+trigger.getGroup());
        
        //��ȡJobDataMap��Ϣ
        JobDataMap jobDataMap = jobExecutionContext.getJobDetail().getJobDataMap();
        JobDataMap triggerDataMap = jobExecutionContext.getTrigger().getJobDataMap();
        String jobMsg = jobDataMap.getString("message");
        Float jobFloat = jobDataMap.getFloat("Float");
        String triggerMsg = triggerDataMap.getString("message");
        Float triggerFloat = triggerDataMap.getFloat("Float");
        System.out.println("jobMsg:"+jobMsg);
        System.out.println("jobFloat:"+jobFloat);
        System.out.println("triggerMsg:"+triggerMsg);
        System.out.println("triggerFloat:"+triggerFloat);
        
        System.out.println(getCurrentDate() + "---------------end---------------");
    }
    
    public String getCurrentDate(){
    	Date date = new Date();
    	SimpleDateFormat sdf = new SimpleDateFormat(pattern);
    	return sdf.format(date);
    }
}
