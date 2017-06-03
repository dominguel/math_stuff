package suites;

import java.util.ArrayList;
import java.util.List;

public class Get10958 {

	private static int permutations = 0;

	public static void main(String[] args) {

		/*evaluate :
		 * all operator permutations
		 * all bracket permutations
		 * all negative number permutations
		 * 
		 * and all permutations of each into all other permutations of the other
		 * shoutout to numberphile, the best maths channel on youtube
		 */

		long time = System.currentTimeMillis();
		char[] expression = new char[17];
		//add, sub, multiply, divide, power, concatenate
		char[] operators = {'+', '-', '*', '/', 'c'};

		//prepare digits
		int indicator = 1;
		for(int i = 0; i < 17; i++) {
			if(i % 2 == 0) {
				expression[i] = Integer.toString(indicator).charAt(0);
				indicator++;
			}
		}

		//OH MY GOD ARE THOSE EIGHT NESTED LOOPS IN A SINGLE BLOCK? - yep.
		for(int i0 = 0; i0 < operators.length; i0++) {
			expression[1] = operators[i0];
			for(int i1 = 0; i1 < operators.length; i1++) {
				expression[3] = operators[i1];
				for(int i2 = 0; i2 < operators.length; i2++) {
					expression[5] = operators[i2];
					for(int i3 = 0; i3 < operators.length; i3++) {
						expression[7] = operators[i3];
						for(int i4 = 0; i4 < operators.length; i4++) {
							expression[9] = operators[i4];
							for(int i5 = 0; i5 < operators.length; i5++) {
								expression[11] = operators[i5];
								for(int i6 = 0; i6 < operators.length; i6++) {
									expression[13] = operators[i6];
									for(int i7 = 0; i7 < operators.length; i7++) {
										expression[15] = operators[i7];
										evaluateNegativePossibilities(expression);
									}
								}
							}
						}
					}
				}
			}
		}
		System.out.println(permutations + " permutations evaluated");
		System.out.println("in " + (System.currentTimeMillis() - time) + " ms");
	}

	public static void evaluateNegativePossibilities(char[] operatorSequence) {

		/*Ok, so heres the deal:
		 * when the evaluation comes up to 10958.0 (double)
		 * print the expression (prefferably with the brackets, but im not that picky)
		 * 
		 * for 390 625 permutations at this point
		 * fuck thats a lot of computation...
		 */

		//step 1: concatenate characters and form expression
		String expression = "";
		for(int i = 0; i < operatorSequence.length; i ++) {

			if(operatorSequence[i] == 'c') {
				continue;
			} else if(isOperator(operatorSequence[i]) != -1) {
				expression += " " + operatorSequence[i] + " ";
				continue;
			}
			
			expression += operatorSequence[i];
		}
		
		//step 2: isolate integer values and operators
		String[] biteSized = expression.split(" ");
		List<Integer> numValues = new ArrayList<Integer>();
		List<Character> operators = new ArrayList<Character>();
		for(int i = 0; i < biteSized.length; i++) {
			if(i % 2 == 0) {
				numValues.add(Integer.parseInt(biteSized[i]));
			} else {
				operators.add(biteSized[i].charAt(0));
			}
		}
		
		//step 3: evaluate all 512 negative and positive number possibilities
		//keeping in mind a null value in an array is empty
		//thats 2 000 000 permutations exactly
		
		
		permutations++;
	}
	
	public static int isOperator(char eval) {
		
		String operators = "+-*/^";
		return operators.indexOf(eval);
	}
}