package ch.ibw.pizzaAbstract;

/**
 * Created by Nett on 15.10.2016.
 */
public class Zutat {

    private Zutaten name;
    private int gramm;

    public Zutat(Zutaten name, int gramm) {
        this.name = name;
        this.gramm = gramm;
    }

    public Zutaten getName() {
        return name;
    }

    /**
     * Berechnet den Nährwert in kcal pro 100 Gramm der instanzierten Zutat
     *
     * @return naehrwert
     */
    public int getNaehrwert() {

        int naehrwert = 0;
        switch(name){
            case TEIG:
                naehrwert = gramm * 333 /100;
                break;
            case MOZZARELLA:
                naehrwert =  gramm * 244 /100;
                break;
            case TOMATENSAUCE:
                naehrwert = gramm * 20 / 100;
                break;
            case OLIVENOEL:
                naehrwert = gramm * 819 /100;
                break;
            case SCHINKEN:
                naehrwert = gramm * 145 / 100;
                break;
            case PILZ:
                naehrwert = gramm * 60 / 100;
                break;
            case PEPERONI:
                naehrwert = gramm * 40 / 100;
                break;
            case ARTISCHOCKEN:
                naehrwert = gramm * 47 / 100;
        }
        return  naehrwert;
    }


    /**
     * Gibt den Preis pro Portion der instanzierten Zutat zurück
     *
     * @return preis
     */
    public double getPreis(){

        double preis = 0;
        switch(name){
            case TEIG:
                preis = 3.0;
                break;
            case MOZZARELLA:
                preis =  2.5;
                break;
            case  TOMATENSAUCE:
                preis = 1.2;
                break;
            case OLIVENOEL:
                preis = 1.0;
                break;
            case SCHINKEN:
                preis = 1.5;
                break;
            case PILZ:
                preis = 1.2;
                break;
            case PEPERONI:
                preis = 0.8;
                break;
            case ARTISCHOCKEN:
                preis = 0.9;
        }
        return  preis;
    }
}
