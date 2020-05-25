package Generics;

public class MainMethod {
    public static void main(String[] args) {
        League <Teams<SoccerPlayer>> premierLeague = new League<>("PremierLeague");

        Teams <SoccerPlayer>  ManchesterUnited = new Teams<>("Manchester United", 10, 2, 0);
        Teams <SoccerPlayer>  Chelsea = new Teams<>("Chelsea", 8, 4, 0);
        Teams <SoccerPlayer>  Liverpool = new Teams<>("Liverpool", 7, 4, 0);
        Teams <SoccerPlayer>  Arsenal = new Teams<>("Arsenal", 15, 1, 0);
        Teams <SoccerPlayer>  Southampton = new Teams<>("Southampton", 4,4, 2);
        Teams <SoccerPlayer>  ManchesterCity = new Teams<>("Manchester City", 3, 8, 0);


        premierLeague.addTeam(ManchesterCity);
        premierLeague.addTeam(Chelsea);
        premierLeague.addTeam(Liverpool);
        premierLeague.addTeam(Arsenal);
        premierLeague.addTeam(Southampton);
        premierLeague.addTeam(ManchesterUnited);

        premierLeague.getTable();

    }
}
