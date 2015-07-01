package raznoe;

public abstract class Demo {

    private int i;
    public Demo(){
        this.i = -100;
        System.out.println("ABSTRACT CONSTRUCTOR");
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }
}

class Demo2 extends Demo {
    public Demo2(){
        System.out.println("DEMO2 CONSTR");
        this.setI(888);
    }
}

class Demo3 extends Demo2 {

    public Demo3() {
        System.out.println("DEMO3 CONSTR");
        this.setI(999);
    }
    public static void main(String[] args) {
        Demo d3 = new Demo3();
        Demo d2 = new Demo2();

        Boolean bool = new Boolean("true");

        System.out.println(d2.getI());
        System.out.println(d3.getI());
    }
}