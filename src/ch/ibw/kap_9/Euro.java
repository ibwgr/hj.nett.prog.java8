package ch.ibw.kap_9;

/**
 * Created by Nett on 04.10.2016.
 */
public class Euro extends  Waehrung {

    /** Ein Euro ist soviel Dollar wert */
    private static double euroDollarKurs = 1.31;

    /** Instanzvariable: Wert in Euro */
    private double wert;

    /** Konstruktor */
    public Euro(double wert) {
        this.wert=wert;
    }

    /** Deklaration der sonst abstrakten Methode dollarBetrag */
    public double dollarBetrag() {
        return wert* euroDollarKurs;
    }

    /** Gibt den Wert der Waehrung in Euro zurueck */
    public double euroBetrag() {
        return wert;
    }

    public double getEuroDollarKurs() {
        return euroDollarKurs;
    }

    /** Zugriff auf die private Klassenvariable */
    public static void setEuroDollarKurs(double Kurs) {
        euroDollarKurs =Kurs;
    }

}
