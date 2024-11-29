
public class Accesory implements Product {
    private String name;
    private Double price;

    public Accesory(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Double getPrice() {
        return price;
    }
}
