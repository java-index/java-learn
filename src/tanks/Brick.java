package tanks;
import javax.imageio.ImageIO;
import java.awt.Color;
import java.io.File;
import java.io.IOException;

public class Brick extends SimpleBFObject {

    public Brick(int x, int y) {
        super(x, y);
        color = new Color(255, 0, 25);
        try {
            image = ImageIO.read(new File("brick.jpg"));
        } catch (IOException e) {
        }
    }
}
