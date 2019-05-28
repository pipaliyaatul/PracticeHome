package com.limosys.api.model.redis;

	public enum RedisKey 
	{
		
	//	STUDENT("Atul","Programmer"),
		SPRING_SESSION("SPRING_SESSION", null),
		CAR("CAR", null),
		CAR_EXPIRATION_TABLE("CAR_EXPIRE", 120000L),
		CAR_GPS("CAR_GPS", null),
		GROUP("GROUP", null),
		MASKED_PHONE("MASKED_PHONE", 86400000L), // 24h
		MASKED_PHONE_FORWARD("MASKED_PHONE_FORWARD", 30000L),
		CALL_LOG("CALL_LOG", 86400000L), // 24h
		EVENT("EVENT", null),
		APP_EVENT("APP_EVENT", null),
		LIVE_TRIP("LiveTrip", null),
		LIVE_TRIP_LAST_SEEN("LastSeenTime", null),
		LIVE_TRIP_EXPOSE_TO("X-ExposeTo", null),
		BLOCKED_CARS("BlockedCars", null);

		public final String key;
		public final Long expire;

		private RedisKey(String key, Long expire) {
			this.key = key;
			this.expire = expire;
		}

		@Override
		public String toString() 
		{
			return key;
		}
	}


