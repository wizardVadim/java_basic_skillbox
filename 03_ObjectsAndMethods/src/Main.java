public class Main {
    public static void main(String[] args)  {
        Basket petyaBasket = new Basket();
        petyaBasket.add("Milk", 70, 5, 1.5);
        petyaBasket.add("Bread", 25, 1, 0.5);
        petyaBasket.print("Корзина Пети: ");

        Basket vasyaBasket = new Basket();
        vasyaBasket.add("M&M's", 120, 5, 0.2);
        vasyaBasket.add("Bread", 25, 1, 0.5);
        vasyaBasket.print("Корзина Васи: ");
        System.out.println(Basket.getCount());
        System.out.println(Basket.getTotalBasketPrice());
        System.out.println(Basket.getTotalBasketCount());
        System.out.println(Basket.getMiddlePrice());
        System.out.println(Basket.getMiddleBasketPrice());


    }

}
