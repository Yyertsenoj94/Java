package CodeWarriors;

public class SquareDigits {
    public static void main(String[] args) {

        squareDigits(1234);

        System.out.println(squareDigits(1234));
    }


    public static int squareDigits(int n) {
        int count = 0;
        String numberString = Integer.toString(n);

        int[] array = new int[numberString.length()];

        for (int i = 0; i < array.length; i++){
            array[count] = (n % 10) * (n % 10);
        count++;
        n = n / 10;
        }

        numberString = "";
        for(int i = array.length - 1; i >= 0; i--){
            numberString += Integer.toString(array[i]);
        }

        int finalNumber = Integer.parseInt(numberString);

        return finalNumber;
    }
}
