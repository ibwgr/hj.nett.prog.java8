package ch.ibw.kap_13;

import java.awt.*;

/**
 * Created by Nett on 04.10.2016.
 */
public class FrameOhneInhalt {

    public static void main(String[] args) {
        Frame fenster = new Frame();
        fenster.setTitle("AWT-Fenster");
        fenster.setSize(300,150);
        fenster.getMenuBar();
        fenster.setVisible(true);
    }
}
