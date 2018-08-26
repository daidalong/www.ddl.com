package com.ddl.test;

import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;

public class JedisStringTest {

    public static final String USER_MOBILE_KEY = "user:mobile:";
    public static final String USER_INFO_KEY = "user:info:";
    public static final String USER_FRIEND_KEY = "user:friend:";

    public static void main(String[] args) {

        //连接redis ，redis的默认端口是6379
        Jedis jedis = new Jedis("localhost", 6379);

        // 设置字符串值
        jedis.set(USER_MOBILE_KEY + "100001", "13624587531");
        jedis.set(USER_MOBILE_KEY + "100003", "13624587999");
        jedis.set(USER_MOBILE_KEY + "100005", "13624587522");

        Map<String,String> userInfoMap1 = new HashMap<String,String>();
        userInfoMap1.put("address","北京");
        userInfoMap1.put("age","33");

        Map<String,String> userInfoMap2 = new HashMap<String,String>();
        userInfoMap2.put("address","上海");
        userInfoMap2.put("age","32");

        Map<String,String> userInfoMap3 = new HashMap<String,String>();
        userInfoMap3.put("address","广州");
        userInfoMap3.put("age","31");

        jedis.hmset(USER_INFO_KEY + "100001",userInfoMap1);
        jedis.hmset(USER_INFO_KEY + "100003",userInfoMap2);
        jedis.hmset(USER_INFO_KEY + "100004",userInfoMap3);

        jedis.sadd(USER_FRIEND_KEY + "100001","甲","乙","丙");

        System.out.println("写入redis完成！");




    }

}
