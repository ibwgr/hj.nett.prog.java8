package ch.ibw.kap_14;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**
 * Created by Nett on 08.10.2016.
 */
public class FrameMitFarbigenLabel extends JFrame {

    private Container c;

    public FrameMitFarbigenLabel(){

        c = getContentPane();
        c.setLayout(new BorderLayout(5,5));
        setJMenuBar(createJMenuBar());
        c.add(createJLabelPanel(),BorderLayout.WEST);
        c.add(createJButtonPanel(), BorderLayout.NORTH);
        c.add(createDivButtonPanel(), BorderLayout.SOUTH);
        c.add(createPictueLabel(), BorderLayout.CENTER);
        c.add(createJListPanel(),BorderLayout.EAST);

    }

    private JPanel createJLabelPanel() {

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3,1));
        FarbigesLabel orangesLabel = new FarbigesLabel("Oranges Label", Color.BLUE, Color.ORANGE);
        orangesLabel.setFont(new Font("SansSerif",Font.ITALIC, 16));
        FarbigesLabel blauesLabel = new FarbigesLabel("Blaues Label", Color.BLACK, Color.BLUE);
        blauesLabel.setFont(new Font("Monospaced", Font.BOLD, 20));
        FarbigesLabel gelbesLabel = new FarbigesLabel("Gelbes Label", Color.CYAN, Color.YELLOW);
        gelbesLabel.setFont(new Font("Serif",Font.ROMAN_BASELINE, 18));
        panel.add(orangesLabel);
        panel.add(blauesLabel);
        panel.add(gelbesLabel);
        return panel;
    }

    private JMenuBar createJMenuBar(){
        JMenuBar menuBar = new JMenuBar();
        JMenu datei = new JMenu("Datei");
        JMenuItem open = new JMenuItem("Öffnen");

        JMenuItem close = new JMenuItem("Schliessen");
        datei.add(open);
        datei.add(close);

        JMenu bearbeiten = new JMenu("Bearbeiten");
        JMenuItem copy = new JMenuItem("Kopieren");
        JMenuItem paste = new JMenuItem("Einfügen");
        bearbeiten.add(copy);
        bearbeiten.add(paste);

        menuBar.add(datei);
        menuBar.add(bearbeiten);

        return  menuBar;
    }

    private JPanel createJButtonPanel(){
        JPanel panel = new JPanel();
        JButton start = new JButton("Start");
        JButton stop = new JButton("Stop");
        JButton interval = new JButton("Interval");
        panel.setLayout(new GridLayout(1,3));
        panel.add(start);
        panel.add(stop);
        panel.add(interval);

        return panel;
    }

    private JLabel createPictueLabel(){
        Icon uhr = new ImageIcon("C:\\Users\\Nett\\Documents\\IBW\\Neon\\ProgrammierenJava8\\src\\ch\\ibw\\kap_14\\uhr.png");
        JLabel label = new JLabel("Zeit", uhr, JLabel.CENTER);
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.TOP);
        return  label;
    }

    private JPanel createDivButtonPanel(){
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1,3));
        ButtonGroup btnGrp = new ButtonGroup();
        JToggleButton toggleBtn = new JToggleButton("Toggle-Button");
        JCheckBox cbx = new JCheckBox("CheckBox");
        JRadioButton radiobtn = new JRadioButton("Radio-Button");
        //Components zu ButtonGroup hinzufügen
        btnGrp.add(toggleBtn);
        btnGrp.add(radiobtn);
        btnGrp.add(cbx);
        //Components zu JPanel hinzufügen
        panel.add(toggleBtn);
        panel.add(radiobtn);
        panel.add(cbx);
        return panel;
    }

    private JPanel createJListPanel(){
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3,1));
        panel.setPreferredSize(new Dimension(120,50));
        String[] namen = new String[]{"Meier","Müller","Berger"};
        JComboBox nachnamen = new JComboBox(namen);

        JComboBox vornamen = new JComboBox();
        vornamen.addItem("Peter");
        vornamen.addItem("Anna");
        vornamen.addItem("Paul");
        vornamen.addItem("Eva");

        String[]berufe = new String[]{"Bauer","Elektriker","Informatiker","Arzt","Kaufmann","Mechaniker","Lehrer","Programmierer"};
        JList liste = new JList(berufe);
        JScrollPane listScrollPane = new JScrollPane();
        listScrollPane.setViewportView(liste);

        panel.add(vornamen);
        panel.add(nachnamen);
        panel.add(listScrollPane);

        return  panel;
    }

    public static void main(String[] args) {

        FrameMitFarbigenLabel frame = new FrameMitFarbigenLabel();
        frame.setTitle("Frame mit Componenten");
        frame.setSize(600,500);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
