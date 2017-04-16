package ch.ibw.thread;

/**
 * Created by Nett on 14.12.2016.
 */
public class Bank {

    static int kontoAnzahl = 4;
    double kontos[];
    private boolean ueberweisung = false;

    Bank() {
        kontos = new double[kontoAnzahl];
        kontos[0] = 100.0;
        kontos[1] = 50.0;
        kontos[2] = 10.0;
        kontos[3] = 0.0;
    }

    /**
     * Verschiebe den gegeben Betrag von Konto mit Nummer von nach Konto mit
     * Nummer nach. Falls die Parameter der Methode ungültig sind, dann gibt die
     * Methode false zurück. Sonst wird der gegebene Betrag vom Konto mit Nummer
     * von abgezogen und dem Konto mit Nummer nach gutgeschrieben und der Wert
     * true zurückgegeben.
     */
    boolean verschiebe(double betrag, int von, int nach) throws InterruptedException{
        // betrag > 0?
        if (betrag <= 0.0) {
            return false;
        }
        // von-Kontonummer gültig?
        if (von < 0 || von >= kontoAnzahl) {
            return false;
        }
        // nach-kontonummer gültig?
        if (nach < 0 || nach >= kontoAnzahl) {
            return false;
        }
        // genügend Geld auf Konto von (Kontostand darf nicht negativ werden)
        System.out.println("Vor Prüfung Betrag " + betrag + " von Konto "+ von + ": " + kontos[von] + " nach Konto " + nach + ": " + kontos[nach] + " : " + Thread.currentThread().getName());
        synchronized (this) {
            while (kontos[von] < betrag) {
                System.out.println("Wait " + Thread.currentThread().getName());
                ueberweisung = false;
                wait();
                System.out.println("Nach Wait " + Thread.currentThread().getName());
            }
            kontos[von] -= betrag;
            kontos[nach] += betrag;
            ueberweisung = true;
            notify();
            System.out.println("Nach Überweisung von " + betrag + " Konto "+ von + ": " + kontos[von] + " nach Konto " + nach + ": " + kontos[nach] + " : " + Thread.currentThread().getName());
        }
        return true;
    }

    public boolean isUeberweisung() {
        return ueberweisung;
    }
}

