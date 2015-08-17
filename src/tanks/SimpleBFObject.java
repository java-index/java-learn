package tanks;

import java.awt.*;
import java.awt.image.ImageObserver;


public abstract class SimpleBFObject implements BFObject {

    private int x;
    private int y;
    private int idx = 0;
    private int f = 0;

    protected int armor = 0;
    protected Color color;
    protected Image image;

    protected Image [] images;

    private boolean isDestroyed = false;

    public SimpleBFObject(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void destroy() {

        if (armor == 0){
            isDestroyed = true;
        } else {armor --;}
    }

    @Override
    public void draw(Graphics g) {
        if (!isDestroyed) {

            if (image != null) {
                g.drawImage(this.image, this.x, this.y, new ImageObserver() {
                    @Override
                    public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
                        return false;
                    }
                });
                idx++;
            } else {
                g.setColor(this.color);
                g.fillRect(this.getX(), this.getY(), 64, 64);
                System.out.println("empty" + f);
                f++;
            }
        }
    }

    public boolean isDestroyed (){
        return isDestroyed;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }
}