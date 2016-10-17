package ch.ibw.pizzastore;

/**
 * Created by Nett on 15.10.2016.
 */
public class PizzaMargherita implements IPizza {

    private int groesse;
    private Zutat[] zutaten;
    private double basispreis = 10.0;

    public PizzaMargherita(Zutat[]zutaten,int groesse) {
        this.groesse = groesse;
        this.zutaten = zutaten;
    }

    public String getGroesse(){
       String size = "";
        switch(groesse){
            case PizzaMargherita.GROSS:
                return "grosse";
            case PizzaMargherita.MITTEL:
                return "mittlere";
            case PizzaMargherita.KLEIN:
                return "kleine";
            default:
                return "unbekannte Grösse";
        }
    }

    @Override
    public Zutat[] getZutaten() {
        return zutaten;
    }

    @Override
    public double getPreis() {
        double zutatenPreis = 0;
        for(Zutat z : zutaten) {
            zutatenPreis +=(z.getPreis() * groesse/10);
        }
       return zutatenPreis + basispreis;
    }

    @Override
    public int getNaehrwert() {
        int naehrwert = 0;
        for(Zutat z : zutaten) {
            naehrwert += (z.getNaehrwert() * groesse/10);
        }
        return  naehrwert;
    }
}
