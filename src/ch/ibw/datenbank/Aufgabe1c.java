package ch.ibw.datenbank;

import java.sql.*;
import java.util.Scanner;

/**
 * Created by Nett on 06.12.2016.
 */
public class Aufgabe1c {

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

            PreparedStatement pstm = conn.prepareStatement("SELECT * FROM artikel WHERE tnr=?");
            pstm.setInt(1,nummer);
            ResultSet res = pstm.executeQuery();
            while(res.next()){
                System.out.println(res.getString("bezeichnung"));
            }

            res.close();
            pstm.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
