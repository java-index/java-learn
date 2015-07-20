package Razozli;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by rabota on 20.07.15.
 */
public class MyPanel extends JPanel {

    public MyPanel(){
        JFrame frame = new JFrame("Angry Neighbor");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(createPanel());
        frame.setLocation(200, 200);
        frame.setMinimumSize(new Dimension(500, 500));
        frame.pack();
        frame.setVisible(true);
    }

    private MyPanel createPanel(){
        this.setLayout(new GridBagLayout());
        Circle c = new Circle();
        JButton btn1 = new JButton("111");
        JButton btn2 = new JButton("222");
        JButton btn3 = new JButton("333");
        btn3.setBackground(Color.GRAY);
        btn3.setForeground(Color.CYAN);
        btn3.setBorderPainted(false);
        btn3.setFocusPainted(false);
        Icon i = new Icon() {
            @Override
            public void paintIcon(Component c, Graphics g, int x, int y) {
                g.setColor(Color.DARK_GRAY);
                g.fillOval(x, y, getIconWidth(), getIconHeight());
            }

            @Override
            public int getIconWidth() {
                return 32;
            }

            @Override
            public int getIconHeight() {
                return 32;
            }
        };
        JLabel label = new JLabel();
        label.setPreferredSize(new Dimension(32, 32));
        label.setIcon(i);
        label.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("KLICK");
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });


        this.add(btn1, new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.LINE_START, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 1, 1));
        this.add(btn2, new GridBagConstraints(2, 2, 1, 1, 0, 0, GridBagConstraints.LINE_START, GridBagConstraints.NONE, new Insets(0,0,0,0), 0, 0));
        this.add(btn3, new GridBagConstraints(3, 3, 1, 1, 0, 0, GridBagConstraints.LINE_START, 0, new Insets(0,0,0,0), 0, 0));
        this.add(label, new GridBagConstraints(4, 4, 1, 1, 0, 0, GridBagConstraints.LINE_START, 0, new Insets(0,0,0,0), 0, 0));

        this.add(c, new GridBagConstraints(4, 4, 1, 1, 0, 0, GridBagConstraints.LINE_START, 0, new Insets(0,0,0,0), 1, 1));

        return this;
    }
}
