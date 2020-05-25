package readIntChallenge;
import java.util.Scanner;

public class ReadInt {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){
        System.out.println("Minimum number is " + findMin((readInt(9))));

    }

    public static int[] readInt(int count){
        int[] readArray = new int[count];

        System.out.println("Please enter " + count + " integers");

        for(int i = 0; i < count; i++){
            readArray[i] = scanner.nextInt();
        }

        return readArray;
    }

    public static int findMin (int[] array){
        int minNumber = array[0];
        for(int i = 1; i < array.length; i++){

            if(array[i] < minNumber){
                minNumber = array[i];
            }

        }

        return minNumber;
    }




}
