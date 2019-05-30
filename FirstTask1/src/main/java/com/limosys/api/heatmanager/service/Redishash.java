package com.limosys.api.heatmanager.service;

import java.io.Serializable;

import org.springframework.data.redis.core.RedisHash;
@RedisHash("Redishash")
public class Redishash implements Serializable
{
	public enum Keystore
	{
		height,width;
	}
	private String id;
  private String name;
  private Keystore gender;
  private int grade;
	

}
