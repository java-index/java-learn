package olesa;

        import java.awt.Color;
        import java.awt.Dimension;
        import java.awt.Graphics;

        import javax.swing.JFrame;
        import javax.swing.JPanel;
        import javax.swing.WindowConstants;

public class BattleFieldTemplate extends JPanel {

    boolean COLORDED_MODE = true;

    int tankX = 0;
    int tankY = 0;

    long speed = 6;

    /* directions of motions */
    int UP = 1;
    int DOWN = 2;
    int LEFT = 3;
    int RIGHT = 4;

    /* size BattleField */
    int quadrantX = 9;
    int quadrantY = 9;

    /**
     * Write your code here.
     */
    void runTheGame() throws Exception {
        while (true) {
            moveToQuadrantRandom();
        }
    }

    public void moveToQuadrantRandom() throws Exception{
        int x = randomInt(9);
        int y = randomInt(9);
        moveToQuadrant(x, y);
    }

    void moveRightLeft() throws Exception {

        while (true) {
            while (tankX < 512) {
                tankX += 64;
                repaint();
                Thread.sleep(speed);
                System.out.println("1: " + tankX);
            }

            while (tankX > 0) {
                tankX -= 64;
                repaint();
                Thread.sleep(speed);
                System.out.println("2: " + tankX);
            }
        }
    }

    void move(int direction) throws Exception {
        int step = 1;
        if ((direction == UP && tankY == 0)
                || (direction == DOWN && tankY >= 512)
                || (direction == LEFT && tankX == 0)
                || (direction == RIGHT && tankX >= 512)) {
            System.out.println("[Illegal move] direction: " + direction
                    + " tankX: " + tankX + ", tankY: " + tankY);
            return;
        }
        if (direction == UP) {
            tankY -= step;
            System.out.println("[Move up] direction: " + direction + " tankX: "
                    + tankX + ", tankY: " + tankY);
        } else if (direction == DOWN) {
            tankY += step;
            System.out.println("[Move down] direction: " + direction
                    + " tankX: " + tankX + ", tankY: " + tankY);
        } else if (direction == LEFT) {
            tankX -= step;
            System.out.println("[Move left] direction: " + direction
                    + " tankX: " + tankX + ", tankY: " + tankY);
        } else if (direction == RIGHT) {
            tankX += step;
            System.out.println("[Move right] direction: " + direction
                    + " tankX: " + tankX + ", tankY: " + tankY);
        }
        repaint();
        Thread.sleep(speed);

    }

    void moveRandom() throws Exception {
        while (true) {
            int rand = (int) System.nanoTime() % 4 + 1;
            System.out.println(rand);
            move(rand);
        }
    }

    static String getQuadrant(int v, int h) throws Exception {

        return (h - 1) * 64 + "_" + (v - 1) * 64;
    }

    void moveToQuadrant(int v, int h) throws Exception {

        int x = h * 64;
        int y = v * 64;

        while (tankX < x) {
            move(RIGHT);
        }
        while (tankX > x) {
            move(LEFT);
        }
        while (tankY < y) {
            move(DOWN);
        }
        while (tankY > y) {
            move(UP);
        }

    }

    public int randomInt (int number){
        return (int)(System.nanoTime() % number);
    }

    // Magic bellow. Do not worry about this now, you will understand everything
    // in this course.
    // Please concentrate on your tasks only.

    final int BF_WIDTH = 576;
    final int BF_HEIGHT = 576;

    public static void main(String[] args) throws Exception {
        BattleFieldTemplate bf = new BattleFieldTemplate();
        bf.runTheGame();
    }

    public BattleFieldTemplate() throws Exception {
        JFrame frame = new JFrame("BATTLE FIELD, DAY 2");
        frame.setLocation(500, 150);
        frame.setMinimumSize(new Dimension(BF_WIDTH, BF_HEIGHT + 22));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().add(this);
        frame.pack();
        frame.setVisible(true);
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

        g.setColor(new Color(255, 0, 0));
        g.fillRect(tankX, tankY, 64, 64);
    }

}