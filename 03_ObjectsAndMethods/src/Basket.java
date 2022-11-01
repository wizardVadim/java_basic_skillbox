public class Basket {

    private static int count = 0;
    private String items = "";
    private int totalPrice = 0;
    private int limit;
    private double totalWeight = 0;


    private static int totalBasketPrice = 0;

    private static int totalBasketCount = 0;

    private static int middlePrice = 0;

    private static int middleBasketPrice = 0;

    public Basket() {
        increaseCount(1);
        items = "Список товаров:";
        this.limit = 1000000;
    }

    public Basket(int limit) {
        this();
        this.limit = limit;
    }

    public Basket(String items, int totalPrice, int totalWeight) {
        this();
        this.items = this.items + items;
        this.totalPrice = totalPrice;
        this.totalWeight = totalWeight;
    }

    public static int getMiddleBasketPrice() {
        return middleBasketPrice;
    }

    public static int getMiddlePrice() {
        return middlePrice;
    }

    public static int getTotalBasketPrice() {
        return totalBasketPrice;
    }

    public static int getTotalBasketCount() {
        return totalBasketCount;
    }

    public static void increaseMiddleBasketPrice(){
        middleBasketPrice = totalBasketPrice / count;
    }

    public static void increaseTotalBasketPrice(int price, int count){
        totalBasketPrice = totalBasketPrice + count * price;
    }

    public static void increaseTotalBasketCount(int count){
        totalBasketCount = totalBasketCount + count;
    }

    public static void increaseMiddlePrice() {
        middlePrice = totalBasketPrice / totalBasketCount;
    }

    public static int getCount() {
        return count;
    }


    public static void increaseCount(int count) {
        Basket.count = Basket.count + count;
    }

    public void add(String name, int price) {
        add(name, price, 1);
    }

    public void add(String name, int price, int count) {
        boolean error = false;
        if (contains(name)) {
            error = true;
        }

        if (totalPrice + count * price >= limit) {
            error = true;
        }

        if (error) {
            System.out.println("Error occured :(");
            return;
        }

        items = items + "\n" + name + " - " +
                count + " шт. - " + price ;
        totalPrice = totalPrice + count * price;
        increaseTotalBasketPrice(count, price);
        increaseTotalBasketCount(count);
        increaseMiddlePrice();
        increaseMiddleBasketPrice();

    }

    public void add(String name, int price, int count, double weight) {
        add(name, price, count);

        totalWeight = totalWeight + count * weight;
    }

    public void clear() {
        items = "";
        totalPrice = 0;
        totalWeight = 0;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public double getTotalWeight() {
        return totalWeight;
    }

    public boolean contains(String name) {
        return items.contains(name);
    }

    public void print(String title) {
        System.out.println(title);
        if (items.isEmpty()) {
            System.out.println("Корзина пуста");
        } else {
            System.out.println(items);
            System.out.println("Товаров на сумму: " + totalPrice + " руб.");
            System.out.println("Общий вес составил: " + totalWeight + " кг");
            clear();
        }
    }
}
