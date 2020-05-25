package Maps;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class Location {
    private final String description;
    private final int locationID;
    private final Map<String, Integer> exits;

    public Location(int locationID, String description, Map<String, Integer> exits){
        this.description = description;
        this.locationID = locationID;
        if(exits != null){
            this.exits = new HashMap<>(exits);
        }else{
            this.exits = new HashMap<>();
        }
        this.exits.put("Q", 0);
    }

    public String getDescription(){
        return this.description;
    }

    public int getLocationID(){
        return locationID;
    }

    public Map<String, Integer> getExits(){
        return new HashMap<>(exits);
    }

}
