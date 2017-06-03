package other;

class Emma {

	public static void main(String[] args) {
		/*25 matrices
		 * imprime combinaisons de 3
		 * peuvent etre combinees entre elles
		 * afficher la liste*/
		for(int i = 1; i < 26; i++) {
			for(int j = 1; j < 26; j++) {
				for(int k = 1; k < 26; k++) {
					
					System.out.println(i + "-" + j + "-" + k);
				}
			}
		}
	}
}