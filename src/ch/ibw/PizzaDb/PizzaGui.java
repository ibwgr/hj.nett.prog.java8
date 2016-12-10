package ch.ibw.PizzaDb;

import ch.ibw.pizzaAbstract.Zutat;
import ch.ibw.pizzaInterface.IPizza;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * Created by Nett on 26.10.2016.
 */
public class PizzaGui extends JFrame {

    private Container c;
    private JPanel panelWest;
    private JPanel panelEast;
    private JPanel panelCenter = null;
    private JPanel panelZutaten = null;
    private JRadioButton[] prodRadioBtns = null;
    private JRadioButton[] zutatenRadioBtns = null;
    private TextField[] gewichte = null;
    private JTextArea textArea = null;
    private DbConnection dbConn = null;
    private JComboBox comboboxRezepte = null;
    private String[] rezeptNamen = null;
    private Zutat[] rezeptZutaten = null;
    private JTextField txtfldZutatNeu = null;
    private Zutat[] zutaten = null;
    private JTextField zutatName = null;
    private JTextField zutatGewicht = null;

    public PizzaGui(){

        dbConn = new DbConnection("//C:/Users/Nett/Documents/Pizza.accdb");
        c = getContentPane();

        panelWest = new JPanel();
        panelCenter = new JPanel();

        textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setBackground(Color.LIGHT_GRAY);
        textArea.setPreferredSize(new Dimension(320,200));

        rezeptNamen = dbConn.getRezepte();
        comboboxRezepte = new JComboBox(rezeptNamen);
        comboboxRezepte.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                getZutaten();
            }
        });

        panelCenter.setLayout(new BorderLayout());
        panelCenter.add(textArea, BorderLayout.NORTH);
        panelCenter.add(createPanelZutaten(), BorderLayout.CENTER);

        txtfldZutatNeu = new JTextField();
        txtfldZutatNeu.setBorder(new TitledBorder("Rezept:"));
        txtfldZutatNeu.setPreferredSize(new Dimension(120,35));

        zutatName = new JTextField();
        zutatName.setBorder(new TitledBorder("Zutat:"));
        zutatName.setPreferredSize(new Dimension(120,35));

        zutatGewicht = new JTextField();
        zutatGewicht.setBorder(new TitledBorder("Gewicht:"));
        zutatGewicht.setPreferredSize(new Dimension(120,35));

        panelWest.setLayout(new FlowLayout());
        panelWest.setPreferredSize(new Dimension(120,250));
        panelWest.add(comboboxRezepte);
        panelWest.add(txtfldZutatNeu);
        panelWest.add(createButtonRezept());
        panelWest.add(zutatName);
        panelWest.add(zutatGewicht);
        panelWest.add(createZutatButton());

        c.setLayout(new BorderLayout(5,5));
        c.add(panelWest, BorderLayout.WEST);
        c.add(createPanelEast(), BorderLayout.EAST);
        c.add(panelCenter, BorderLayout.CENTER);

        getZutaten();
    }

    private void getZutaten() {
        rezeptZutaten = dbConn.selectRezeptDetails((String) comboboxRezepte.getSelectedItem());

        String text = "Produkt\t\tGramm\tkCal\tPreis\n";
        text += "---------------------------------------------------------------------------------------------------\n";
        for(Zutat zutat : rezeptZutaten){
            text += zutat.getName() + "\t\t";
            text += zutat.getGewicht() + "\t";
            text += zutat.getBrennwert() + "\t";
            text += zutat.getPreis() + " Fr.\n";

        }
        int kal = 0;
        double preis = 0;
        for(Zutat zutat : rezeptZutaten){
            kal += zutat.getBrennwert();
            preis += zutat.getPreis();
        }
        text += "---------------------------------------------------------------------------------------------------\n";
        text += "Basispreis: \t\t\t\t"+ IPizza.BASISPREIS +"Fr.\n";
        text += "Total:\t\t\t" + kal + "\t" + (preis + IPizza.BASISPREIS) + "Fr.\n";
        textArea.setText(text);
    }

    private JPanel createPanelEast(){

        panelEast = new JPanel();
        panelEast.setLayout(new FlowLayout(FlowLayout.LEFT));
        panelEast.setPreferredSize(new Dimension(120,20));
        String[] produkte = dbConn.getAllProducts();
        prodRadioBtns = new JRadioButton[produkte.length];

        for(int i = 0; i < produkte.length; i++){
            JRadioButton radioBtn = new JRadioButton(produkte[i]);
            prodRadioBtns[i] = radioBtn;
            radioBtn.setPreferredSize(new Dimension(120,20));
            panelEast.add(radioBtn);
        }

        return panelEast;
    }

    private JButton createButtonRezept(){
        JButton btnRezeptNeu = new JButton("Rezept anlegen");
        btnRezeptNeu.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                String cmdString1 = "INSERT INTO Rezept (RezeptName) VALUES ('"+ txtfldZutatNeu.getText() +"')";
                dbConn.insertCommand(cmdString1);

                for(JRadioButton rdoBtn : zutatenRadioBtns) {
                    if (rdoBtn.isSelected()) {
                        String cmdString2 = "INSERT INTO Rezeptdetails (ZutatName, RezeptName) " +
                                "VALUES ('" + rdoBtn.getText() + "', '" + txtfldZutatNeu.getText() + "')";

                        dbConn.insertCommand(cmdString2);
                    }
                }
            }
        });
        return btnRezeptNeu;
    }

    private JButton createZutatButton(){
        JButton btnRezeptNeu = new JButton("Zutat anlegen");
        btnRezeptNeu.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                String produktName = "";
                for(JRadioButton rdoBtn : prodRadioBtns){
                    if(rdoBtn.isSelected()){
                        produktName = rdoBtn.getText();
                    }
                }

                String cmdString = "INSERT INTO Zutat (ZutatName, ProduktID, ZutatGewicht) " +
                        "SELECT '"+ zutatName.getText() +"', ProduktID, " + zutatGewicht.getText() + " "  +
                        "FROM Produkt " +
                        "WHERE ProduktName='" + produktName + "'";
                dbConn.insertCommand(cmdString);
            }
        });
        return btnRezeptNeu;
    }

    private JPanel createPanelZutaten(){

        zutaten = dbConn.selectZutaten();

        panelZutaten = new JPanel();
        panelZutaten.setLayout(new FlowLayout(FlowLayout.LEFT));
        zutatenRadioBtns = new JRadioButton[zutaten.length];

        for(int i = 0; i < zutaten.length; i++){
            JRadioButton btn = new JRadioButton(zutaten[i].getName());
            btn.setPreferredSize(new Dimension(120,20));
            zutatenRadioBtns[i] = btn;
            panelZutaten.add(btn);

            TextField txtfld = new TextField();
            txtfld.setText(zutaten[i].getGewicht() + "");
            txtfld.setPreferredSize(new Dimension(40,20));
            txtfld.setEditable(false);
            txtfld.setBackground(Color.LIGHT_GRAY);
            panelZutaten.add(txtfld);

        }

        return  panelZutaten;
    }

    public static void main(String[] args) {

        PizzaGui frame = new PizzaGui();
        frame.setTitle("Pizzaverwaltung");
        frame.setSize(670,500);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
