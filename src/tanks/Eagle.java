package tanks;

import javax.imageio.ImageIO;
import java.awt.Color;
import java.io.File;
import java.io.IOException;

public class Eagle extends SimpleBFObject {


    public Eagle(int x, int y) {
        super(x, y);
        color = new Color(255, 255, 0);
        armor = 1;
//        try {
//            image = ImageIO.read(new File("tankG.jpg").getAbsoluteFile());
//        } catch (IOException e) {
//        }
    }
}
