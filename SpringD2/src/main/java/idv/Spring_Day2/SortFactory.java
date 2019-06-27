package idv.Spring_Day2;

public class SortFactory {
	
	private ISort sort = null;
	private int[] valueList;
	
	
	public void setValueList(int[] valueList) {
		this.valueList = valueList;
	}
	
	public void setSort(ISort sort) {
		this.sort = sort;
	}
	
	public void sort() {
		this.sort.sort(valueList);
	}
	
	
}
