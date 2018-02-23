package com.dreambird.quartz;


public class TestJob {

    public static String JOB_NAME = "��̬�������";
    public static String TRIGGER_NAME = "��̬���񴥷���";
    public static String JOB_GROUP_NAME = "XLXXCC_JOB_GROUP";
    public static String TRIGGER_GROUP_NAME = "XLXXCC_JOB_GROUP";

    public static void main(String[] args) {
        try {
            System.out.println("��ϵͳ��������ʼ(ÿ1�����һ��)...");
            QuartzManager.addJob(JOB_NAME, JOB_GROUP_NAME, TRIGGER_NAME, TRIGGER_GROUP_NAME, MyJob.class, "0/1 * * * * ?");

            Thread.sleep(5000);
            System.out.println("���޸�ʱ�䡿��ʼ(ÿ5�����һ��)...");
            QuartzManager.modifyJobTime(JOB_NAME, JOB_GROUP_NAME, TRIGGER_NAME, TRIGGER_GROUP_NAME, "0/5 * * * * ?");

            Thread.sleep(16000);
            System.out.println("���Ƴ���ʱ���񡿿�ʼ...");
            QuartzManager.removeJob(JOB_NAME, JOB_GROUP_NAME, TRIGGER_NAME, TRIGGER_GROUP_NAME);
            System.out.println("���Ƴ���ʱ���񡿳ɹ�");

            Thread.sleep(6000);
            System.out.println("���رն�ʱ������ʼ...");
            QuartzManager.shutdownJobs();
            System.out.println("���رն�ʱ�����ɹ�");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
