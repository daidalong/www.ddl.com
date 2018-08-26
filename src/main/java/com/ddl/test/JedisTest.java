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

        // 设置字符串值
        jedis.set("ddl", "idea");
        jedis.set("ddl2", "idea2");
        jedis.set("ddl3", "idea3");

        // 获取值
        String s1 = jedis.get("ddl");
        System.out.println("[ddl]=" + s1);

        // 删除
        jedis.del("ddl3");
        String s2 = jedis.get("ddl3");
        System.out.println("[ddl3]=" + s2);

        // 重命名
        jedis.rename("ddl2", "ddl3");
        String s3 = jedis.get("ddl3");
        System.out.println("[ddl3]2=" + s3);

        // 设置ddl3永远不过期
        jedis.persist("ddl3");
        System.out.println("[ddl3]3=" + s3);

        // 判断ddl是否存在
        Boolean exists = jedis.exists("ddl");
        System.out.println("[ddl]2=" + exists);

        // 返回key值的类型
        String type = jedis.type("ddl");
        System.out.println("[ddl]3=" + type);

        // 设置过期
        jedis.expire("ddl", 5);//5秒过期
        /*try {
            Thread.sleep(5 * 1001);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        // 并测试过期
        String s11 = jedis.get("ddl");
        System.out.println("[ddl]4=" + s11);

        // 哈希表key中的域field的值设为value。
        jedis.hset("key1", "field1", "field1-value");
        jedis.hset("key1", "field2", "field2-value");

        // 返回哈希表key中给定域field的值(多个)
        List list = jedis.hmget("key1", "field1", "field2");
        for (int i = 0; i < list.size(); i++) {
            System.out.println("one-" + list.get(i));
        }

        // 哈希表封装测试
        Map map = new HashMap();
        map.put("field1", "field1-value222");
        map.put("field2", "field2-value222");
        jedis.hmset("key1", map);

        // 返回哈希表key中给定域field的值
        String value1 = jedis.hget("key1", "field1");
        System.out.println("[key1-field1]=" + value1);

        // 返回哈希
        Map<String, String> map1 = jedis.hgetAll("key1");
        for (Map.Entry entry : map1.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }

        // 删除哈希表中一个或多个域
        jedis.hdel("key1", "field1");

        // 返回值的集合
        List list1 = jedis.hmget("key1", "field1", "field2");
        for (int i = 0; i < list1.size(); i++) {
            System.out.println("two-" + list1.get(i));
        }

        //查看哈希表给定域是否存在
        boolean hexists = jedis.hexists("key1", "field2");
        System.out.println("hexists=" + hexists);

        //返回哈希表中所有的域
        Set<String> fields = jedis.hkeys("key1");
        System.out.println("fields=" + fields);

        //返回哈希表中所有的值
        List<String> values = jedis.hvals("key1");
        System.out.println("values=" + values);



        // 获取全部keys
        Set<String> keys = jedis.keys("*");
        System.out.println(keys);

        //long length = jedis.llen("key1");
        //System.out.println("length=" + length);

        jedis.close();

    }

}