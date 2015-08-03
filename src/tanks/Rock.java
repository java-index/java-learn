package tanks;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.File;
import java.io.IOException;

public class Rock extends SimpleBFObject {

    public Rock(int x, int y) {
        super(x, y);
        color = new Color(255, 0, 255);
        armor = 1;
        try{
            image = ImageIO.read(new File("rock.jpg").getAbsoluteFile());
        }catch (IOException e){
            throw new IllegalStateException("Can't find tank images.");
        }
    }
//        try {
//            image = ImageIO.read(new File("tankG.jpg").getAbsoluteFile());
//        } catch (IOException e) {
//        }


}
