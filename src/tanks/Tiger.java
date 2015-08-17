package tanks;

import java.awt.Color;

public class Tiger extends AbstractTank {

    private int armore;

    public  Tiger(ActionField af, BattleField bf) {
        super(af, bf);
        armore = 1;
        tankColor = new Color(0, 100, 0);
        towerColor = new Color(0, 185, 0);
    }

    public Tiger(ActionField af, BattleField bf, int x, int y, Direction direction) {
        super(af, bf, x, y, direction);
        armore = 1;

    }

}