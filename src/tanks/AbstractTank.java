package tanks;


import java.awt.*;
import java.awt.image.ImageObserver;

import tanks.ActionField;

public abstract class AbstractTank implements Destroyable, Drawable{

    protected int speed = 5;

    private int x;
    private int y;

    private boolean isDestroyed = false;

    private Direction direction;
    private ActionField af;
    private BattleField bf;

    protected Color tankColor;
    protected Color towerColor;

    protected Image [] images;

    public AbstractTank(ActionField af, BattleField bf){
        this(af, bf, 128, 512, Direction.LEFT );
    }

    public AbstractTank(ActionField af, BattleField bf, int x, int y, Direction direction){
        this.af = af;
        this.bf = bf;
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public void turn(Direction direction) throws Exception{
        this.direction = direction;
        af.processTurn(direction.getId());
    }

    public void draw(Graphics g) {
        if (!isDestroyed) {
                g.drawImage(images[getDirection().getId()-1], getX(), getY(), new ImageObserver() {
                    @Override
                    public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
                        return false;
                    }
                });
            }
        }

    public void move() throws Exception{
        af.processMove(this);
    }

    public void fire() throws Exception{
        Bullet bullet = new Bullet((x + 25),(y + 25), direction.getId());
        af.processFire(bullet);
    }


//    public boolean isDestroyed(){
//        return destroyed;
//    }

    public void destroy() throws InterruptedException {
        x = -100;
        y = -100;
        af.repaint();
        Thread.sleep(3000);
        String AggressorQuadrant = af.getAggreQuadrant();
        y=Integer.parseInt(AggressorQuadrant.split("_")[0]);
        x=Integer.parseInt(AggressorQuadrant.split("_")[1]);
        af.repaint();

    }

    public void moveToQuadrant(int v, int h) throws Exception{
    }

    public void moveRandom() throws Exception{
    }

    public void clean() throws Exception{
    }


    public void updateX(int x) {
        this.x += x;
    }

    public void updateY(int y) {
        this.y += y;
    }

    public Direction getDirection() {
        return direction;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getSpeed() {
        return speed;
    }
}