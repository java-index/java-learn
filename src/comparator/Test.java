package comparator;

/**
 * Created by rabota on 10.07.15.
 */
public class Test implements Comparable<Test> {
    int x;

    public Test(int x){
        this.x = x;
    }

    public int getX() {
        return x;
    }

    @Override
    public int compareTo(Test o) {
        return (this.x - o.getX()) * -1;
    }
}
