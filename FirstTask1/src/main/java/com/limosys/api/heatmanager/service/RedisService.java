package com.limosys.api.heatmanager.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.swing.text.html.HTMLDocument.Iterator;

import org.apache.catalina.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.RedisServer;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ScanOptions;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.stereotype.Service;

import com.limosys.api.model.redis.RedisKey;

@Service
public class RedisService 
{
		String key1="spring.boot.redisset.test";
			
	@Autowired
	public RedisTemplate<String, Object> redisServer;
	
	public void set(String value)throws Exception
	{
		
		SetOperations<String, Object> set_operation=this.redisServer.opsForSet();
		
		set_operation.add(key1, value);
			
	}
	
	public Boolean get(String value)
	{
		
		Boolean res = this.redisServer.opsForSet().isMember(key1,value);
		return res;
	}
	
}
	

