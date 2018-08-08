package com.ddl.test;

import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class JedisTest {
    public static void main(String[] args) {
        //连接redis ，redis的默认端口是6379
        Jedis jedis = new Jedis("localhost", 6379);

        jedis.set("ddl", "idea");
        jedis.set("ddl2", "idea2");
        jedis.set("ddl3", "idea3");

        String s1 = jedis.get("ddl");
        System.out.println(s1);

        jedis.del("ddl3");
        String s2 = jedis.get("ddl3");
        System.out.println(s2);

        jedis.rename("ddl2", "ddl3");
        String s3 = jedis.get("ddl3");
        System.out.println(s3);

        //jedis.persist("ddl1");
        Boolean exists = jedis.exists("ddl");
        System.out.println(exists);

        String type = jedis.type("ddl");
        System.out.println(type);

        jedis.expire("ddl", 5);//5秒过期
        try {
            Thread.sleep(5 * 1001);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String s11 = jedis.get("ddl");
        System.out.println(s11);

        //哈希表key中的域field的值设为value。
        jedis.hset("key1", "field1", "field1-value");
        jedis.hset("key1", "field2", "field2-value");

        //返回哈希表key中给定域field的值(多个)
        List list = jedis.hmget("key1", "field1", "field2");
        for (int i = 0; i < list.size(); i++) {
            System.out.println("one-" + list.get(i));
        }

        Map map = new HashMap();
        map.put("field1", "field1-value222");
        map.put("field2", "field2-value222");
        jedis.hmset("key1", map);

        //返回哈希表key中给定域field的值
        jedis.hget("key1", "field1");

        List list1 = jedis.hmget("key1", "field1", "field2");
        for (int i = 0; i < list1.size(); i++) {
            System.out.println("two-" + list1.get(i));
        }

        Map<String, String> map1 = jedis.hgetAll("key1");
        for (Map.Entry entry : map1.entrySet()) {
            System.out.print(entry.getKey() + ":" + entry.getValue() + "\t");
        }


        Set<String> keys = jedis.keys("*"); //
        System.out.println(keys);

        jedis.close();

    }

}
