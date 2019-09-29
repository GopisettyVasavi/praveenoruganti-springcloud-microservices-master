package com.praveen.zipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import zipkin2.server.internal.EnableZipkinServer;

@SpringBootApplication
@EnableZipkinServer
public class PraveenZipkinServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(PraveenZipkinServerApplication.class, args);
	}

}
