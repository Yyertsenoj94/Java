package Math;

import java.util.Scanner;
public class Functions {

    public static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        //take user input
        System.out.println("Please enter a value to find the square root");
        sqrRoot(scanner.nextDouble());

    }

    public static void sqrRoot(double number){
        //set initial sqr root = 0
        double root = 0;

        //while the square root * square root < user value, increments by 1 to find the first digit.
        while((root + 1)* (root + 1) < number){
            root += 1;
        }
        //call decimal function to find the decimal values
        decimal(root, 1, number);
    }

    //takes the intial value (root), the decimal incrementer (whatever thousands place it is, and the user value.
    public static void decimal(double root, double decimalIncrement, double number) {

        double currDecimal = 0;
        //move to the next thousands place
        decimalIncrement /= 10;

        //increment the current decimal value while the root^2 is less than the value.
        while ((root + currDecimal + decimalIncrement) * (root + currDecimal + decimalIncrement) < number) {
            currDecimal += decimalIncrement;
        }

        //if the root ^2  matches the number, then done
        if ((root + currDecimal) * (root + currDecimal) >= number) {
            root = root + currDecimal;
            System.out.println("Square root of " + number + " is: " + root);
        } else {
            //call decimal to get the next decimal place number
            decimal((root + currDecimal), decimalIncrement, number);
        }
    }
}
