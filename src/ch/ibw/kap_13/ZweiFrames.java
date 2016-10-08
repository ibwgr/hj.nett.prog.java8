package ch.ibw.kap_13;

import Prog1Tools.IOTools;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Nett on 08.10.2016.
 */
public class ZweiFrames extends JFrame {

    private Container c;

    public ZweiFrames() {
        c = getContentPane();
        c.setLayout(new FlowLayout());
    }

    public static void main(String[] args) {

        ZweiFrames fenster = new ZweiFrames();
        fenster.setSize(400,250);
        fenster.setTitle("Titel nach Programmstart");
        fenster.setVisible(true);
        fenster.setDefaultCloseOperation(EXIT_ON_CLOSE);

        String titel = IOTools.readLine("Bitte Titel eingeben");
        fenster.setTitle(titel);
        System.out.println("<-'");

        int hoehe = IOTools.readInt("Neue Höhe eingeben: ");
        int breite = IOTools.readInt("Neue Breite eingeben: ");
        fenster.setSize(breite,hoehe);
        System.out.println("<-'");

        IOTools.readLine("Fenster unsichtbar machen mit Enter: ");
        fenster.setVisible(false);
        System.out.println("<-'");

        IOTools.readLine("Fenster wieder sichtbar machen mit Enter");
        fenster.setVisible(true);
        System.out.println("<-'");

        IOTools.readLine("Fenster aud die Koordinaten 300,10 verschieben mit Enter: ");
        fenster.setLocation(300,10);
        System.out.println("<-'");

        IOTools.readLine("Neues Fenster erstellen mit Enter: ");
        ZweiFrames fenster2 = new ZweiFrames();
        fenster2.setTitle("Zweites Fenster erstellen mit Enter: ");
        fenster2.setSize(300,150);
        fenster2.setVisible(true);
        fenster2.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
