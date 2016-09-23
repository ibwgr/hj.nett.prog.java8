package ch.ibw.kap_9;

import Prog1Tools.IOTools;

public class TestMetallplatte {
	
	public static Metallplatte lochen(Metallplatte mp, int anzahlLoecher){
		GelochtePlatte lochPlatte = new GelochtePlatte(mp.laenge, mp.breite, 10);
		
		for (int i = 0; i < anzahlLoecher; i++) {
			lochPlatte.neuesLochStanzen();			
		}
		return lochPlatte;
	}

	public static void main(String[] args) {
		double laenge = IOTools.readDouble("Laenge erste Platte: ");
		double breite = IOTools.readDouble("Breite erste Platte: ");
		
		Metallplatte platte1 = new Metallplatte(laenge, breite);
		
		laenge = IOTools.readDouble("Laenge zweite Platte: ");
		breite = IOTools.readDouble("Breite zweite Platte: ");
		
		Metallplatte platte2 = new Metallplatte(laenge, breite);
		
		System.out.println("Platte 1 schwerer als Platte 2 = " + platte1.schwererAls(platte2));
		
		Metallplatte lochPlatte1 = lochen(platte1, 1);
		Metallplatte lochPlatte2 = lochen(platte2, 8);
		
		System.out.println("Lochplatte 1 schwerer als Lochplatte 2 = " + lochPlatte1.schwererAls(lochPlatte2));
		
	}

}
