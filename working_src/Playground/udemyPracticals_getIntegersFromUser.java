package Playground;
import java.util.Scanner;

public class udemyPracticals_getIntegersFromUser {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int sum = 0;

        for(int i = 1; i < 11; i++){

            System.out.println("Please enter number #" + i);

            boolean hasNextInt = scanner.hasNextInt();

            if(hasNextInt){

                sum += scanner.nextInt();

            }else{
                System.out.println("You did not enter a correct number");
            }

        }
        scanner.close();
        System.out.println("the sum of the numbers is " + sum);

    }
}
