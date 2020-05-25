package Playground;
public class udemyPracticals_palindrome {

    public static void main(String[] args) {

        System.out.println(isPalindrome(-525));

    }

    public static boolean isPalindrome(int number) {

        boolean condition = false;
        int reverse = 0;

        int originalNumber = number * 10;

        int lastDigit = 0;

        //condition to see if positive version or negative version.
        if (number > 0) {
            while (number > 0) {

                //place digit in temp lastDigit value.
                lastDigit = number % 10;

                //remove the least significant digit
                number = number / 10;


                reverse = reverse + lastDigit;

                reverse = reverse * 10;

                System.out.println("Reverse number is now " + reverse);
                System.out.println("Original number is " + originalNumber);
            }

            if (originalNumber == reverse) {
                condition = true;
            } else {
                condition = false;

            }

        }else{
            //run the negative version
            while (number <= -1) {

                //place digit in temp lastDigit value.
                lastDigit = number % 10;

                //remove the least significant digit
                number = number / 10;


                reverse = reverse + lastDigit;

                reverse = reverse * 10;

                System.out.println("Reverse number is now " + reverse);
                System.out.println("Original number is " + originalNumber);
            }

            if (originalNumber == reverse) {
                condition = true;
            } else {
                condition = false;

            }


        }

        return condition;

    }
}
