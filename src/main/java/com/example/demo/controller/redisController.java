package com.example.demo.controller;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class redisController {
	
	JedisPool pool;
	Jedis jedis;
	
	@Before
	public void start() {
		
		//初始化redis连接池
		pool = new JedisPool(new JedisPoolConfig(),"127.0.0.1");
		//从redis连接池中获取一个连接
		jedis = pool.getResource();
		//redis的密码，对应redis.windows.conf中的masterauth
		/* jedis.auth("123456"); */
	}
	
	//添加测试
	@Test
	public void putTest() {
		jedis.set("userName", "张三");
		System.out.println(jedis.get("userName"));
	}
	
	@Autowired
	private RedisTemplate<Object, Object> template;
	
}
