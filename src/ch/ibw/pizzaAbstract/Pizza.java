package ch.ibw.pizzaAbstract;

/**
 * Created by Nett on 17.10.2016.
 */
public abstract class Pizza{

    public static final int GROSS = 10;
    public static final int MITTEL = 8;
    public static final int KLEIN = 5;

    private Zutat[] zutaten;
    private double basispreis = 10.0;

    public Pizza(Zutat[] zutaten) {
        this.zutaten = zutaten;
    }

    public double getBasispreis() {
        return basispreis;
    }

    public Zutat[] getZutaten() {
        return zutaten;
    }

    public int getNaehrwert() {
        int naehrwert = 0;
        for(Zutat z : zutaten) {
            naehrwert += z.getBrennwert();
        }
        return  naehrwert;
    }

    public double getPreis() {
        double zutatenPreis = 0;
        for(Zutat z : zutaten) {
            zutatenPreis +=z.getPreis();
        }
        return zutatenPreis + basispreis;
    }
}
