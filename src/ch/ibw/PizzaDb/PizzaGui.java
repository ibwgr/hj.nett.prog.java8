package ch.ibw.PizzaDb;

import ch.ibw.pizzaAbstract.Zutat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Nett on 26.10.2016.
 */
public class PizzaGui extends JFrame {

    private Container c;
    private JPanel panelWest;
    private JPanel panelEast;
    private JPanel panelCenter = null;
    private JRadioButton[] prodRadioBtns = null;
    private JButton btnZutaten = null;
    private JTextArea textArea = null;
    private DbConnection dbConn = null;
    private JComboBox comboboxRezepte = null;
    private String[] rezeptNamen = null;
    private Zutat[] zutaten = null;

    public PizzaGui(){

        dbConn = new DbConnection("//C:/Users/Nett/Documents/Pizza.accdb");
        c = getContentPane();

        panelWest = new JPanel();
        panelCenter = new JPanel();

        rezeptNamen = dbConn.getRezepte();
        comboboxRezepte = new JComboBox(rezeptNamen);

        textArea = new JTextArea();
        panelCenter.add(textArea);

        btnZutaten = new JButton("Zeige Zutaten");
        btnZutaten.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                zutaten = dbConn.selectRezeptDetails((String) comboboxRezepte.getSelectedItem());

                String text = "";
                for(Zutat zutat : zutaten){
                    text += zutat.getName() + "\n";

                }
                textArea.setText(text);
            }
        });

        panelWest.setLayout(new GridLayout(5,1));
        panelWest.add(comboboxRezepte);
        panelWest.add(btnZutaten);

        c.setLayout(new BorderLayout(5,5));
        c.add(panelWest, BorderLayout.WEST);
        c.add(createPanelEast(), BorderLayout.EAST);
        c.add(panelCenter, BorderLayout.CENTER);

    }

    private JPanel createPanelEast(){

        panelEast = new JPanel();
        panelEast.setLayout(new GridLayout(15,1));
        String[] produkte = dbConn.getAllProducts();
        prodRadioBtns = new JRadioButton[produkte.length];

        for(int i = 0; i < produkte.length; i++){

            JRadioButton radioBtn = new JRadioButton(produkte[i]);
            prodRadioBtns[i] = radioBtn;
            panelEast.add(radioBtn);
        }

        return panelEast;
    }


    public static void main(String[] args) {

        PizzaGui frame = new PizzaGui();
        frame.setTitle("Pizzaverwaltung");
        frame.setSize(600,500);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
