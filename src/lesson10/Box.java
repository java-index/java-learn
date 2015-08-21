package lesson10;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Box<T extends Bird> {

    List<T> item;

    public Box(){
        this.item = new ArrayList<>();
    }

    public List<T> getItem() {
        return item;
    }

    public T getItemByIndex(int index){
        return item.get(index);
    }

    public void addItem(T item){
        this.item.add(item);
    }

    public void sortByName(){
        item.sort(new CompareByName());
    }

    public void print() {
        for(T o : this.item) {
            System.out.println(o.toString());
        }
    }

    private class CompareByName implements Comparator<T> {
        @Override
        public int compare(T o1, T o2) {
            return o1.getName().compareTo(o2.getName());
        }
    }
}
