package idv.Spring_Day2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SortFactory {
	
	private ISort sort = null;
	private String sortType = "";
	private int[] valueList;
	
	
	
	public String getSortType() {
		return sortType;
	}
	
	public void setSortType(String sortType) {
		this.sortType = sortType;
	}
	
	public void setValueList(int[] valueList) {
		this.valueList = valueList;
	}
	
	
	public void sort() {

		
		ApplicationContext context = new ClassPathXmlApplicationContext("SortFactory.xml");
		if(this.sortType.equals("Merge")) {
			this.sort = (MergeSort) context.getBean("mergeSort");
		}
		
		if(this.sortType.equals("bubble")) {
			this.sort = (BubbleSort) context.getBean("bubbleSort");
		}
		
		System.out.println("method: " + sortType);
		
		this.sort.sort(valueList);
	}
	
	
}
