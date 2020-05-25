package Generics;

import java.util.ArrayList;

public class Teams<T extends Player> implements Comparable<Teams<T>> {

    private String name;
    private int won;
    private int lost;
    private int draw;
    private int score;
    private ArrayList<T> players = new ArrayList<>();

    public Teams(String name, int wins, int losses, int draws){
        this.name = name;
        this.lost = losses;
        calcScore(wins, draws);
    }

    public boolean addPlayer(T player){
        if(players.contains(name)){
            System.out.println("Cannot add " + name + ", they are already on the team");
            return false;
        }else{
            players.add(player);
        }
        return true;
    }

    public String getName(){
        return name;
    }

    public int getScore(){
        return this.score;
    }

    private void calcScore(int wins, int draw){
        this.score = (wins * 3) + draw;
    }

    public void matchResult(Teams<T> opponent, int ourScore, int theirScore){

        String message;

        if(ourScore > theirScore){
            won ++;
            message = " defeated ";
        }else if(ourScore < theirScore){
            lost ++;
            message = " lost to ";
        }else{
            draw++;
            message = " tied ";
        }

        if(opponent != null){
            System.out.println(this.name + message + opponent.name);
            opponent.matchResult(null, theirScore, ourScore);
        }

    }

    public void getRecord(){
        System.out.println(this.name + " Wins: " + won + " Losses: " + lost + " Tied " + draw+".");
    }

    @Override
    public int compareTo(Teams<T> team) {
        if(this.score > team.getScore()){
            return -1;
        }else if(this.score < team.score){
            return 1;
        }else{
            return 0;
        }
    }
}
