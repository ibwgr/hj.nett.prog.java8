package ch.ibw.pizzaAbstract;

/**
 * Created by Nett on 15.10.2016.
 */
public class Zutat {

    private String name;
    private int gramm;
    private int brennwert;
    private double preis;

    public Zutat(String name, int gramm, int brennwert, double preis) {
        this.name = name;
        this.gramm = gramm;
        this.brennwert = brennwert;
        this.preis = preis;
    }

    public String getName() {
        return name;
    }

    /**
     * Berechnet den Nährwert in kcal pro 100 Gramm der instanzierten Zutat
     *
     * @return naehrwert
     */
    public int getBrennwert() {
        return gramm * brennwert / 100;
    }

    /**
     * Gibt den Preis pro Portion der instanzierten Zutat zurück
     *
     * @return preis
     */
    public double getPreis(){
        return preis;
    }

}
