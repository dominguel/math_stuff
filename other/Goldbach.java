package other;
import java.io.*;
import java.util.Arrays;

public class Goldbach {
	public static void main(String[] args)throws IOException {
		
		//prend input, gere quelques exceptions communes
		int input = 0;
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			input = Integer.parseInt(br.readLine());
		} catch(NumberFormatException e) {
			System.out.println("INVALID INPUT.");
			System.exit(0);
		}
		
		//plus d'exceptions
		if(input % 2 != 0 || input < 4) {
			System.out.println("INVALID INPUT.");
			System.exit(0);
		}
		
		//appelle sommeGoldBach, qui retourne un tableau trop grand (valeurs vides init. a 0)
		int[][] toPrint = sommeGoldBach(input);

		//imprime tout ce qui n'est pas vide dans le format demande
		for(int i = 0; i < toPrint.length; i++){
			
			if(toPrint[i][0] != 0) {
				
				System.out.println(toPrint[i][0] + " + " + toPrint[i][1]);
			} else {
				break;
			}
		}
	}
	
	public static int[][] sommeGoldBach(int num) {
		
		//initialisation de quelques variables
		int[][] resultats = new int[num][2];
		int primeNumber = 0;
		boolean[] primeDirector = new boolean[num - 1];
		Arrays.fill(primeDirector, Boolean.FALSE);
		
		//cherche les nombres premiers plus petits que num sans savoir lesquels
		for(int i = 0; i < num-1; i++) {
			if(estPremier(i)) {
				
				primeNumber++;
				primeDirector[i] = true;
			}
		}
	
		//cette fois, on peut creer un tableau de la bonne grandeur et enregistrer les nombres premier en int
		int[] primes = new int[primeNumber];
		for(int i = 0; i < primeDirector.length; i++) {
			if(primeDirector[i]) {
				
				primeNumber--;
				primes[primeNumber] = i;
			}
		}
		
		//on essaye des additions de nombres premiers
		int compteur = 0;
		for(int i = 0; i < primes.length; i++) {
			//j = i pour ne pas repeter les memes additions
			for(int j = i; j < primes.length; j++) {
				if(primes[i] + primes[j] == num) {
					
					resultats[compteur][0] = primes[i];
					resultats[compteur][1] = primes[j];
					compteur++;
				}else if(primes[i] + primes[j] < num) {
					break;
				}
			}
		}
		
		return resultats;	
	}
	
	public static boolean estPremier(int num) {
		
		//retirer les multiples de 2,3,5 pour accelerer le processus
		//cette fonction est loin d'etre la plus efficace possible
		if(num < 2) {
			return false;
		}

		if(num == 2 || num == 3 || num == 5) {
			return true;
		}
		
		if(num % 2 == 0 || num % 3 == 0 || num % 5 == 0 || num < 2) {
			return false;
		}

		for(int i = 6; i * i < num; i += 2) {
			if(num % i == 0) {
				return false;
			}
		}
		return true;
	}
}