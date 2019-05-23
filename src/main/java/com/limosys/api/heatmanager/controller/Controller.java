package com.limosys.api.heatmanager.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.limosys.api.heatmanager.service.RedisService;
//import com.limosys.api.model.redis.RedisRepository;
//import com.limosys.api.redis.entity.CachedAffId;
//import com.limosys.api.redis.entity.CachedGroup;

@RestController
public class Controller 
{
	
	@Autowired
	RedisService redis;@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
	
	@RequestMapping(method = { RequestMethod.GET, RequestMethod.POST })
	public String ping() 
	{

		//return redis.hello();
		return redis.firstfunc();
	}

}

