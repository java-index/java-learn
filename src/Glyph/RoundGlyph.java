package Glyph;

public class RoundGlyph extends Glyph {

    private int radius = 5;

    public RoundGlyph(int radius) throws Exception{
        System.out.println("RoundGlyph#constructor");
        draw();
        this.radius = radius;
    }

    @Override
    public void draw() {
        System.out.println("RoundGlyph#draw()");
        System.out.println("Radius " + radius);
    }

    public void printI(){
        System.out.println(this.i);
    }
}
