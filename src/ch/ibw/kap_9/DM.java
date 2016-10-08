package ch.ibw.kap_9;

/**
 * Created by Nett on 04.10.2016.
 */
public class DM extends  Euro {

    public static final double KURS =  1.95583;

    public DM(double wert) {
        super(wert/ KURS);
    }

    public  DM(Euro euro){
        super(euro.euroBetrag());
    }

    public double waehrungsBetrag(){
        return euroBetrag() * KURS;
    }
}
