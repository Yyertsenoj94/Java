package BankingApplication;import java.util.Scanner;

public class Main_Bank {
    private static Bank bank;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome! Please enter bank name: \r");
        bank = new Bank(retrieveString());
        mainMenu(bank);
        System.out.println("Welcome to " + bank.getName());
    }


    public static void welcomeMenu() {
        System.out.println("----------------MAIN MENU--------------------------------------------------------");
        System.out.println("\n1: Create Branch");
        System.out.println("\n2: Modify Branch");
        System.out.println("\n3: Remove Branch");
        System.out.println("\n4: Print Branch List");
        System.out.println("\n5: Create Customer");
        System.out.println("\n6: Modify Customer");
        System.out.println("\n7: Remove Customer");
        System.out.println("\n8: Print Customer List");
        System.out.println("\n9: Create Transaction");
        System.out.println("\n10: Modify Transaction");
        System.out.println("\n11: Remove Transaction");
        System.out.println("\n12: Print Transaction List");
        System.out.println("\n13: Exit Menu");
        System.out.println("---------------------------------------------------------------------------------");

    }


    public static void mainMenu(Bank bank) {
        boolean exitMenu = true;

        while (exitMenu) {
            clearScreen();
            welcomeMenu();
            int choice = 0;
            choice = retrieveInt();

            switch (choice) {
                case 1:
                    createBranch();
                    break;
                case 2:
                    modifyBranch();
                    break;
                case 3:
                    removeBranch();
                    break;
                case 4:
                    bank.printBranches(1);
                    //type 1 tells function to not print out "Add new Branch"
                    break;
                case 5:
                    createCustomer();
                    break;
                case 6:
                    modifyCustomer();
                    break;
                case 7:
                    removeCustomer();
                    break;
                case 8:
                    printTotalCustomerList();
                    break;
                case 9:
                    createTransaction();
                    break;
                case 10:
                    modifyTransaction();
                    break;
                case 11:
                    removeTransaction();
                    break;
                case 12:
                    printTransactionList();
                    break;
                case 13:
                    exitMenu = false;
            }

        }

    }

    public static void clearScreen(){
        System.out.print("\033[H\033[2J");

    }

    public static void createBranch() {
        System.out.println("Please enter new branch name\r");
        String branchName = retrieveString();

        //use the static factory function to create the object.
        Branch branch = Branch.createBranch(branchName);

        //using the add branch.
        bank.addBranch(branch);

    }


    public static void modifyBranch() {
        String message = "Please select the branch you are modifying: \r";
        Branch oldBranch = bank.BranchMenuSelect(message);

        System.out.println("Enter modified name of branch\r");
        //input name of new branch to input in old place
        Branch newBranch = Branch.createBranch(retrieveString());

        bank.modifyBranch(oldBranch, newBranch);

        //how are the customers going to carry over????

    }

    public static void removeBranch() {
        System.out.println("Enter name of branch to remove\r");
        int choice = 0;
        if(!branchExist()){
            System.out.println("No branches currently exist. Please create a new branch\r");
        }else{
            System.out.println("Select Branch\r");
            bank.printBranches(1);
            //tells function to add option for creating a branch.
            choice = retrieveInt();
        }
        Branch branch = bank.queryBranch(choice);

        bank.removeBranch(branch);

    }

    public static void createCustomer() {
            int choice = 1;

            if(!branchExist()){
                System.out.println("No branches currently exist. Please create a new branch\r");
            }else{
                System.out.println("Select Branch\r");
                bank.printBranches(0);
                //tells function to add option for creating a branch.
                choice = retrieveInt();
            }

            if(choice > bank.getBranchNumber()){
                //this means the user selected add new branch, since he is seeing the count as one more than the actual index.
                createBranch();
            }

            //find branch the user selected
            Branch branch = bank.queryBranch(choice-1);

            //get name of new customer to be created.
            System.out.println("Please enter name of new customer\r");
            String name = retrieveString();

            //create customer via factory method and pass on to add Customer function as a customer object.
            Customer customer = Customer.createCustomer(name, branch.getBranchName());
            branch.addCustomer(customer);

            //add initial transaction amount
            System.out.println("Enter initial deposit");
            double amount = retrieveDouble();
            customer.addTransaction(amount);
    }


    public static void modifyCustomer() {
        if(bank.getBranchNumber() == 0){
            System.out.println("No branches exist");
        }else{
            //create a query the user can go to for finding the branches they are a part of.
            String message = "Please select the branch of the customer you are modifying: \r";
            Branch branch = bank.BranchMenuSelect(message);

            //select customer you need to remove
            branch.printCustomers();
            int decision = retrieveInt();

            //instantiate a customer object to pass to the removeCustomer function
            Customer oldCustomer = branch.queryCustomer(decision-1);

            //find a way to save down transaction history of the old customer. use some gets for this.
            System.out.println("Please enter the new name of the customer\r");
            String newName = retrieveString();

            Customer newCustomer = Customer.createCustomer(newName, branch.branchName);

            branch.modifyCustomer(oldCustomer, newCustomer);
        }

    }


    public static void removeCustomer() {

        if(bank.getBranchNumber() == 0){
            System.out.println("No branches exist");
        }else {
            //select branch you need to delete customer from
            String message = "Please select the branch you are deleting customer from \r";
            Branch branch = bank.BranchMenuSelect(message);

            //select customer you need to remove
            branch.printCustomers();
            int decision = retrieveInt();

            //instantiate a customer object to pass to the removeCustomer function
            Customer customer = branch.queryCustomer(decision-1);

            //remove the customer
            branch.removeCustomer(customer);
        }
    }


    public static void printTotalCustomerList() {
        int branchLength;

        branchLength = bank.getBranchNumber();
        //selecting all branches, and all customers within each branch.
        System.out.println("# | Customer | Branch\n");
        for (int i = 0; i < branchLength; i++) {

            Branch branch = bank.queryBranch(i);
            int customerLength = branch.getCustomerLength();
            System.out.println("-------" + branch.getBranchName() + "-------");

            for (int j = 0; j < customerLength; j++) {
                //I'm having to increment this, because the queryCustomer is used for printing options for a user to select
                Customer customer = branch.queryCustomer(j);


                System.out.println((j + 1) + " | " + customer.getName() + " | " + branch.branchName + "\r");
            }

        }

    }


    public static void createTransaction() {
        if(branchExist()){
            String message = "Please select the branch for the customer \r";
            Branch branch = bank.BranchMenuSelect(message);

            if(customerExist(branch)) {
                //select customer you need add transaction for:
                //select customer you need to remove
                branch.printCustomers();
                int decision = retrieveInt();

                //instantiate a customer object to pass to the removeCustomer function
                Customer customer = branch.queryCustomer(decision-1);

                System.out.println("Please enter transaction amount for customer " + customer.getName());
                double amount = retrieveDouble();

                customer.addTransaction(amount);
            }
        }

    }


    public static void removeTransaction() {

        if(branchExist()){
            String message = "Please select the branch for the customer \r";
            Branch branch = bank.BranchMenuSelect(message);

            if(customerExist(branch)) {
                //select customer you need to remove
                branch.printCustomers();
                int decision = retrieveInt();

                //instantiate a customer object to pass to the removeCustomer function
                Customer customer = branch.queryCustomer(decision-1);

                //retrieve the index value of the customer's transaction history
                String transaction_message = "Please select transaction to remove\r";
                int value = customer.selectTransaction(message);

                //delete transaction for customer
                customer.deleteTransaction(value);
            }
        }

    }


    public static void modifyTransaction() {


        if(branchExist()){
            String message = "Please select the branch for the customer \r";
            Branch branch = bank.BranchMenuSelect(message);

            if(customerExist(branch)) {
                //select customer you need to remove
                branch.printCustomers();
                int decision = retrieveInt();

                //instantiate a customer object to pass to the removeCustomer function
                Customer customer = branch.queryCustomer(decision-1);

                //retrieve the index value of the customer's transaction history
                int value = customer.selectTransaction("Please select transaction to modify\r");

                System.out.println("Please enter new value for the transaction amount\r");

                double newValue = retrieveDouble();

                //modify value for customer
                customer.modifyTransaction(value-1, newValue);
                System.out.println("Modification of transaction number: " + (value + 1) + ", complete for customer " + customer.getName() + " of branch " + branch.getBranchName());
            }
        }


    }


    public static void printTransactionList() {
        int branchLength;

        branchLength = bank.getBranchNumber();
        //selecting all branches, and all customers within each branch.
        System.out.println("# Customer | Transaction | Branch\n");
        for (int i = 0; i < branchLength; i++) {

            Branch branch = bank.queryBranch(i);
            int customerLength = branch.getCustomerLength();
            System.out.println("-------" + branch.getBranchName() + "-------");
            for (int j = 0; j < customerLength; j++) {
                Customer customer = branch.queryCustomer(j);
                int transactionLength = customer.getTransactionLength();


                for (int k = 0; k < transactionLength; k++) {

                    System.out.println((k + j + 1) + ". " + customer.getName() + " | " + customer.getTransaction(k) + " | " + branch.branchName + "\r");

                }
            }
        }
        System.out.println("-------------------------------------");

        //duplicate code, need to modify:

    }


    private static String retrieveString() {
        return scanner.nextLine();
    }

    private static double retrieveDouble() {
        if(scanner.hasNextDouble()){
            return scanner.nextDouble();
        }else{
            System.out.println("Please enter value above 0");
            return scanner.nextDouble();
        }
    }

    private static int retrieveInt() {
        boolean getInt = true;

        while(getInt){
            if(scanner.hasNextInt()){
                int integer = scanner.nextInt();
                scanner.nextLine();
                getInt = false;
                return integer;
            }else{
                System.out.println("Please enter a valid value:");
                int integer = scanner.nextInt();
                scanner.nextLine();
            }
        }
        return -1;

    }


    //----------------------------------------VALIDATION CODE-------------------------------------------------------
    private static boolean branchExist(){
        if(bank.getBranchNumber() == 0){
            System.out.println("There are no existing branches");
            return false;
        }else{
            return true;
        }
    }

    private static boolean customerExist(Branch branch){
        if(branch.getCustomerLength() ==0){
            System.out.println("There are no customers for this branch.");
            return false;
        }else{
            return true;
        }
    }
}
