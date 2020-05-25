package Generics_Refresher;

public class SoccerPlayer extends Player {

    public SoccerPlayer(String name){
        super(name);
    }

    @Override
    public void play() {
        System.out.println("I kick the ball");
    }

}
