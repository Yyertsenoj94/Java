package PracticeTest;

public class lastTwo {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 4, 4, 3, 2, 2, 1};

        System.out.println(isInPreviousIndex(array, 3));
        System.out.println(isInPreviousIndex(array, 4));

        System.out.println("-------------");


        System.out.println(numbersMoreThanTwice(array));


    }

    public static boolean isInPreviousIndex (int[] array, int index){
        int compareVal = array[index];
        for(int i = 0; i < index; i++){
            if(array[i] == compareVal){
                return true;
            }
        }

        return false;

    }

    public static int numbersMoreThanTwice(int[] array) {
        int overallCount = 0;
        for (int i = 0; i < array.length; i++) {

            if (isInPreviousIndex(array, i)) {
                continue;
            }

            int numAppear = 1;
            for (int j = i + 1; j < array.length; j++) {

                if (array[i] == array[j]) {

                    numAppear++;

                }

            }

            if (numAppear > 2) {

                overallCount++;

            }

        }
        return overallCount;
    }
}
