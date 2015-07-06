package LinkedList;

import java.util.Iterator;
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
        myList.addFirst(one);
        myList.addLast(two);
        myList.addLast(three);
        myList.addAfter(four, three);
        myList.addLast(one);

        for(Object s : myList){
            System.out.println(s);
        }

        myList.remove(one);
        myList.remove(two);

        System.out.println("After REMOVED");
        for(Object s : myList){
            System.out.println(s);
        }


//        Iterator sslIterator = myList.iterator();
//        System.out.println(sslIterator.next().toString() + "**");
//
//        while(sslIterator.hasNext()){
//            System.out.println(sslIterator.next().toString());
//        }
    }
}
