package ch.ibw.datenbank;

import javax.swing.*;
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

    public Aufgabe2(){

        c = getContentPane();

        c.add(createPanel());

    }

    private JPanel createPanel(){
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.LEFT));

        Box box = new Box(BoxLayout.X_AXIS);

        JLabel url = new JLabel("URL");
        url.setPreferredSize(new Dimension(100,25));
        box.add(url);
        JTextField txtfldurl = new JTextField();
        txtfldurl.setPreferredSize(new Dimension(250,25));
        txtfldurl.setText("org.postgresql.Driver");
        box.add(txtfldurl);
        panel.add(box);

        box = new Box(BoxLayout.X_AXIS);
        JLabel user = new JLabel("Benutzer");
        user.setPreferredSize(new Dimension(100,25));
        box.add(user);
        JTextField txtflduser = new JTextField();
        txtflduser.setText("postgres");
        txtflduser.setPreferredSize(new Dimension(250,25));
        box.add(txtflduser);
        panel.add(box);

        box = new Box(BoxLayout.X_AXIS);
        JLabel password = new JLabel("Passwort");
        password.setPreferredSize(new Dimension(100,25));
        box.add(password);
        JTextField txtfldpw = new JTextField();
        txtfldpw.setPreferredSize(new Dimension(250,25));
        box.add(txtfldpw);
        panel.add(box);

        box = new Box(BoxLayout.X_AXIS);
        JLabel abfrage = new JLabel("Abfrage");
        abfrage.setPreferredSize(new Dimension(100,25));
        box.add(abfrage);

        JTextArea txtAbfrage = new JTextArea();
        txtAbfrage.setPreferredSize(new Dimension(250,75));
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

        txtausgabe = new JTextArea();
        txtausgabe.setPreferredSize(new Dimension(350,250));
        panel.add(txtausgabe);

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
            String ausgabe = null;
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

    public static void main(String[] args) {

        Aufgabe2 frame = new Aufgabe2();
        frame.setTitle("QueryTool");
        frame.setSize(400,500);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
