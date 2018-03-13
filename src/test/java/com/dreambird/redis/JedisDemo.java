package com.dreambird.redis;

import org.aspectj.lang.annotation.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by chen.jun on 2018/3/13.
 */
public class JedisDemo {

    private Jedis jedis;

    @org.junit.Before
    public void connectionRedis(){
        jedis = new Jedis("localhost");
    }

    /**
     * redis�洢�ַ���
     */
    @Test
    public void testString(){
        //�������
        jedis.set("name","����");
        System.out.println(jedis.get("name"));

        //ƴ������
        jedis.append("name","������");
        System.out.println(jedis.get("name"));

        //ɾ������
        jedis.del("name");
        System.out.println(jedis.get("name"));

        //���ö����ֵ��
        jedis.mset("name","����","age","12","QQ","123456");
        jedis.incr("age");
        System.out.println("������"+jedis.get("name")+"  ���䣺"+jedis.get("age")+"  QQ:"+jedis.get("QQ"));
    }

    /**
     * redis����Map
     */
    @Test
    public void testMap(){
        //-----�������----------
        Map<String,String> map = new HashMap<String,String>();
         map.put("name","����");
         map.put("age","12");
         map.put("QQ","123456");
         jedis.hmset("user",map);
        //ȡ��user�е�name��ִ�н��:[minxr]-->ע������һ�����͵�List
        //��һ�������Ǵ���redis��map�����key����������Ƿ���map�еĶ����key�������key���Ը�������ǿɱ����
        List<String> resultMap = jedis.hmget("user","name","age","QQ");
        System.out.println(resultMap);

        //ɾ��map�е�ĳ����ֵ
        jedis.hdel("user","age");
        System.out.println(jedis.hmget("user", "age")); //��Ϊɾ���ˣ����Է��ص���null
        System.out.println(jedis.hlen("user")); //����keyΪuser�ļ��д�ŵ�ֵ�ĸ���2
        System.out.println(jedis.exists("user"));//�Ƿ����keyΪuser�ļ�¼ ����true
        System.out.println(jedis.hkeys("user"));//����map�����е�����key
        System.out.println(jedis.hvals("user"));//����map�����е�����value

        //����redis�е�Map
        Iterator<String> it = jedis.hkeys("user").iterator();
        while (it.hasNext()){
            String key = it.next();
            System.out.println(key);
            System.out.println(jedis.hmget("user",key));
        }
    }

    /**
     * jedis����List
     */
    @Test
    public void testList(){
        //��ʼǰ���Ƴ���������
        jedis.del("java framework");
        System.out.println(jedis.lrange("java framework",0,-1));

        //�������
        jedis.lpush("java framework","spring");
        jedis.lpush("java framework","struts");
        jedis.lpush("java framework","hibernate");
        //��ȡ����������jedis.lrange�ǰ���Χȡ����
        // ��һ����key���ڶ�������ʼλ�ã��������ǽ���λ�ã�jedis.llen��ȡ���� -1��ʾȡ������
        System.out.println(jedis.lrange("java framework",0,-1));

        jedis.del("java framework");
        jedis.rpush("java framework","spring");
        jedis.rpush("java framework","struts");
        jedis.rpush("java framework","hibernate");
        System.out.println(jedis.lrange("java framework",0,-1));



    }

}
