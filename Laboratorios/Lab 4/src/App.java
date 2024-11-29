public class App {
    public static void main(String[] args) {
        Store store = new Store();
        store.addProduct(new Electronic("Laptop", 1000.0));
        store.addaccessories(new Accesory("mouse pad", 20.0));
        store.addProduct(new Electronic("Smartphone", 500.0));
        store.addaccessories(new Accesory("caracaza", 70.0));

        // Apply a 10% discount
        Discountable dsicountClient= product -> product.getPrice() * 0.9;
        store.applyDiscount(dsicountClient);
    }
}

