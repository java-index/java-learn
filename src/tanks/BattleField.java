package tanks;

import java.awt.*;

public class BattleField {

    public static final String BRICK = "B";
    public static final String EAGLE = "E";
    public static final String ROCK = "R";
    public static final String WATER = "W";

    private int bfWidth = 576;
    private int bfHeight = 576;
    private Bullet bullet;

    private String[][] battleFieldTemplate = {
            { "B", " ", " ", " ", "E", " ", " ", " ", " "},
            { "B", "B", "R", " ", " ", " ", "R", "B", " "},
            { " ", "W", "W", "W", " ", " ", " ", " ", " "},
            { " ", " ", "B", "B", "R", "B", " ", " ", " "},
            { " ", " ", " ", " ", " ", " ", " ", " ", " "},
            { " ", "B", "B", " ", " ", "B", "B", " ", " "},
            { " ", " ", " ", " ", " ", " ", " ", " ", " "},
            { " ", " ", " ", "B", "B", "B", " ", "B", "B"},
            { "B", " ", " ", " ", " ", " ", "B", " ", " "}
    };



    private SimpleBFObject[][] battleField = new SimpleBFObject[9][9];

    public BattleField() {
        drawBattleField();
    }

    public BattleField(String [][]battleField) {
        this.battleFieldTemplate = battleField;
        drawBattleField();
    }

    private String getQuadrantXY(int v, int h) {
        return (v - 1) * 64 + "_" + (h - 1) * 64;
    }

    private void drawBattleField() {
        SimpleBFObject bfObject;

        for (int y = 0; y < 9; y++) {
            for (int x = 0; x < 9; x++) {
                String obj = battleFieldTemplate[y][x];
                if (obj.equals(BRICK)) {
                    bfObject = new Brick(x*64, y*64);
                } else if (obj.equals(ROCK)) {
                    bfObject = new Rock(x*64,y*64);
                } else if (obj.equals(EAGLE)) {
                    bfObject = new Eagle(x*64, y*64);
                } else if (obj.equals(WATER)) {
                    bfObject = new Water(x*64, y*64);
                } else {
                    bfObject = new Blank(x*64, y*64);
                }
                battleField[y][x] = bfObject;
            }
        }
    }


    public void updateQuadrante(int v, int h, String object){
        battleFieldTemplate[v][h] = object;
    }

    public BFObject scanQuadrant(int v, int h){
        return battleField[v][h];
    }

    public int getDimentionX(){
        return battleField.length;
    }

    public int getDimentionY(){
        return battleField.length;
    }

    public int getBfWidth(){
        return bfWidth;
    }

    public int getBfHeight(){
        return bfHeight;
    }

    public void destroyObject(int v, int h) {
        battleField[v][h].destroy();
    }

    public void draw(Graphics g) {
        for (int j = 0; j < 9; j++) {
            for (int k = 0; k < 9; k++) {
                battleField[j][k].draw(g);
//                System.out.println(battleField[j][k]);
            }
        }
    }
}