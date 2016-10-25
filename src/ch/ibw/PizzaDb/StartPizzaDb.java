package ch.ibw.PizzaDb;

import ch.ibw.pizzaAbstract.Zutat;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Nett on 23.10.2016.
 */
public class StartPizzaDb {

    public static void main(String[] args) {

        DbConnection dbConn = new DbConnection("//C:/Users/Nett/Documents/Pizza.accdb");
        String rezept1 = "Margherita";
        String rezept2 = "Napolitana";
        Zutat[] zutaten ;
        String name;
        int gewicht;
        int brennwert;
        double preis;

        try {

          //  dbConn.insertCommand("INSERT INTO Produkt (ProduktName, Brennwert, Preis) VALUES ('Zwiebeln',10, 0.5)");


            ResultSet res = dbConn.selectRezeptDetails(rezept2);
            res.last();
            int rows = res.getRow();
            // Move to beginning
            res.beforeFirst();
            zutaten = new Zutat[rows];
            while (res.next()) {

                int row = res.getRow();

                name = res.getString("ZutatName");
                gewicht = res.getInt("ZutatGewicht");
                brennwert = res.getInt("Brennwert");
                preis = res.getDouble("Preis");

                zutaten[row-1] = new Zutat(name,gewicht,brennwert,preis);

                System.out.print(name + "\t");
                System.out.print(gewicht + " Gramm\t");
                System.out.print(brennwert + " Calorien\t");
                System.out.print(preis + " Fr.\t");
                System.out.println();
            }
        }
        catch(SQLException e){

            }

        }

    public static Zutat[] getZutaten(String rezept) {

        DbConnection dbConn = new DbConnection("//C:/Users/Nett/Documents/Pizza.accdb");
        String rezept1 = "Margherita";
        String rezept2 = "Napolitana";
        Zutat[] zutaten = null;
        String name;
        int gewicht;
        int brennwert;
        double preis;

        try {

            //  dbConn.insertCommand("INSERT INTO Produkt (ProduktName, Brennwert, Preis) VALUES ('Zwiebeln',10, 0.5)");

            ResultSet res = dbConn.selectRezeptDetails(rezept);
            res.last();
            int rows = res.getRow();
            // Move to beginning
            res.beforeFirst();
            zutaten = new Zutat[rows];
            while (res.next()) {

                int row = res.getRow();

                name = res.getString("ZutatName");
                gewicht = res.getInt("ZutatGewicht");
                brennwert = res.getInt("Brennwert");
                preis = res.getDouble("Preis");

                zutaten[row-1] = new Zutat(name,gewicht,brennwert,preis);

            }
        }
        catch(SQLException e){

        }

        return  zutaten;
    }

}
