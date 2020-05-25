package Playground;
public class udemyPracticals_getGreatestCommonDivisor {

    public static void main(String[] args) {

        System.out.println(getGreatestCommonDivisor(81, 81));

    }

    public static int getGreatestCommonDivisor(int first, int second){

        int commonDivisor = 0;
        //want to find smaller number to begin comparison.
        int smallerNumber = 0;
        int largerNumber = 0;

        int smallDivisor = 0;


        //find the smaller number to start with
        if(first >= second){
            smallerNumber = second;
            largerNumber = first;
        }else{
            smallerNumber = first;
            largerNumber = second;
        }


        for(int x = smallerNumber; x > 0; x--){



            if(smallerNumber % x == 0){
                smallDivisor = x;
                System.out.println(smallerNumber + " is divisible by " + smallDivisor);
            }

            if(largerNumber % smallDivisor == 0){
                commonDivisor = smallDivisor;
                System.out.println("Biggest Common divisor is " + smallDivisor);
                break;
            }
        }

        return commonDivisor;
    }
}
