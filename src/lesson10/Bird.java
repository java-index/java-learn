package lesson10;

import java.util.Comparator;

/**
 * Created by eco on 17.08.15.
 */
public abstract class Bird {
    private String name;
    private Double price;

    public Bird(){}

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return this.price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Name: " + this.name + "; price: " + this.price;
    }
}
