package BankAccount;

public class BankAccount {

    private int acctNumber = 0;

    private double balance = 0;

    private String phoneNumber = "";

    private String customerName = "";

    public int getAcctNumber() {
        return acctNumber;
    }

    //the following constructor is not necessary, but it is called
    //by java automatically - it can be how you either initially set up
    //your object and assign default values.
    //BEGIN DEFAULT CONSTRUCTOR:
    public BankAccount(){
        //if no values are passed, going to call the other constructor to assign default
        //values
        this(10000001, 0.00, "123 456 7890", "John Smith");

        System.out.println("empty constructor called");

    }

    //BEGIN OVERLOADED CONSTRUCTOR
    //overloaded constructor to assign values when created
    public BankAccount(int acctNumber, double balance, String phoneNumber, String customerName){

        this.acctNumber = acctNumber;
        this.balance = balance;
        this.phoneNumber = phoneNumber;
        this.customerName = customerName;


    }

    public void setAcctNumber(int acctNumber) {
        this.acctNumber = acctNumber;
    }

    public int getacctNumber(){
        return this.acctNumber;
    }


    public double getBalance() {
        return this.balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCustomerName() {
        return this.customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void depositFunds(int deposit){
        this.balance += deposit;
    }

    public void withdrawal(int withdrawal){
        if(withdrawal > this.balance){
            System.out.println("Your withdrawal amount of: " + withdrawal + " exceeds your current balance of " + this.balance);

        }else{
            this.balance -= withdrawal;
            System.out.println("Your current balance is now " + this.balance);
        }
    }

}
