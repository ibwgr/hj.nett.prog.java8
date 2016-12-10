package ch.ibw.thread;

/**
 * Created by Nett on 08.12.2016.
 */
public class KauThread extends Thread{

    @Override
    public void run() {

        while(!isInterrupted()) {
            try {
                System.out.println("Schmatz");
                Thread.sleep(500);
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}
