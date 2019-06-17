package idv.Day4;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class ReadSourceFile {
	
	public Map<String, String> readFile(String path) {
		StringBuilder sBuild = new StringBuilder();
		String str = "";
		try {
		      FileReader fr = new FileReader(path);
		      BufferedReader br =new BufferedReader(fr);
		      String line;
		      while ((line = br.readLine()) != null) {
		        sBuild.append(line);
		        
		        
		        	
		        
			         
		        }
		      }
		    catch (IOException e) {
		    	e.printStackTrace();
		    	}
		str = sBuild.toString();
		
		Map<String, String> map = new HashMap<>();
		
		if(str.indexOf("method=") != -1) {
        	int sIndex = str.lastIndexOf("method=");
        	String[] method = sBuild.substring(sIndex).split("method=");
        	String[] valList = sBuild.substring(0,sIndex).split("value-list=");

        	map.put("method", method[1]);
        	map.put("value-list", valList[1]);

        }
		

		return map;
	}



}
