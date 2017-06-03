package other;

import java.io.*;

class Water_Drips {

	public static void main(String[] args)throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("awaiting input");
		String[] s = br.readLine().split(",");
		int[] landscape = new int[s.length];
		for(int i = 0; i < s.length; i++) {
			
			landscape[i] = Integer.parseInt(s[i]);
		}
		
		int[] right = parseRight(landscape);
		int[] left = parseLeft(landscape);
		int[] maxes = new int[landscape.length];
		
		for(int i = 0; i < landscape.length; i++) {
			if(right[i] > left[i]) {
				maxes[i] = left[i];
			} else {
				maxes[i] = right[i];
			}
		}
		
		int total = 0;
		
		for(int i = 0; i < landscape.length; i++) {
		
			total += maxes[i] - landscape[i];
		}
		
		System.out.println(total);
	}
	
	private static int[] parseRight(int[] landscape) {
		int[] results = new int[landscape.length];
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < landscape.length; i++) {
			if(landscape[i] > max) {
				max = landscape[i];
			}
			results[i] = max;
		}
		return results;
	}

	private static int[] parseLeft(int[] landscape) {
		int[] results = new int[landscape.length];
		int max = Integer.MIN_VALUE;
		for(int i = landscape.length-1; i >= 0; i--) {
			if(landscape[i] > max) {
				max = landscape[i];
			}
			results[i] = max;
		}
		return results;
	}
}