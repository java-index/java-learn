package hw_exeptions;

public class Main {
    static int i = 0;

    public static void main(String[] args) {
        try {
            test(i);
        } catch (MyPersonalExeption e) {
            e.printStackTrace();
            System.out.println("get message " + e.getMessage());
        } finally {
            i++;
            test(i);
        }
        System.out.println("END");
    }

    static public void test(int x) {
        if(x == 0){
            throw new MyPersonalExeption("My---exeptions");
        } else {
            System.out.println("int x = " + x);
        }
    }
}
