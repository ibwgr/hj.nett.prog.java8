package ch.ibw.kap_9_Test;

import ch.ibw.kap_9.waehrung.Euro;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Nett on 07.10.2016.
 */
public class EuroTest extends TestCase {

    Euro euro = null;
    double inValue;

    @Before
    public void setUp() throws Exception {
        euro = new Euro(100.00);
        inValue = 100.00;
    }

    @Test
    public void testEuroBetrag() throws Exception {

        double outValue = euro.euroBetrag();
        assertEquals(inValue,outValue,0);
    }

    @Test
    public void testDollarBetrag() throws Exception {

        double dollar = euro.dollarBetrag();
        assertEquals(inValue * euro.getEuroDollarKurs(),dollar, 0);
    }

}