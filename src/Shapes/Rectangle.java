package Shapes;

import java.awt.*;

public class Rectangle extends Shape {

    Rectangle(){

    }
    @Override
    public void draw(Graphics g) {
        printName();
        g.setColor(new Color(34, 0, 255));
        g.drawRect(9, 9, 301, 51);
        g.setColor(new Color(167, 255, 185));
        g.fillRect(10, 10, 300, 50);
    }

}
