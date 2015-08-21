package lesson10;

import javax.xml.ws.Service;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rabota on 18.08.15.
 */
public class ServiceRepository<T extends Service> {

    List<T> box;

    public ServiceRepository(){
        box = new ArrayList<>();
    }

    public T getService(int i) {
        return box.get(i);
    }

    public void addService(T box) {
        this.box.add(box);
    }
}
