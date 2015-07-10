package comparator;

import java.util.Comparator;

/**
 * Created by rabota on 10.07.15.
 */
public class CompareTest implements Comparator<Test> {
    @Override
    public int compare(Test o1, Test o2) {
        return o1.getX() - o2.getX();
    }
}
