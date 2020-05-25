package Arrays;

public class ReverseArray {

    public static void main(String[] args){

        int [] originalArray = {0, 3, 4, 6, 8, 11, 10};

        printArray(originalArray);
        reverseArray(originalArray);
        printArray(originalArray);

    }

    public static void reverseArray(int[] arr){
        //number of times to cycle through the array:
        int halfLength = arr.length / 2;

        //reduce array length by 1 to get the actual index value:
        int maxIndexValue = arr.length - 1;

        //store value for the switch reversing:
        int tempValue;

        for(int i = 0; i < halfLength; i++){
            tempValue = arr[i];
            arr[i] = arr[maxIndexValue-i];
            arr[maxIndexValue - i] = tempValue;
        }
    }

    public static void printArray(int[] array){
        for(int i = 0; i < array.length; i++){
            System.out.println("Element " + i + ": " + array[i]);
        }
    }






}
