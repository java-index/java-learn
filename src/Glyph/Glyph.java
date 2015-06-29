package Glyph;

/**
 * Created by eco on 22.06.15.
 */
public class Glyph {

    public int i = 5;

    public Glyph() throws Exception{
        System.out.println("Glyph#constructor");
        draw();
    }

    public void draw() throws Exception {
            throw new Exception();
    }

    public int get(){
        return i;
    }
}
