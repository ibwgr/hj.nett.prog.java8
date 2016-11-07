package ch.ibw.PizzaDb;

import ch.ibw.pizzaAbstract.Zutat;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static java.sql.DriverManager.getConnection;


/**
 * Created by Nett on 23.10.2016.
 */
public class DbConnection {

   private String connStr = null;
    String message = "";

    public DbConnection(String connStr){
        this.connStr = "jdbc:ucanaccess:" + connStr;
    }

    public Zutat[] selectRezeptDetails(String rezept){

        String selectCmd = "SELECT Rezeptdetails.ZutatName, Zutat.ZutatGewicht, Produkt.Brennwert, Produkt.Preis "
                + "FROM Rezeptdetails, Zutat, Produkt "
                + "WHERE Rezeptdetails.ZutatName = Zutat.ZutatName "
                + "AND Zutat.ProduktID =Produkt.ProduktID "
                + "AND Rezeptdetails.RezeptName ='" + rezept + "'";
        Connection con = null;
        ResultSet res = null;
        Statement s = null;
        Zutat[] zutaten = null;

        try {
            con = getConnection(connStr, "", "");
            s = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);

            res = s.executeQuery(selectCmd);

            res.last();
            int rows = res.getRow();
            // Move to beginning
            res.beforeFirst();
            zutaten = new Zutat[rows];

            while (res.next()) {

                int row = res.getRow();

                String name = res.getString("ZutatName");
                int gewicht = res.getInt("ZutatGewicht");
                int brennwert = res.getInt("Brennwert");
                double preis = res.getDouble("Preis");

                zutaten[row-1] = new Zutat(name,gewicht,brennwert,preis);
            }

        }
        catch (Exception e) {
            System.out.println("" + e.getMessage());}
        finally {
            try {
                if (s != null)
                    s.close();
                if (con != null)
                    con.close();
            }catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
        return zutaten;
    }

    public String[] getAllProducts(){

        String selectCmd = "SELECT ProduktName FROM Produkt";
        Connection con = null;
        ResultSet res = null;
        Statement s = null;
        String[]products = null;

        try {
            con = getConnection(connStr, "", "");
            s = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);

            res = s.executeQuery(selectCmd);

            res.last();
            int rows = res.getRow();
            // Move to beginning
            res.beforeFirst();
            products = new String[rows];

            while (res.next()) {

                int row = res.getRow();
                String name = res.getString("ProduktName");
                products[row-1] =name;
            }
        }
        catch (Exception e) {
            System.out.println("" + e.getMessage());}
        finally {
            try {
                if (s != null)
                    s.close();
                if (con != null)
                    con.close();
            }catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
        return products;
    }

    public String[] getRezepte(){

        String selectCmd = "SELECT RezeptName FROM Rezept";
        Connection con = null;
        ResultSet res = null;
        Statement s = null;
        String[]rezepte = null;

        try {
            con = getConnection(connStr, "", "");
            s = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);

            res = s.executeQuery(selectCmd);

            res.last();
            int rows = res.getRow();
            // Move to beginning
            res.beforeFirst();
            rezepte = new String[rows];

            while (res.next()) {

                int row = res.getRow();
                String name = res.getString("RezeptName");
                rezepte[row-1] =name;
            }
        }
        catch (Exception e) {
            System.out.println("" + e.getMessage());}
        finally {
            try {
                if (s != null)
                    s.close();
                if (con != null)
                    con.close();
            }catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
        return rezepte;

    }

    public void insertCommand(String command){

        Connection con = null;
        ResultSet res = null;
        Statement s = null;

        try {
            con = getConnection(connStr, "", "");

            s = con.createStatement();
            s.executeUpdate(command);

        }catch (SQLException e){
           message = e.getMessage();

        }finally {
            try {
                if (s != null)
                    s.close();
                if (con != null)
                    con.close();
            }catch (SQLException e)
            {
                e.printStackTrace();
            }
        }

    }
}
