package BankingApplication;
import java.util.ArrayList;
import java.util.Scanner;

public class Bank {
    private ArrayList<Branch> branches = new ArrayList<>();
    private String name;

    //-------------------------------------------CONSTRUCTOR--------------------------------------------------------
    public Bank(String name){
        this.branches = new ArrayList<>();
        this.name = name;
    }//-------------------------------------------------------------------------------------------------------------

    //-----------------------------------PUBLIC FUNCTIONS FOR HIERARCHY---------------------------------------------
    public Branch queryBranch(String name){

        int branchIndex = branchIndex(name);
        if(branchIndex < 0){
            System.out.println("Branch does not exist");
            return null;
        }else{
            return branches.get(branchIndex);
        }

    }

    //again can this function be private???
    public Branch queryBranch(Branch branch){

        int branchIndex = branchIndex(branch);
        if(branchIndex < 0){
            System.out.println("Branch does not exist");
            return null;
        }else{
            return branch;
        }
    }


    public Branch queryBranch(int integer){
        return branches.get(integer);
    }

    public Branch BranchMenuSelect (String message){
        int branchChoice;
        Scanner scanner = new Scanner(System.in);
        for(int i = 0; i < branches.size(); i++){
            System.out.println((i+1) + ". Branch - " + branches.get(i).getBranchName() + ". ");
        }

        System.out.println(message);

        branchChoice = scanner.nextInt();
        scanner.nextLine();
        branchChoice -=1;

        return queryBranch(branchChoice);

    }

    public int getBranchNumber(){
        return branches.size();
    }

    public String getName(){
        return name;
    }
    //--------------------------------------------------------------------------------------------------------------




    //--------------------------------------------PRIVATE FUNCTIONS-------------------------------------------------
    private int branchIndex(String name){

        for(int i = 0; i < branches.size(); i++){
            if(branches.get(i).getBranchName().equals(name)){
                return i;
            }
        }

        return -1;
    }

    private int branchIndex(Branch branch){

        for(int i = 0; i < branches.size(); i++){
            if(branches.get(i) == branch){
                return i;
            }
        }
        return -1;

    }


    //--------------------------------------------------------------------------------------------------------------




    //------------------------------ADD, MODIFY, REMOVE, PRINT FUNCTIONS--------------------------------------------

    //Staging_Functions to add branches. Again, not sure if this should be here or not.
    public void addBranch(Branch branch){
        if(branchIndex(branch) < 0){
            branches.add(branch);
            System.out.println("Branch " + branch.getBranchName() + " was successfully added.");
        }
        else{
            System.out.println("Branch already exists.");
        }

    }

    public void removeBranch(Branch branch){
        String tempName = branch.getBranchName();
        if(branchIndex(branch) < 0){
            System.out.println("Branch " + branch.getBranchName() + " does not exist.");
        }else{
            branches.remove(queryBranch(branch));
            System.out.println("Branch " + branch.getBranchName() + " was successfully removed.");
        }
    }

    public void modifyBranch(Branch oldBranch, Branch newBranch){
        ArrayList<Customer> tempCustomers = new ArrayList<Customer>();
        String tempOldName = oldBranch.getBranchName();

        //store old branch list of customers for the new branch.
        tempCustomers.addAll(oldBranch.customers);


        int oldIndex = branchIndex(oldBranch);

        if(oldIndex < 0){

            System.out.println("Branch " + oldBranch.getBranchName() + " does not exist.");

        }else{

            branches.set(oldIndex, newBranch);
            newBranch.setCustomer(tempCustomers);
            System.out.println("Branch " + tempOldName + " was sucessfully replaced with " + newBranch.getBranchName());

        }
    }

    public void printBranches(int type){
            int nextBranch = 1;
            System.out.println("-----------------------------");
            System.out.println("# | Branch Name");
            for(int i = 0; i < branches.size(); i++){
                System.out.println((i+1) + ": " + branches.get(i).getBranchName());
                nextBranch = i+1;
            }
            if(type == 0){
                System.out.println((nextBranch+1) + ": Add new Branch");
                System.out.println("-----------------------------");
            }else{
                System.out.println("-----------------------------");
            }


    }
    //--------------------------------------------------------------------------------------------------------------

}
