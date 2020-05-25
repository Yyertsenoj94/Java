package BankingApplication;
import java.util.ArrayList;

public class Branch {
    public String branchName;
    ArrayList<Customer> customers;

    //-------------------------------------------CONSTRUCTOR--------------------------------------------------------
    public Branch(String branchName){
        this.branchName = branchName;
        //this below might need to be moved back into the variables listing.
        this.customers = new ArrayList<Customer>();
    }//-------------------------------------------------------------------------------------------------------------


    //-----------------------------------PUBLIC FUNCTIONS FOR HIERARCHY---------------------------------------------
    public static Branch createBranch(String branchName){
        return new Branch(branchName);
    }

    public String getBranchName(){
        return branchName;
    }


    public Customer queryCustomer(String name){
        int customerIndex = customerIndex(name);
        if(customerIndex >= 0){
            System.out.println(customers.get(customerIndex).getName() + " was found");
        }else{
            System.out.println("Customer was not found");
        }
        return customers.get(customerIndex);
    }

    //can this function be private??
    public Customer queryCustomer(Customer customer){
        if(customerIndex(customer) >= 0){
            System.out.println(customer.getName() + " was found");
            return customer;
        }else{
            System.out.println("Customer was not found");
            return null;
        }
    }

    public Customer queryCustomer(int integer){
        return customers.get(integer);
    }

    public int getCustomerLength(){
        return customers.size();
    }

    public void setCustomer(ArrayList<Customer> customer){
        this.customers = customer;
    }
    //--------------------------------------------------------------------------------------------------------------


    //--------------------------------------------PRIVATE FUNCTIONS-------------------------------------------------
    private int customerIndex(String name){

        for(int i = 0; i < customers.size(); i++){
            //test to see if the loop customer name = name passed into the function.
            if(customers.get(i).equals(name)){
                return i;
            }
        }
        return -1;
    }

    private int customerIndex(Customer customer){

        for(int i = 0; i < customers.size(); i++){
            //test to see if the loop customer equals the customer passed in.
            if(customers.get(i).equals(customer)){
                return i;
            }
        }
        return -1;
    }
    //--------------------------------------------------------------------------------------------------------------


    //------------------------------ADD, MODIFY, REMOVE, PRINT FUNCTIONS--------------------------------------------
    public void addCustomer(Customer customer){

        if(customerIndex(customer) < 0){
            customers.add(customer);
            System.out.println("Customer " + customer.getName() + " was successfully created");
        }else{
            System.out.println("Customer " + customer.getName() + " already exists in branch " + getBranchName());
        }

    }

    public void modifyCustomer(Customer oldCustomer, Customer newCustomer){
        ArrayList<Double> tempTransaction = oldCustomer.getTransactions();
        String tempOldName = oldCustomer.getName();
        int oldIndex = customerIndex(oldCustomer);

        //If the customer is in a different branch, it should be ok to add this customer because it's looking at
        //the ENTIRE customer object (which includes the branch), not just the customer name.
        if(oldIndex < 0){
            System.out.println("Customer " + oldCustomer.getName() + " does not exist.");
        }else{
            customers.set(oldIndex, newCustomer);
            //set the old transaction listing with the modified customer.
            newCustomer.setTransactions(tempTransaction);
            System.out.println("Customer " + tempOldName + " was sucessfully replaced with " + newCustomer.getName() + " for the " + branchName + " branch.");
        }
    }

    public void removeCustomer(Customer customer){
        String tempName = customer.getName();
        if(customerIndex(customer) < 0){
            System.out.println("Customer " + customer.getName() + " does not exist.");
        }else{
            customers.remove(customer);
            System.out.println("Customer" + tempName + " was successfully removed.");
        }
    }

    public void printCustomers(){

        for(int i = 0; i < customers.size(); i++){
            System.out.println((i+1) + ": " + customers.get(i).getName() + " | " + customers.get(i).getBranchName());
        }
    }
    //--------------------------------------------------------------------------------------------------------------



}
