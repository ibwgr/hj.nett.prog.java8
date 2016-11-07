package ch.ibw.kap_9.waehrung;

/**
 * Created by Nett on 04.10.2016.
 */
public abstract class Waehrung {

    private int nummer;

    public Waehrung(int nummer) {
        this.nummer = nummer;
    }

    /** Gibt den Wert des Objekts in US-Dollar zurueck */
    public abstract double dollarBetrag();

}
