package ch.ibw.db_swing;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

/**
 * Created by Nett on 14.01.2017.
 */
public class DbAccess{

    public String[] getTableNames(String dbName){

        String[] tables = null;
        try{
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager
                    .getConnection("jdbc:postgresql://localhost/" + dbName, "postgres", "goeginett");
            DatabaseMetaData dbmd = conn.getMetaData();
            String[] types = {"TABLE"};

            ResultSet rs = dbmd.getTables(null, null, "%", types);
            rs.last();
            int rows = rs.getRow();
            rs.beforeFirst();

            tables = new String[rows];
            int idx = 0;
            while (rs.next()) {
                tables[idx] = rs.getString(3);
                idx++;
            }
            conn.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return tables;
    }

    public DefaultTableModel getTableModelFromCmd(String database,String cmd){

        return getDefaultTableModel(database, cmd);
    }

    public DefaultTableModel getTableModel(String database, String table){
        String cmd = "SELECT * FROM " + table;
        return getDefaultTableModel(database, cmd);
    }

    private DefaultTableModel getDefaultTableModel(String database, String cmd) {
        String[][] datenArray = null;
        String[] header = null;
        ResultSetMetaData metaData = null;
        DefaultTableModel model = null;
        int columns = 0;

        try{
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager
                    .getConnection("jdbc:postgresql://localhost/" + database, "postgres", "goeginett");

            Statement stm = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            ResultSet res = stm.executeQuery(cmd);
            //Anzahl Spalten und Zeilen auslesen
            metaData = res.getMetaData();
            columns = metaData.getColumnCount();
            res.last();
            int rows = res.getRow();
            res.beforeFirst();
            //Daten auslesen
            datenArray = new String[rows][columns];
            while(res.next()) {
                int row = res.getRow();
                for (int i = 1; i <= columns; i++) {
                    datenArray[row-1][i-1] = res.getString(i) + " ";
                }
            }
            res.close();
            stm.close();
            conn.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }

        //Überschrift Spalten
        header = new String[columns];
        for(int i = 1; i <= columns; i++){
            try {
                header[i-1]= metaData.getColumnName(i);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return model = new DefaultTableModel(datenArray, header);
    }


}
