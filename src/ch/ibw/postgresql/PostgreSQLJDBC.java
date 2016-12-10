package ch.ibw.postgresql;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by Nett on 16.11.2016.
 */
public class PostgreSQLJDBC {

    public static void main(String args[]) {
        Connection c = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/postgres",
                            "postgres", "goeginett");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
        System.out.println("Opened database successfully");
    }
}

