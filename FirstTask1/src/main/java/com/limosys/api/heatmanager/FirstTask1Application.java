package com.limosys.api.heatmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;

@SpringBootApplication
@ComponentScan
public class FirstTask1Application {

	private static final String REDIS_URL = "redis-11109.c99.us-east-1-4.ec2.cloud.redislabs.com";
	private static final int REDIS_PORT = 11109;
	
	@Bean
	@Primary
	public JedisConnectionFactory redisConnectionFactory()
	{
		RedisStandaloneConfiguration config = new RedisStandaloneConfiguration(REDIS_URL, REDIS_PORT);
//		RedisClusterConfiguration config	 = new RedisClusterConfiguration(REDIS_NODES);
//	    redisStandaloneConfiguration.setPassword(RedisPassword.of("yourRedisPasswordIfAny"));

		return new JedisConnectionFactory(config);
	}
	 
	@Bean
	public RedisTemplate<String, Object> redisTemplate() {
	    RedisTemplate<String, Object> template = new RedisTemplate<>();
	    template.setConnectionFactory(redisConnectionFactory());
	    template.setDefaultSerializer(new GenericJackson2JsonRedisSerializer());
	    return template;
	}
	
	public static void main(String[] args) 
	{
		SpringApplication.run(FirstTask1Application.class, args);

	}

	public interface MessagePublisher 
	{
		 
    void publish(final String message);
}
}
