package Arrays;
import java.util.Scanner;

public class ArraySortAlternative {

    public static void main(String[] args){
        int number = 3;

        printArray((sortArray(getArray(number))));
    }

    public static Scanner scanner = new Scanner(System.in);


    public static int[] getArray(int number){

        //initialize the array
        int[] anArray = new int[number];

        System.out.println("Please enter " + " values for the new array \r");
        //loop through to get the values
        for(int i = 0; i< anArray.length; i++){
            anArray[i] = scanner.nextInt();
        }
        return anArray;
    }

    public static void printArray(int[] array){

        for(int i = 0; i < array.length; i++){
            System.out.println("Element " + i + ": " + array[i]);
        }

    }

    public static int[] sortArray(int[] array){
        printArray(array);

        boolean flag = true;
        int tempValue = 0;

        while (flag) {

            flag = false;

            for(int i = 0; i < array.length; i++){

                for(int j = i+1; j < array.length; j++){
                    if(array[j] < array[i]){

                        tempValue = array[i];

                        array[i] = array[j];

                        array[j] = tempValue;

                        flag = true;

                    }

                }

            }

        }
        return array;
    }


}
