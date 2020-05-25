package OOP_Master_Challenge;
public class BurgerChallenge {

    public static void main(String[] args){
        Burger burger = new Burger("Regular", "beef", "white", 5.99);
        burger.addTopping1("Cheese", 2.00);
        burger.addTopping2("Onion", .50);
        burger.addTopping3("Lettuce", .84);
        burger.addTopping4("Tomato", 2.00);

        burger.getBurgerDetails();
        burger.getToppingTotal();

        HealthyBurger healthyBurger = new HealthyBurger("HealthyBurger", "Turkey", 7.86);
        healthyBurger.addTopping1("Cheese", 2.00);
        healthyBurger.addTopping2("Onion", .50);
        healthyBurger.addTopping3("Lettuce", .84);
        healthyBurger.addTopping4("Tomato", 2.00);
        healthyBurger.addTopping5("HealthySauce", 2.00);
        healthyBurger.addTopping6("Carrots", 2.00);

        healthyBurger.getBurgerDetails();
        healthyBurger.getToppingTotal();

        DeluxBurger deluxBurger = new DeluxBurger("The Deluxe", "Steak", "Sesame", 10.80);

        deluxBurger.addTopping1("Test", 2.00);
        deluxBurger.getBurgerDetails();
        deluxBurger.getToppingTotal();

    }
}

class Burger{
    private String name;
    private String meat;
    private String bread;
    private double price;

    private String topping1;
    private String topping2;
    private String topping3;
    private String topping4;

    private double topping1Price;
    private double topping2Price;
    private double topping3Price;
    private double topping4Price;

    private double toppingTotal;

    public Burger(String name, String meat, String bread, double price){
        this.name = name;
        this.meat = meat;
        this.bread = bread;
        this.price = price;

    }

    public void addTopping1(String name, double price){
        topping1 = name;
        topping1Price = price;
        System.out.println("Added " + name + " for an additional " + price);
    }

    public void addTopping2(String name, double price){
        topping2 = name;
        topping2Price = price;
        System.out.println("Added " + name + " for an additional " + price);
    }

    public void addTopping3(String name, double price){
        topping3 = name;
        topping3Price = price;
        System.out.println("Added " + name + " for an additional " + price);
    }

    public void addTopping4(String name, double price){
        topping4 = name;
        topping4Price = price;
        System.out.println("Added " + name + " for an additional " + price);
    }

    public double getToppingTotal(){
        if(topping1 != null){
            toppingTotal += topping1Price;
        }
        if(topping2 != null){
            toppingTotal += topping2Price;
        }
        if(topping3 != null){
            toppingTotal += topping3Price;
        }
        if(topping4 != null){
            toppingTotal += topping4Price;
        }
        return toppingTotal;
    }

    public void getBurgerDetails(){
        System.out.println("Burger: " + name + ". With " + meat + ", on a " + bread + " roll. The total cost is " + (getToppingTotal() + price));
    }

    public void setToppingTotal(double price){
        toppingTotal += price;
    }

}

class HealthyBurger extends Burger{
    private String topping5;
    private String topping6;

    private double topping5Price;
    private double topping6Price;

    public HealthyBurger(String name, String meat, double price) {
        super(name, meat, "Rye", price);
    }

    public void addTopping5(String name, double price){
        topping5 = name;
        topping5Price = price;
        System.out.println("Added " + name + " for an additional " + price);
    }

    public void addTopping6(String name, double price){
        topping6 = name;
        topping6Price = price;
        System.out.println("Added " + name + " for an additional " + price);
    }

    @Override
    public double getToppingTotal() {
        if(topping5 != null){
            setToppingTotal(topping5Price);
        }if(topping6 != null){
            setToppingTotal(topping6Price);
        }
        return super.getToppingTotal();
    }


}

class DeluxBurger extends Burger{

    public DeluxBurger(String name, String meat, String bread, double price){
        super(name, meat, bread, price);
        super.addTopping1("Chips", 2.00);
        super.addTopping2("Drink", 2.55);

    }

    @Override
    public void addTopping1(String name, double price) {
        System.out.println("You cannot add additional toppings");
    }

    @Override
    public void addTopping2(String name, double price) {
        System.out.println("You cannot add additional toppings");
    }


    @Override
    public void addTopping3(String name, double price) {
        System.out.println("You cannot add additional toppings");
    }

    @Override
    public void addTopping4(String name, double price) {
        System.out.println("You cannot add additional toppings");
    }

}



//------------------------------------------------BEGIN MY SOLUTION----------------------------------------------------------------------------------------------
//Would like to make this to where it accepts a name, and the price of the topping, instead of true false.
//then, need to check to see if the topping name is not null to validate price and add.

//public class BurgerChallenge {
//
//    public static void main(String[] args){
//
//        Burger burger = new Burger("Regular", "White", "Beef", 3.99);
//        burger.addToppings(true, false, true, false);
//        System.out.println("Regular Burger Grand Total: " + burger.getGrandTotal());
//        System.out.println("Regular Burger, " + burger.getName() + ", consists of " + burger.getBreadType() + ", " + burger.getMeat() + ". " +
//                "Total Toppings: " + burger.getItemTotal());
//
//
//
//        HealthyBurger healthyBurger = new HealthyBurger("Healthy", "Turkey", 5.00);
//        healthyBurger.addToppings(false,false,false,true,true,true);
//        System.out.println("Healthy Burger Grand Total: " + healthyBurger.getGrandTotal());
//        System.out.println("Healthy Burger, " + healthyBurger.getName() + ", consists of " + healthyBurger.getBreadType() + ", " + healthyBurger.getMeat() +
//                ". Total Toppings: " + healthyBurger.getItemTotal());
//
//
//        DeluxeBurger deluxeBurger = new DeluxeBurger("Delux", "Italian", "Kobe", 10.00);
//        deluxeBurger.addToppings(true, true);
//        System.out.println("Delux Burger Grand Total: " + deluxeBurger.getGrandTotal());
//        System.out.println("Delux Burger, " + deluxeBurger.getName() + ", consists of " + deluxeBurger.getBreadType() + ", " + deluxeBurger.getMeat()
//                + ". Total Toppings: " + deluxeBurger.getItemTotal());
//
//
//    }
//
//}
//
//class Burger {
//
//    //---------------------------INSTANCE VARIABLES--------------------------
//    private String name;
//    private String breadType;
//    private String meat;
//    private double price;
//
//    //---------------------------TOPPINGS VARIABLE---------------------------
//    private Topping topping;
//
//    //---------------------------CONSTRUCTORS--------------------------------
//
//    //constructor for the burger class:
//    public Burger(String name, String breadType, String meat, double price) {
//        this.name = name;
//        this.breadType = breadType;
//        this.meat = meat;
//        this.price = price;
//    }
//
//    //----------------------------METHODS------------------------------------
//
//    //method to set the toppings and pass to the variable "regularAddition"
//    public void addToppings(boolean cheese, boolean tomato, boolean lettuce, boolean onion){
//
//        topping = new Topping(cheese, tomato, lettuce, onion);
//
//    }
//
//    //----------------------GETTERS AND SETTERS------------------------------
//
//    //return the main burger price:
//    public double getPrice(){
//        return price;
//    }
//
//    //set the topping total for this burger instance.
//    public double getToppingTotal(){
//        return topping.getToppingTotal();
//    }
//
//    public double getGrandTotal(){
//
//        return (getToppingTotal() + getPrice());
//    }
//
//    public String getItemTotal(){
//        return topping.getTotalItems();
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public String getBreadType() {
//        return breadType;
//    }
//
//    public String getMeat() {
//        return meat;
//    }
//}
//
//class HealthyBurger extends Burger{
//
//    //---------------------------TOPPINGS VARIABLE---------------------------
//    private Topping topping;
//
//    //---------------------------CONSTRUCTOR--------------------------------
//    public HealthyBurger(String name, String meat, double price){
//        super(name, "Rye", meat, price);
//    }
//
//    //----------------------------METHODS------------------------------------
//    public void addToppings(boolean cheese, boolean tomato, boolean lettuce, boolean onion, boolean healthySauce, boolean carrot){
//        topping = new Topping(cheese, tomato, lettuce, onion, healthySauce, carrot);
//    }
//
//    @Override
//    public double getToppingTotal(){
//        return topping.getToppingTotal();
//    }
//
//    //return the main burger price:
//    @Override
//    public double getPrice(){
//        return super.getPrice();
//    }
//
//    @Override
//    public double getGrandTotal(){
//        return getPrice() + getToppingTotal();
//    }
//
//    @Override
//    public String getItemTotal(){
//        return topping.getTotalItems();
//    }
//
//}
//
//class DeluxeBurger extends Burger{
//
//    //---------------------------TOPPINGS VARIABLE---------------------------
//    private Topping topping;
//
//    //---------------------------CONSTRUCTOR--------------------------------
//    public DeluxeBurger(String name, String breadType, String meat, double price){
//        super(name, breadType, meat, price);
//    }
//
//    //----------------------------METHODS------------------------------------
//    public void addToppings(boolean chips, boolean drink){
//        topping = new Topping(chips, drink);
//    }
//
//    @Override
//    public double getToppingTotal(){
//        return topping.getToppingTotal();
//    }
//
//    //return the main burger price:
//    @Override
//    public double getPrice(){
//        return super.getPrice();
//    }
//
//    @Override
//    public double getGrandTotal(){
//        return getPrice() + getToppingTotal();
//    }
//
//    @Override
//    public String getItemTotal(){
//        return topping.getTotalItems();
//    }
//
//}
//
//class Topping{
//
//        //variables for passing in toppings
//        private boolean cheese;
//        private boolean onion;
//        private boolean tomato;
//        private boolean lettuce;
//        private boolean healthySauce;
//        private boolean carrot;
//        private boolean chips;
//        private boolean drink;
//
//        private static double toppingPrice = .25;
//        private static double deluxAdditions = .75;
//
//        //variables for calculating additions:
//        private double sum;
//        private String totalItems = "";
//
//
//
//        //---------------------------CONSTRUCTORS-------------------------------
//        //main constructor for a regular burger:
//        public Topping(boolean cheese, boolean onion, boolean tomato, boolean lettuce){
//            this.cheese = cheese;
//            this.onion = onion;
//            this.tomato = tomato;
//            this.lettuce = lettuce;
//        }
//
//        //constructor for a healthy burger:
//        public Topping(boolean cheese, boolean onion, boolean tomato, boolean lettuce, boolean healthySauce, boolean carrot){
//            //points to main constructor ^^^^
//            this(cheese, onion, tomato, lettuce);
//            this.healthySauce = healthySauce;
//            this.carrot = carrot;
//        }
//
//        //constructor for a deluxe burger:
//        public Topping(boolean chips, boolean drink){
//            //points to main constructor ^^^^
//            this(false, false, false, false);
//            this.chips = chips;
//            this.drink = drink;
//        }
//
//
//        //----------------------GETTERS AND SETTERS------------------------------
//        public double getToppingTotal(){
//
//            if(cheese){
//                sum += toppingPrice;
//                totalItems += "Cheese ";
//            }
//            if(tomato){
//                sum += toppingPrice;
//                totalItems += "Tomato ";
//            }
//            if(onion){
//                sum += toppingPrice;
//                totalItems += "Onion ";
//            }
//            if(lettuce){
//                sum += toppingPrice;
//                totalItems += "Lettuce ";
//            }
//            if(healthySauce){
//                sum += toppingPrice;
//                totalItems += "HealthySauce ";
//            }
//            if(carrot){
//                sum += toppingPrice;
//                totalItems += "Carrot ";
//            }
//            if(chips){
//                sum += deluxAdditions;
//                totalItems += "Chips ";
//            }
//            if(drink){
//                sum += deluxAdditions;
//                totalItems += "Drink ";
//            }
//
//            return sum;
//        }
//
//
//        public String getTotalItems(){
//
//            return totalItems;
//
//        }
//
//}
//
//
//

