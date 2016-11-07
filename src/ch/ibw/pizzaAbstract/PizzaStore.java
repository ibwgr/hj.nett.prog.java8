package ch.ibw.pizzaAbstract;

import ch.ibw.PizzaDb.DbConnection;
import ch.ibw.pizzaInterface.*;

/**
 * Created by Nett on 15.10.2016.
 */
public class PizzaStore {

    public static void main(String[] args) {

        Zutat z1 = new Zutat("Teig", 200, 333, 3.0);
        Zutat z2 = new Zutat("Mozzarella", 60, 244, 2.5);
        Zutat z3 = new Zutat("Tomatensauce", 100, 20, 1.2);
        Zutat z4 = new Zutat("Olivenoel", 6, 819, 1.0);
        Zutat z5 = new Zutat("Schinken", 30, 145, 1.5);
        Zutat z6 = new Zutat("Pilz", 15, 60, 1.2);
        Zutat z7 = new Zutat("Peperoni", 25, 40, 0.8);
        Zutat z8 = new Zutat("Artischocken", 80, 47, 0.9);

        Zutat[] zutatenMargherita = new Zutat[]{z1,z2,z3,z4};
        Zutat[] zutatenNapolitana = new Zutat[]{z1,z2,z3,z4,z7};
        Zutat[] zutatenQuattroStagioni = new Zutat[]{z1, z2, z3, z4, z5, z6, z7, z8};

        Pizza margherita = new MargheritaAbstract(zutatenMargherita, "Margherita", MargheritaAbstract.GROSS);
        Pizza margheritaKlein = new MargheritaAbstract(zutatenMargherita,"Margherita", MargheritaAbstract.KLEIN);
        Pizza quattroStagione = new QuattroStagioniAbstract(zutatenQuattroStagioni, "QuattroStagoni");
        Pizza napolitana = new QuattroStagioniAbstract(zutatenNapolitana, "Napolitana");

        Pizza[] pizzas = new Pizza[]{margherita, margheritaKlein,quattroStagione,napolitana};

        System.out.println("Pizzas mit abstracter Class");

        for(Pizza pizza : pizzas){

            String groesse = "";
            if(pizza instanceof MargheritaAbstract){
                groesse = ((MargheritaAbstract) pizza).getGroesse() + " ";
            }
            System.out.println("Eine " + groesse + pizza.getClass().getSimpleName() + " kostet " + pizza.getPreis() + " Fr. und hat " + pizza.getNaehrwert() + " kCal");
        }

        IPizza margheritaI = new MargheritaInterface(zutatenMargherita, IPizza.GROSS);
        IPizza margheritaKleinI = new MargheritaInterface(zutatenMargherita, IPizza.KLEIN);
        IPizza quattroStagioneI = new QuattroStagioniInterface(zutatenQuattroStagioni);
        IPizza napolitanaI = new NapolitanaInterface(zutatenNapolitana);

        IPizza[] pizzasI = new IPizza[]{margheritaI, margheritaKleinI,quattroStagioneI,napolitanaI};

        System.out.println();
        System.out.println("Pizzas mit Interface");

        for(IPizza pizza : pizzasI){

            String groesse = "";
            if(pizza instanceof MargheritaInterface){
                groesse = ((MargheritaInterface) pizza).getGroesse() + " ";
            }
            System.out.println("Eine " + groesse + pizza.getClass().getSimpleName() + " kostet " + pizza.getPreis() + " Fr. und hat " + pizza.getNaehrwert() + " kCal");
        }


        /**
         *  Verwaltung Pizzdetails in C:/Users/Nett/Documents/Pizza.accdb
         */
        DbConnection dbConn = new DbConnection("//C:/Users/Nett/Documents/Pizza.accdb");

        IPizza margheritaDb = new MargheritaInterface(dbConn.selectRezeptDetails("Margherita"), IPizza.GROSS);
        IPizza margheritaKleinDb = new MargheritaInterface(dbConn.selectRezeptDetails("Margherita"), IPizza.KLEIN);
        IPizza quattroStagioneDb = new QuattroStagioniInterface(zutatenQuattroStagioni);
        IPizza napolitanaDb = new NapolitanaInterface(dbConn.selectRezeptDetails("Napolitana"));

        IPizza[] pizzasDb = new IPizza[]{margheritaDb, margheritaKleinDb,quattroStagioneDb,napolitanaDb};

        System.out.println();
        System.out.println("Pizzas mit Zutaten aus DB");

        for(IPizza pizza : pizzasDb){

            String groesse = "";
            if(pizza instanceof MargheritaInterface){
                groesse = ((MargheritaInterface) pizza).getGroesse() + " ";
            }
            System.out.println("Eine " + groesse + pizza.getClass().getSimpleName() + " kostet " + pizza.getPreis() + " Fr. und hat " + pizza.getNaehrwert() + " kCal");
        }
    }
}
