package LinkedList;

import java.util.Objects;

public class SimpeLinkedList {
    private Node root;
    private int size;

    public SimpeLinkedList(){
        this.size = 0;
    }

    public void addFirst(Object obj){
        Node n = new Node();
        n.obj = obj;
        if(root != null){
            n.ref = root;
        }
        root = n;
        size++;
    }

    public void addLast(Object obj) {
        Node n = new Node();
        n.obj = obj;
        if (root == null) {
            root = n;
        } else {
            Node last = root;
            while(last.ref != null){
                last = last.ref;
            }
            last.ref = n;
        }
        size++;
    }

    public void addAfter(Object addObj, Objects prev){

    }

    public int getSize(){
        return size;
    }

    private class Node {
        Object obj;
        Node ref;
    }
}


