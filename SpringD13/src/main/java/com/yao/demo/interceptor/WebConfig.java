package com.yao.demo.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class WebConfig implements WebMvcConfigurer {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new LoginIntercepter())
		.excludePathPatterns("/js/**","/css/**","/images/**")
        .excludePathPatterns("/account/index")
        .excludePathPatterns("/account/register")
        .excludePathPatterns("/account/login")
        .excludePathPatterns("/account/insert")
		.addPathPatterns("/**");
	}

}
