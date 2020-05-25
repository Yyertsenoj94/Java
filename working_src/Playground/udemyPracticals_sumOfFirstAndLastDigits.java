package Playground;
public class udemyPracticals_sumOfFirstAndLastDigits {

    public static void main(String[] args) {

        System.out.println(sumFirstAndLastDigit(2809));

    }

    public static int sumFirstAndLastDigit(int number){
        int firstNumber = 0;

        //assign the last number
        int lastNumber = number % 10;


        int sumDigits = 0;



        //find the first digit
        while(number > 0){
            firstNumber = number;
            number = number / 10;

            System.out.println("First Number is " + firstNumber);
        }

        sumDigits = firstNumber + lastNumber;
        System.out.println("sum of first and last digit in the number provided is: " + sumDigits);

        return sumDigits;

    }
}
