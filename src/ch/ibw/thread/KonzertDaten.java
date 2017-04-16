package ch.ibw.thread;

class KonzertDaten {
  private int sitzPlatz = 0;

  public synchronized int freierPlatz() {
    int n = sitzPlatz;
    // simuliere Datenbankabfragen
    try {
      Thread.sleep((int) (Math.random()*100)); 
    }
    catch (InterruptedException ie) {
    }
    return sitzPlatz = n + 1;
  }
}
