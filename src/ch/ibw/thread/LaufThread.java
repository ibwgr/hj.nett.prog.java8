package ch.ibw.thread;

/**
 * Created by Nett on 08.12.2016.
 */
public class LaufThread extends Thread {

    @Override
    public void run() {
        while(!isInterrupted()) {

            try {
                System.out.println("links");
                Thread.sleep(500);
                System.out.println("rechts");
                Thread.sleep(500);
            } catch (InterruptedException e) {
               return;
            }
        }
    }
}
