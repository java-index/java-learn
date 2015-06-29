package Shapes;

import java.awt.Color;
import java.awt.Graphics;

public class Circle extends Shape {
    @Override
    public void draw(Graphics g) {
        printName();
        g.setColor(new Color(255, 0, 0));
        g.drawOval(200, 200, 100, 100);
        g.setColor(new Color(0, 18, 255));
        g.fillOval(200, 200, 100, 100);
    }
}