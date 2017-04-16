package ch.ibw.thread;

/**
 * Created by Nett on 14.12.2016.
 */
public class Bankkunde extends Thread {

    private Bank bank = null;
    double betrag;
    int von;
    int nach;

    public Bankkunde(Bank bank, double betrag, int von, int nach) {
        this.bank = bank;
        this.betrag = betrag;
        this.von = von;
        this.nach = nach;
    }

    @Override
    public void run() {

        while(true) {
            try {
                bank.verschiebe(betrag, von, nach);
                sleep((int)(Math.random() * 100));
            } catch (InterruptedException e) {
                return;
            }
        }

    }
}
