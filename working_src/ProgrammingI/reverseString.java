package ProgrammingI;
import java.util.Scanner;
public class reverseString {

    public static String integerToReverseBinary(int integerValue){

        String binaryString = "";
        while(integerValue > 0){

            binaryString += integerValue % 2;
            integerValue /= 2;


        }

        return binaryString;
    }

    public static String reverseString(String inputString){
        String reverseString = "";

        for(int i = inputString.length()-1; i >= 0; i--){
            reverseString += inputString.charAt(i);

        }

        return reverseString;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int userInt = 0;
        String intString = "";
        String finalResult = "";

        System.out.print("Please enter an integer");
        userInt = scanner.nextInt();

        intString = integerToReverseBinary(userInt);
        finalResult = reverseString(intString);
        System.out.println(finalResult);
    }
}
