package lesson10;

/**
 * Created by rabota on 21.08.15.
 */
public class MyReflection {
    public static void main(String[] args) {
        Class cls = Number.class;
        Class subSls = cls.asSubclass();


        for(Class clazz : c){
            System.out.println(clazz.getSimpleName());
        }
    }
}
