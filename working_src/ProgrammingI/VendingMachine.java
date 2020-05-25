
package ProgrammingI;
import java.util.Scanner;
public class VendingMachine {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean chipsSold;
        boolean fruitSold;
        boolean nutsSold;


        boolean juiceSold;
        boolean waterSold;
        boolean coffeeSold;

        chipsSold = scanner.nextBoolean();
        fruitSold = scanner.nextBoolean();
        nutsSold = scanner.nextBoolean();
        juiceSold = scanner.nextBoolean();
        waterSold = scanner.nextBoolean();
        coffeeSold = scanner.nextBoolean();

        if(!(chipsSold && fruitSold && nutsSold && juiceSold && waterSold && coffeeSold)) {
            System.out.print("No Items");

        }else if(chipsSold && fruitSold && nutsSold && juiceSold && waterSold && coffeeSold){
            System.out.println("All-snacks All-drinks");
        }
        else if(chipsSold && fruitSold && nutsSold) {
            System.out.print("All-snacks ");
            if (juiceSold) {
                System.out.print("Juice ");
            }
            if (waterSold) {
                System.out.print("Water ");
            }
            if (coffeeSold) {
                System.out.print("Coffee ");

            }
        }
        else if(juiceSold && waterSold && coffeeSold) {

            if(chipsSold) {
                System.out.print("Chips ");
            }
            if(nutsSold) {
                System.out.print("Nuts ");
            }
            if(fruitSold) {
                System.out.print("Fruit ");
            }
            System.out.print("All-drinks ");
        }
        else{
            if(chipsSold) {
                System.out.print("Chips ");
            }
            if(nutsSold) {
                System.out.print("Nuts ");
            }
            if(fruitSold) {
                System.out.print("Fruit ");
            }
            if (juiceSold) {
                System.out.print("Juice ");
            }
            if (waterSold) {
                System.out.print("Water ");
            }
            if (coffeeSold) {
                System.out.print("Coffee ");

            }
            
        }
        System.out.println("");

    }

}
