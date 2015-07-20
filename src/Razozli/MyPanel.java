package Razozli;

import javax.swing.*;
import java.awt.*;

/**
 * Created by rabota on 20.07.15.
 */
public class MyPanel extends JPanel{

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
        this.add(btn1, new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.LINE_START, GridBagConstraints.NONE, new Insets(0,0,0,0), 1, 1));
        this.add(btn2, new GridBagConstraints(2, 2, 1, 1, 0, 0, GridBagConstraints.LINE_START, GridBagConstraints.NONE, new Insets(0,0,0,0), 0, 0));
        this.add(btn3, new GridBagConstraints(3, 3, 1, 1, 0, 0, GridBagConstraints.LINE_START, 0, new Insets(0,0,0,0), 0, 0));
        this.add(c, new GridBagConstraints(4, 4, 1, 1, 0, 0, GridBagConstraints.LINE_START, 0, new Insets(0,0,0,0), 1, 1));
        return this;
    }
}
