package ch.ibw.leitungsnachweis2;

import java.sql.*;
import java.util.Scanner;

/**
 * Created by Nett on 24.01.2017.
 */
public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        try {
            Class.forName("org.postgresql.Driver");
            Connection c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/Pizzakur",
                            "postgres", "goeginett");
            String insertCmd = "INSERT INTO bestellung (datumZeit, kommentar, kunde_username) " +
                    "VALUES (?, ?, ?)";
            PreparedStatement pstmt = c.prepareStatement(insertCmd);


          //  pstmt.setString(2, kommentar);
          //  pstmt.setString(3, username);

          pstmt.executeUpdate();

            pstmt.close();
            c.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}
