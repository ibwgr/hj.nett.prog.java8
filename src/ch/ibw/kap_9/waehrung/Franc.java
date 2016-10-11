package ch.ibw.kap_9.waehrung;

import ch.ibw.kap_9.waehrung.Euro;

/**
 * Created by Nett on 04.10.2016.
 */
public class Franc extends Euro {

    public static final double KURS =  6.55957;

    public Franc(double wert) {
        super(wert/KURS);
    }

    public Franc(Euro euro){
        super(euro.euroBetrag());
    }

    public double waehrungsBetrag(){
        return euroBetrag() * KURS;
    }
}
