package Shapes;

import java.awt.event.ActionListener;

public class Launcher {
    public static void main(String[] args){
        Drawable [] shapes = new Shape[4];

        //shapes[0] = new Shape();
        shapes[0] = new Circle();
        shapes[1] = new Rectangle();
        shapes[2] = new Triangle();
        shapes[3] = new Square();

        Rectangle rec = (Rectangle)shapes[1];

    }
}
