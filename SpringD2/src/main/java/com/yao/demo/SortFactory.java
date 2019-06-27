package com.yao.demo;


public class SortFactory {
	
	public ISort getSort(String sortType) {
		
	      if(sortType.equalsIgnoreCase("Bubble")){
	         return new BubbleSort();
	         
	      } else if(sortType.equalsIgnoreCase("Merge")){
	         return new MergeSort();
	         
	      }
	      
		return null;

	}

}
