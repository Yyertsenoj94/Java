package Generics_Refresher;

import java.io.Closeable;
import java.util.ArrayList;
import java.util.List;

public class Team<T extends Player> implements Comparable<Team<T>>{

    String name;
    int wins;
    int ties;
    int losses;
    int totalPoints = (wins * 3) + ties;
    List<T> players = new ArrayList<>();

    public Team(String name){
        this.name = name;
    }

    public int getScore(){
        return (wins * 3) + ties;
    }

    public void addPlayer(T player){
        players.add(player);
        System.out.println(player.name + " was successfully added to the team");
    }

    public void playGame(Team opponent, int ourScore, int theirScore){
        if(ourScore > theirScore){
            wins++;
        }else if (ourScore < theirScore){
            losses++;
        }else{
            ties++;
        }
        if(opponent != null){
            opponent.playGame(null, theirScore, ourScore);
        }

    }

    @Override
    public int compareTo(Team<T> team) {
        if(this.getScore() > team.getScore()){
            return -1;
        }else if(this.getScore() < team.getScore()){
            return 1;
        }
        return 0;
    }

}
