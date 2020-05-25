package Playground;
public class udemyPracticals_findEachDigit {

    public static void main(String[] args) {

        System.out.println(sumDigits(555));

    }


    public static int sumDigits(int number){

        int intSum = 0;

        if(number < 10){
            return -1;
        }


        do {
            intSum += number % 10;
            number = number/10;

        }while((number / 10) > 0);

        intSum += number;

        return intSum;

    }

}













