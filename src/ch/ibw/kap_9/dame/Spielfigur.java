package ch.ibw.kap_9.dame;

public class Spielfigur {

	// Position A-H der Figur
	private char xPos;

	//Position 1-8 der Figur
	private int yPos;

	// Farbe der Figur
	private String farbe;

	public Spielfigur(char x, int y, String f){
		xPos = x;
		yPos = y;
		farbe = f;
		//korrigiere evt falsche Positionsangaben
		korrigierePosition();
	}
	
	private void korrigierePosition(){
		if(xPos < 'A'){
			xPos = 'A';
		}
		else if(yPos > 'H'){
			xPos = 'H';
		}
		if(yPos < 1){
			yPos = 1;
		}else if(yPos > 8){
			yPos = 8;
		}
	}
	
	public char getxPos() {
		return xPos;
	}
	
	public int getyPos() {
		return yPos;
	}
	
	public String getFarbe() {
		return farbe;
	}
	
	public void ziehe(int xF, int yF){
		xPos = (char)(xPos + xF);
		yPos = yPos + yF;
		korrigierePosition();
	}

	@Override
	public String toString() {
		return farbe + "e Figur auf Feld " + xPos + yPos;
	}
	
	
}
