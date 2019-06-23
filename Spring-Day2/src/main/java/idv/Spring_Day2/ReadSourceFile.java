package idv.Spring_Day2;

import java.io.*;
import java.util.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ReadSourceFile {

	private static Properties props;

	public void readFile(String path) {

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
		
		
		
		ApplicationContext context = new ClassPathXmlApplicationContext("SortFactory.xml");
		SortFactory sortFactory = (SortFactory) context.getBean("sortFactory");
		sortFactory.setSortType(props.getProperty("method"));
		sortFactory.setValueList(valueList);
		sortFactory.sort();

	}

}
