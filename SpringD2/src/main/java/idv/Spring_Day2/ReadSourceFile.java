package idv.Spring_Day2;

import java.io.*;
import java.util.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

public class ReadSourceFile implements ResourceLoaderAware{

	private static Properties props;

	private ResourceLoader resourceLoader;
	
	public void readFile(String path){
		
		props = new Properties();
		Resource resource = resourceLoader.getResource(path);
		
		try {
			InputStream in = resource.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));
			props.load(reader);

        reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
        
		String sortType = props.getProperty("method");
		String[] val = props.getProperty("value-list").split(",");
		int[] valueList = new int[val.length];
		
		for(int i = 0; i<val.length; i++) {
			valueList[i] = Integer.valueOf(val[i]).intValue();
		}
		
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		SortFactory sortFactory = (SortFactory) context.getBean("sortFactory");

		sortFactory.setValueList(valueList);
		
		if(!sortType.equals("")) {
			System.out.println("method : " + sortType);
			sortFactory.setSort((MergeSort) context.getBean(sortType));
			sortFactory.sort();
		}
		

	}

	public void setResourceLoader(ResourceLoader resourceLoader) {
		this.resourceLoader = resourceLoader;	
	}

}
