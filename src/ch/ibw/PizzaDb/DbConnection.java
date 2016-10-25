package ch.ibw.PizzaDb;

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

    public ResultSet selectRezeptDetails(String rezept){

        String selectCmd = "SELECT Rezeptdetails.ZutatName, Zutat.ZutatGewicht, Produkt.Brennwert, Produkt.Preis "
                + "FROM Rezeptdetails, Zutat, Produkt "
                + "WHERE Rezeptdetails.ZutatName = Zutat.ZutatName "
                + "AND Zutat.ProduktID =Produkt.ProduktID "
                + "AND Rezeptdetails.RezeptName ='" + rezept + "'";
        Connection con = null;
        ResultSet res = null;
        Statement s = null;

        try {
            con = getConnection(connStr, "", "");

            s = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);

            res = s.executeQuery(selectCmd);

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
        return res;
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
