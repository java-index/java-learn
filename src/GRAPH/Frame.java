package GRAPH;

import java.awt.*;
import javax.swing.*;

/**
 * Created by rabota on 10.07.15.
 */
public class Frame extends JFrame {

    public Frame(){
        super("MY PANEL");
        setVisible(true);
        setLocation(100, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pack();
        setMinimumSize(new Dimension(800, 600));
    }

//
//    public <T extends JPanel> void getPanel(T p) {
//        frame.add(p);
//        p.repaint();
//    }
}
