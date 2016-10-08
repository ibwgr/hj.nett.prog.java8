package ch.ibw.kap_9;

/**
 * Created by Nett on 04.10.2016.
 */
public class Lire extends Euro {

    public static final double KURS =  1936.27;

    public Lire(double wert) {
        super(wert/KURS);
    }

    public  Lire(Euro euro){
        super(euro.euroBetrag());
    }

    public double waehrungsBetrag(){
        return euroBetrag() * KURS;
    }
}
