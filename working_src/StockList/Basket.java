package StockList;

import java.util.HashMap;
import java.util.Map;


public class Basket {
    final String name;
    Map<StockItem, Integer> cart;

    public Basket(String name){
        this.name = name;
        this.cart = new HashMap<>();
    }

    public int addToBasket(StockItem newItem, int quantity){
        if(newItem != null && quantity > 0){
            int item = cart.getOrDefault(newItem, 0);
            cart.put(newItem, item + quantity);
            return item + quantity;
        }
        return 0;
    }

    public int removeFromBasket(StockItem item, int quantity){
        if(cart.containsKey(item) && (cart.get(item) - quantity) != 0) {
            cart.put(item, (cart.get(item) - quantity));
            return quantity;
        }else if (cart.containsKey(item) && (cart.get(item) - quantity == 0)){
            cart.remove(item);
            return quantity;
        }
        return -1;
    }

    public void checkout(){
        this.cart.clear();
    }

    @Override
    public String toString() {
        String s = "\n" + name + " 's shopping cart. You have " + cart.size() + (cart.size() > 1 ? " types of items": " type of item") + "\n";
        double totalCost = 0.0;
        for(Map.Entry<StockItem, Integer> item: cart.entrySet()){
            s += "Item: " + item.getKey().getName() + " Price: " + String.format("$%.2f",item.getKey().getPrice()) + " Quantity: " + item.getValue() + "\n";
            totalCost += item.getKey().getPrice() * item.getValue();
        }

        s += String.format("Total Cost is: $%.2f", totalCost);

        return s;
    }
}
