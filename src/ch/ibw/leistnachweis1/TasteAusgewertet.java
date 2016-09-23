
package ch.ibw.leistnachweis1;

/**
 * @author Nett Hans-Juerg
 *
 */
public class TasteAusgewertet {

	public static void main(String[] args) {
		
		int pressedNumbers = 0;
		
		if((pressedNumbers >= 0) && (pressedNumbers < 10)){
			System.out.println("Taste " + pressedNumbers + " gedrückt");
		}
		else{
			System.out.println("Nicht erlaubt");
		}
	}

}
