package Arrays;

import java.util.Scanner;



public class ArrayPractice {

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
        int[] sortedArray = new int[array.length];
        int tempIndex;

        //find minimum number from the array
        for(int i = 0; i < array.length; i++){

            //min number starts out at index i:
            System.out.println("Starting the minimum number at " + array[i]);
            int minNumber = array[i];
            tempIndex =0;
                    //loop through each remaining index to determine the next minimum value.
                    for(int j = i; j < array.length; j++){
                        System.out.println("Comparing " + array[j] + " to min number of " + minNumber);
                        if(array[j] < minNumber) {
                            System.out.println(array[j] + " is less than " + minNumber);
                            minNumber = array[j];
                            System.out.println("Min number is now " + array[j]);
                            tempIndex = j;
                        }

                    }
                    System.out.println("Min number is " + minNumber);
                    System.out.println("Index of smallest number is " + tempIndex);
                    //put smallest value in the sorted array
                    System.out.println("Sorted array before");
                    printArray(sortedArray);
                    System.out.println("adding min number " + minNumber + " to sorted array");
                    sortedArray[i] = minNumber;
                    System.out.println("Sorted array after: ");
                    printArray(sortedArray);
                    //swap the values of i and j since i was not the smallest.
                    array[tempIndex] = array[i];
                    System.out.println("Swapping value of " + minNumber + " at index " + tempIndex + " with value " + array[i] + " at index " + i);
                    System.out.printf("Swapped array is now: ");
                    printArray(array);
        }
        return sortedArray;
    }
}
