package idv.Day5;

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
        
        map.put("ConnectionConnection", cusSubStr(props.getProperty("Connection.String")));
        map.put("UserId", cusSubStr(props.getProperty("DB.User")));
        map.put("Password", cusSubStr(props.getProperty("DB.Password")));
        map.put("Action", props.getProperty("DB.Action"));
        map.put("C.Data", props.getProperty("DB.C.Data"));
        map.put("R.ID", props.getProperty("DB.R.ID"));
        map.put("U.Data", props.getProperty("DB.U.Data"));
        map.put("D.ID", props.getProperty("DB.D.ID"));

		return map;
	}

	private String cusSubStr(String str) {

		String capStr = "";

		capStr = str.substring(str.indexOf("{") + 1,str.indexOf("}"));

		System.out.println(capStr);

		return capStr;
	}

}
