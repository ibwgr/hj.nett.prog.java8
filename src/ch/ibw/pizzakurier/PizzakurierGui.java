package ch.ibw.pizzakurier;

import ch.ibw.postgresql.ConnDbPizzakurier;
import ch.ibw.postgresql.Pizza;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nett on 20.11.2016.
 */
public class PizzakurierGui extends JFrame{

    private ConnDbPizzakurier db = null;
    private Container c = null;
    private JPanel buttenPanel = null;
    private List<Pizza> pizzaListe = null;
    private List<Box> boxlist = null;
    private boolean editable = false;

    public PizzakurierGui() {

        boxlist = new ArrayList<>();
        db = new ConnDbPizzakurier();
        pizzaListe = db.getPizzas();
        c = getContentPane();
        c.setLayout(new BorderLayout(5,5));

        c.add(createButtonPanel(), BorderLayout.NORTH);

        c.add(createPizzaPanel(), BorderLayout.CENTER);

        buttenPanel = new JPanel();
    }

    public static void main(String[] args) {

        PizzakurierGui gui = new PizzakurierGui();
        gui.setTitle("Pizzakurier");
        gui.setSize(850,500);
        gui.setVisible(true);
        gui.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private JPanel createButtonPanel(){

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.LEFT));

        JButton btnBestellen = new JButton("Bestellen");
        btnBestellen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String orderComment = null;
                String username =  JOptionPane.showInputDialog("Benutzer-Name eingeben:");

                if(username != null && db.existUser(username)){
                    orderComment = JOptionPane.showInputDialog("Bestell-Kommentar:");
                    if(orderComment == null){
                        orderComment = "";
                    }
                }
                else{
                    JOptionPane.showMessageDialog(panel, "Der Username " + username + " konnte nicht gefunden werden!");
                    return;
                }

                if(db.makeOrder(orderComment,username )<= 0) {
                    JOptionPane.showMessageDialog(panel, "Die Bestellung konnte nicht abgeschlossen werden!");
                    return;
                }

                for(Box b : boxlist){
                    JTextField txtfldAnzahl = (JTextField)b.getComponent(0);
                    int anzahl = Integer.parseInt(txtfldAnzahl.getText());
                    if(anzahl > 0){
                        String pizzaname = ((JTextField)b.getComponent(1)).getText();
                        String kommentar = ((JTextField)b.getComponent(4)).getText();
                        if(db.insertOrderDetails(anzahl,pizzaname,kommentar) <= 0){
                            JOptionPane.showMessageDialog(panel, "Die Bestellung konnte nicht abgeschlossen werden!");
                            return;
                        }
                    }

                }

                JOptionPane.showMessageDialog(panel, "Die Bestellung konnte erfolgreich abgeschlossen werden!");
            }
        });
        panel.add(btnBestellen);

        JButton btnEdit = new JButton("Pizza ändern");
        btnEdit.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                saveChangedPizzaList(btnEdit);
            }
        });
        panel.add(btnEdit);

        JButton btnNewPizza = new JButton("Neue Pizza anlegen");
        btnNewPizza.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDialog w = new JDialog();
                Container c = w.getContentPane();
                JPanel panel = new JPanel();
                JTextField name = new JTextField();
                name.setPreferredSize(new Dimension(120,25));
                JTextField preis = new JTextField();
                preis.setPreferredSize(new Dimension(120,25));
                JTextField beschreibung = new JTextField();
                beschreibung.setPreferredSize(new Dimension(120,25));
                panel.add(name);
                panel.add(preis);
                panel.add(beschreibung);
                c.add(panel);
                w.setSize(200,200);
                w.setVisible(true);
            }
        });
        panel.add(btnNewPizza);
        return panel;
    }

    private void saveChangedPizzaList(JButton btnEdit) {

        List<Pizza> changedPizzaList = new ArrayList<Pizza>();

        if(!editable) {
            for (Box b : boxlist) {
                ((JTextField) b.getComponent(0)).setEditable(false);
                ((JTextField) b.getComponent(1)).setEditable(false);
                ((JTextField) b.getComponent(2)).setEditable(true);
                ((JTextField) b.getComponent(3)).setEditable(true);
                ((JTextField) b.getComponent(4)).setEditable(false);
            }
            btnEdit.setText("Speichern");
            editable = true;
            revalidate();
        }else{
            for (Box b : boxlist) {
                ((JTextField) b.getComponent(0)).setEditable(true);
                ((JTextField) b.getComponent(1)).setEditable(false);
                ((JTextField) b.getComponent(2)).setEditable(false);
                ((JTextField) b.getComponent(3)).setEditable(false);
                ((JTextField) b.getComponent(4)).setEditable(true);
                String pizzaname = ((JTextField)b.getComponent(1)).getText();
                String sPreis = ((JTextField)b.getComponent(2)).getText();
                double preis = Double.parseDouble(sPreis.substring(0,sPreis.length()-4));
                String beschreibung = ((JTextField)b.getComponent(3)).getText();
                Pizza p = new Pizza(pizzaname,preis,beschreibung);
                changedPizzaList.add(p);
            }
            btnEdit.setText("Pizza ändern");
            editable = false;
            db.modifyPizza(changedPizzaList);
        }
    }

    private JPanel createPizzaPanel(){
        JPanel pizzapanel = new JPanel();
        pizzapanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        List<Box> boxlist = createPizzaBox(pizzaListe);
        for(Box b : boxlist) {
            pizzapanel.add(b);
        }
        return pizzapanel;
    }

    private List<Box> createPizzaBox(List<Pizza> pizzaListe){

        for(Pizza p: pizzaListe) {

            JTextField txtfld = null;
            JButton btn = null;

            Box box = new Box(BoxLayout.X_AXIS);

            txtfld = new JTextField("0");
            txtfld.setBorder(new TitledBorder("Anzahl"));
            txtfld.setPreferredSize(new Dimension(60,35));
            box.add(txtfld);

            txtfld = new JTextField(p.getName());
            txtfld.setBorder(new TitledBorder("Pizza"));
            txtfld.setPreferredSize(new Dimension(150,35));
            txtfld.setEditable(false);
            box.add(txtfld);

            txtfld = new JTextField(p.getPreis() + " Fr.");
            txtfld.setBorder(new TitledBorder("Preis"));
            txtfld.setPreferredSize(new Dimension(50,35));
            txtfld.setEditable(false);
            box.add(txtfld);

            txtfld = new JTextField(p.getBeschreibung());
            txtfld.setBorder(new TitledBorder("Beschreibung"));
            txtfld.setPreferredSize(new Dimension(270,35));
            txtfld.setEditable(false);
            box.add(txtfld);

            txtfld = new JTextField();
            txtfld.setBorder(new TitledBorder("Kommentar"));
            txtfld.setPreferredSize(new Dimension(270,35));
            box.add(txtfld);

            boxlist.add(box);
        }

        return boxlist;
    }

}
