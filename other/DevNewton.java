package other;

import java.io.*;

public class DevNewton {

	public static void main(String[] args) throws IOException {
		
		//developement d'une puissance de (a+b)

		System.out.println("(a + b)^");
		int power = 0;

		try {

			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Awaiting input...");
			power = Integer.parseInt(br.readLine());
		} catch(NumberFormatException e) {

			System.out.println("Invalid Input.");
			System.exit(0);
		}

		if(power < 2) {
			System.out.println("Integer too small.");
			System.exit(0);
		}
		
		String out = "";
		long[] facts = pascal(power);
		
		for(int i = 0; i <= power; i++) {
			
			if(facts[i] != 1) {
				out += facts[i];
			}
			
			if(power-1 != 0) {
				out += "a^" + (power-i);
			}
			
			if(i != 0) {
				out += "b^" + i;
			}
			
			if(i != power) {
				out += " + ";
			}
		}
		System.out.println(out);
	}

	public static long[] pascal(int s) throws IOException {

		long[] lv1 = new long[1];
		long[] lv2;
		lv1[0] = 1;

		for(int i = 0; i < s; i++) {

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

		return lv1;
	}
}