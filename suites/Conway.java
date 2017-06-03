package suites;

import java.io.*;

class Conway {

	public static void main(String[] args)throws IOException {
		
		
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
		
		//Create some stuff to start the process
		String[] litt = new String[s+1];
		litt[0] = "1";
		litt[1] = "1 1";
		litt[2] = "2 1";
		litt[3] = "1 2 1 1";
		
		//Start creation process loop
		for(int i = 3; i < s; i++) {
			
			//split previous step into an int[]
			String[] temp =  litt[i].split(" ");
			int[] prevStep = new int[temp.length];
			for(int k = 0; k < temp.length; k++) {
				prevStep[k] = Integer.parseInt(temp[k]);
			}
			
			//create current step template
			String thisStep = "";
			
			//look through the previous step
			int j = -1;
			while(j <= prevStep.length-1) {
				
				//exception handling for the end of a string (12 and 11)
				if(j >= prevStep.length-3) {
					if(i % 2 == 0) {
						thisStep += "1 1";
					} else {
						thisStep += "2 1";
					}
					break;
				}
				
				//look ahead for repetition
				if(prevStep[j+1] == prevStep[j+2]) {
					if(prevStep[j+1] == prevStep[j+3]) {
						
						//three
						thisStep += "3 " + prevStep[j+1] + " ";
						j += 3;
					} else {
						
						//two
						thisStep += "2 " + prevStep[j+1] + " ";
						j += 2;
					}
				} else {
					
					//one
					thisStep += "1 " + prevStep[j+1] + " ";
					j ++;
				}
			}
			
			//put thisstep on the end of litt
			litt[i+1] = thisStep;
		}
		
		//Print the damn thing string by string
		for(int i = 0; i < litt.length; i++) {
			
			System.out.println(litt[i]);
		}
	}
}