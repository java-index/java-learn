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
            Node cp = root;
            while(cp.ref != null){
                cp = cp.ref;
            }
            cp.ref = n;
        }
        size++;
    }

    public void addAfter(Object obj, Object prev){

        Node n = null;
        Node cp = root;

        for(int i = 0; i < size; i++){
            if (cp.obj == prev){
                n = new Node();
                n.obj = obj;
                n.ref = cp.ref;
                cp.ref = n;
                size++;
                break;
            }
            cp = cp.ref;
        }
        if (n == null){
            throw new IllegalStateException();
        }
    }

    public int getSize(){
        return size;
    }

    @Override
    public String toString() {
        Node cp = root;
        String toString = new String("{");
        for(int i = 0; i < size; i++){
            toString += " " + cp.obj.toString();
            cp = cp.ref;
        }
        toString += " }";
        return toString;
    }

    private class Node {
        Object obj;
        Node ref;
    }
    private class SLLIterator {
        boolean hasNext(){

        }

        Node next(){

        }
    }
}


