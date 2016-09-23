package ch.ibw.kap_5;

import Prog1Tools.IOTools;

public class Aufgabe_5_5 {

	public static void main(String[] args) {
		
		int n = 0;
		
		while(((n % 2) == 0) || (n < 3 || n > 9)){
			n = IOTools.readInt("Ungerade Zahl zwischen 3 und 9 eigeben: ");
		}
		
		int [][]tabelle = new int[n][n];
		int zeile = n/2;
		int spalte = n/2+1;
		int i = 1;
		while (i <= n*n) {
			tabelle[zeile][spalte] = i;
			spalte++;
			zeile--;
			if(zeile < 0){
				zeile = n-1;
			}
			if(spalte == n){
				spalte =0;
			}
			if(tabelle[zeile][spalte] != 0){
				zeile++;
				spalte++;
				if(zeile == n){
					zeile = 0;
				}
				if(spalte == n){
					spalte = 0;
				}
			}
			i++;
		}
		for (int j = 0; j < tabelle.length; j++) {
			
			for (int j2 = 0; j2 < tabelle[j].length; j2++) {
				System.out.print(tabelle[j][j2] + "\t");				
			}
			System.out.println();
		}		
	}

}
