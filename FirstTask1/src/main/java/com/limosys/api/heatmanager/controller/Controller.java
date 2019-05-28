package com.limosys.api.heatmanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.ReactiveHashCommands.HGetCommand;
import org.springframework.data.redis.connection.ReactiveHashCommands.HSetCommand;
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
import com.limosys.api.model.factory.GeoFactory;
import com.limosys.api.obj.companylist.AppCompKey;
import com.limosys.api.obj.geo.ExtEvent;
import com.limosys.api.obj.geo.ExtEventLog;
import com.limosys.api.service.geo.LoggingService.Event;


@RestController
public class Controller 
{
	@Autowired
	RedisService redis;@Override
	public String toString() 
	{
		// TODO Auto-generated method stub
		return super.toString();
	}
	
	/*
	@RequestMapping(value=method = { RequestMethod.GET, RequestMethod.POST,RequestMethod.PUT})
	public ResponseEntity<String> ping() throws Exception 
	{
		//redis.set(value);
		String value = redis.get();
		
		if (value == null || value.isEmpty()) 
		{
			redis.set(value);
			return new ResponseEntity<>(HttpStatus.CREATED);
		} 
		else 
		{
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
	
	
	/*private String HGetCommand(String value1)
	{
		//HSetCommand.value(value);
		
		return value1;
	}
	*/
	
	
	
	
	@RequestMapping(value=("/service"),method = { RequestMethod.PUT })
	public String get(String value) throws Exception 
	{
	
		String value1 = redis.get();
	
		System.out.println("This is in old value of redis"+value1);
				
		redis.set(value);
			
		  if(value.equals(value1)) 
		  {
					System.out.println("Value is already present in redis Do nothing = "+""+value1);
		  } 
		  else 	
		  {
					redis.set(value);
					System.out.println("New Value is added"+value);
		  }
		
			return null;
	}
	

	@GetMapping("/service")
	ResponseEntity<String> age(
	  @RequestParam("value")
	{
	  
	    if (isInFuture(yearOfBirth)) 
	    {
	        return new ResponseEntity<>("Year of birth cannot be in the future",HttpStatus.BAD_REQUEST);
	    }
	 
	    return new ResponseEntity<>("Your age is " + calculateAge(yearOfBirth),HttpStatus.OK);
	}
}

