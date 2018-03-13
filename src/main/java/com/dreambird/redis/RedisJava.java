package com.dreambird.redis;

import com.mchange.v2.c3p0.ConnectionTester;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Created by chen.jun on 2018/2/23.
 */
public class RedisJava {

    public static void main(String[] args) {
        connectionTest();
//        jedisPool();
    }

    public static  void connectionTest(){
        //���ӱ��ص� Redis ����
//        Jedis jedis = new Jedis("localhost");
        Jedis jedis = new Jedis("192.168.88.128",6379);
        System.out.println("���ӳɹ�");
        //�鿴�����Ƿ�����
        System.out.println("������������: "+jedis.ping());
        jedis.set("test","chenjun");
        System.out.println(jedis.get("test"));
        //�ͷ���Դ
        jedis.close();
    }

    public static void jedisPool(){
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(30); //�������������
        config.setMaxIdle(10); //���ÿ���������
        JedisPool pool = new JedisPool(config,"192.168.88.128",6379);
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            System.out.println(jedis.ping());
            jedis.set("name","zhangsan");
            System.out.println(jedis.get("name"));
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (jedis != null){
                jedis.close();
                if (pool != null){
                    pool.close();
                }
            }
        }

    }

}
