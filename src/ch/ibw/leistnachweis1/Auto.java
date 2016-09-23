
package ch.ibw.leistnachweis1;

/**
 * @author Nett Hans-Juerg
 *
 */
public class Auto {
	
	@SuppressWarnings("unused")
	private String autoMarke;
	@SuppressWarnings("unused")
	private int anzahlTueren;
	@SuppressWarnings("unused")
	private int ps;

	public static void main(String[] args) {
		
		Auto auto1 = new Auto();
		auto1.anzahlTueren =5;
		auto1.autoMarke = "BMW";
		auto1.ps = 210;
		
		Auto auto2 = new Auto();
		auto2.anzahlTueren =5;
		auto2.autoMarke = "VW";
		auto2.ps = 160;
		
		Auto auto3 = new Auto();
		auto3.anzahlTueren =3;
		auto3.autoMarke = "Fiat";
		auto3.ps = 80;
		

	}

}
