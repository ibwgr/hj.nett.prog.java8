package ch.ibw.kap_9_Test;

import ch.ibw.kap_9.waehrung.Euro;
import ch.ibw.kap_9.waehrung.Franc;
import org.junit.Assert;
import org.junit.Test;


/**
 * Created by Nett on 07.10.2016.
 */
public class FrancTest {
    @Test
    public void waehrungsBetragReturnEuroInFranc(){

        Franc franc = new Franc(new Euro(100.00));
        double francBetrag =franc.waehrungsBetrag();
        Assert.assertEquals(100 * Franc.KURS, francBetrag, 0);
    }

}