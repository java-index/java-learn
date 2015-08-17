package tanks;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class ActionField extends JPanel {

    private static final long serialVersionUID = 1L;

    final boolean COLORDED_MODE = false;

    private BattleField battleField;
    private AbstractTank tank;
    private AbstractTank tankA;
    private Bullet bullet;

    public String aggreQuadrant;

    void runTheGame() throws Exception {

//        processDestroyShtab(tankA);
//        moveRandom(tank);
        clean(tank);

    }


    public String getQuadrant(int x, int y) {

        return y / 64 + "_" + x / 64;

    }

    public static void main(String[] args) throws Exception {

        ActionField af = new ActionField();
        af.runTheGame();

    }

    public ActionField() throws Exception {

        battleField = new BattleField();
        tank = new T34(this, battleField);
        String AggressorQuadrant = getAggreQuadrant();
        tankA = new T34(this, battleField,
                Integer.parseInt(AggressorQuadrant.split("_")[1]), Integer.parseInt(AggressorQuadrant.split("_")[0]), Direction.UP);
        bullet = new Bullet(-100, -100, -1);

        JFrame frame = new JFrame("BATTLE FIELD, DAY 2");
        frame.setLocation(550, 150);
        frame.setMinimumSize(new Dimension(battleField.getBfWidth()+ 10, battleField.getBfHeight() + 40));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().add(this);
        frame.pack();
        frame.setVisible(true);

    }

    public String getQuadrantXY(int v, int h) {
        int x = v;
        x = (x - 1) * 64;
        int y = h;
        y = (y - 1) * 64;
        return (x + "_" + y);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int i = 0;
        Color cc;
        for (int v = 0; v < 9; v++) {
            for (int h = 0; h < 9; h++) {
                if (COLORDED_MODE) {
                    if (i % 2 == 0) {
                        cc = new Color(252, 241, 177);
                    } else {
                        cc = new Color(233, 243, 255);
                    }
                } else {
                    cc = new Color(180, 180, 180);
                }
                i++;
                g.setColor(cc);
                g.fillRect(h * 64, v * 64, 64, 64);
            }
        }

//        for (int j = 0; j < battleField.getDimentionY(); j++) {
//            for (int k = 0; k < battleField.getDimentionX(); k++) {
//                if (battleField.scanQuadrant(j, k).equals("B")) {
//                    String coordinates = getQuadrantXY(j + 1, k + 1);
//                    int separator = coordinates.indexOf("_");
//                    int y = Integer.parseInt(coordinates.substring(0, separator));
//                    int x = Integer.parseInt(coordinates.substring(separator + 1));
//                    g.setColor(new Color(0, 0, 255));
//                    g.fillRect(x, y, 64, 64);
//                }
//            }
//        }

        battleField.draw(g);
        tank.draw(g);
        tankA.draw(g);
        bullet.draw(g);

    }

    public void clean(AbstractTank tank) throws Exception {
        this.tank = tank;
        moveToQuadrant(9, 9);
        tank.turn(Direction.LEFT);
        for (int newX = 8; newX >= 0; newX--) {
            namberShot(newX);
            tank.turn(Direction.UP);
            processMove(tank);
            tank.turn(Direction.LEFT);
        }
    }


    public void processMove(AbstractTank tank) throws Exception {
        this.tank = tank;
        System.out.println(tank.getDirection());

        int step = 1;
        int covered = 0;

        // check limits x: 0, 513; y: 0, 513
        if ((tank.getDirection().getId() == 1 && tank.getY() == 0) || (tank.getDirection().getId() == 2 && tank.getY() >= 512)
                || (tank.getDirection().getId() == 3 && tank.getX() == 0) || (tank.getDirection().getId() == 4 && tank.getX() >= 512)) {
            System.out.println("[illegal move] direction: " + " tankX: " + tank.getX() + ", tankY: " + tank.getY());
            return;
        }

        tank.turn(tank.getDirection());
        int nextX = 0;
        int nextY = 0;

        while (covered < 64) {
            if (tank.getDirection().getId() == 1) {
                nextX = tank.getX() / 64;
                nextY = (tank.getY() - 1) / 64;
                BFObject bfObject = battleField.scanQuadrant(nextY, nextX);

                if (!bfObject.isDestroyed() && (!(bfObject instanceof Blank)))
                {
                    tank.fire();
                    System.out.println(nextY + "---" + nextX);
                    System.out.println(tankA.getX() / 64 + "___" + tankA.getY() / 64);
                }
                tank.updateY(-step);
                System.out.println("[move up] direction: " + Direction.UP + " tankX: " + tank.getX() + ", tankY: " + tank.getY());
            } else if (tank.getDirection().getId() == 2) {
                nextX = tank.getX() / 64;
                nextY = (tank.getY() + 64) / 64;//+64
                BFObject bfObject = battleField.scanQuadrant(nextY, nextX);

                if (!bfObject.isDestroyed() && (!(bfObject instanceof Blank)))
                {
                    tank.fire();
                }
                tank.updateY(step);
                System.out.println("[move down] direction: " + " tankX: " + tank.getX() + ", tankY: " + tank.getY());
            } else if (tank.getDirection().getId() == 3 && tank.getX() > 0) {
                nextX = (tank.getX() - 1) / 64;
                nextY = tank.getY() / 64;
                BFObject bfObject = battleField.scanQuadrant(nextY, nextX);

                if (!bfObject.isDestroyed() && (!(bfObject instanceof Blank)))
                {
                    tank.fire();
                }
                tank.updateX(-step);
                System.out.println("[move left] direction: " + " tankX: " + tank.getX() + ", tankY: " + tank.getY());
            } else {
                nextX = (tank.getX() + 64) / 64;
                nextY = tank.getY() / 64;
                BFObject bfObject = battleField.scanQuadrant(nextY, nextX);

                if (!bfObject.isDestroyed() && (!(bfObject instanceof Blank)))
                {
                    tank.fire();
                }
                tank.updateX(step);
                System.out.println("[move right] direction: " + " tankX: " + tank.getX() + ", tankY: " + tank.getY());
            }
            covered += step;

            repaint();
            Thread.sleep(tank.getSpeed());
        }
    }


    public void processTurn(int i) throws Exception {

        repaint();

    }

    void moveRandom(AbstractTank tank) throws Exception {
        this.tank = tank;
        long t = System.currentTimeMillis();
        String time = java.lang.String.valueOf(t);
        String a = time.substring(time.length() - 1);
        int i = Integer.valueOf(a);
        if (i == 1 || i == 5) {
            tank.turn(Direction.DOWN);
        } else if (i == 2 || i == 6 || i == 9) {
            tank.turn(Direction.UP);
        } else if (i == 3 || i == 0) {
            tank.turn(Direction.LEFT);
        } else if (i == 4 || i == 7 || i == 8) {
            tank.turn(Direction.RIGTH);
        }
        processMove(tank);

    }


    public void moveToQuadrant(int v, int h) throws Exception {
        String coordinates = getQuadrantXY(v, h);
        int dotIndex = coordinates.indexOf("_");
        int x = Integer.valueOf(coordinates.substring(0, dotIndex));
        int y = Integer.valueOf(coordinates.substring(dotIndex + 1));
        while (tank.getY() != y) {
            if (tank.getY() > y) {
                tank.turn(Direction.UP);
                processMove(tank);
            } else if (tank.getY() < y) {
                tank.turn(Direction.DOWN);
                processMove(tank);
            }
        }
        while (tank.getX() != x) {
            if (tank.getX() > x) {
                tank.turn(Direction.LEFT);
                processMove(tank);
            } else if (tank.getX() < x) {
                tank.turn(Direction.RIGTH);
                processMove(tank);
            }

        }
    }


    private void namberShot(int x) throws Exception {
        int result = 0;
        for (int k = 0; k < 9; k++) {
            BFObject bfObject = battleField.scanQuadrant(x, k);
            if ((!(bfObject instanceof Blank) && !(bfObject instanceof Water)))
            {
                result = result + 1;
            }
        }
        System.out.println("Number shot = " + result);
        for (int i = 0; i < result; i++) {
            tank.fire();
        }

    }


    public void processFire(Bullet bullet) throws Exception {
        this.bullet = bullet;
        int step = 1;
        while ((bullet.getX() > -14 && bullet.getX() < 590) && (bullet.getY() > -14 && bullet.getY() < 590)) {
            if (tank.getDirection().getId() == 1) {
                bullet.updateY(-step);
                System.out.println(bullet.getX() + ":" + (bullet.getY() - 25));
            } else if (tank.getDirection().getId() == 2) {
                bullet.updateY(step);
                System.out.println(bullet.getX() + ":" + (bullet.getY() - 25));
            } else if (tank.getDirection().getId() == 3) {
                bullet.updateX(-step);
                System.out.println(bullet.getX() + ":" + (bullet.getY() - 25));
            } else {
                bullet.updateX(step);
                System.out.println(bullet.getX() + ":" + (bullet.getY() - 25));
            }

            if (processInterception()) {
                bullet.destroy();
            }

            repaint();
            Thread.sleep(bullet.getSpeed());

        }

    }


    private boolean processInterception() throws InterruptedException {

        int x = bullet.getX() / 64;
        int y = bullet.getY() / 64;


        if (x >= 0 && x < 9 && y >= 0 && y < 9) {
            BFObject bfObject = battleField.scanQuadrant(y, x);
            if (!bfObject.isDestroyed() && !(bfObject instanceof Blank) && !(bfObject instanceof Water)) {
                battleField.destroyObject(y, x);
                return true;
            }

            //         if (x == tankA.getX() / 64 &&
            //                     y == tankA.getY() / 64) {
            //                 tankA.destroy();
            //                 return true;
            //             }
        }

        return false;

    }

    public void processDestroyShtab(AbstractTank tank) throws Exception {
        this.tank = tank;
        int Yt = tank.getY() / 64 + 1;
        int Xt = tank.getX() / 64 + 1;

        System.out.println(Xt + "---" + Yt);
        int YEagle = 0;
        int XEagle = 0;

        for (int i = 0; i < 9; i++) {
            for (int k = 0; k < 9; k++) {
                BFObject bfObject = battleField.scanQuadrant(i, k);
                if ((bfObject instanceof Eagle)) {
                    XEagle = k + 1;
                    YEagle = i + 1;
                    System.out.println(XEagle + "---" + YEagle);
                }
            }
        }
        if ((Yt - YEagle) <= (Xt - XEagle)) {

            moveToQuadrant(Xt, YEagle);

            if (Xt > XEagle) {
                tank.turn(Direction.LEFT);
            } else {
                tank.turn(Direction.RIGTH);
            }
            BFObject bfObject = battleField.scanQuadrant(XEagle, YEagle);
            while (bfObject instanceof Eagle) {
                tank.fire();
            }
        } else {
            System.out.println(XEagle + "---" + Yt);
            moveToQuadrant(XEagle, Yt);
            if (Yt > YEagle) {
                tank.turn(Direction.UP);
            } else {
                tank.turn(Direction.DOWN);
            }
            while (true) {
                BFObject bfObject = battleField.scanQuadrant(YEagle - 1, XEagle - 1);
                if (bfObject instanceof Eagle)
                {
                    tank.fire();
                } else {
                    break;
                }
            }

        }
    }

    public String getAggreQuadrant() {

        long t = System.currentTimeMillis();
        String time = java.lang.String.valueOf(t);
        String a = time.substring(time.length() - 1);
        int i = Integer.valueOf(a);

        if (i == 1 || i == 4 || i == 7)
        {
            aggreQuadrant = "512_128";
        } else

        if (i == 2 || i == 5 || i == 8) {
            aggreQuadrant = "192_64";
        } else

        if (i == 3 || i == 0 || i == 9 || i == 6) {
            aggreQuadrant = "320_512";
        }
        return aggreQuadrant;

    }
}