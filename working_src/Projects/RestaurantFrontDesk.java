package Projects;
import java.util.Scanner;

/* Author: Trey Jones
 * Date: 3/31/2020
 *
 * RestaurantFrontDesk Purpose:
 * The following program allows the table manager to input the customer's name and party. It will then auto assign
 * the customer a table if there is a table that meets their requirements. It then also allows the manager to clear
 * a table when the customer is leaving, and print the status of the tables to determine which tables are currently occupied.
 */

public class RestaurantFrontDesk {
    static final Scanner CONSOLE = new Scanner(System.in);

    public static void main(String[] args){

        boolean[] occupied = {false, false, false, false, false};
        int[] seats = {2, 2, 4, 5, 8};
        String[] names = {"","","","",""};
        int decision = -1; //initialize to -1 to prevent exiting on the first loop.


        //basic heading information at start of program.
        System.out.println("Spring 2020 - CS1083 - Section 002 - Project 2 - written by Trey Jones");
        System.out.println("Restaurant Front Desk");
        System.out.println("-------------------------");
        System.out.println("Welcome to XYZ Restaurant \n");


        do{ //loop to repeat the menu options until the user selects 0.
            decision = menuOption(); //go to menu display for the customer options

            //if else statement to determine which menu option is selected, and call the appropriate function.
            if(decision == 1){
                newCustomer(occupied, names, seats); // call the newCustomer function.
            }else if(decision == 2){
                emptyTable(occupied, names); //call the emptyTable function.
            }else if(decision == 3){
                printStatus(occupied, names, seats); //call the printStatus function.
            }else if(decision == 0){
                System.out.println("thank you, and good bye.");
            }else{
                System.out.println("Wrong option selected. Please, try again.");
            }

        }while(decision != 0);

    }

    public static int menuOption(){
        System.out.println("----- MENU -----");
        System.out.println("0: Exit");
        System.out.println("1: New Customer");
        System.out.println("2: Empty table");
        System.out.println("3: Print status");
        System.out.print("What is your choice? ");
        return CONSOLE.nextInt(); // returns the menu choice of the user
    }

    public static void newCustomer(boolean[] occupied, String[] names, int[] seats){
        System.out.print("Customer's name? ");
        String userName = CONSOLE.next();  //takes in the customer's name.
        System.out.print("For how many people? ");
        int userCapacity = CONSOLE.nextInt(); //takes in the number of people the customer needs to sit.
        int customerTable = -1; //initialize the customerTable to -1 as a default in case no table is found in the check for table loop.

        //loop through each of the tables to determine whether the table is occupied and if the table capacity meets
        //the customer's needs.
        for(int i = 0; i < seats.length; i++){
            if(seats[i] >= userCapacity && !occupied[i]){
                customerTable = i; //sets the table number of the customer.
                break; //stop going through loop since table was found.
            }
        }

        if(customerTable != -1){ //if no table is found (-1) then, supply error message, otherwise set the arrays accordingly.
            occupied[customerTable] = true; //make the occupied = true;
            names[customerTable] = userName; //store the customer name in the name array
            System.out.println("Welcome " + userName + " your table is number " + (customerTable +1)); //welcome the customer and tell them their table number.
        }else{
            System.out.println("We are sorry, there is no table available."); //error message if table not found.
        }
    }

    public static void emptyTable(boolean[] occupied, String[] names){
        System.out.print("What table was made avaliable? ");
        int tableNumber = CONSOLE.nextInt(); //stores user entered table to empty out.

        if(tableNumber > occupied.length || tableNumber <= 0){ //return an error message if the table is outside range.
            System.out.println("Table number out of range. Please, try again.");
        }else if(!occupied[tableNumber-1]){//return an error message if the table was empty to begin with.
            System.out.println("The table " + tableNumber + " is not occupied. Please, try again.");
        }else{//if no error, then set the table to empty and clear out the customer name from the name array.
            System.out.println("We hope to have you back soon, " + names[tableNumber-1] + ".");
            occupied[tableNumber - 1] = false;
            names[tableNumber - 1] = "";
        }
    }

    //prints the status of each table.
    public static void printStatus(boolean[] occupied, String[] names, int[] seats){
        for(int i = 0; i < occupied.length; i++){ //goes through each table and prints out the info.
            if(occupied[i]){ //only print status if the table is occupied.
                System.out.print("Table: " + (i+1) + " Seats: " + seats[i] + " Name: " + names[i] + "\n");
            }
        }
    }

}
