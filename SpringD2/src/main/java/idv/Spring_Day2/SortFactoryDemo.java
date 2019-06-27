package idv.Spring_Day2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SortFactoryDemo {
	

	public static void main(String[] args) {

	String path = "";

	if (args[0] != null) {
		path = args[0];
	}
	
	@SuppressWarnings("resource")
	ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
	ReadSourceFile sortFactory = (ReadSourceFile) context.getBean("readSource");
	sortFactory.readFile(path);

	}

}
