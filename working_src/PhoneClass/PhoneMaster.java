package PhoneClass;
import java.util.Scanner;

public class PhoneMaster {

    public static void main(String[] args){
        boolean appRun = true;

        Phone phone = new Phone();
        int choice = -1;

        while(appRun){

            System.out.println("main Menu: Please select an option to choose from");

            mainMenu();

            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 1:
                    phone.printContactList();
                    break;
                case 2:
                    phone.addContact();
                    break;
                case 3:
                    phone.removeContact();
                    break;
                case 4:
                    phone.updateContactName();
                    break;
                case 5:
                    phone.updateContactNumber();
                    break;
                case 6:
                    phone.findContactName();
                    break;
                case 7:
                    appRun = false;
            }

        }

        System.out.println("Exiting main Menu...\r");
        System.out.println("GoodBye!");



    }

    public static void mainMenu(){
        System.out.println("1: Print Contact List \t");
        System.out.println("2: Add Contact \t");
        System.out.println("3: Delete Contact \t");
        System.out.println("4: Modify Contact Name \t");
        System.out.println("5: Modify Contact Number \t");
        System.out.println("6: Find Contact \t");
        System.out.println("7: Exit main Menu \t");
    }

}
