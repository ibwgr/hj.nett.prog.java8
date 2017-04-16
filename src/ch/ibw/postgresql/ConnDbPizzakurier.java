package ch.ibw.postgresql;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Nett on 20.11.2016.
 */
public class ConnDbPizzakurier {

    private Connection c = null;
    private Timestamp  sqlDate = null;

    public ConnDbPizzakurier() {


    }

    private void createConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        c = DriverManager
                .getConnection("jdbc:postgresql://localhost:5432/Pizzakurier",
                        "postgres", "goeginett");
    }

    public List<Pizza> getPizzas(){

        List<Pizza> pizzaListe = new ArrayList<Pizza>();
        ResultSet res = null;
        Statement stm = null;

        try {
            createConnection();
            c.setAutoCommit(false);
            stm = c.createStatement();
            res = stm.executeQuery("SELECT * FROM Pizza");
            while ( res.next() ) {
                String  name = res.getString("pizzaname");
                double  preis = res.getDouble("preis");
                String  beschreibung = res.getString("beschreibung");

                pizzaListe.add(new Pizza(name, preis,beschreibung));
            }
            res.close();
            stm.close();
            c.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
        }

        return  pizzaListe;
    }

    public int makeOrder(String kommentar, String username){

        int retval = 0;
        try {
            createConnection();

            String insertCmd = "INSERT INTO Bestellung (datumZeit, kommentar, kunde_username) " +
                               "VALUES (?, ?, ?)";
            PreparedStatement pstmt = c.prepareStatement(insertCmd);

            sqlDate = new Timestamp(new java.util.Date().getTime());
            pstmt.setTimestamp(1, sqlDate);
            pstmt.setString(2, kommentar);
            pstmt.setString(3, username);

            retval = pstmt.executeUpdate();

            pstmt.close();
            c.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
        }
        return retval;
    }


    public int insertOrderDetails(int anzahl, String pizzaname, String kommentar){

        int retVal = 0;
        Statement stmt = null;

        try{
            createConnection();

            String insertCmd = "INSERT INTO bestellposition (anzahl, kommentar, pizzaname, bestellungid) " +
                               "SELECT " + anzahl + ", '" + kommentar + "', '" + pizzaname + "', bestellungid " +
                               "FROM bestellung " +
                               "WHERE datumzeit='"+sqlDate+"'";

            c.setAutoCommit(false);
            stmt = c.createStatement();
            retVal = stmt.executeUpdate(insertCmd);

            stmt.close();
            c.commit();
            c.close();
        }catch(Exception e){
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
        }
        return retVal;
    }

    public boolean existUser(String username){

        boolean valid = false;
        ResultSet res = null;
        Statement stm = null;
        List<String> userListe = new ArrayList<>();

        try {
            createConnection();
            stm = c.createStatement();
            res = stm.executeQuery("SELECT username FROM kunde");
            while ( res.next() ) {
                String  name = res.getString("username");
                userListe.add(name);
            }
            res.close();
            stm.close();
            c.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
        }

        if(userListe.contains(username)){
            valid = true;
        }

        return valid;
    }

    public void modifyPizza(List<Pizza> changedPizzaList){

        Statement stm = null;

        try{
            createConnection();
            stm = c.createStatement();
            c.setAutoCommit(false);

            for(Pizza p : changedPizzaList) {

                String sql = "UPDATE Pizza set preis = "+ p.getPreis() +" where pizzaname='"+ p.getName() + "';";
                stm.executeUpdate(sql);

                sql = "UPDATE Pizza set beschreibung = '" + p.getBeschreibung() + "' where pizzaname='"+ p.getName() + "';";
                stm.executeUpdate(sql);
            }
            c.commit();
            stm.close();
            c.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    public int insertNewPizza(String name, double preis, String comment){

        int retval = 0;
        try {
            createConnection();

            String insertCmd = "INSERT INTO Pizza (pizzaname, preis, beschreibung) " +
                    "VALUES (?, ?, ?)";
            PreparedStatement pstmt = c.prepareStatement(insertCmd);

            pstmt.setString(1, name);
            pstmt.setDouble(2, preis);
            pstmt.setString(3, comment);

            retval = pstmt.executeUpdate();

            pstmt.close();
            c.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
        }
        return retval;
    }
}
