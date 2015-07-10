package comparator;

import java.awt.*;
import java.util.*;

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

        HashMap<String, String> stringHashMap = new HashMap<>();
        stringHashMap.put("1", "Roma1");
        stringHashMap.put("2", "Roma2");
        stringHashMap.put("3", "Roma3");
        stringHashMap.put(null, "Roma4");
        stringHashMap.put(null, "Roma5");

        Set<Map.Entry<String, String>> set = stringHashMap.entrySet();
        for (Map.Entry e: set){
            System.out.println(e.getValue() + " " + e.getKey());
        }


        Collection<String> str = stringHashMap.values();
        for(String s: str){
            System.out.println(s);
        }
    }
}
