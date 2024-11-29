
import java.util.ArrayList;
import java.util.List;

public class Store {
    private List<Product> products;
    private List<Product> accessories;

    public Store() {
        this.products = new ArrayList<>();
        this.accessories = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }
    
    public void addaccessories(Product product){
        accessories.add(product);
    }

    public void applyDiscount(Discountable discountable) {
        System.out.println("Applying discounts to products:");
        for (Product product : products) {
            Double newPrice = discountable.applyDiscount(product);
            System.out.println("Product: " + product.getName() + ", Original Price: " + product.getPrice() + ", Discounted Price: " + newPrice);
        }
    
        System.out.println("\nApplying discounts to accessories:");
        for (Product accessory : accessories) {
            Double newPrice = discountable.applyDiscount(accessory);
            System.out.println("Accessory: " + accessory.getName() + ", Original Price: " + accessory.getPrice() + ", Discounted Price: " + newPrice);
        }
    }

    public List<Product> getProducts() {
        return products;
    }

    public List<Product> getAccesories(){
        return accessories;
    }

}
