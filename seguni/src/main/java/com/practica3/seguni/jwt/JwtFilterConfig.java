package com.practica3.seguni.jwt;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class JwtFilterConfig {
	@Bean
    FilterRegistrationBean<JwtFilter> jwtFilter() {
        FilterRegistrationBean<JwtFilter>  filter= new FilterRegistrationBean<JwtFilter>();
        filter.setFilter(new JwtFilter());
        
       filter.addUrlPatterns("/seguni/auth/*");   
       return filter;
    }
}
