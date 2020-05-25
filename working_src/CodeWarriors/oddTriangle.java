package CodeWarriors;

public class oddTriangle {

    public static void main(String[] args) {
        oddNum(5);
    }

    public static int oddNum(int n){
        int sum = 1;
        int count = 1;
        int max = n;
        sum = recurse(sum, count, max, 1);
        System.out.println(sum);
        return sum;
    }

    public static int recurse(int oldSum, int count, int max, int rowSum){
        int newSum = oldSum;

        if(count == max){
            return rowSum; //implementing to sum the row.
            //return newSum;
        }
        rowSum = 0;//reset on each loop.
        count++;
        for(int i = 1; i <= count; i++) {
            newSum += 2;
            System.out.print(newSum + " ");
            rowSum += newSum;
        }
        System.out.println("");
        newSum = recurse(newSum, count, max, rowSum);
        return newSum;
    }
}
