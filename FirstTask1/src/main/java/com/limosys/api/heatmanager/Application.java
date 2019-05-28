package com.limosys.api.heatmanager;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseBody;

//import com.limosys.api.Application;
//import com.limosys.api.Application;
import com.limosys.api.heatmanager.service.RedisService;
import com.limosys.api.model.redis.RedisKey;

@SpringBootApplication
@ComponentScan("com.limosys.api.heatmanager")
public class Application 
{

	private static final String REDIS_URL = "redis-11109.c99.us-east-1-4.ec2.cloud.redislabs.com";
	private static final int REDIS_PORT = 11109;
	private static final String REDIS_PASSWORD="rrvkdlbsCqMrHj70bTT14Wc5ApOrVnpW";
	
	@Bean
	@Primary
	public JedisConnectionFactory redisConnectionFactory()
	{
		RedisStandaloneConfiguration config = new RedisStandaloneConfiguration(REDIS_URL, REDIS_PORT);
//		RedisClusterConfiguration config	 = new RedisClusterConfiguration(REDIS_NODES);
		config.setPassword(RedisPassword.of(REDIS_PASSWORD));

		return new JedisConnectionFactory(config);
	}
	 
	@Bean
	public RedisTemplate<String, Object> redisTemplate() 
	{
	    RedisTemplate<String, Object> template = new RedisTemplate<>();
	    template.setConnectionFactory(redisConnectionFactory());
	    template.setDefaultSerializer(new GenericJackson2JsonRedisSerializer());
	    return template;
	}
	
	protected void runApp(String[] args) 
	{
		Map<String, Object> properties = new HashMap<String, Object>();

		
		properties.put("server.error.whitelabel.enabled", false);
		properties.put("spring.datasource.driverClassName", "org.postgresql.Driver");
		properties.put("spring.jpa.properties.hibernate.current_session_context_class", "thread");
		properties.put("spring.jpa.properties.hibernate.jdbc.lob.non_contextual_creation", true); // to avoid Exception in Method
																																															// org.postgresql.jdbc.PgConnection.createClob() is not yet																																															// implemented.
		properties.put("spring.session.store-type", "redis");
		properties.put("server.servlet.session.timeout", "600");
		properties.put("spring.session.redis.flush-mode", "on-save");
		properties.put("spring.session.redis.namespace", RedisKey.SPRING_SESSION.key);
		
		properties.put("logging.level.org.springframework.web.filter.CommonsRequestLoggingFilter","ERROR"); // set "DEBUG" to see all output
		properties.put("server.tomcat.protocol-header", "x-forwarded-proto"); // for https not to redirect back to http
		properties.put("server.use-forward-headers", "true");
		
		
		SpringApplication app = new SpringApplication(Application.class);
		
		app.setDefaultProperties(properties);
		app.run(args);

	}
	
	public static void main(String[] args) 
	{
		SpringApplication.run(Application.class, args);

	}

}
