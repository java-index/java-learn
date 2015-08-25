package lesson10;

import javax.swing.*;

/**
 * Created by rabota on 23.08.15.
 */
public class ForInstance extends JPanel{
    private String name1;
    private String name2;
    private String name3;

    public ForInstance(){
        System.out.println("CONSTRUCTOR: ForInstance CREATED");
        name1 = "no change";
        name2 = "no change";
        name3 = "no change";
    }

    public ForInstance(String name){
        System.out.println("STRING - CONSTRUCTOR: ForInstance CREATED");
    }

    public ForInstance(String name, int i){
        System.out.println("STRING INT - CONSTRUCTOR: ForInstance CREATED");
    }

    public ForInstance(String name, double i){
        System.out.println("STRING DOUBLE - CONSTRUCTOR: ForInstance CREATED");
    }


    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
        System.out.println("setName1: " + this.name1);
    }
    public void setName1(String name1, int i) {
        this.name1 = name1;
        System.out.println("setName1 + int i: " + this.name1);
    }
    public String getName2() {
        return name2;
    }

    public void setName2(String name2) {
        this.name2 = name2;
        System.out.println("setName2: " + this.name2);
    }

    public void setName2(String name2, int i) {
        this.name2 = name2;
        System.out.println("setName2 + int i: " + this.name2);
    }

    public String getName3() {
        return name3;
    }

    public void setName3(String name3) {
        this.name3 = name3;
        System.out.println("setName3: " + this.name3);
    }

    public void setName3(String name3, int i) {
        this.name3 = name3;
        System.out.println("setName3 + int i: " + this.name3);
    }

    public static void main(String[] args) {
        System.out.println("MAIN: ForInstance CREATED");
    }
}
