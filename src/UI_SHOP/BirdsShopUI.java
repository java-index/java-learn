package UI_SHOP;

import GRAPH.Panel;

import javax.swing.*;
import java.awt.*;

public class BirdsShopUI {
    BirdsShop bs;

    public BirdsShopUI(BirdsShop bs) {
        this.bs = bs;
        JFrame frame = new JFrame("BIRDS MARKET");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(createSellingPanel());
        frame.setMinimumSize(new Dimension(100, 100));
        //frame.setMaximumSize(new Dimension(500, 500));
        frame.pack();
        frame.setVisible(true);
    }

    private JPanel createSellingPanel() {
        JPanel panel = new JPanel();
        JLabel lName = new JLabel("Enter your name");
        JTextField tfName = new JTextField(20);
        JRadioButton rbItem1 = new JRadioButton("one");
        JRadioButton rbItem2 = new JRadioButton("two");
        JRadioButton rbItem3 = new JRadioButton("three");
        rbItem1.setSelected(true);
        ButtonGroup rbGroup = new ButtonGroup();
        rbGroup.add(rbItem1);
        rbGroup.add(rbItem2);
        rbGroup.add(rbItem3);

        JButton btnBye = new JButton("BUY");

        panel.add(lName);
        panel.add(tfName);
        panel.add(rbItem1);
        panel.add(rbItem2);
        panel.add(rbItem3);
        panel.add(btnBye);
        return panel;
    }
}
