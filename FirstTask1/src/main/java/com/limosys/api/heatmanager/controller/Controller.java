package com.limosys.api.heatmanager.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.ReactiveHashCommands.HGetCommand;
import org.springframework.data.redis.connection.ReactiveHashCommands.HSetCommand;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.connection.RedisServer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.limosys.api.heatmanager.service.RedisService;
/*
import com.limosys.api.model.factory.GeoFactory;
import com.limosys.api.obj.companylist.AppCompKey;
import com.limosys.api.obj.geo.ExtEvent;
import com.limosys.api.obj.geo.ExtEventLog;
import com.limosys.api.service.geo.LoggingService.Event;
*/

@RestController
public class Controller 
{
	@Autowired
	RedisTemplate<String, Object> RedisServer;
	
	@Autowired
	RedisService redis;@Override
	public String toString() 
	{
		
		return super.toString();
	}
	
	
	String key1="car";
	
	@SuppressWarnings("unlikely-arg-type")
	@RequestMapping(value=("/service"),method = { RequestMethod.PUT })
	public ResponseEntity<String> Storeinredis(String value) throws Exception 
	{
	
						
		  if(redis.get(value)) 
		  {
		  	
					System.out.println("Value is already present in redis Do nothing = "+""+value);
					return ResponseEntity.status(HttpStatus.OK).body(value);				
		  } 
		  else 	
		  {
					redis.set(value);
					System.out.println("New Value is added"+value);
					return ResponseEntity.status(HttpStatus.CREATED).body(value);
		  }
	}
}

