package com.isystango.social.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.userinfo.CustomUserTypesOAuth2UserService;

@Configuration
@EnableWebSecurity
@Order(17)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests()
		.antMatchers("/").permitAll()
		.anyRequest().authenticated()
		.and().formLogin().permitAll()
		.and()
		.oauth2Login()
		.loginPage("/user/signin/facebook");
//		and().oauth2Login().loginPage("/user/signin/facebook");
		
//		
//		http
//		.authorizeRequests()
//		.antMatchers("/", "/user/", "/user/login", "/user/registration").permitAll()
//		.anyRequest().authenticated()
//		.and().formLogin().permitAll();
		
		

		
//		http
//			.authorizeRequests()
//			.anyRequest()
//			.authenticated()
//			.and()
//			.httpBasic();
		
		
//		
//		http
//      .authorizeRequests()
//      .antMatchers("/", "/login**", "/webjars/**", "/error**")
//      .permitAll()
//      .anyRequest()
//      .authenticated();
		 
		
		
//		http
//		.authorizeRequests()
//		.antMatchers("/home").permitAll()
//		.anyRequest()
//		.authenticated().and().oauth2Login();
//
		
	}

}
