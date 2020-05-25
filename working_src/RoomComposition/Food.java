package RoomComposition;
public class Food {

    private int meatSupply;
    private int milkSupply;
    private int coffeeSupply;
    private int waterSupply;


    //default constructor if you don't want to customize the food in the room.
    public Food(){
        this(100, 100, 100, 100);
    }

    public Food(int meatSupply, int milkSupply, int coffeeSupply, int waterSupply){

        this.meatSupply = meatSupply;
        this.milkSupply = milkSupply;
        this.coffeeSupply = coffeeSupply;
        this.waterSupply = waterSupply;



    }

    public void cookFood(){

        System.out.println("Cooking Food......");

        meatSupply -= 5;

        milkSupply -=5;

        waterSupply -=2;

        getSupplyLevel();

    }

    private void getSupplyLevel(){
        System.out.println("Meat Supply is: " + meatSupply);
        System.out.println("Milk Supply is: " + milkSupply);
        System.out.println("Coffee Supply is: " + coffeeSupply);
        System.out.println("Water Supply is: " + waterSupply);

    }

    public void makeCoffee(){
        System.out.println("Brewing Coffe");
        coffeeSupply -= 10;

        getSupplyLevel();
    }


}
