package suites;

import java.io.*;

public class Pascal {

	public static void main(String[] args)throws IOException {

		int s = 0;

		try {

			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Awaiting input...");
			s = Integer.parseInt(br.readLine());
		} catch(NumberFormatException e) {

			System.out.println("Invalid Input.");
			System.exit(0);
		}

		if(s <= 1) {

			System.out.println("Invalid input.");
			System.exit(0);
		}


		long[] lv1 = new long[1];
		long[] lv2;
		lv1[0] = 1;
		
		for(int i = 0; i < s; i++) {
			
			for(int j = 0; j < lv1.length; j++) {
				System.out.print(lv1[j] + " ");
			}
			System.out.println();
			
			lv2 = new long[lv1.length + 1];
			lv2[0] = 1;
			lv2[lv1.length] = 1;
			
			for(int j = 1; j < lv1.length; j++) {
				lv2[j] = lv1[j-1] + lv1[j];
			}
			
			lv1 = new long[lv2.length];
			for(int j = 0; j < lv1.length; j++) {
				lv1[j] = lv2[j];
			}
		}
	}
}