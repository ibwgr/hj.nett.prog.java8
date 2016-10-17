package ch.ibw.pizzastore;

/**
 * Created by Nett on 16.10.2016.
 */
public class PizzaQuattroStagione implements IPizza{

    private Zutat[] zutaten;
    private double basispreis = 10.0;

    public PizzaQuattroStagione(Zutat[] zutaten, double basispreis) {
        this.zutaten = zutaten;
        this.basispreis = basispreis;
    }

    @Override
    public Zutat[] getZutaten() {
        return zutaten;
    }

    @Override
    public double getPreis() {

        double zutatenPreis = 0;
        for(Zutat z : zutaten) {
            zutatenPreis += z.getPreis();
        }
        return zutatenPreis + basispreis;
    }

    @Override
    public int getNaehrwert() {

        int naehrwert = 0;
        for(Zutat z : zutaten) {
            naehrwert += z.getNaehrwert();
        }
        return  naehrwert;
    }
}
