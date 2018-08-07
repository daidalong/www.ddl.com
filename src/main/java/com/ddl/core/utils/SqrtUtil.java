package com.ddl.core.utils;

import redis.clients.jedis.Jedis;

public class SqrtUtil {

	public static double sqrt(double c) {
		if (c < 0)
			return Double.NaN;
		double err = 1e-15;
		double t = c;

		while (Math.abs(t - c / t) > err * t)
			t = (c / t + t) / 2.0;

		return t;
	}

	public static double kf(double a, int n) {
		if (n < 0)
			return Double.NaN;

		if (n == 1)
			return a;

		double x1 = (1 + a) / 2.0d;

		for (int j = 0; j < 16; j++) {

			double xn = x1;
			for (int i = 1; i < n; i++)
				xn *= x1;

			double xn_1 = x1;
			for (int i = 1; i < n - 1; i++)
				xn_1 *= x1;

			xn_1 *= 2.0;
			x1 = (xn + a) / xn_1;
		}
		return x1;
	}
	
	public static void main(String[] args) {
        //连接本地的 Redis 服务
        Jedis jedis = new Jedis("localhost");
        //设置 redis 字符串数据
        //final String code = jedis.set("hello", "www.runoob.com");
        //System.out.println(code);
        // 获取存储的数据并输出
        System.out.println("redis 存储的字符串为: "+ jedis.get("hello"));
    }
}
