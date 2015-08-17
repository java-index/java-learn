package tanks;
import java.awt.Color;

public class Aggressor extends AbstractTank {

    public Aggressor(ActionField af, BattleField bf) {
        super(af, bf);
        tankColor = new Color(255, 250, 0);
        towerColor = new Color(255, 0, 0);

    }

    public Aggressor(ActionField af, BattleField bf, int x, int y, Direction direction) {
        super(af, bf, x, y, direction);
        tankColor = new Color(255, 255, 0);
        towerColor = new Color(255, 0, 0);
    }

}
