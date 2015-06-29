package constr;

class main_2 {
    protected int zero;
    protected int zero1;

    public main_2(){
        zero = 1;
        System.out.println("main_2 + zero = " + zero);
    }

    public main_2(int y){
        System.out.println("main_2 y = " + y);
    }

}

class main_1 extends main_2{
    public main_1(){
        System.out.println("main_1 + zero = " + zero);
        System.out.println("main_1 + zero1 = " + zero1);
    }

    public main_1(int x){
        System.out.println("main_1 x = " + x);
    }
}

public class main extends main_1 {

    public main(){
        System.out.println("main + zero = " + zero);
    }

    public static void main(String[] args) {
        new main();
    }
}
