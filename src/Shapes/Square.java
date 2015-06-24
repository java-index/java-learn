package Shapes;

import java.awt.*;

public class Square extends Rectangle {

    @Override
    protected void draw(Graphics g) {
        System.out.println("Square DRAW");
        g.setColor(new Color(34, 0, 255));
        g.drawRect(349, 149, 51, 51);
        g.setColor(new Color(255, 0, 52));
        g.fillRect(350, 150, 50, 50);
    }
}
