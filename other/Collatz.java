package other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Collatz {

	public static void main(String[] args) throws IOException {
	
		int startPoint = 0;

		try {

			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Awaiting input...");
			startPoint = Integer.parseInt(br.readLine());
		} catch(NumberFormatException e) {

			System.out.println("Invalid Input.");
			System.exit(0);
		}
		
		if(startPoint < 1) {
			
			System.out.println("Invalid Input.");
			System.exit(0);
		}
		
		String branch = "";
		
		while(startPoint != 1) {
			branch += Integer.toString(startPoint) + " ";
			if(startPoint%2 == 0) {
				startPoint = startPoint/2;
			} else {
				startPoint = (startPoint*3) + 1;
			}
		}
		
		branch += "1";
		System.out.println(branch);
	}

}