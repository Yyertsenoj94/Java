package ProgrammingI;
import java.util.Scanner;
public class helpStudents {
    public static final Scanner scnr = new Scanner(System.in);

    public static void main (String [] args) {
        System.out.println("Enter the first digit: ");
        int value = scnr.nextInt();
        int value2 = returnDigit();

        System.out.println(value);

        System.out.println(value2);

    }

    public static int returnDigit(){
        System.out.println("Enter the second digit: ");
        int value = scnr.nextInt();

        return value;
    }

}



