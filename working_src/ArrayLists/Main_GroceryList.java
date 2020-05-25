
package ArrayLists;
import java.util.Scanner;

public class Main_GroceryList {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){

    MenuOptions();


    }

    public static void MenuOptions(){
       int choice;
       boolean runApp = true;
       GroceryList groceryList = new GroceryList();

       while(runApp){

           System.out.println("Please select an option from the menu: \n");
           getMenu();

           choice = scanner.nextInt();
           scanner.nextLine(); //removes the buffer to continue running:

           switch (choice){
               case 1:
                   System.out.println("Please enter an item to add");
                   groceryList.addItem(scanner.nextLine());
                   break;
               case 2:
                   System.out.println("Please enter an item to remove");
                   groceryList.removeItem(scanner.nextLine());
                   break;
               case 3:
                   System.out.println("Enter the item you wish to change");
                   String changeItem = scanner.nextLine();

                   System.out.println("Please enter the alteration");
                   String modifyTo = scanner.nextLine();

                   groceryList.modifyItem(changeItem, modifyTo);
                   break;

               case 4:
                   System.out.println("--------------------------------------");
                   groceryList.printList();

                   System.out.println("--------------------------------------");
                   break;
               case 5:
                   runApp = false;
           }

       }

    }

    public static void getMenu(){
        System.out.println("1: Add Item \t");
        System.out.println("2: Remove Item \t");
        System.out.println("3: Change Item \t");
        System.out.println("4: Print List \t");
        System.out.println("5: Exit Menu \t");
        System.out.println("\n");
    }

}


