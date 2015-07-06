package comparator;

import java.util.Collection;
import java.util.Collections;

/**
 * Created by rabota on 04.07.15.
 */
public class demo {
    public static void main(String[] args) {

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
