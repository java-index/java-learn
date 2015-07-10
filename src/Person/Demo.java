package Person;

import java.util.*;

/**
 * Created by rabota on 04.07.15.
 */
public class Demo {
    public static void main(String[] args) {
        Person person = new Person("Roma", 40, 1200L);
        Person person2 = new Person("Roma", 45, 200L);
        Person person3 = new Person("Roma", 42, 5600L);
        Person person4 = new Person("Roma3", 38, 6500L);
        Person person5 = new Person(null, 12, 55400L);

        HashMap<String, Person> map = new HashMap<>();
        HashMap<String, Person> map2;
        map.put(person.getName(), person);
        map.put(person2.getName(), person2);
        map.put(person3.getName(), person3);
        map.put(person4.getName(), person4);
        map.put(person5.getName(), person5);
        String s = new String();
        s = "qwerty";


        System.out.println(map.size());

        Objects.requireNonNull(map);

        Set<String> setStr = map.keySet();
        for(String s1 : setStr){
            System.out.printf("KEY: %7s,   NAME: %7s\n", s1, map.get(s).getName());
        }

        Collection<Person> collPers = map.values();
        for(Person p : collPers){
            System.out.println(p.getName());
        }
    }
}
