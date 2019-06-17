package idv.Day4;

import java.util.Map;

public class SortFactoryDemo {
	
	public static void main(String[] args) {
	SortFactory sortfac = new SortFactory();
	ReadSourceFile rsf = new ReadSourceFile();
	
	Sort_interface sort = null;
	Map<String, String> readVal = null;
	
	
	String path = "source-file.txt";
	
	readVal = rsf.readFile(path);
	
	System.out.println(readVal.get("method"));
	
	String[] val = readVal.get("value-list").split(",");
	int[] valueList = new int[val.length];
	
	for(int i = 0; i<val.length; i++) {
		valueList[i] = Integer.valueOf(val[i]).intValue();
	}
	
			

	
	sort = sortfac.getSort(readVal.get("method"));
	sort.sort(valueList);
	
	}
	
	
	
}
