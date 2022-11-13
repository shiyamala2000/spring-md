package com.kgisl.role.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

public class UserSecurityConfig {
	 @Bean
	    public SecurityFilterChain filterChain2(HttpSecurity http) throws Exception {
	         
	        http.antMatcher("/user/**")
	            .authorizeRequests().anyRequest().hasAuthority("USER")
	            .and()
	            .formLogin()
	                .loginPage("/user/login")
	                .usernameParameter("name")
	                .loginProcessingUrl("/user/login")
	                .defaultSuccessUrl("/user/home")
	                .permitAll()
	            .and()
	            .logout()
	                .logoutUrl("/user/logout")
	                .logoutSuccessUrl("/");
	         
	        return http.build();
}
}
