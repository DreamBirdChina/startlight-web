package com.dreambird.redis;

import redis.clients.jedis.Jedis;

import java.util.Iterator;
import java.util.Set;

/**
 * Created by chen.jun on 2018/2/23.
 */
public class RedisKeyJava {

    public static void main(String[] args) {
        //���ӱ��ص� Redis ����
        Jedis jedis = new Jedis("localhost");
        System.out.println("���ӳɹ�");

        // ��ȡ���ݲ����
        Set<String> keys = jedis.keys("*");
        Iterator<String> it=keys.iterator() ;
        while(it.hasNext()){
            String key = it.next();
            System.out.println(key);
        }
    }

}
