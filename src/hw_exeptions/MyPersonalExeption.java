package hw_exeptions;

/**
 * Created by rabota on 21.06.15.
 */
public class MyPersonalExeption extends RuntimeException {
    public MyPersonalExeption(String str){
        //this();
        System.out.println(str);
    }

    public MyPersonalExeption(){
    }

}
