package com.praveen.restservices;

import static springfox.documentation.builders.PathSelectors.regex;
import static springfox.documentation.builders.RequestHandlerSelectors.basePackage;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.Cloud;
import org.springframework.cloud.CloudFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import com.praveen.restservices.entities.User;
import com.praveen.restservices.model.User1;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class UserManagementServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserManagementServiceApplication.class, args);
	}

	@Bean
	public Docket configDock() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(basePackage("com.praveen.restservices.controller"))
				.paths(regex("/rest.*")).build().apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("PRAVEEN ORUGANTI SPRING BOOT SWAGGER")
				.description("WELCOME TO SWAGGER CLIENT")
				.contact(
						new Contact("PRAVEEN ORUGANTI", "https://javafluid.blogspot.com/", "praveenoruganti@gmail.com"))
				.license("Apache 2.0").licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html").version("1.0.0")
				.build();
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

//	@Bean
//	JedisConnectionFactory jedisConnectionFactory() {
//		return new JedisConnectionFactory();
//	}
//
//	@Bean
//	RedisTemplate<String, User1> redisTemplate1() {
//		RedisTemplate<String, User1> redisTemplate = new RedisTemplate<>();
//		redisTemplate.setConnectionFactory(jedisConnectionFactory());
//		return redisTemplate;
//	}
//
//	@Bean
//	public StringRedisTemplate stringRedisTemplate() {
//		StringRedisTemplate stringRedisTemplate = new StringRedisTemplate(jedisConnectionFactory());
//		return stringRedisTemplate;
//	}

	@Bean
	public RedisConnectionFactory redisConnectionFactory() {
		CloudFactory cloudFactory = new CloudFactory();
		Cloud cloud = cloudFactory.getCloud();
		return cloud.getSingletonServiceConnector(RedisConnectionFactory.class, null);
	}

	/*
	 * @Bean public RedisTemplate redisTemplate() { return new
	 * StringRedisTemplate(redisConnectionFactory()); }
	 */
	@Bean
	RedisTemplate redisTemplate1() {
		RedisTemplate redisTemplate = new RedisTemplate<>();
		redisTemplate.setConnectionFactory(redisConnectionFactory());
		return redisTemplate;
	}
	

}
