package Playground;
public class udemyPracticals_hasSharedDigit {

    public static void main(String[] args) {

        System.out.println(hasSharedDigit(15, 41));

    }
    public static boolean hasSharedDigit(int x, int y){
        boolean condition = false;

        int xDigit = 0;
        int yDigit = 0;

        if((x >= 10 && x <= 99) && (y >= 10 && y <= 99)){

            int xTempShrink = x;

            //loop through the x values
            while(xTempShrink > 0){

                //reset y value back to it's original. VERY IMPORTANT.
                int yTempShrink = y;
                //assign the last digit of the shrinking x value.
                xDigit = xTempShrink % 10;
                System.out.println("Scope digit is now " + xDigit);
                //compare by looping through the y values
                while(yTempShrink > 0){

                    //assign the last digit of the shrinking y value.
                    yDigit = yTempShrink % 10;
                    System.out.println("Y digit is now " + yDigit);
                    if(xDigit == yDigit){
                        condition = true;
                        System.out.println("Shared digit is " + xDigit);
                    }

                    yTempShrink = yTempShrink / 10;
                }

                //shrink the x value down by one digit.
                xTempShrink = xTempShrink / 10;

            }

        }
        if(condition == false){
            System.out.println("there is no shared digit");
        }

        return condition;
    }
}
