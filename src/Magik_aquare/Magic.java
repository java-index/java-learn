package Magik_aquare;

import com.sun.org.apache.xpath.internal.operations.Operation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by rabota on 19.07.15.
 */
public class Magic {

    public Magic(){
        JFrame frame = new JFrame("MAGIC SQUARE");
        frame.getContentPane().add(BorderLayout.CENTER, createPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(500, 500));
        frame.setLocation(300, 300);
        //frame.pack();
        frame.setVisible(true);
    }

    private JPanel createPanel(){
        JPanel panel = new JPanel();
        panel.setToolTipText("CLICK ME");
        panel.setBackground(Color.BLUE);
        JButton btn = new JButton("123");
        panel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

                if (e.isControlDown() && panel.getBackground() == Color.BLUE){
                    panel.setBackground(Color.ORANGE);
                } else {
                    panel.setBackground(Color.BLUE);
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
                System.out.println(e.getX() + " " + e.getY());
                System.out.println(e.paramString());
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
        btn.addActionListener(new myListener());
        panel.add(btn);
        return panel;
    }

    private class myListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println(e.getActionCommand());
    }
    }
}
