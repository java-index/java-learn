package Observer;

/**
 * Created by rabota on 30.07.15.
 */
public class Demo {
    public static void main(String[] args) {
        PublishingHouse PlayBoy = new Magazin("PlayBoy");
        PublishingHouse Daily = new Newspaper("Daily");
        PublishingHouse NewYorkTimes = new Newspaper("NewYorkTimes");

        Subscriber Ivanov = new RealSubscriber();
        Subscriber Petrov = new RealSubscriber();

        Ivanov.addSubscribe(PlayBoy);
        Ivanov.addSubscribe(Daily);
        Ivanov.addSubscribe(NewYorkTimes);

        Petrov.addSubscribe(PlayBoy);
        Petrov.addSubscribe(Daily);
        Petrov.addSubscribe(NewYorkTimes);

        PlayBoy.issue();
        Daily.issue();
        NewYorkTimes.issue();
    }
}
