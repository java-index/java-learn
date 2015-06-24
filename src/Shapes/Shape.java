package Shapes;
import java.awt.Graphics;

public class Shape {
    protected void draw(Graphics g){
        throw new IllegalArgumentException("Can not draw shapes");
    }

    protected void printName(){
        System.out.println(this.getClass().getSimpleName());
    }

    protected void test(){
        System.out.println("Shape TEST");
    }

    public Shape(){
    }
}
