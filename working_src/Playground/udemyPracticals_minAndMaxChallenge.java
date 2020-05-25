package Playground;
import java.util.Scanner;

public class udemyPracticals_minAndMaxChallenge {

    public static void main(String[] args) {

        //initialize the input
        Scanner scanner = new Scanner(System.in);

        int max = 0;

        int min = 0;


        while(true) {
            System.out.println("Enter Number");
            boolean hasNextInt = scanner.hasNextInt();

            if (hasNextInt) {


                int nextInt = scanner.nextInt();

                if(nextInt > max){
                    max = nextInt;
                }else if(nextInt < min){
                    min = nextInt;
                }

            } else {
                System.out.println("Max is: " + max + "." + " Min is: " + min);
                break;
            }

        }




    }

}
