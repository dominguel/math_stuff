package other;

import java.io.*;

class Sandpiles {
	//https://www.youtube.com/watch?v=1MtEUErz7Gg

	private static int height;
	private static int width;
	private static int[][] masterPile;
	//private static int maximum;

	public static void main(String[] args) throws IOException {

		/*Concept scrapped until a better collapsing algorithm is found
		 * note: dont forget to un-comment private static int maximum
		 * -----------------------------------------------------------
		 * System.out.println("Define maximum value:");
		maximum = inputInt();
		
		if(maximum < 2) {
			System.out.println("Maximum too small.");
			System.exit(0);
		}*/
		
		System.out.println("Define height:");
		height = inputInt();

		System.out.println("Define width:");
		width = inputInt();

		if(height < 1 || width < 1) {
			System.out.println("Impossible to compute, sandpile size too small.");
			System.exit(0);
		}

		masterPile = makePile();
		showPile();

		System.out.println("Creating pile to add...");
		int[][] grains = makePile();
		System.out.println("Solving...");

		addPile(grains);
		while(max() > 3) {
			collapse();
		}
		System.out.println("Done!");

		showPile();
	}

	private static int inputInt() throws IOException {

		int out = 0;

		try {

			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Awaiting input...");
			out = Integer.parseInt(br.readLine());
		} catch(NumberFormatException e) {

			System.out.println("Invalid Input.");
			System.exit(0);
		}

		return out;
	}

	private static int[][] makePile() throws IOException {

		int[][] pile = new int[height][width];

		for(int i = 0; i < height; i++) {
			for(int j = 0; j < width; j++) {

				System.out.println("Value of pile[" + i + "][" + j + "] ?");
				pile[i][j] = inputInt();
			}
		}

		return pile;
	}

	private static void showPile() {

		for(int i = 0; i < height; i++) {
			for(int j = 0; j < width; j++) {

				System.out.print(masterPile[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static void addPile(int[][] grains) {

		int[][] out = new int[height][width];

		//adding...
		for(int i = 0; i < height; i++) {
			for(int j = 0; j < width; j++) {

				out[i][j] = masterPile[i][j] + grains[i][j];
			}
		}

		//there is a way to add and topple/collapse in a single loop, but i am tired...
		masterPile = out;
	}

	private static void collapse() {

		int[][] temp = new int[height][width];

		for(int i = 0; i < height; i++) {
			for(int j = 0; j < height; j++) {

				switch(masterPile[i][j]) {
				case 6:
					temp[i][j]++;
					
				case 5:
					temp[i][j]++;
					
				case 4:
					if(i > 0) {
						temp[i-1][j]++;
					}
					if(i < height-1) {
						temp[i+1][j]++;
					}
					if(j > 0) {
						temp[i][j-1]++;
					}
					if(j < width-1) {
						temp[i][j+1]++;
					}
					break;
				default:
					temp[i][j] += masterPile[i][j];
				}
			}
		}
		
		masterPile = temp;
	}

	private static int max() {

		int out = 0;

		for(int i = 0; i < height; i ++) {
			for(int j = 0; j < width; j++) {

				if(masterPile[i][j] > out) {
					out = masterPile[i][j];
				}
			}
		}
		return out;
	}
/*for sandpile 1 by 3, add all possible sandpiles to themselves, plot on a 3d graph and get zeroes to act as such
 * this may be brilliant or impossibly dumb, I am so tired...*/
}