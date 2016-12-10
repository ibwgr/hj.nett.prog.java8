package ch.ibw.thread;

/**
 * Created by Nett on 08.12.2016.
 */
public class CowboyJim {

    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();

        LaufThread lauf = new LaufThread();
        lauf.start();

        KauThread kau = new KauThread();
        kau.start();

        while(kau.isAlive() && lauf.isAlive()){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if(startTime + 10000 < System.currentTimeMillis()) {
                try {
                    lauf.interrupt();
                    lauf.join();
                    kau.interrupt();
                    kau.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }


    }
}
