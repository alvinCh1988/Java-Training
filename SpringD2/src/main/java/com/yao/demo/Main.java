package com.yao.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	

	public static void main(String[] args) {

	@SuppressWarnings("resource")
	ApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);
	ReadSourceFile readSource = context.getBean(ReadSourceFile.class);
	SortFactory sortFac = context.getBean(SortFactory.class);
	ISort iSort = sortFac.getSort(readSource.getMethod());
	iSort.sort(readSource.getValueList());
	
	}

}
