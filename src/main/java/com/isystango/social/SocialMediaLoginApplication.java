package com.isystango.social;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableOAuth2Sso
public class SocialMediaLoginApplication {

	public static void main(String[] args) {
		SpringApplication.run(SocialMediaLoginApplication.class, args);
	}

}
