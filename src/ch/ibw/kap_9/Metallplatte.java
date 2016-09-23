package ch.ibw.kap_9;

public class Metallplatte {
	
	/** Länge der Platte */
	public double laenge;
	
	/** Breite der Platte */
	public double breite;
	
	public Metallplatte(double laenge, double breite){
		this.laenge = laenge;
		this.breite = breite;
	}
	
	/** Berechnet die Fläche der Platte */
	public double flaeche(){
		return laenge * breite;
	}
	
	/** Vergleicht das Gewicht dieser Platte
	 * mit dem einer anderen Platte */
	public boolean schwererAls(Metallplatte p){
		return (this.flaeche() > p.flaeche());
	}

}
