package ch.ibw.datenbank;

import java.sql.*;

/**
 * Created by Nett on 06.12.2016.
 */
public class Main {

    public static void main(String[] args) {

        Connection conn = null;
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager
                    .getConnection("jdbc:postgresql://localhost/Pizzakurier",
                            "postgres", "goeginett");

            Statement stm = conn.createStatement();

            //CREATE TABLE
            stm.execute("DROP TABLE IF EXISTS zutat");
            stm.execute("CREATE TABLE zutat (zutat_name varchar(30) PRIMARY KEY, gewicht INTEGER NOT NULL)");

            //Insert
            stm.executeUpdate("INSERT INTO zutat VALUES ('Zwiebeln', 15)");
            stm.executeUpdate("INSERT INTO zutat VALUES ('Schinken', 25)");

            //Select
            ResultSet res = stm.executeQuery("SELECT * FROM pizza");
            while(res.next()){
                System.out.println(res.getString("pizzaname"));
            }
            res.close();
            stm.close();

            //Prepared-Statement
            PreparedStatement prestm = conn.prepareStatement("SELECT gewicht FROM zutat WHERE zutat_name = ?");
            prestm.setString(1,"Zwiebeln");
            res = prestm.executeQuery();
            while(res.next()){
                System.out.println("Gewicht: " + res.getInt(1) + " Gramm");
            }
            res.close();
            prestm.close();

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
