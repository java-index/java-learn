package GRAPH;

import java.awt.*;
import javax.swing.JPanel;

/**
 * Created by rabota on 08.07.15.
 */
public class Panel extends JPanel {
    private Image image;

    public void setImage(Image image) {
        this.image = image;
    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);
//        g.setColor(Color.GRAY);
//        g.fillRect(0, 0, getWidth(), getHeight());


        if(this.image != null){
            g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
        }
    }
}
