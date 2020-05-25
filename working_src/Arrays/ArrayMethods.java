package Arrays;

public class ArrayMethods {

    public static void main(String[] args) {
        int[] testArray = {1, 3, 5, 2, 6, 7, 9, 3};

        printArray(testArray);

        //before
        sortLowHigh(testArray);

        //after
        printArray(testArray);

        testArray = add(200, testArray);

        //after
        printArray(testArray);
        testArray = remove(3, testArray);

        printArray(testArray);

    }

    public static void sortLowHigh(int[] array){
        int arraySize = array.length;
        boolean notSorted = true;
        while(notSorted){
            notSorted = false;
            for(int i = 0; i < arraySize-1; i++){
                if(array[i] > array[i+1]){
                    notSorted = true;
                    int temp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temp;
                }
            }
        }
    }

    public static int[] add(int num, int[] array){
        int[] tempArray = new int[array.length + 1];

        for(int i = 0; i < array.length; i++){
            tempArray[i] = array[i];
        }
        tempArray[array.length] = num;
        return tempArray;
    }

    public static int[] remove(int num, int[] arr){
        //remove all instances of num!
        boolean remove = true;
        int countNum = 0;
        int[] newArray;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == num){
                countNum++;
            }
        }

        newArray = new int[arr.length - countNum];
        int newArrayCount = 0;
        for(int i = 0; i < arr.length; i++){
            if(!(arr[i] == num)){
                newArray[newArrayCount] = arr[i];
                newArrayCount++;
            }
        }
        return newArray;
    }

    public static void printArray(int[] arr){
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println("");
    }


}
