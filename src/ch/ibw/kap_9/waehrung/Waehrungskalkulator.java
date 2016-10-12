package ch.ibw.kap_9.waehrung;

import Prog1Tools.IOTools;
import ch.ibw.kap_9.waehrung.DM;
import ch.ibw.kap_9.waehrung.Euro;
import ch.ibw.kap_9.waehrung.Franc;
import ch.ibw.kap_9.waehrung.Lire;

/**
 * Created by Nett on 04.10.2016.
 */
public class Waehrungskalkulator {

    public static void main(String[] args) {

        DM dm = new DM(IOTools.readDouble("Wert in DM eingeben: "));
        double euroBetrag  = dm.euroBetrag();
        Lire lire = new Lire(new Euro(euroBetrag));
        Franc franc = new Franc(new Euro(euroBetrag));

        System.out.println("Der Betrag " + dm.waehrungsBetrag() + " DM entspricht:\n" + Math.round(100.0 * dm.euroBetrag())/100.0 + "\tEuro\n" +
                Math.round(lire.waehrungsBetrag()) + "\tLire\n" + Math.round(100.0 * franc.waehrungsBetrag())/100.0 + "\tFranc");

        System.out.println(lire.toString());

        Euro euro = new Euro(150.0);
        System.out.println(euro.toString());

        Double d = new Double(5.5);
        if(d.doubleValue() == 5.5){
            System.out.println("d ist gleich 5.5");
        }
    }


}
