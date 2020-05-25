package Maps;

import java.util.*;

public class MapProgram {
    private Map<Integer, Location> map = new HashMap<>();


   public MapProgram() {
        Map<String, Integer> alternateExits = new Hashtable<>();

       map.put(0, new Location(0, "You are sitting in front of a computer learning Java", null));

       Map<String, Integer> tempLocationExits = new HashMap<>();
       tempLocationExits = new HashMap<>();
       tempLocationExits.put("N", 5);
       tempLocationExits.put("W", 2);
       tempLocationExits.put("S", 4);
       tempLocationExits.put("E", 3);
       map.put(1, new Location(1, "You are at the end of a road in front of a small building", tempLocationExits));
       
       tempLocationExits = new HashMap<>();
       tempLocationExits.put("N", 5);
       map.put(2, new Location(2, "You are at the top of a hill", tempLocationExits));

       tempLocationExits = new HashMap<>();
       tempLocationExits.put("W", 1);
       map.put(3, new Location(3, "You are inside a building, a well house for a small spring", tempLocationExits));

       tempLocationExits = new HashMap<>();
       tempLocationExits.put("N", 1);
       tempLocationExits.put("W", 2);
       map.put(4, new Location(4, "You are in a valley beside a stream", tempLocationExits));

       tempLocationExits = new HashMap<>();
       tempLocationExits.put("W", 2);
       tempLocationExits.put("S", 1);
       map.put(5, new Location(5, "You are in a forest", tempLocationExits));

   }

   public HashMap<Integer, Location> getMap(){
       return new HashMap<>(this.map);
   }

}
