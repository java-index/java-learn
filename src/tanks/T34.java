package tanks;
import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class T34 extends AbstractTank {


    public T34(ActionField af, BattleField bf) {
        super(af, bf);
        tankColor = new Color(255, 0, 0);
        towerColor = new Color(0, 255,0);
        setImages();

    }

    public T34(ActionField af, BattleField bf, int x, int y, Direction direction) {
        super(af, bf, x, y, direction);
        tankColor = new Color(255, 0, 0);
        towerColor = new Color(0, 255, 0);
        setImages();
    }

    private void setImages(){
        images = new Image[4];
        try{
            images[0]= ImageIO.read(new File("t34.jpg").getAbsoluteFile());
            images[1]= ImageIO.read(new File("t34.jpg").getAbsoluteFile());
            images[2]= ImageIO.read(new File("t34.jpg").getAbsoluteFile());
            images[3]= ImageIO.read(new File("t34.jpg").getAbsoluteFile());
        }catch (IOException e){
            throw new IllegalStateException("Can't find tank images.");
        }
    }

}