package idv.Spring_Day2;

public class SortFactory {
	
	private ISort sort = null;
	private String sortType = null;
	
	SortFactory(String sortType){
		this.sortType = sortType;
	}
	
	public ISort getSort() {
		return sort;
	}
	public void setSort(ISort sort) {
		this.sort = sort;
	}
	public String getSortType() {
		return sortType;
	}
	public void setSortType(String sortType) {
		this.sortType = sortType;
	}
	
	public void Sort(int[] value) {
		this.sort.sort(value);
	}
	
	
//	public ISort getSort(String sortType) {
//		
//		if(sortType == null){
//	         return null;
//	      }		
//		
//	      if(sortType.equalsIgnoreCase("Bubble")){
//	         return new BubbleSort();
//	         
//	      } else if(sortType.equalsIgnoreCase("Merge")){
//	         return new MergeSort();
//	         
//	      }
//	      
//		return null;
//
//	}

}
