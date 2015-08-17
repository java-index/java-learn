package Observer;

/**
 * Created by rabota on 30.07.15.
 */
public interface IObservable {
    void addObserver(IObserver obj);
    void notifyObserver(IObservable obj);
}
