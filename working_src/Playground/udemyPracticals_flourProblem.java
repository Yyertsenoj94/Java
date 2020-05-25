//this was super confusing, re-do sometime.
package Playground;
public class udemyPracticals_flourProblem {
    public static void main(String[] args) {

        System.out.println(canPack(2, 2, 11));


    }

    public static boolean canPack(int bigCount, int smallCount, int goal){

        boolean condition = false;
        int bigFactor = 5;
        int smallFactor = 1;

        int bigTotal = bigCount*bigFactor;
        int smallTotal = smallCount*smallFactor;

        System.out.println("Big Total is: " + bigTotal);
        System.out.println("Small Total is: " + smallTotal);


        int totalSum = bigTotal + smallTotal;
        System.out.println("Total sum is " + totalSum);

        if(totalSum >= goal){
            System.out.println("Total sum of: " + totalSum + " is greater than the goal of " + goal);
            //we only care if the big total is bigger than goal, because that means that partial packs MAY have been used.
            if(bigTotal > goal){
                System.out.println("Big total of " + bigTotal + " is greater than the goal of " + goal);

                int difference = bigTotal - goal;
                System.out.println("Difference is " + difference);

                System.out.println(bigFactor + " minus the remainder of " + difference + " divided by " + bigFactor + " equals " + (bigFactor - (difference % bigFactor)) + ". " +
                        "Which is greater than the small total of " + smallTotal);

                if(bigFactor - (difference % bigFactor) > smallTotal){
                    condition = false;

                }

            }else{
                condition = true;
                System.out.println("big total of " + bigTotal +" plus the small total of " + smallTotal + " is greater than or equal to the the goal of " + goal);
            }



        }else{
            //the total sum does not match the goal.
            System.out.println("The total sum of " + totalSum + " is less than the goal of " + goal);
            condition = false;
        }

        return condition;

    }
}
