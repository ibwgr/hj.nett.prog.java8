package ch.ibw.kap_5;

import java.util.Arrays;
import Prog1Tools.IOTools;

public class Aufgabe_5_4 {

	public static void main(String[] args) {
		
		int count = IOTools.readInt("Anzahl zu sortierende Zahlen eigeben: ");
		int[] zahl = new int[count];
		
		for(int i = 0; i < zahl.length; i++ ){
			zahl[i] = IOTools.readInt((i+1) + ". Zahl eingeben: ");
		}
		Arrays.sort(zahl);
		
		for(int i = 0; i < zahl.length; i++ ){
			System.out.print(zahl[i] + " ");
		}
		
	}

}
