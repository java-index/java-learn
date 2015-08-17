package Observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rabota on 30.07.15.
 */
public abstract class PublishingHouse implements IObservable {

    private List<IObserver> iObserverList;
    private String name;

    public PublishingHouse(String name){
        this.name = name;
        this.iObserverList = new ArrayList<IObserver>(10);
    }

    public String getName() {
        return name;
    }

    public void issue(){
        this.notifyObserver(this);
    }

    @Override
    public void addObserver(IObserver obj) {
        iObserverList.add(obj);
    }

    @Override
    public void notifyObserver(IObservable obj) {
        for(IObserver o : iObserverList){
            o.update(obj);
        }
    }
}
