package Playground;
public class udemyPracticals_highScore {


    public static void main(String[] args) {

        displayHighScorePosition("John", calculateHighScorePosition(1500));
        displayHighScorePosition("Michael", calculateHighScorePosition(900));
        displayHighScorePosition("Peter", calculateHighScorePosition(400));
        displayHighScorePosition("Luke", calculateHighScorePosition(50));
    }

    public static int calculateHighScorePosition(int playerScore){

        if(playerScore > 1000){
            return 1;
        }else if(playerScore > 500){
            return 2;
        }else if(playerScore > 100) {
            return 3;
        }
        return 4;
    }


    public static void displayHighScorePosition(String playerName, int position){
        System.out.println(playerName + " managed to get into " + position + " position on the high score table");
    }


}