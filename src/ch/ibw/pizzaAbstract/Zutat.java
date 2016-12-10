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

    public int getGewicht() {
        return gramm;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Zutat zutat = (Zutat) o;

        if (gramm != zutat.gramm) return false;
        if (brennwert != zutat.brennwert) return false;
        if (Double.compare(zutat.preis, preis) != 0) return false;
        return name != null ? name.equals(zutat.name) : zutat.name == null;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name != null ? name.hashCode() : 0;
        result = 31 * result + gramm;
        result = 31 * result + brennwert;
        temp = Double.doubleToLongBits(preis);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
