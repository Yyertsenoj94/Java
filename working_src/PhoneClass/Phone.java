package PhoneClass;
import java.util.ArrayList;
import java.util.Scanner;


public class Phone {

    static Scanner scanner = new Scanner(System.in);

    private ArrayList<Contact> contact;

    public Phone(){
        this.contact = new ArrayList<>();
    }

    public void printContactList(){
        for(int i = 0; i< contact.size(); i++){
            System.out.println((i+1) + ". " + contact.get(i).getName() + ": Number is " + contact.get(i).getNumber() + ". \t");
        }
    }

    public void addContact(){
        String newName = "";
        String newPhoneNumber = "";
        System.out.println("Please enter name of new contact: \r");
        newName = retrieveString();
        System.out.println("Please enter " + newName + "'s phone number \r");
        newPhoneNumber = retrieveString();
        contact.add(new Contact(newName, newPhoneNumber));
        System.out.println(newName + " was successfully created \r");
    }

    public void removeContact(){
        String name = "";
        int indexRemove = -1;
        System.out.println("Please enter name of contact you wish to delete");
        name = retrieveString();
        if(nameOnFile(name)){
            indexRemove = findIndex(name);
            contact.remove(indexRemove);
            System.out.println("Contact " + name + " was successfully deleted.");
        }else{
            errorMessage();
        }
    }

    public void findContactName(){
        String name = "";
        System.out.println("Please enter name to search: \r");
        name = retrieveString();
        if(nameOnFile(name)){
            System.out.println(name + " was found \r" + name + " is contact number " + (findIndex(name) + 1) + " on your phone");
            System.out.println(name + "'s number is: " + contact.get(findIndex(name)).getNumber());
        }else{
            errorMessage();
        }
    }

    public void updateContactName(){
        System.out.println("Please enter name of contact you wish to modify: \r");
        String name = retrieveString();
        int indexModify = -1;
        if(nameOnFile(name)){
            System.out.println("Please enter new name for contact\r");
            String newName = retrieveString();
            indexModify = findIndex(name);
            contact.get(indexModify).setName(newName);
            System.out.println(name + " was succesfully changed to : " + newName + "\r would you like to modify " + newName + "'s number too? \r" + "'Yes' or 'No'");
            String decision = retrieveString();
            if(decision.equals("Yes")){
                updateContactNumber(newName);
            }
        }else{
            errorMessage();
        }

    }

    //private function to call once you've updated someone's name.
    private void updateContactNumber(String name){
        if(nameOnFile(name)){
            String newNumber = "";
            int modifyIndex = findIndex(name);
            System.out.println("Please enter new phone number for " + name);
            newNumber = retrieveString();
            contact.get(modifyIndex).setNumber(newNumber);
            System.out.println(name + "'s number was succesfully updated to " + newNumber);
        }else{
            errorMessage();
        }
    }

    public void updateContactNumber(){
        String name = "";
        String newNumber = "";
        System.out.println("Please enter contact name to change their phone number\r");
        name = retrieveString();

        if(nameOnFile(name)){

            int modifyIndex = findIndex(name);
            System.out.println("Please enter new phone number for " + name);
            newNumber = retrieveString();
            contact.get(modifyIndex).setNumber(newNumber);
            System.out.println(name + "'s number was succesfully updated to " + newNumber);

        }else{

            errorMessage();

        }
    }

    private int findIndex(String string){
        int index = -1;
        if(nameOnFile(string)){
            for(int i = 0; i < contact.size(); i++){
                if(contact.get(i).getName().equals(string)){
                    return i;
                }
            }
        }
        //if not found, will return -1;
        return index;
    }


    private boolean nameOnFile(String string){
        boolean onFile = false;
        for(int i = 0; i < contact.size(); i++){
            if(contact.get(i).getName().equals(string)){
                onFile = true;
            }
        }
        return onFile;
    }

    private void errorMessage(){
        System.out.println("Contact not found \r");
    }


    private String retrieveString(){
        String string = scanner.nextLine();

        return string;
    }

}
