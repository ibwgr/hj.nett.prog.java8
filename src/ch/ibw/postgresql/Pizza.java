package ch.ibw.postgresql;

/**
 * Created by Nett on 20.11.2016.
 */
public class Pizza {

    private String name = "";
    private double preis;
    private String beschreibung = "";

    public Pizza(String name, double preis, String beschreibung) {
        this.name = name;
        this.preis = preis;
        this.beschreibung = beschreibung;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPreis() {
        return preis;
    }

    public void setPreis(double preis) {
        this.preis = preis;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }
}
