package Arrays;

public class Dimensional {

    public static void main(String[] args) {

        //think of dimensions as this:
        /*
        You always start with one array (in the first dimension). If you want
        to go to the second dimension, then every element in the first array is ANOTHER array.
        If you want to go to the third dimension, then every element in the second array, is ANOTHER array.

        first array has 7 elements int[7]
        1st Array [ 0  1  2  3  4  5  6 ]

        there are 7 additional arrays when you add the second array of length 3 int[3] --> 0, 1, 2
        1st Array [ 0  1  2  3  4  5  6 ]
                    |  |  |  |  |  |  |
        2nd         0  0  0  0  0  0  0
                    1  1  1  1  1  1  1
                    2  2  2  2  2  2  2
         */

        int[][] twoDimensions = new int[4][4];

        //row loop
        int outerCount = 0;
        for (int i = 0; i < 4; i++) {
            int innerCount = 0;
            //column loop
            for (int j = 0; j < 4; j++) {
                twoDimensions[i][j] = innerCount;
                innerCount++;
            }
        }

        for (int[] s : twoDimensions) {
            for (int a : s) {
                System.out.println(a);
            }
            System.out.println("");
        }
    }
}
