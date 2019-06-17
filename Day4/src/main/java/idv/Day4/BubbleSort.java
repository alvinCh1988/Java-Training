package idv.Day4;

public class BubbleSort implements Sort_interface{



	@Override
	public void sort(int[] valueList) {		

	    int temp = 0;
	    
	    for(int i=0; i<valueList.length; i++){
	    	
	    	for(int j=0; j<valueList.length-1; j++){
	    	   
	    	   if(valueList[j] > valueList[j+1]){
	    		   
	    		  temp = valueList[j];
	    		  valueList[j] = valueList[j+1];
	    		  valueList[j+1] = temp;
	    	   }
	    	}
	    }
		
		
		for(int num: valueList){
			System.out.print(num + " ");
		}
		
	}

}
