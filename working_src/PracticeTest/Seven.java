package PracticeTest;

public class Seven {

    public static void main(String[] args) {
        int[] array1 = {3, 4, 5, 6, 7, 8, 4, 6, 2, 7, 8, 9, 1, 2, 2, 0, 7, 7};
        System.out.println(isInPreviousIndex(array1, 1));

        System.out.println(numberMoreTwice(array1));

    }

    public static boolean isInPreviousIndex(int[] array, int index){

        int compareVal = array[index];

        for(int i = 0; i < index; i++){
            if(array[i] == compareVal){
                return true;
            }
        }
        return false;

    }

    public static int numberMoreTwice(int[] array){
        int count = 0;

        for(int i =0; i < array.length; i++){
            int numberCount = 0;
            int compareInt = array[i];
            if(isInPreviousIndex(array,i)){
                continue;
            }
            for(int j = i+1; j < array.length; j++){
                if (array[j] == compareInt){
                    numberCount++;
                }
            }

            if(numberCount >= 2){
                count++;
            }

        }

        return count;
    }

}
