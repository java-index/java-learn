package comparator;

import java.util.Comparator;

/**
 * Created by rabota on 04.07.15.
 */
public class Compare implements Comparator<String>{

    @Override
    public int compare(String o1, String o2) {
        int result = o1.compareToIgnoreCase(o2);
        return result * -1;
    }
}
