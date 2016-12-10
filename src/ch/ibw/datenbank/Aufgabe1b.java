package ch.ibw.datenbank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

/**
 * Created by Nett on 06.12.2016.
 */
public class Aufgabe1b {


    public static void main(String[] args) {
        Connection conn = null;
        System.out.println("Bitte Nummer eingeben:");
        Scanner sc = new Scanner(System.in);
        int nummer = sc.nextInt();

        try {
            Class.forName("org.postgresql.Driver");

            conn = DriverManager
                    .getConnection("jdbc:postgresql://localhost/byceco",
                            "postgres", "goeginett");

            Statement stm = conn.createStatement();
            ResultSet res = stm.executeQuery("SELECT * FROM artikel WHERE tnr="+ nummer  +"");
            while(res.next()){
                System.out.println(res.getString("bezeichnung"));
            }

            res.close();
            stm.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }



    }
}
