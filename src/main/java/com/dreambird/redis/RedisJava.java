package com.dreambird.redis;

import redis.clients.jedis.Jedis;

/**
 * Created by chen.jun on 2018/2/23.
 */
public class RedisJava {

    public static void main(String[] args) {
        //���ӱ��ص� Redis ����
        Jedis jedis = new Jedis("localhost");
        System.out.println("���ӳɹ�");
        //�鿴�����Ƿ�����
        System.out.println("������������: "+jedis.ping());
    }

}
