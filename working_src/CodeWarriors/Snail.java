package CodeWarriors;

public class Snail {

    public static void main(String[] args) {
//        int[][] array = {{1, 2, 3, 4}, {1, 2, 3, 4}, {1, 2, 3, 4}, {1, 2, 3, 4}};
        int[][] array = {{}};
        int[] newArray;
        newArray = snail(array);
        for(int i: newArray){
            System.out.println(i);
        }
    }


    public static int[] snail(int[][] array){
        if(array.length == 1){
            int[] alt = new int[array[0].length];
            for(int i = 0; i <= array[0].length-1; i++){
                alt[i] = array[0][i];
            }
            return alt;
        }
        int[] newArray = new int[array.length*array.length];
        int start = 0;
        int end = array.length-1;
        int count = 0;
        for(int i = 0; i <= end; i++) {
            int[] tempArray = array[start];
            for(int column = start; column <= end; column++){
                newArray[count] = tempArray[column];
                count++;
            }
            for(int row = start+1; row <= end; row++){
                newArray[count] = array[row][end];
                count++;
            }
            //reverse and decrement;
            tempArray = array[end];
            end--;
            for(int column = end; column >= start; column--){
                newArray[count] = tempArray[column];
                count++;
            }
            for(int row = end; row >= start+1; row--){
                newArray[count] = array[row][start];
                count++;
            }
            start++;
        }
        return newArray;
    }

}
