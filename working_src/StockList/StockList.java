package StockList;

    /*

    Modify the program so that adding items to the shopping basket doesn't
    actually reduce the stock count but, instead, reserves the requested
    number of items.  /*TODO - change the sellStock method so that instead of reducing the count it will
    TODO just place the items and the quantity into a reserved map.

    */
    /*
    You will need to add a "reserved" field to the StockItem class to store the
    number of items reserved.

    Items can continue to be added to the basket, but it should not be possible to
    reserve more than the available stock of any item. An item's available stock
    is the stock count less the reserved amount.

    The stock count for each item is reduced when a basket is checked out, at which
    point all reserved items in the basket have their actual stock count reduced.

    Once checkout is complete, the contents of the basket are cleared.

    It should also be possible to "unreserve" items that were added to the basket
    by mistake.

    The program should prevent any attempt to unreserve more items than were
    reserved for a basket.

    Add code to Main that will unreserve items after they have been added to the basket,
    as well as unreserving items that have not been added to make sure that the code
    can cope with invalid requests like that.

    After checking out the baskets, display the full stock list and the contents of each
    basket that you created.

     */


import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class StockList {
    private final Map<String, StockItem> list;
    private final Map<StockItem, Integer> reserved;
    public StockList(){
        this.list = new LinkedHashMap<>();
        this.reserved = new LinkedHashMap<>();
    }

    public int addStock(StockItem item){
        if(item != null){
            String test = "Hello";
            StockItem inStock = list.getOrDefault(item.getName(), item);
            /* first parameter is lookup. if it doesn't find it in the list,
            the second param is used to return to the StockItem variable.
             */
            //then check if we already have quantities of this item.
            if(inStock != item){ //if already stock of this item, then adjust the quantity.
                item.adjustQuantity(inStock.getQuantity()); // adjust the item to reflect new quantity by adding the old list's item quantity to this one.
            }

            list.put(item.getName(), item); //will overwrite the current entry if already exists, or add the entry for the first time either way.
            return item.getQuantity();
        }
        return 0;
    }

    public int unreserveItem(StockItem item, int quantity){
        if(reserved.containsKey(item)){
            int newQuantity = reserved.get(item) - quantity;
            if(newQuantity > 0){
                reserved.put(item, newQuantity);
                return newQuantity;
            }else if(newQuantity == 0){
                reserved.remove(item);
            }
        }
        return -1;
    }

    public int reserveItem(String item, int quantity){
        StockItem inStock = list.getOrDefault(item, null);
        int reservedQuantity = reserved.getOrDefault(inStock, 0);
        if(inStock != null && (inStock.getQuantity()-reservedQuantity) >= quantity && quantity > 0){
                reserved.put(inStock, quantity + reservedQuantity);
                return quantity; //returns amount taken out of stock.
        }
        return -1;
    }

    public void checkout(){
        for(Map.Entry<StockItem, Integer> item: reserved.entrySet()){
            list.get(item.getKey().getName()).adjustQuantity(-item.getValue());
        }
        reserved.clear();
    }

    public StockItem getItem(String key){
        return list.get(key);
    }

    public Map<String, StockItem> Items(){
        return Collections.unmodifiableMap(list);
    }

    @Override
    public String toString() {
        String s = "\nStock List\n";
        String r = "\nReserved List\n";
        double totalCost = 0.0;
        for(Map.Entry<String, StockItem> item: list.entrySet()){
            StockItem stockItem = item.getValue();
            double itemValue = stockItem.getPrice() * stockItem.getQuantity();
            s += stockItem.getName() + ". There are " + stockItem.getQuantity() + " in stock. Value of: ";
            s += String.format("$%.2f", itemValue) + "\n";
            totalCost += itemValue;
        }


        for(Map.Entry<StockItem, Integer> item: reserved.entrySet()){
            r += "Item: " + item.getKey().getName() + " Quantity on reserve: " + item.getValue() + "\n";
        }

        return s + "\n\n" + r;
    }
}
