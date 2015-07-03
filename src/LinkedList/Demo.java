package LinkedList;

import java.util.Objects;

/**
 * Created by rabota on 02.07.15.
 */
public class Demo {
    static String one = new String("one");
    static String two = new String("two");
    static String three = new String("three");
    static String four = new String("four");

    public static void main(String[] args) {
        SimpeLinkedList myList = new SimpeLinkedList();
        myList.addFirst(one);
        myList.addLast(two);
        myList.addLast(three);
        myList.addAfter(four, three);
        myList.addLast(one);
        System.out.println(myList.getSize());
        System.out.println(myList.toString());
    }

}
