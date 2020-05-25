package StockList;

public class Main {

    public static StockList storeStock = new StockList();

    public static void main(String[] args) {

        StockItem item = new StockItem("Milk", 2.50,  10);
        storeStock.addStock(item);

        item = new StockItem("Eggs", 2.50, 10);
        storeStock.addStock(item);


        item = new StockItem("Sausage", 5.31, 10);
        storeStock.addStock(item);


        System.out.println("Store Stock at opening");
        System.out.println(storeStock);


        Basket basket = new Basket("Trey");
        addToCart(basket, "Milk", 5);
        System.out.println(basket);
        System.out.println(storeStock);


        addToCart(basket, "Sausage", 5);
        System.out.println(basket);
        System.out.println(storeStock);

        addToCart(basket, "Eggs", 15);
        System.out.println(basket);
        System.out.println(storeStock);

        addToCart(basket, "Eggs", 8);
        System.out.println(basket);
        System.out.println(storeStock);

        removeFromCart(basket, "Eggs", 6);
        System.out.println(basket);
        System.out.println(storeStock);

        removeFromCart(basket, "Eggs", 2);
        System.out.println(basket);
        System.out.println(storeStock);

        checkout(basket);
        System.out.println(basket);

        System.out.println("Store Stock at close");
        System.out.println(storeStock);

    }

    public static void addToCart(Basket basket, String item, int quantity){
        StockItem stockItem = storeStock.getItem(item);
        if(stockItem != null){
            if(storeStock.reserveItem(item, quantity) != -1){
                basket.addToBasket(stockItem, quantity);
            }else{
                System.out.println("Sorry, there are not that many available items in stock");
            }
        }else{
            System.out.println("Sorry, we do not sell " + item);
        }
    }

    public static void removeFromCart(Basket basket, String item, int quantity){
        StockItem removeItem = storeStock.getItem(item);
        storeStock.unreserveItem(removeItem, quantity);
        basket.removeFromBasket(removeItem, quantity);
    }

    public static void checkout(Basket basket){
        storeStock.checkout();
        basket.checkout();
    }
}
