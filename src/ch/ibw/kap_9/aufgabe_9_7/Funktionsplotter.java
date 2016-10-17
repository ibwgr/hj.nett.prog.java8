package ch.ibw.kap_9.aufgabe_9_7;

import Prog1Tools.Plottable;
import Prog1Tools.Plotter;

/**
 * Created by Nett on 11.10.2016.
 */
public class Funktionsplotter implements Plottable {

    private double tlinks = -3.14;
    private double trechts = 3.14;

    @Override
    public double inf() {
        return tlinks;
    }

    @Override
    public double sup() {
        return trechts;
    }

    @Override
    public double x(double t) {
        return t;
    }

    @Override
    public double y(double t) {

        return Math.sin(t);
    }

    public static void main(String[] args) {
        Plotter p=new Plotter(new Funktionsplotter(),"Funktionsplott");
        p.adjustGrid(0.5,0.5);
        p.showGrid(true);
        p.setNumOfPoints(120);
        p.setVisible(true);
        System.out.print("zum Beenden bitte das ");
        System.out.println("Grafikfenster schliessen.");
    }
}
