package Generics_Refresher;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class League<T extends Team>{

    String leagueName;
    List<T> teams;

    public League(String name){
        this.leagueName = name;
        this.teams = new ArrayList<>();
    }

    public void addTeam(T team){
        teams.add(team);
        System.out.println(team.name + " was successfully added to the league");
    }

    public void playMatch(T one, T two, int oneScore, int twoScore){
        one.playGame(two, oneScore, twoScore);
    }

    public void sort(){
        Collections.sort(teams);
    }

    public void printLeagueRankings(){
        int rank = 1;
        for(T team: teams){
            System.out.print(rank + ". " + team.name);
            System.out.println(" | Wins: " + team.wins + " Losses: " + team.losses + " Ties: " + team.ties);
        }
    }

}
