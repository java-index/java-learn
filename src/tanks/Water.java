package tanks;

import javax.imageio.ImageIO;
import java.awt.Color;
import java.io.File;
import java.io.IOException;

public class Water extends SimpleBFObject {

    public Water(int x, int y) {
        super(x, y);
        color = new Color(0, 0, 255);
 //       try {
 //           image = ImageIO.read(new File("wather.jpg").getAbsoluteFile());
 //       } catch (IOException e) {
 //       }
    }
}
