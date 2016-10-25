package ch.ibw.pizzaInterface;

import ch.ibw.pizzaAbstract.Zutat;

/**
 * Created by Nett on 15.10.2016.
 */
public class MargheritaInterface implements IPizza {

    private Zutat[]zutaten;
    private int groesse;

    public MargheritaInterface(Zutat[] zutaten, int groesse) {
        this.zutaten = zutaten;
        this.groesse = groesse;
    }


    @Override
    public int getNaehrwert() {
        int naehrwert = 0;
        for(Zutat z : zutaten) {
            naehrwert += z.getBrennwert();
        }
        return  naehrwert * groesse/10;
    }

    @Override
    public Zutat[] getZutaten() {
        return zutaten;
    }

    @Override
    public double getPreis() {
        double zutatenPreis = 0;
        for(Zutat z : zutaten) {
            zutatenPreis += z.getPreis() * groesse/10;
        }
        return zutatenPreis + IPizza.BASISPREIS ;
    }

    public String getGroesse(){
       String size = "";
        switch(groesse){
            case MargheritaInterface.GROSS:
                return "grosse";
            case MargheritaInterface.MITTEL:
                return "mittlere";
            case MargheritaInterface.KLEIN:
                return "kleine";
            default:
                return "unbekannte Grösse";
        }
    }
}
