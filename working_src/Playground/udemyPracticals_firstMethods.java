package Playground;
public class udemyPracticals_firstMethods {

    public static void main(String[] args) {

        System.out.println("local_test");

        //must run your other functions within the main function.
        int highScore = calculateScore(true, 300, 5, 4000);
        System.out.println("The high score was " + highScore);

    }


    public static int calculateScore(boolean gameOver, int score, int levelComplete, int bonus){

        if (gameOver) {
            int finalScore = score + (levelComplete * bonus);
            return finalScore;
        }

        return - 1;
    }


}
