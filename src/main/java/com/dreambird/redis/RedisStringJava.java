package com.dreambird.redis;

import redis.clients.jedis.Jedis;

/**
 * Created by chen.jun on 2018/2/23.
 */
public class RedisStringJava {

    public static void main(String[] args) {
        //���ӱ��ص� Redis ����
        Jedis jedis = new Jedis("localhost");
        System.out.println("���ӳɹ�");
        //���� redis �ַ�������
        jedis.set("runoobkey", "www.runoob.com");
        // ��ȡ�洢�����ݲ����
        System.out.println("redis �洢���ַ���Ϊ: "+ jedis.get("runoobkey"));
    }
}
