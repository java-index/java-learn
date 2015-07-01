package Shapes;

import java.awt.*;

/**
 * Created by eco on 22.06.15.
 */
public class Rectangle extends Shape {
    @Override
    public void draw(Graphics g) {
        printName();
        g.setColor(new Color(34, 0, 255));
        g.drawRect(9, 9, 301, 51);
        g.setColor(new Color(167, 255, 185));
        g.fillRect(10, 10, 300, 50);
    }
}
