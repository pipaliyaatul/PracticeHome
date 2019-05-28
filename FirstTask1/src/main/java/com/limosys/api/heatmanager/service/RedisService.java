package com.limosys.api.heatmanager.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.PostConstruct;

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
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.stereotype.Service;

import com.limosys.api.model.redis.RedisKey;

@Service
public class RedisService 
{
	String key = "spring.boot.redis.test";
	
	@Autowired
	RedisTemplate<String, Object> redisServer;

	public void set(String value)throws Exception
	{
		ValueOperations<String, Object> ops = this.redisServer.opsForValue();
		
		ops.set(key, value);

	}
	
	public String get()
	{
		String res = (String)this.redisServer.opsForValue().get(key);
		return res;
	}

	public String Status()
	{
		return null;
	}
	public String firstfunc()
	{
		return "this is called from the firstfunction";
		
	}
	
	
	
	/*
	    @Test 
	    public void testKeys()
	    {
	        Set<String> set = redisServer.keys("*");
	        System.out.println(set.toString());
	    }
	    
	    @Test
	    public void testSet()
	    {
	        redisServer.opsForSet().add("keyb", "11");
	        System.out.println(redisServer.opsForValue().get("key0")+","+redisServer.opsForSet().pop("keyb")+","+redisServer.opsForSet().pop("keyb"));
	    }
	    
	    @Test
	    public void testOpsForList(){
	        List<User> roles = new ArrayList<>();
	        User user = new com.limosys.api.heatmanager.service(1L, "luke", 20);
	        roles.add(user);
	        ValueOperations<String, Object> opsForList = redisServer.opsForValue();
	        
	        opsForList.set("roles", roles);
	        
	        List<User> result = (List<User>) opsForList.get("roles");
	 
	        System.out.println(result.get(0).getName());
	        
	    }
	    
	    @Test
	    public void testOpsForMap(){
	        Map<String, String> score = new HashMap<>();
	        score.put("stuA", "89");
	        score.put("stuB", "63");
	        score.put("stuC", "94");
	        score.put("stuD", "21");
	        
	        ValueOperations<String, Object> opsForList = redisServer.opsForValue();
	        opsForList.set("scores", score);
	        @SuppressWarnings("unchecked")
					Map<String, String> result = (Map<String, String>) opsForList.get("scores");
	        System.out.println(result.get("stuA"));
	    }
	    
	    
	    
	    @Test
	    public void testBoundOperations() 
	    {
	        BoundValueOperations<String, Object> boundValueOperations = RedisServer.boundValueOps("BoundTest");    
	    
	        System.out.println("key: " + boundValueOperations.getKey());
	        System.out.println(boundValueOperations.get());
	        System.out.println("expire: " + boundValueOperations.getExpire());
	    }
	 */   
	}
	

