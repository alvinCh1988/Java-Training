import java.util.Scanner;

public class work {

	
	public static void main(String args[]) {
		
		System.out.println("Please enter the number ex:1,3,5,7,9");
		Scanner sc = new Scanner(System.in);
		work w = new work();
		
		
		Boolean check = true;
		String num = sc.next();
		
		for(int i =0; i<num.length(); i++) {
			
			String ch = num.substring(i, i+1);
			
			if(ch.matches("[^a-zA-Z_0-9,]")) {
				System.out.println("Number interval Please enter\",\" ");
				check = false;
				break;
			} 
			
		}
		
		if(check) {
			w.fomatNum(num);
		}
		
	}
	
	
	
	private void fomatNum(String num) {
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
}
