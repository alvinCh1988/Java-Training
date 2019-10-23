package com.yao.demo;

import org.springframework.beans.factory.annotation.Value;



public class ReadSourceFile{
	
	@Value("${method}")
	private String method;
	
	@Value("#{'${value-list}'.split(',')}")
	private String[] valueList;
	

	public String getMethod() {
		return method;
	}
	
	public int[] getValueList() {
		
		int[] valueArray = new int[valueList.length];
		for(int i = 0; i<valueList.length; i++) {
			valueArray[i] = Integer.valueOf(valueList[i]).intValue();
		}	
		return valueArray;
	}
	
	
		

}
