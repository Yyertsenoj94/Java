package Generics;
import java.util.ArrayList;
import java.util.Collections;

public class League<T extends Teams>{

    private ArrayList<T> teams = new ArrayList<>();
    private String name;

    public League (String name){
        this.name = name;
    }

    public void addTeam(T team){
        if(teams.contains(team)){
            System.out.println("Team is already in the league");
        }else{
            System.out.println("Adding team " + team.getName());
            teams.add(team);
        }
    }

    public void getTable(){
        System.out.println(name + " Standings: ");
        Collections.sort(teams);
        for(int i = 0; i < teams.size(); i++){

            System.out.println(i+1 + ". " + teams.get(i).getName() + " | Score: " + teams.get(i).getScore());
        }
    }

}
