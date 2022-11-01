public class Product {

    private final String name;
    private int price;
    private final int barCode;

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }


}
