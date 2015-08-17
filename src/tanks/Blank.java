package tanks;
import javax.imageio.ImageIO;
import java.awt.Color;
import java.io.File;
import java.io.IOException;

public class Blank extends SimpleBFObject {

    public Blank(int x, int y) {
        super(x, y);
//        color = new Color(180, 180, 180);
        try {
            image = ImageIO.read(new File("blank.jpg").getAbsoluteFile());
        } catch (IOException e) {throw new IllegalStateException("Can't find tank images.");
        }
    }
}
