package ch.ibw.pizzastore;

/**
 * Created by Nett on 15.10.2016.
 */
public interface IPizza {

    public static final int GROSS = 10;
    public static final int MITTEL = 8;
    public static final int KLEIN = 5;

    public Zutat[] getZutaten();
    public double getPreis();
    public int getNaehrwert();
}
