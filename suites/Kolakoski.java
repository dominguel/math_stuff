package suites;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Kolakoski {
	public static void main(String[] args) {
		
		//made in 5 minutes after watching this: https://www.youtube.com/watch?v=co5sOgZ3XcM
		
		//take input, consider exceptions
		int s = 0;

		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Awaiting input...");
			s = Integer.parseInt(br.readLine()) - 1;
		} catch(NumberFormatException | IOException e) {

			System.out.println("Invalid Input.");
			System.exit(0);
		}

		if(s < 1) {

			System.out.println("Invalid input.");
			System.exit(0);
		}
		s--;
		
		System.out.print("12");
		
		int cNum = 1;
		int cRead = 2;
		LinkedList<Integer> stackLink = new LinkedList<Integer>();
		stackLink.add(2);
		
		while(s > 0) {
			
			stackLink.add(cNum);
			if(cRead == 2) {
				stackLink.add(cNum);
			}
			
			if(cNum == 1) {
				cNum = 2;
			} else {
				cNum = 1;
			}
			
			System.out.print(stackLink.pop());
			s--;
			cRead = stackLink.peek();
		}
	}
}