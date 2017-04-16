package ch.ibw.datenbank;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

/**
 * Created by Nett on 06.12.2016.
 */
public class Aufgabe2 extends JFrame{

    private Container c = null;
    private ResultSet res = null;
    private JTextArea txtausgabe = null;
    private JTable table = null;
    private JPanel panel = null;
    private JScrollPane scroller = null;

    public Aufgabe2(){

        c = getContentPane();

        c.add(createPanel());

    }

    private JPanel createPanel(){
        panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.LEFT));

        Box box = new Box(BoxLayout.X_AXIS);

        JLabel url = new JLabel("URL");
        url.setPreferredSize(new Dimension(100,25));
        box.add(url);
        JTextField txtfldurl = new JTextField();
        txtfldurl.setPreferredSize(new Dimension(350,25));
        txtfldurl.setText("org.postgresql.Driver");
        box.add(txtfldurl);
        panel.add(box);

        box = new Box(BoxLayout.X_AXIS);
        JLabel user = new JLabel("Benutzer");
        user.setPreferredSize(new Dimension(100,25));
        box.add(user);
        JTextField txtflduser = new JTextField();
        txtflduser.setText("postgres");
        txtflduser.setPreferredSize(new Dimension(350,25));
        box.add(txtflduser);
        panel.add(box);

        box = new Box(BoxLayout.X_AXIS);
        JLabel password = new JLabel("Passwort");
        password.setPreferredSize(new Dimension(100,25));
        box.add(password);
        JTextField txtfldpw = new JTextField();
        txtfldpw.setText("goeginett");
        txtfldpw.setPreferredSize(new Dimension(350,25));
        box.add(txtfldpw);
        panel.add(box);

        box = new Box(BoxLayout.X_AXIS);
        JLabel abfrage = new JLabel("Abfrage");
        abfrage.setPreferredSize(new Dimension(100,25));
        box.add(abfrage);

        JTextArea txtAbfrage = new JTextArea();
        txtAbfrage.setText("SELECT * FROM ARTIKEL");
        txtAbfrage.setPreferredSize(new Dimension(350,75));
        box.add(txtAbfrage);
        panel.add(box);

        JButton btnexe = new JButton("Ausführen");
        btnexe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                connectDb(txtfldurl.getText(), txtflduser.getText(), txtfldpw.getText(), txtAbfrage.getText());
            }
        });
        panel.add(btnexe);

        JButton btnlist = new JButton("Liste füllen");
        btnlist.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fillList(txtfldurl.getText(), txtflduser.getText(), txtfldpw.getText(), txtAbfrage.getText());
                panel.revalidate();
            }
        });
        panel.add(btnlist);

        txtausgabe = new JTextArea();
        txtausgabe.setPreferredSize(new Dimension(450,200));
        panel.add(txtausgabe);

        table = new JTable();
        scroller = new JScrollPane(table,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroller.setPreferredSize(new Dimension(450,200));
        panel.add(scroller);

        return panel;
    }

    private void connectDb(String driver, String user, String passwort, String cmd){

        try{
            Class.forName(driver);

            Connection conn = DriverManager
                    .getConnection("jdbc:postgresql://localhost/byceco", user, passwort);

            Statement stm = conn.createStatement();
            ResultSet res = stm.executeQuery(cmd);
            ResultSetMetaData metaData = res.getMetaData();
            int columns = metaData.getColumnCount();
            String ausgabe = new String();
            while(res.next()) {
                for (int i = 1; i <= columns; i++) {
                    ausgabe += res.getString(i) + " ";

                }
                ausgabe += "\n";
            }
            txtausgabe.setText(ausgabe);
            res.close();
            stm.close();
            conn.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }

    }

    private void fillList(String driver, String user, String passwort, String cmd){

        String[][] datenArray = null;
        String[] header = null;
        ResultSetMetaData metaData = null;
        DefaultTableModel model = null;
        int columns = 0;

        try{
            Class.forName(driver);
            Connection conn = DriverManager
                    .getConnection("jdbc:postgresql://localhost/byceco", user, passwort);

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
        model = new DefaultTableModel(datenArray, header);
        table.setModel(model);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
    }

    public static void main(String[] args) {

        Aufgabe2 frame = new Aufgabe2();
        frame.setTitle("QueryTool");
        frame.setSize(500,650);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
