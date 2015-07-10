package comparator;

import java.util.*;

/**
 * Created by rabota on 04.07.15.
 */
public class ArrList {
    ArrayList<String> myStrList;

    public ArrList(){
        myStrList = new ArrayList<>();
    }

    public void addToList(String str){
        myStrList.add(str);
    }

    public void printList(){
        for(String s: myStrList){
            System.out.println(s);
        }
    }

    public ArrayList<String> getMyStrList() {
        return myStrList;
    }
    
    public void SortList(){
        Collections.sort(myStrList, new comparator.Compare());
    }

    private class Compare implements Comparator<String> {

        @Override
        public int compare(String o1, String o2) {
            int result = o1.compareToIgnoreCase(o2);
            return result * -1;
        }
    }
}
