package idv.Day3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class App {
	private static Properties props;

	public static void main(String[] args) {

		App w = new App();
		
		String path = "";

		if (args[0] != null) {
			path = args[0];
		}

		String source = w.readFile(path);

		if (w.checkVal(source) == true) {
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
			for (String token : tokens) {

				int i = Integer.valueOf(token).intValue();
				sum += i;

			}
		} catch (NumberFormatException e) {
			errStr = "You entered the wrong format. Please enter the number.";
			System.out.println(errStr);
			e.printStackTrace();
		}

		if (errStr.equals("")) {
			System.out.println(sum);
		}
	}

	private Boolean checkVal(String valList) {
		Boolean check = true;

		try {
			for (int i = 0; i < valList.length(); i++) {

				String ch = valList.substring(i, i + 1);

				if (ch.matches("[^a-zA-Z_0-9,]")) {
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
	@SuppressWarnings("resource")
	private String readFile(String path) {
		
		props = new Properties();
        try {
             props.load(new FileInputStream(path));
        } catch (FileNotFoundException e) {
             e.printStackTrace();
        } catch (IOException e) {
             e.printStackTrace();
        }
        

		try {
			FileReader fr = new FileReader(path);
			BufferedReader Buffer = new BufferedReader(fr);
			String line;
			while ((line = Buffer.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			System.out.println(e);
		}
		
		return props.getProperty("value-list");
	}
}
