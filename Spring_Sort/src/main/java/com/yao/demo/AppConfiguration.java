package com.yao.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("file:./source-file.txt" )

public class AppConfiguration {
	
	@Bean
	public SortFactory sortFac() {
		return new SortFactory();
	}

	@Bean
	public ReadSourceFile readFile() {
		return new ReadSourceFile();
	}
}
