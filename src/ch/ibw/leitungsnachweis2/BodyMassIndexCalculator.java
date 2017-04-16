package ch.ibw.leitungsnachweis2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Name und Vorname setzen
 *
 * Im Anschluss Datei senden an msferlazza@gmail.com
 */
public class BodyMassIndexCalculator implements ActionListener {
    private JFrame frame;

    // hier kommen alle Komponenten dier verwendet werden
    private JRadioButton rbMale = new JRadioButton("männlich", true);
    private JRadioButton rbFemale = new JRadioButton("weiblich", false);
    private JLabel labelGewicht = new JLabel("Gewicht in kg:");
    private JTextField txtGewicht = new JTextField();
    private JLabel labelGroesse = new JLabel("Grösse in m:");
    private JTextField txtGroesse = new JTextField();
    private JLabel labelBmi = new JLabel("BMI");
    private JTextField txtBmi = new JTextField();
    private JTextField mtxtMessage = new JTextField();
    private JButton btnBerechne = new JButton("berechne");
    private JButton btnabbrechen = new JButton("abbrechen");

    public BodyMassIndexCalculator() {
        frame = new JFrame("BodyMassIndex Calculator");
        frame.setLayout(new FlowLayout());
        Container c = frame.getContentPane();
        Box box = new Box(BoxLayout.X_AXIS);
        labelGewicht.setPreferredSize(new Dimension(225,25));
        box.add(labelGewicht);
        txtGewicht.setPreferredSize(new Dimension(225,25));
        box.add(txtGewicht);
        c.add(box);
        box = new Box(BoxLayout.X_AXIS);
        labelGroesse.setPreferredSize(new Dimension(225,25));
        box.add(labelGroesse);
        txtGroesse.setPreferredSize(new Dimension(225,25));
        box.add(txtGroesse);
        c.add(box);
        box = new Box(BoxLayout.X_AXIS);
        box.add(rbMale);
        box.add(rbFemale);
        c.add(box);
        box = new Box(BoxLayout.X_AXIS);
        labelBmi.setPreferredSize(new Dimension(225,25));
        box.add(labelBmi);
        txtBmi.setPreferredSize(new Dimension(225,25));
        box.add(txtBmi);
        c.add(box);
        box = new Box(BoxLayout.X_AXIS);
        box.add(mtxtMessage);
        mtxtMessage.setPreferredSize(new Dimension(350,25));
        c.add(box);
        box = new Box(BoxLayout.X_AXIS);
        btnBerechne.addActionListener(this);
        box.add(btnBerechne);
        btnabbrechen.addActionListener(this);
        box.add(btnabbrechen);
        c.add(box);



        frame.setSize(500,300);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == btnabbrechen) {
            System.exit(0);
        }

        if(e.getSource() == btnBerechne) {

            double weight = Double.parseDouble(txtGewicht.getText());//(double)(txtGewicht.getText());
            double height = Double.parseDouble(txtGroesse.getText()); //txtGroesse.getText();
            double bmi = weight / (height * height);
            txtBmi.setText(Double.toString(bmi));
            String bmiType = getBMIType(rbMale.isSelected(), bmi);
            mtxtMessage.setText(bmiType);
        }

        // hier Code ergänzen
        //
        //
    }

    public String getBMIType(boolean male, double bmi){
        String erg = "";
        if (male) {
            if (bmi<20) erg="Untergewicht";
            // else
            // else
        }
        else {
            if (bmi<19) erg="Untergewicht";
            //else
            //else
        }
        return erg;
    }

    public static void main(String[] args) {
        new BodyMassIndexCalculator();
    }

}
