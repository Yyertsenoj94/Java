package Library;
public final class functions {

    public static void main(String[] args){
        //run area

    }

    //---------------------BINARY TO DECIMAL CONVERSION---------------------------
    public static int binaryToDecimal(int[] binary){
        int sum = 0;
        for(int i = 0; i < binary.length; i++){
            if(binary[i] != 0) {
                sum += (int) Math.pow(2.0, (7-i));
            }
        }
        return sum;
    }
    //----------------------------------------------------------------------------

    //---------------------DECIMAL TO BINARY CONVERSION---------------------------
    public static int[] decimalToBinary(int decimal){
        int[] binaryInt = {0, 0, 0, 0, 0, 0, 0, 0};
        if(decimal == 0){
            return binaryInt;
        }
        boolean notConverted = true;
        if(decimal % 2 != 0){
            binaryInt[7] = 1;
        }
        while(notConverted){
            int temp = decimal;
            int placeCount = 0;
            while(temp / 2 != 0) {
                temp/=2;
                placeCount++;
            }
            binaryInt[7- placeCount] = 1;
            int nextDecimal = (int) decimal - (int) (Math.pow(2.0, (placeCount)));
            if(nextDecimal!= 0) {
                decimal = nextDecimal;
            }else{
                notConverted = false;
            }
        }
        return binaryInt;
    }
    //----------------------------------------------------------------------------

    //===============================INT ARRAY FUNCTIONS=============================================================

    //---------------------PRINT INT ARRAY FUNCTION--------------------------------
    public static void printArray(int[] arr){
        for(int i = 0; i < arr.length; i++){
            System.out.println("Element :" + i + " -> " + arr[i]);
        }
    }
    //-----------------------------------------------------------------------------


    //-----------------SEARCH INDEX OF AN INT ARRAY------------------------------
    public static int findArrayIndex(int value, int[] array){
        int searchValue = -1;

        for(int i = 0; i < array.length; i++){
            if(value == array[i])
                searchValue = i;
        }

        return searchValue;
    }
    //-----------------------------------------------------------------------------


    //-----------------ADD INT VALUE TO AN INT ARRAY-------------------------------
    public static int[] arrayAddValue(int value, int[] array){
        int[] newArray = new int[array.length + 1];
        int newValuePlace = 0;

        for(int i = 0; i < array.length; i++){
            newArray[i] = array[i];
            newValuePlace = i+1;
        }

        newArray[newValuePlace] = value;

        return newArray;
    }
    //-----------------------------------------------------------------------------


    //---------------------REMOVING A VALUE FROM AN INT ARRAY----------------------
    //due to having to re-declare the array, you will need to return the new array
    public static int[] removeArrayValue(int value, int[]arr){

        int removeIndex = findArrayIndex(value, arr);
        int[] copyArray = arr;
        int copyArrayCounter = 0;

        arr = new int[arr.length - 1];

        for(int i = 0; i < arr.length; i++){

            if(copyArrayCounter == removeIndex){
                copyArrayCounter++;
            }

            arr[i] = copyArray[copyArrayCounter];
            copyArrayCounter++;
        }
        return arr;
    }
    //-----------------------------------------------------------------------------


    //---------------------MODIFYING VALUE FROM INDEX ARRAY-----------------------
    public static void modifyArrayValue(int value, int newValue, int [] arr){

        int modifyIndex = findArrayIndex(value, arr);

        arr[modifyIndex] = newValue;
    }
    //-----------------------------------------------------------------------------


    //---------------------REVERSE INT ARRAY FUNCTION---------------------------
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
    //--------------------------------------------------------------------------


    //---------------------RESIZE EXISTING ARRAY FUNCTION-----------------------
    //--------YOU WILL NEED TO ASSIGN THIS TO A NEW ARRAY VALUE-----------------
    public static int[] resizeArray(int[] array, int resizeValue){
        //declare new array with new size value
        int[] resizedArray = new int[resizeValue];

        //loop through new values of the resized array. passing in the old values
        //ONLY to the length of the old array, other values will remain 0:
        for(int i = 0; i < array.length; i++){
            resizedArray[i] = array[i];
        }

       return resizedArray;
    }
    //--------------------------------------------------------------------------



    //------------------------SORT AN INT ARRAY FROM MIN TO MAX----------------------------------------------------
    //this method takes the min of the all values in the array, puts the min at the beginning index, and then
    //replaces the former min index with the starting position value that was the base for comparison.
    public static void sortArrayMin(int[] arr){
        int tempSwitch;
        int oldMinIndex;
        int minValue;

        for(int i = 0; i < arr.length; i++){
            //set starting minimum value at the beginning of each iteration
            minValue = arr[i];

            //set starting place for the old min index each time through the loop.
            oldMinIndex = i;
            //j = i -> this is just to make sure that we don't keep starting at the index from where we just put
            //the most recent minimum number.
            for(int j = i; j < arr.length; j++){

                //see if next value is the new minimum
                if(arr[j] < minValue){
                    //continue to set minimum value of the array from most recent starting point "i".
                    minValue = arr[j];
                    //store the index of the most recent minimum value.
                    oldMinIndex = j;
                }

            }
            //place the starting position into a temp variable.
            tempSwitch = arr[i];
            //make the starting position the next min number
            arr[i] = minValue;
            //put the old value in the starting position back into the old index where the min value used to be.
            arr[oldMinIndex] = tempSwitch;
        }
    }
    //------------------------------------------------------------------------------------------------------------


    //------------------------SORT AN INT ARRAY FROM MAX TO MIN---------------------------------------------------
    //this method takes the max of the all values in the array, puts the max at the beginning index, and then
    //replaces the former max index with the starting position value that was the base for comparison.

    public static void sortArrayMax(int[] arr){
        int tempSwitch;
        int oldMaxIndex;
        int maxValue;

        for(int i = 0; i < arr.length; i++){
            //set starting minimum value at the beginning of each iteration
            maxValue = arr[i];

            //set starting place for the old min index each time through the loop.
            oldMaxIndex = i;
            //j = i -> this is just to make sure that we don't keep starting at the index from where we just put
            //the most recent minimum number.
            for(int j = i; j < arr.length; j++){

                //see if next value is the new minimum
                if(arr[j] > maxValue){
                    //continue to set minimum value of the array from most recent starting point "i".
                    maxValue = arr[j];
                    //store the index of the most recent minimum value.
                    oldMaxIndex = j;
                }

            }
            //place the starting position into a temp variable.
            tempSwitch = arr[i];
            //make the starting position the next min number
            arr[i] = maxValue;
            //put the old value in the starting position back into the old index where the min value used to be.
            arr[oldMaxIndex] = tempSwitch;
        }
    }
    //------------------------------------------------------------------------------------------------------------


    //------------------------SORT AN INT ARRAY FROM MIN TO MAX---------------------------------------------------
    //this sort method just compares each number down the line over and over, switching them until
    //theres nothing left to switch.
    public static void sortArrayMinAlt(int[] arr){
        int tempSwitch;
        boolean comparison = true;

        while(comparison){
            comparison = false;
            for(int i = 0; i < arr.length-1; i++){
                if(arr[i+1] < arr[i]){
                    tempSwitch = arr[i+1];
                    arr[i+1] = arr[i];
                    arr[i] = tempSwitch;
                    comparison = true;
                }
            }
        }

    }
    //------------------------------------------------------------------------------------------------------------



    //------------------------SORT AN INT ARRAY FROM MAX TO MIN---------------------------------------------------
    //this sort method just compares each number down the line over and over, switching them until
    //theres nothing left to switch.
    public static void sortArrayMaxAlt(int[] arr){
        int tempSwitch;
        boolean comparison = true;

        while(comparison){
            comparison = false;
            for(int i = 0; i < arr.length-1; i++){
                if(arr[i] < arr[i+1]){
                    tempSwitch = arr[i+1];
                    arr[i+1] = arr[i];
                    arr[i] = tempSwitch;
                    comparison = true;
                }
            }
        }

    }
    //------------------------------------------------------------------------------------------------------------



    //===============================STRING ARRAY FUNCTIONS=============================================================


    //---------------------PRINT STRING ARRAY FUNCTION-----------------------------
    public static void printArray(String[] arr){
        for(int i = 0; i < arr.length; i++){
            System.out.println("Element :" + i + " -> " + arr[i]);
        }
    }
    //-----------------------------------------------------------------------------



    //-----------------SEARCH INDEX OF A STRING ARRAY------------------------------
    public static int findArrayIndex(String string, String[] array){
        int searchValue = -1;

        for(int i = 0; i < array.length; i++){
            if(string == array[i])
                searchValue = i;
        }

        return searchValue;
    }
    //-----------------------------------------------------------------------------


    //-----------------ADD STRING VALUE TO A STRING ARRAY--------------------------
    public static String[] arrayAddValue(String string, String[] array){
        String[] newArray = new String[array.length + 1];
        int newValuePlace = 0;

        for(int i = 0; i < array.length; i++){
            newArray[i] = array[i];
            newValuePlace = i+1;
        }

        newArray[newValuePlace] = string;

        return newArray;
    }
    //-----------------------------------------------------------------------------


    //---------------------REMOVING A VALUE FROM A STRING ARRAY--------------------
    //due to having to re-declare the array, you will need to return the new array
    public static String[] removeArrayValue(String value, String[] arr){

        int removeIndex = findArrayIndex(value, arr);
        String[] copyArray = arr;
        int copyArrayCounter = 0;

        arr = new String[arr.length - 1];

        for(int i = 0; i < arr.length; i++){

            if(copyArrayCounter == removeIndex){
                copyArrayCounter++;
            }

            arr[i] = copyArray[copyArrayCounter];
            copyArrayCounter++;
        }
        return arr;
    }
    //-----------------------------------------------------------------------------

    //---------------------MODIFYING VALUE FROM STRING ARRAY-----------------------
    public static void modifyArrayValue(String value, String newValue, String [] arr){

        int modifyIndex = findArrayIndex(value, arr);

        arr[modifyIndex] = newValue;
    }
    //-----------------------------------------------------------------------------


    //---------------------REVERSE STRING ARRAY FUNCTION---------------------------
    public static void reverseArray(String[] arr){
        //number of times to cycle through the array:
        int halfLength = arr.length / 2;

        //reduce array length by 1 to get the actual index value:
        int maxIndexValue = arr.length - 1;

        //store value for the switch reversing:
        String tempValue;

        for(int i = 0; i < halfLength; i++){
            tempValue = arr[i];
            arr[i] = arr[maxIndexValue-i];
            arr[maxIndexValue - i] = tempValue;
        }
    }
    //----------------------------------------------------------------------------


    //---------------------RESIZE EXISTING STRING ARRAY FUNCTION------------------
    //--------YOU WILL NEED TO ASSIGN THIS TO A NEW ARRAY VALUE-------------------

    public static String[] resizeArray(String[] array, int resizeValue){
        //declare new array with new size value
        array = new String[resizeValue];

        //loop through new values of the resized array. passing in the old values
        //ONLY to the length of the old array, other values will remain 0:
        for(int i = 0; i < array.length; i++){
            array[i] = array[i];
        }

        return array;
    }
    //----------------------------------------------------------------------------

}
