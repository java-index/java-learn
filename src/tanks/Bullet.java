package tanks;

import java.awt.Color;
import java.awt.Graphics;

public class Bullet implements Drawable, Destroyable {

    private int x;
    private int y;
    private int direction;

    private int Speed = 5;

    public Bullet (int x, int y, int direction){
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public void updateX (int x){
        this.x += x;
    }

    public void updateY (int y){
        this.y += y;
    }

    public void destroy (){
        x = -100;
        y = -100;
    }

    public void draw(Graphics g) {
        g.setColor(new Color(255, 255, 0));
        g.fillRect(this.getX(), this.getY(), 14, 14);
    }

    public int getSpeed(){

        return Speed;

    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public int getDirection(){
        return direction;
    }
}