package multy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rabota on 22.09.15.
 */
public class Multy {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B12");
        list.add("C");
        list.set(1, "D");
        list.add(1, "B");

        System.out.println(list);
    }
}
