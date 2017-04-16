package ch.ibw.thread;

/**
 * Created by Nett on 14.12.2016.
 */
public class Bankverwaltung {

    public static void main(String[] args) {
        Bank bank = new Bank();
        Bankkunde kunde1 = new Bankkunde(bank,40,1,2);
        Bankkunde kunde2 = new Bankkunde(bank,40,1,2);
        Bankkunde kunde3 = new Bankkunde(bank,20,0,1);
        kunde1.setName("Kunde1");
        kunde2.setName("Kunde2");
        kunde3.setName("Kunde3");
        kunde1.start();
        kunde2.start();
        kunde3.start();

        long startTime = System.currentTimeMillis();
        while(!bank.isUeberweisung() && kunde1.isAlive() && kunde2.isAlive()){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if(startTime + 5000 < System.currentTimeMillis()) {
                try {
                    kunde1.interrupt();
                    System.out.println("Kunde 1 interrupt");
                    kunde1.join();
                    System.out.println("Kunde 1 join");
                    kunde2.interrupt();
                    System.out.println("Kunde 2 interrupt");
                    kunde2.join();
                    System.out.println("Kunde 2 join");
                    kunde3.interrupt();
                    System.out.println("Kunde 3 interrupt");
                    kunde3.join();
                    System.out.println("Kunde 3 join");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
