package com.praveen.restservices.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.Setter;

@Configuration
@Getter
@Setter
@RefreshScope
public class UserProperties {
	
	@Value("${praveen-user-management-service.redis.host}")
	private String hostName;
	
	@Value("${praveen-user-management-service.redis.port}")
	private int port;
	
	@Value("${praveen-user-management-service.redis.password}")
	private String password;
	
	@Value("${praveen-user-management-service.redis.jedis.pool.max-active}")
	private int jedisPoolMaxActive;
	
	@Value("${praveen-user-management-service.redis.jedis.pool.max-idle}")
	private int jedisPoolMaxIdle;
	
	@Value("${praveen-user-management-service.redis.jedis.pool.max-wait}")
	private long jedisPoolMaxWait;
	
	@Value("${praveen-user-management-service.redis.jedis.pool.min-idle}")
	private int jedisPoolMinIdle;
	

}
