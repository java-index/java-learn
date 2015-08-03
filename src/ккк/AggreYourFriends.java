package ккк;


import javax.swing.*;
import javax.swing.plaf.basic.BasicOptionPaneUI;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.Random;

/**
 * Created by Андрій on 21.07.2015.
 */
public class AggreYourFriends extends JPanel {
    public int x;
    public int y;

    public void setBX(int x) {
        this.x = x;
    }

    public void setBY(int y) {
        this.y = y;
    }


    public int getBX() {
        return this.x;
    }


    public int getBY() {
        return this.y;
    }

    public AggreYourFriends() {

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.RED);
        g.fillOval(this.x, this.y, 100, 100);
    }


    public static void main(String[] args) {
        start(100, 100);
    }


    public static void start(int x, int y) {
        AggreYourFriends boll = new AggreYourFriends();
        boll.setBX(x);
        boll.setBY(y);
        boll.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                if (e.getX() < (boll.getBX() + 100) && e.getX() > boll.getBX() &&
                        e.getY() < (boll.getBY() + 100) && e.getY() > boll.getBY()) {
                    random(boll);
                }
            }
        });

        JFrame f = new JFrame(" Push to boll ");
        f.setMinimumSize(new Dimension(600, 600));
        f.setLocation(300, 100);
        f.getContentPane().add(boll);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);

    }

    private static void random(AggreYourFriends boll) {
        Random rand = new Random();
        int i = rand.nextInt(200);
        boll.setBX(i);
        boll.setBY(i);
        boll.repaint();

    }
}