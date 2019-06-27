package com.yao.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.yao.demo")
@PropertySource(value = { "file:./source-file.txt" })


public class AppConfig {
	
	@Bean
	public SortFactory sortFac() {
		return new SortFactory();
	}

	@Bean
	public ReadSourceFile readFile() {
		return new ReadSourceFile();
	}
}
