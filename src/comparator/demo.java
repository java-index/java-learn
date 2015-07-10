package comparator;

import java.util.Arrays;

/**
 * Created by rabota on 04.07.15.
 */
public class demo {
    public static void main(String[] args) {
        Test[] t = new Test[5];
        t[0] = new Test(5);
        t[1] = new Test(1);
        t[2] = new Test(20);
        t[3] = new Test(3);
        t[4] = new Test(40);

        Arrays.sort(t, new CompareTest());
        for(Test i : t){
           System.out.println(i.getX());
        }

        ArrList list = new ArrList();
        list.addToList("Roma");
        list.addToList("Anna");
        list.addToList("Misha");
        list.addToList("Sveta");
        list.addToList("Tanya");
        list.addToList("Jenya");
        list.addToList("Artem");

        list.printList();

        list.SortList();

        list.printList();


    }
}
