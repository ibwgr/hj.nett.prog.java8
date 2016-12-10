package ch.ibw.thread;

class Runner implements Runnable {
	public void run() {
		try {
			for (int i = 0; i < 10; i++) {
				Thread.sleep(100);
				for (int j = 0; j < 100000; j++) {
					Thread.yield();
				}
			}
		} catch (InterruptedException e) {
			System.out.println("Interrupted");
		}
	}
}

public class Aufgabe2 {
	public static void main(String[] args) throws InterruptedException {
		Runner c = new Runner();
		Thread r = new Thread(c);
		System.out.println(r.getState());
		r.start();
		while (r.isAlive()) {
			System.out.println(r.getState());
			Thread.sleep(100);
		}
		System.out.println(r.getState());
	}
}
