package Observer;

/**
 * Created by rabota on 30.07.15.
 */
public abstract class Subscriber implements IObserver{

    IObservable obj;

    public Subscriber(){

    }

    public Subscriber(IObservable obj){
        this.addSubscribe(obj);
    }

    public void addSubscribe (IObservable obj){
        this.obj = obj;
        obj.addObserver(this);
    }

    @Override
    public void update(IObservable obj) {
        if (obj instanceof Magazin) {
            System.out.println("Notifyed! " + ((Magazin) obj).getName() + " new issue");
        } else if (obj instanceof Newspaper){
            System.out.println("Notifyed! " + ((Newspaper) obj).getName() + " new issue");
        }
    }
}
