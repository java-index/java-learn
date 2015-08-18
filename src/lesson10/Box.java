package lesson10;

import java.util.ArrayList;
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
}
