package ch.ibw.kap_9.aufgabe_9_7;

import Prog1Tools.Plottable;

/**
 * Created by Nett on 11.10.2016.
 */
public class Funktionsplotter implements Plottable {

    private double tlinks;
    private double trechts;

    @Override
    public double inf() {
        return tlinks;
    }


    @Override
    public double sup() {
        return trechts;
    }

    @Override
    public double x(double v) {
        return 0;
    }

    @Override
    public double y(double v) {
        return 0;
    }
}
