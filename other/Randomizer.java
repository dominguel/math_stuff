package other;

import java.io.*;

class Randomizer {

	public static void main(String[] args) throws IOException {
		int s = 0;
		
		try {
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Awaiting input...");
			s = Integer.parseInt(br.readLine());
		} catch(NumberFormatException e) {
			
			System.out.println("Invalid Input.");
			System.exit(0);
		}
		
		if(s == 0) {
			System.exit(0);
		} else {
			double out1 = Math.random()*s;
			int out2 = (int) out1;
			System.out.println(out2);

		}
	}
}