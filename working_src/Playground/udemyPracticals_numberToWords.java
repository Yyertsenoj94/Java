package Playground;
public class udemyPracticals_numberToWords {

    public static void main(String[] args) {


        numberToWords(1000);

    }

    //number to words function

    //function to convert number to words.
    public static void numberToWords(int number){

        int numberCount = getDigitCount(number);

        System.out.println("Number entered is: " + number);
        //reverse the original number so that it will re-reverse into words.


        //reverse the number
        number = reverseNumber(number);
        int reverseCount = getDigitCount(number);


        int difference = numberCount - reverseCount;


        int tempNumber = 0;
        String wordNumber = "";

        while(number > 0){
            System.out.println("Converting number " + number + " to words...");
            tempNumber = number % 10;

            String tempString = "";

            switch (tempNumber){

                case 0:
                    tempString = "Zero";
                    break;
                case 1:
                    tempString = "One";
                    break;
                case 2:
                    tempString = "Two";
                    break;
                case 3:
                    tempString = "Three";
                    break;
                case 4:
                    tempString = "Four";
                    break;
                case 5:
                    tempString = "Five";
                    break;
                case 6:
                    tempString = "Six";
                    break;
                case 7:
                    tempString = "Seven";
                    break;
                case 8:
                    tempString = "Eight";
                    break;
                case 9:
                    tempString = "Nine";
                    break;
            }
            System.out.println("Adding word " + tempString + " to wordNumber: " + wordNumber);

            wordNumber += tempString;

            System.out.println("WordNumber is now: " + wordNumber);

            number = number / 10;

        }


        for(int i = 0; i < difference; i++){

            wordNumber += "Zero";

        }

        System.out.println("The wordNumber is: " + wordNumber);

    }


    //reverse function
    public static int reverseNumber(int number){

        int reversedNumber = 0;

        System.out.println("Number passed to be reversed is: " + number);
        //take the original number and mod it down to a reversed number
        while(number > 0 ){

            reversedNumber += number % 10;

            //if last digit, stop multiplying by 10.
            if(number / 10 < 1){
                break;
            }else{
                reversedNumber = reversedNumber * 10;
            }

            //reduce the original number.
            number = number / 10;
        }

        System.out.println("Final reversed Number is " + reversedNumber);


        //return reversed number
        return reversedNumber;
    }


    //get digit count function. (reversedNumber)
    public static int getDigitCount(int number){
        int Count = 0;

        while(number > 0){

            number = number / 10;
            Count ++;

        }

        return Count;
    }
}
