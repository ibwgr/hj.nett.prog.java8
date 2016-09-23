
package ch.ibw.leistnachweis1;

/**
 * @author Nett Hans-Juerg
 *
 */
public class Aufgabe_8 {

	public static void main(String[] args) {
		
		boolean[] boolArray = new boolean[4];
		
		boolArray[0] = true;
		boolArray[1] = false;
		boolArray[2] = true;
		boolArray[3] = true;
		
		for (int i = 0; i < boolArray.length; i++) {
			
			if(boolArray[i] == true){
				System.out.println("Wahr");
			}
			else{
				System.out.println("Falsch");
			}			
		}

	}

}
