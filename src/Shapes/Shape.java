package Shapes;
import java.awt.Graphics;

public abstract class Shape implements Drawable {

    protected void printName(){
        System.out.println(this.getClass().getSimpleName());
    }
}
