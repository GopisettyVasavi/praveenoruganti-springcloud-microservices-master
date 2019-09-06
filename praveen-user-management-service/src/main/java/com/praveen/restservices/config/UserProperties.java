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
	

}
