package lesson10;

/**
 * Created by eco on 17.08.15.
 */
public abstract class Bird {
    private String name;
    private Double price;

    public Bird(){}

    public Bird(String name, Double price){
        this.name = name;
        this.price = price;
    }

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
}
