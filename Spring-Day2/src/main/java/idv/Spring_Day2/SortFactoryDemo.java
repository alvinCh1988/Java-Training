package idv.Spring_Day2;

import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SortFactoryDemo {
	

	public static void main(String[] args) {
//	SortFactory sortFac = new SortFactory();
	ReadSourceFile read = new ReadSourceFile();
	
	ISort sort = null;
	Map<String, Object> readVal = null;

	String path = "source-file.txt";

//	if (args[0] != null) {
//		path = args[0];
//	}
	
	readVal = read.readFile(path);
	
	System.out.println(readVal.get("method"));
	System.out.println(readVal.get("value-list"));


//	sort = sortFac.getSort((String) readVal.get("method"));
//	sort.sort((int[]) readVal.get("value-list"));
	
	
	
	@SuppressWarnings("resource")
	ApplicationContext context = new ClassPathXmlApplicationContext("SortFactory.xml");
	SortFactory sortFactory = (SortFactory) context.getBean("sortFactory");
	sortFactory.Sort((int[]) readVal.get("value-list"));

	
	
	}

}
