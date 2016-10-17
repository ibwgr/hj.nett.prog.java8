package ch.ibw.kap_9_Test;

import ch.ibw.kap_9.waehrung.Euro;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Nett on 07.10.2016.
 */
public class EuroTest {

    double inValue;

    @Before
    public void setUp() throws Exception {
        inValue = 100.00;
    }

    @Test
    public void EuroBetragInValueEqualsOutValue() {

        Euro euro = MakeEuro();
        double outValue = euro.euroBetrag();
        Assert.assertEquals(inValue,outValue,0);
    }

    @Test
    public void DollarBetragInEuroEqualsOutDollar() {

        Euro euro = MakeEuro();
        double dollar = euro.dollarBetrag();
        assertEquals(inValue * euro.getEuroDollarKurs(),dollar, 0);
    }

    private static Euro MakeEuro(){

        return new Euro(100.0);
    }

}