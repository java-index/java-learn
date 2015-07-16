package GRAPH;

import javax.swing.*;
import java.awt.*;
import java.awt.Color;

/**
 * Created by rabota on 10.07.15.
 */
public class Panel2 extends JPanel{
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.GRAY);
        g.drawRect(10, 10, 600, 600);

        g.setColor(Color.GREEN);
        g.drawRect(15, 15, 504, 504);

    }
}
