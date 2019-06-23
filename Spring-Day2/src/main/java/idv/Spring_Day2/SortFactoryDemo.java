package idv.Spring_Day2;


public class SortFactoryDemo {
	

	public static void main(String[] args) {
	ReadSourceFile read = new ReadSourceFile();
	

	String path = "source-file.txt";

//	if (args[0] != null) {
//		path = args[0];
//	}
	
	read.readFile(path);
	
	}

}
