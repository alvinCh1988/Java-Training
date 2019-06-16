package idv.Day3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App 
{
public static void main(String[] args) {
		
		App w = new App();
		String path = "source-file.txt";
		
		System.out.println(w.readFile(path));
		String source = w.readFile(path).substring(11);
		
			if(w.checkVal(source) == true) {
				w.fomatNumAndSum(source);
			} else {
				System.out.println("Number interval  Please enter\",\"。");
			}
	    }
	
	private void fomatNumAndSum(String num) {
		String[] tokens = num.split(",");
		String errStr = "";
		int sum = 0;
		
		try {
			for (String token : tokens){

				int i = Integer.valueOf(token).intValue();	
				sum += i;

			}
		} catch (NumberFormatException e) {
			errStr = "You entered the wrong format. Please enter the number.";
			System.out.println(errStr);
			e.printStackTrace();
		}

		if(errStr.equals("")) {
			System.out.println(sum);
		}
	}
	
	
	private Boolean checkVal(String valList) {
		Boolean check = true;
		
		try {
			for(int i =0; i < valList.length(); i++) {
				
				String ch = valList.substring(i, i+1);
				
				if(ch.matches("[^a-zA-Z_0-9,]")) {
					check = false;
					break;
				} 
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return check;
	}
	
	
//	=== File I/O ===
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
