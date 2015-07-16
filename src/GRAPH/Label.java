package GRAPH;

import javax.swing.*;
import java.awt.*;

public class Label extends JLabel {
    public Label(String s){
        setText(s);
        setBackground(new Color(91, 255, 61));
        setFont(new Font("Tahoma", Font.ITALIC, 12));
        updateUI();
    }
}
