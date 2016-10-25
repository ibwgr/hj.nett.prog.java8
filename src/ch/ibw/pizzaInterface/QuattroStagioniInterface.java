package ch.ibw.pizzaInterface;

import ch.ibw.pizzaAbstract.Zutat;

/**
 * Created by Nett on 18.10.2016.
 */
public class QuattroStagioniInterface implements IPizza {

    private Zutat[]zutaten;

    public QuattroStagioniInterface(Zutat[] zutaten) {
        this.zutaten = zutaten;
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
        return zutatenPreis + IPizza.BASISPREIS ;
    }

    @Override
    public int getNaehrwert() {
        int naehrwert = 0;
        for(Zutat z : zutaten) {
            naehrwert += z.getBrennwert();
        }
        return  naehrwert;
    }
}
