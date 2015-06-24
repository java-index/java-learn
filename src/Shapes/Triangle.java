package Shapes;

import java.awt.*;

/**
 * Created by eco on 22.06.15.
 */
public class Triangle extends Shape {
    @Override
    protected void draw(Graphics g) {
        System.out.println("Triangle DRAW");
        g.setColor(new Color(48, 255, 192));
        g.drawPolygon(new Polygon(new int[]{150, 50, 200}, new int[]{50, 200, 200}, 3));
        g.fillPolygon(new Polygon(new int[]{150, 50, 200}, new int[]{50, 200, 200}, 3));
    }
}
