package suites;

import java.io.*;
class Golden_ratio {

	public static void main(String[] args) throws IOException {

		//take input, consider exceptions
		int s = 0;

		try {

			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Awaiting input...");
			s = Integer.parseInt(br.readLine()) - 1;
		} catch(NumberFormatException e) {

			System.out.println("Invalid Input.");
			System.exit(0);
		}

		if(s <= 1) {

			System.out.println("Invalid input.");
			System.exit(0);
		}
		
		int small = 1;
		int temp;
		int big = 1;
		System.out.print("1");
		
		for(int i = 0; i < s; i++) {
			
			System.out.print(" " + big);
			
			temp = small + big;
			small = big;
			big = temp;
		}
	}
}