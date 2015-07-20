package Razozli;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by rabota on 20.07.15.
 */
public class Circle extends JPanel {
    private int x = 0;
    private int y = 0;
    private int size = 50;
    private int width = 500;
    private int height = 500;


    public Circle() {
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.RED);
        g.fillOval(this.x, this.y, 50, 50);
    }
}
