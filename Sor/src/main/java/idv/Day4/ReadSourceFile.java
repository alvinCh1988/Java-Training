package idv.Day4;

import java.io.*;
import java.util.*;

public class ReadSourceFile {

	private static Properties props;

	public Map<String, String> readFile(String path) {

		props = new Properties();
		try {
			props.load(new FileInputStream(path));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		Map<String, String> map = new HashMap<String, String>();

		map.put("value-list", props.getProperty("value-list"));
		map.put("method", props.getProperty("method"));

		return map;
	}

}
