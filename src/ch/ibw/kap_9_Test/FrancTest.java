package ch.ibw.kap_9_Test;

import ch.ibw.kap_9.*;
import junit.framework.TestCase;
import org.junit.Test;


/**
 * Created by Nett on 07.10.2016.
 */
public class FrancTest extends TestCase {
    @Test
    public void testWaehrungsBetrag() throws Exception {

        Franc franc = new Franc(new Euro(100.00));
        double francBetrag =franc.waehrungsBetrag();
        assertEquals(100 * Franc.KURS, francBetrag, 0);
    }

}