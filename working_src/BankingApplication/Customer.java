package BankingApplication;
import java.util.ArrayList;
import java.util.Scanner;

public class Customer {
    private String name;
    private ArrayList<Double> transactions = new ArrayList<Double>();
    private String branchName;

    //-------------------------------------------CONSTRUCTOR--------------------------------------------------------
    private Customer(String name, String branchName) {
        this.name = name;
        this.branchName = branchName;

    }//-------------------------------------------------------------------------------------------------------------


    //-----------------------------------PUBLIC FUNCTIONS FOR HIERARCHY---------------------------------------------

    //static "Factory" convenience method for returning a customer based on inputs.
    public static Customer createCustomer(String name, String branchName){

        return new Customer(name, branchName);

        //NOTE:
        //need to pass in the correct branch name from wherever this will be called.
    }

    //function to return customer name.
    public String getName(){

        return name;

    }

    //function to return customer branch name.
    public String getBranchName(){

        return branchName;

    }
    //--------------------------------------------------------------------------------------------------------------



    //need to actually go in and print and show all transactions, user then need to select the one to modify.

    //------------------------------ADD, MODIFY, REMOVE, PRINT FUNCTIONS--------------------------------------------
    public void addTransaction(double value){
        Double modValue = Double.valueOf(value);
        transactions.add(modValue);
        System.out.println("Transaction amount of: " + modValue.doubleValue() + " was successful");
    }

    public void setTransactions(ArrayList<Double> transactions){
        this.transactions.addAll(transactions);

    }

    public void modifyTransaction(int index, double newValue){
        transactions.set(index, newValue);
        System.out.println("Transaction: " + (index+1) + ", was successfully changed to " + newValue);
    }

    public void printTransactions(){
        System.out.println("-------------Begin Transaction History------------------");
        for(int i = 0; i < transactions.size(); i++){
            System.out.println((i+1) + ": " + transactions.get(i));
        }
        System.out.println("--------------End Transaction History-------------------");
    }

    public int selectTransaction(String message){
        printTransactions();
        int choice;
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        choice = scanner.nextInt();
        scanner.nextLine();

        return choice;
    }

    public int getTransactionLength(){
        return transactions.size();
    }

    public ArrayList<Double> getTransactions(){
        return transactions;
    }

    public double getTransaction(int i){
        double value;
        value = transactions.get(i).doubleValue();
        return value;
    }

    public void deleteTransaction(int value){
        int modValue = (value -1);
        double placeValue = transactions.get(modValue).doubleValue();
        transactions.remove(modValue);
        System.out.println("Transaction number " + value + " of amount: " + placeValue + " was deleted");
    }
    //-------------------------------------------------------------------------------------------------------------

}




