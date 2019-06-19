package idv.Day5;

import java.io.*;
import java.util.*;

public class ReadSourceFile {

	StringBuilder sBuild = new StringBuilder();
	private String information = "";
	private String operateion = "";

	public Map<String, String> readFile(String path) {

		try {
			FileReader fr = new FileReader(path);
			BufferedReader br = new BufferedReader(fr);
			String line;
			while ((line = br.readLine()) != null) {
				sBuild.append(line);

			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		information = sBuild.substring(sBuild.indexOf("#"), sBuild.lastIndexOf("#"));
		operateion = sBuild.substring(sBuild.lastIndexOf("#"));

		Map<String, String> map = new HashMap<String, String>();

		map.put("ConnectionConnection", informationSubStr("ConnectionConnection"));
		map.put("UserId", informationSubStr("User"));
		map.put("Password", informationSubStr("Password"));
		map.put("Action", operateionSubStr("Action"));
		map.put("C.Data", operateionSubStr("C"));
		map.put("R.ID", operateionSubStr("R"));
		map.put("U.Data", operateionSubStr("U"));
		map.put("D.ID", operateionSubStr("D"));

		return map;
	}

	private String informationSubStr(String key) {

		String capStr = "";

		capStr = information.substring(information.indexOf("{", information.indexOf(key)) + 1,
				information.indexOf("}", information.indexOf(key)));

//		System.out.println(capStr);

		return capStr;
	}

	private String operateionSubStr(String key) {

		String capStr = "";

		if (key.equals("Action")) {
			capStr = operateion.substring(operateion.indexOf("=", operateion.indexOf(key)) + 1,
					operateion.indexOf("DB.", operateion.indexOf(key)));
		}

		if (key.equals("C") || key.equals("R") || key.equals("U")) {
			key = key + ".";
			capStr = operateion.substring(operateion.indexOf("=", operateion.indexOf(key)) + 1,
					operateion.indexOf("DB.", operateion.indexOf(key)));
		}

		if (key.equals("D")) {
			key = key + ".";
			capStr = operateion.substring(operateion.indexOf("=", operateion.indexOf(key)) + 1);
		}

		return capStr;
	}

}
