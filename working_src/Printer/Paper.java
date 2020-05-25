package Printer;
import java.util.Scanner;

public class Paper {

    private int level;

    private int paperCapacity;

    public Paper(int paperCapacity){
        this.paperCapacity = paperCapacity;
        this.level = paperCapacity;
    }

    public void usePaper(int totalPages, int currentPageNumber){

            checkPaperLevel();

            if (level > 0) {
                System.out.println("Printing page number: " + currentPageNumber + " of " + totalPages + ".");
                level -= 1;
            } else {
                System.out.println("Paper tray is empty.");
                refillLevel();
            }

            if(currentPageNumber == totalPages){
                System.out.println("Printing job completed successfully. " + currentPageNumber + " pages were printed out of " + totalPages);
            }

    }

    private void checkPaperLevel(){
        if(level < 5){

            boolean validResponse = false;

            System.out.println("Paper level is low. Current amount is: " + level + ". Would you like to replace paper now?");
            System.out.println("Please enter Y for 'Yes' and N for 'No'");

            Scanner scanner = new Scanner(System.in);
            String userResponse;

            while(!validResponse) {

                userResponse = scanner.nextLine();
                if (userResponse.equals("Y") || userResponse.equals("N")) {

                    if (userResponse.equals("Y")){
                        refillLevel();
                        validResponse = true;
                    }{
                        validResponse = true;
                    }
                } else {
                    System.out.println("Invalid Response");
                    System.out.println("Please enter Y for 'Yes' and N for 'No'");

                }

            }



        }else{
            System.out.println("Current paper level is: " + level);
        }

    }

    private void refillLevel(){

        System.out.println("Current paper level is " + level);
        System.out.println("Refilling paper level by...." + (paperCapacity - level));
        level += (paperCapacity-level);
        System.out.println("Paper refill is complete");
        System.out.println("Paper level is now at: " + level + " out of a total tray capacity of: " + paperCapacity);

    }


}
