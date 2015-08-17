package GRAPH;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class Demo {

    public static void main(String[] args) {
        Frame f = new Frame();
        Panel p = new Panel();

        try {
            p.setImage(ImageIO.read(new File("test.png")));
        } catch (IOException e){
            e.printStackTrace();
        }

        f.getContentPane().add(p);
        f.repaint();
    }
}
