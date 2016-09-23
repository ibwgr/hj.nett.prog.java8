
package ch.ibw.leistnachweis1;

/**
 * @author Nett Hans-Juerg
 *
 */
public class Summe {

	public static void main(String[] args) {
		
		int summe = 0;
		int lowerBound = 1;
		int upperBound = 100;
		
		for (int i = lowerBound; i <= upperBound; i++) {
			summe += i;			
		}
		System.out.println("Summe von " + lowerBound + " bis " + upperBound + " : " + summe);
	}

}
