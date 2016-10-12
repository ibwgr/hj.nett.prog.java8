package ch.ibw.kap_9.aufgabe_9_11;

public class GelochtePlatte extends Metallplatte {
	
	private int anzahlLoecher;
	private double lochLaenge, lochbreite;
	private Metallplatte[] loch = null;

	public GelochtePlatte(double laenge, double breite, int m) {
		super(laenge, breite);
		loch = new Metallplatte[m];
		lochLaenge = laenge/m;
		lochbreite = breite/m;
	}
	
	public void neuesLochStanzen(){
		if(anzahlLoecher < loch.length){
			loch[anzahlLoecher] = new Metallplatte(lochLaenge, lochbreite);
			anzahlLoecher++;
			System.out.println((anzahlLoecher) + " Loch gestanzt!");
		}
	}

	@Override
	public double flaeche() {
		
		double lochFlaeche = 0;		
		for (int i = 0; i < loch.length; i++) {
			if(loch[i] != null){
				lochFlaeche += loch[i].flaeche();
			}						
		}
		return super.flaeche() - lochFlaeche;
	}
	
	

}
