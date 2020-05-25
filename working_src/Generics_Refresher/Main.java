package Generics_Refresher;

public class Main {

    public static void main(String[] args) {
        int compare;
        String String1 = "bat";
        String String2 = "hat";
        String String3 = "mat";
        String String4 = "sat";

        compare = String2.compareTo(String1);
        System.out.println(compare);

        League<Team<SoccerPlayer>> league = new League("Soccer League");
        Team<SoccerPlayer> Galaxy = new Team("Galaxy");
        Team<SoccerPlayer> FCDallas = new Team("FC Dallas");
        Team<SoccerPlayer> MetroStars = new Team("MetroStars");
        Team<SoccerPlayer> MightyDucks = new Team("MightyDucks");
        Team<FootballPlayer> Raiders = new Team("Raiders");

        SoccerPlayer player = new SoccerPlayer("David Beckham");
        FootballPlayer footballPlayer = new FootballPlayer("Vince Young");
        Galaxy.addPlayer(player);
        FCDallas.addPlayer(player);
        MetroStars.addPlayer(player);
        MightyDucks.addPlayer(player);


        league.addTeam(Galaxy);
        league.addTeam(FCDallas);
        league.addTeam(MetroStars);
        league.addTeam(MightyDucks);


        league.playMatch(Galaxy, FCDallas, 2, 1);

        league.printLeagueRankings();
    }


}
