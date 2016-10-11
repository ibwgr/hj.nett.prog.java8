package ch.ibw.kap_14;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Nett on 08.10.2016.
 */
public class FarbigesLabel extends JLabel {

    public FarbigesLabel(String text, Color fG, Color bG){
        super(text);
        setOpaque(true);
        setForeground(fG);
        setBackground(bG);
    }
}
