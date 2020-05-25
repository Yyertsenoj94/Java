package Maps;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AdventureGame {

    static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        MapProgram map = new MapProgram();
        String direction;
        Map<String, String> vocabulary = new HashMap<>();

        vocabulary.put("NORTH", "N");
        vocabulary.put("SOUTH", "S");
        vocabulary.put("EAST", "E");
        vocabulary.put("WEST", "W");
        vocabulary.put("QUIT", "Q");

        int loc = 1;
        while (true) {
            System.out.println("=======================");
            Location location = map.getMap().get(loc);
            if (loc == 0) {
                System.out.println(location.getDescription());
                break;
            }
            System.out.println(location.getDescription());
            Map<String, Integer> exits = location.getExits();
            System.out.println("Available Options:");
            for (String exit : exits.keySet()) {
                System.out.println(exit);
            }
            System.out.println("=======================\n");
            System.out.print("Please select an option\t");


            direction = scanner.nextLine().toUpperCase();
            String[] input = direction.split(" ");
            int lastLoc = loc;
            if(input.length > 1){
                for (String string : input) {
                    if (vocabulary.containsKey(string)){
                        if(location.getExits().containsKey(vocabulary.get(string))){
                            loc = location.getExits().get(vocabulary.get(string));
                        }
                    }
                }
                if(loc == lastLoc){
                    System.out.println("Invalid option selected");
                }
            }else{
                if (location.getExits().containsKey(vocabulary.get(input[0]))) {
                    loc = location.getExits().get(vocabulary.get(input[0]));
                }else if(location.getExits().containsKey((input[0]))){
                    loc = location.getExits().get(input[0]);
                }
                if (loc == lastLoc) {
                    System.out.println("Invalid option selected");
                }
            }

        }
    }

}
