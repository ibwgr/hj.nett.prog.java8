package ch.ibw.PizzaDb;

import ch.ibw.pizzaAbstract.Zutat;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sun.xml.internal.messaging.saaj.util.FinalArrayList;
import org.mockito.Mockito;
import com.mockrunner.mock.jdbc.MockResultSet;

import static java.sql.DriverManager.getConnection;


/**
 * Created by Nett on 23.10.2016.
 */
public class FakeDbConnection extends DbConnection {

   private String connStr = null;
    String message = "";
    private Zutat[] zutatenMargherita = null;

    public FakeDbConnection(String connStr, Zutat[] zutaten){
        super(connStr);
        zutatenMargherita = zutaten;
    }

    @Override
    public ResultSet getResultSet(String rezept) {

        MockResultSet mockResultSet = new MockResultSet("myResultSet");

        String[] columns = new String[]{"ZutatName","ZutatGewicht","Brennwert","Preis"};

        for(String column : columns) {
            mockResultSet.addColumn(column);
        }

        for(Zutat z : zutatenMargherita) {
            List<Object> list = new ArrayList<Object>();
            list.add(z.getName());
            list.add(z.getGewicht());
            list.add(z.getBrennwert());
            list.add(z.getPreis());
            mockResultSet.addRow(list);
        }
        return mockResultSet;
    }


    @Override
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

    @Override
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

    @Override
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
