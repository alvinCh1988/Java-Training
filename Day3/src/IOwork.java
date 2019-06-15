import java.io.*;

public class IOwork {
	
	public static void main(String[] args) {
		
		IOwork w = new IOwork();

		
		
		System.out.println(w.readFile("test.txt"));
	    }
	
	
	
	private String readFile(String path) {
		String x = null;
		try {
		      FileReader fr = new FileReader(path);
		      BufferedReader br =new BufferedReader(fr);
		      String line;
		      while ((line = br.readLine()) != null) {
		        x = line;
		        }
		      }
		    catch (IOException e) {
		    	System.out.println(e);
		    	}
		
		return x;
	}
}
