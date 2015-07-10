package Person;

import java.util.SplittableRandom;

/**
 * Created by rabota on 04.07.15.
 */
public class Person {
    private String name;
    private int age;
    private long salary;

    public Person(String name, int age, long salary){
        this.name = name;
        this.age = age;
        this.salary = salary;
    }


    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Person){
            Person p = (Person)obj;
            if (this.name.equals(p.name) && this.age == p.age && this.salary == p.salary){
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        int result = 25;
        result = 37 * result + name.hashCode();
        result = 37 * result + age;
        result = 37 * result + Long.hashCode(salary);
        return result;
    }
}
