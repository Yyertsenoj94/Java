package StockList;

public class StockItem implements Comparable<StockItem> {
    private final String name;
    private double price;
    private int quantity;

    public StockItem(String name, double price, int quantity){
        this.name = name;
        this. price = price;
        this.quantity = quantity;
    }

    public int getQuantity(){
        return this.quantity;
    }

    public double getPrice(){
        return price;
    }

    public void adjustQuantity(int quantity){
        int newQuantity = this.quantity + quantity;
        if(newQuantity >= 0){
            this.quantity = newQuantity;
        }
    }

    public void setPrice(double price){
        if(price >= 0.0){
            this.price = price;
        }
    }

    public String getName(){
        return this.name;
    }

    @Override
    public int hashCode() {
        return this.name.hashCode() + 53;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || (!obj.getClass().equals(this.getClass()))) {
            return false;
        }
        return ((StockItem) obj).getName().equals(this.name);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public int compareTo(StockItem o) {
        if(o == null){
            throw new NullPointerException();
        }else if(o == this){
            return 0;
        }
        return this.getName().compareTo(o.getName());
    }
}
