package GRAPH;

import javax.swing.*;
import java.awt.*;

/**
 * Created by rabota on 08.07.15.
 */
public class Frame extends JPanel {

    public Frame(){
        JFrame frame = new JFrame();
        frame.setVisible(true);
        frame.setLocation(100, 300);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        frame.getContentPane().add(this);

        frame.pack();
        frame.setMinimumSize(new Dimension(800, 600));

        repaint();
    }

    public static void main(String[] args) {
        new Frame();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.GRAY);
        g.drawRect(10, 10, 500, 500);

        g.setColor(Color.lightGray);
        g.drawRect(8, 8, 504, 504);
    }
}
