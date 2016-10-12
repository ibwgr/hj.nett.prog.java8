package ch.ibw.kap_9.aufgabe_9_12_13;
import Prog1Tools.IOTools;;

public class DSpiel {
	
	static int versuche = 0;

	public static void main(String[] args) {
		System.out.println("Positionieren Sie die Beute");
		DameFigur beute = createDame();
		Bildschirm.loeschen();
		
		System.out.println("Die Beute steht, positionieren Sie den J�ger");		
		DameFigur jaeger = createDame();
		if (!jaeger.trifft(beute)) {
			System.out.println("Die Beute-Figur steht woanders\nSie haben nun 10 Z�ge um die Beute zu treffen");
			do {
				System.out.println("Bewegen Sie Ihre " + jaeger.toString());
				char richtung = IOTools.readChar("Wollen Sie waagrecht(-), senkrecht(|)\n oder diagonale(/,\\) ziehen?");
				int anzahl = IOTools.readInt("Wie viele Felder ziehen? (> 0 nach rechts oben,\n > 0 nach links unten)");
				jaeger.ziehe(richtung, anzahl);
				if (jaeger.trifft(beute)) {
					System.out.println("Treffer! Sie als Jaeger haben gewonnen!");
					break;
				} else {
					System.out.println("Leider kein Treffer!");
				}
				versuche++;
			} while (versuche < 10);
			System.out.println("Das Spiel ist beendet!");
		}
		
		
	}

	private static DameFigur createDame() {
		char xPos = IOTools.readChar("Spalte (A-H) Ihrer Figur?");
		int yPos = IOTools.readInt("Zeile (1-8) Ihrer Figur?");
		String farbe = IOTools.readString("Farbe Ihrer Figur");
					 
		return new DameFigur(xPos, yPos, farbe);
	}

}
