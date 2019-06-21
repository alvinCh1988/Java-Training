package idv.Spring_Day2;

import java.io.*;
import java.util.*;

public class ReadSourceFile {

	private static Properties props;

	public Map<String, Object> readFile(String path) {

		props = new Properties();
		try {
			props.load(new FileInputStream(path));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String[] val = props.getProperty("value-list").split(",");
		int[] valueList = new int[val.length];
		
		for(int i = 0; i<val.length; i++) {
			valueList[i] = Integer.valueOf(val[i]).intValue();
		}

		Map<String, Object> map = new HashMap<String, Object>();

		map.put("value-list", valueList);
		map.put("method", props.getProperty("method"));
		

		return map;
	}

}
