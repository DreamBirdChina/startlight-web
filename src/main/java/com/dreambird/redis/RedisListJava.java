package com.dreambird.redis;

import redis.clients.jedis.Jedis;

import java.util.List;

/**
 * Created by chen.jun on 2018/2/23.
 */
public class RedisListJava {
    public static void main(String[] args) {
        //���ӱ��ص� Redis ����
        Jedis jedis = new Jedis("localhost");
        System.out.println("���ӳɹ�");
        //�洢���ݵ��б���
        jedis.lpush("site-list", "Runoob");
        jedis.lpush("site-list", "Google");
        jedis.lpush("site-list", "Taobao");
        // ��ȡ�洢�����ݲ����
        List<String> list = jedis.lrange("site-list", 0 ,2);
        for(int i=0; i<list.size(); i++) {
            System.out.println("�б���Ϊ: "+list.get(i));
        }
    }
}
