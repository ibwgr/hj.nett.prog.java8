package ch.ibw.kap_15;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Created by Nett on 22.11.2016.
 */
public class SwingEventsFrame extends JFrame{


    private Dimension screenSize = null;
    private double screenHight;
    private double screenWith;
    private JDialog dlg = null;

    public SwingEventsFrame() {

        screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        screenHight = screenSize.getHeight();
        screenWith = screenSize.getWidth();

        this.addComponentListener(new ComponentAdapter() {

            @Override
            public void componentMoved(ComponentEvent e) {
                Dimension frameSize = getSize();
                double hight = frameSize.getHeight();
                double with = frameSize.getWidth();
                Point p = getLocation();
                double posX = p.getX();
                double posY = p.getY();

                if(screenHight > hight && screenWith > with) {
                    if (screenWith - with - posX < 20) {
                        setLocation((int) (screenWith - with), (int) getLocation().getY());
                    }
                    if (posX < 20) {
                        setLocation(0, (int) getLocation().getY());
                    }
                    if (screenHight - hight - posY < 20) {
                        setLocation((int) getLocation().getX(), (int) (screenHight - hight));
                    }
                    if (posY < 20) {
                        setLocation((int) getLocation().getX(), 0);
                    }
                }
            }

        });

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setTitle("X = " + e.getX() + " Y = " + e.getY());
            }
        });

        dlg = new JDialog(this);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                JOptionPane.showMessageDialog(getParent(), "Wirklich beenden?");
                System.exit(0);

            }

            @Override
            public void windowActivated(WindowEvent e) {
                dlg.dispose();
            }

            @Override
            public void windowDeactivated(WindowEvent e) {
                dlg.setTitle("Window minimiert");
                dlg.setSize(250,100);
                dlg.setLocation(300,300);
                dlg.setVisible(true);
            }
        });

        addKeyListener(new KeyEvents());
    }


    public class KeyEvents extends KeyAdapter{

        KeyStroke ks = KeyStroke.getKeyStroke('g',InputEvent.ALT_MASK);
        @Override
        public void keyPressed(KeyEvent e) {
           if(e.getKeyCode() == KeyEvent.VK_ALT  && e.getKeyCode() == KeyEvent.VK_5){
                JOptionPane.showMessageDialog(getParent(),"Taste: " + e.getKeyChar());
           }

        }

    }


    public static void main(String[] args) {

        SwingEventsFrame frame = new SwingEventsFrame();
        frame.setSize(600,200);
        frame.setTitle("Man nennt es \"Das Fenster\"");
        frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        frame.setVisible(true);

    }

}
