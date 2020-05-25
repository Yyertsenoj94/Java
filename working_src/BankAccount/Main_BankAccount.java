package BankAccount;

public class Main_BankAccount {

   public static void  main(String[] args){

       BankAccount myAccount = new BankAccount(102131010, 12000, "830 388 9259", "Trey Jones");

       myAccount.depositFunds(300);

       myAccount.withdrawal(400);

       myAccount.withdrawal(12000);

       myAccount.withdrawal(11000);

       //-----------------------------CREATE NEW DEFAULT CUSTOMER ACCOUNT----------------------------------------

       //call the empty constructor. empty constructor in class will then call the main constructor and pass default values.
       BankAccount defaultAccount = new BankAccount();

       System.out.println(defaultAccount.getAcctNumber());
       System.out.println(defaultAccount.getBalance());
       System.out.println(defaultAccount.getCustomerName());
       System.out.println(defaultAccount.getPhoneNumber());

   }
}
