package ch.ibw.thread;

class UseTerminals {
  public static void main(String[] args) {
    KonzertDaten daten = new KonzertDaten();
    KartenTerminal 
      t1 = new KartenTerminal("Karten-Terminal 1", daten), 
      t2 = new KartenTerminal("Karten-Terminal 2", daten);
    t1.start(); 
    t2.start();
  }
}
