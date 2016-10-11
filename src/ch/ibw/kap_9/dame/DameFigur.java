package ch.ibw.kap_9.dame;

public class DameFigur extends Spielfigur {

	private final String name = "Dame";
	
	public DameFigur(char x, int y, String f) {
		super(x, y, f);
	}

	
	public void ziehe(char richtung, int anzahl) {
		
		switch (richtung) {
		case '-':
			super.ziehe(anzahl, 0);
			break;
		case '|':
			super.ziehe(0, anzahl);
			break;
		case '/':
		case '\\':
			super.ziehe(anzahl, anzahl);
			break;
		}
	}

	public boolean trifft(DameFigur dame){
		
		return (getxPos() == dame.getxPos()) && (getyPos() == dame.getyPos());
	}


	@Override
	public String toString() {
		
		return getFarbe() + "e " + name +  " auf Feld " + getxPos() + getyPos();
	}
	
	
}
