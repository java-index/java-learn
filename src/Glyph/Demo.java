package Glyph;


public class Demo {
    public static void main(String[] args) throws Exception {
        Glyph glyph = new RoundGlyph(10);
        glyph.draw();
        RoundGlyph r = new RoundGlyph(10);
        r.printI();
        glyph.draw();
    }
}
