package idv.Day4;

public class SortFactory {
	
	public Sort_interface getSort(String sortType) {
		
		
		if(sortType == null){
	         return null;
	      }		
		
	      if(sortType.equalsIgnoreCase("Bubble")){
	         return new BubbleSort();
	         
	      } else if(sortType.equalsIgnoreCase("Merge")){
	         return new MergeSort();
	         
	      }
	      
		return null;

	}

}
