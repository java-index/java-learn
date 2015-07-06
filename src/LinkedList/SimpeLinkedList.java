package LinkedList;

import java.util.Iterator;
import java.util.Objects;

public class SimpeLinkedList implements Iterable<Object> {
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
        Node cp = root;
        while (cp != null && cp.obj != prev){
            cp = cp.ref;
        }

        if (cp == null){
            throw new IllegalStateException();
        } else {
            Node n = new Node();
            n.obj = obj;
            n.ref = cp.ref;
            cp.ref = n;
            size++;
        }
    }

    public void remove(Object obj){
        Node cp = root;
        Node prev = null;

        while (cp != null && cp.obj != obj){
            prev = cp;
            cp = cp.ref;
        }
        if (cp == null){
            throw new IllegalStateException("No ELEMENT");
        } else if (cp == root) {
            root = cp.ref;
        } else {
            prev.ref = cp.ref;
            cp.obj = null;
            cp.ref = null;
        }
        size--;
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

        @Override
        public String toString() {
            return obj.toString();
        }
    }

    private class SLLIterator implements Iterator<Object> {
        Node cp = root;

        public boolean hasNext(){
            return (cp == null)? false : true;
        }

        public Node next(){
            if (cp == null){
                throw new IllegalStateException("Object is NULL");
            }
            Node temp = cp;
            cp = cp.ref;
            return temp;
        }
    } // SSLIterator

    @Override
    public Iterator<Object> iterator() {
        return new SLLIterator();
    }
} // SSL


