package ch.ibw.pizzaAbstract;

/**
 * Created by Nett on 15.10.2016.
 */
public class MargheritaAbstract extends Pizza {

    private int groesse;

    public MargheritaAbstract(Zutat[]zutaten, String name, int groesse) {
        super(zutaten);
        this.groesse = groesse;
    }

    @Override
    public int getNaehrwert() {
        return  super.getNaehrwert() * groesse/10;
    }

    @Override
    public double getPreis() {
        return (super.getPreis() - super.getBasispreis()) * groesse/10 + super.getBasispreis();
    }

    public String getGroesse(){
       String size = "";
        switch(groesse){
            case MargheritaAbstract.GROSS:
                return "grosse";
            case MargheritaAbstract.MITTEL:
                return "mittlere";
            case MargheritaAbstract.KLEIN:
                return "kleine";
            default:
                return "unbekannte Grösse";
        }
    }
}
