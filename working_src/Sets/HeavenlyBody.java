package Sets;

import java.util.HashSet;
import java.util.Set;

public class HeavenlyBody {
    private final int rotation;
    private final Set<HeavenlyBody> satellites;
    private final Key key;
    public enum BodyTypes{
        MOON,
        STAR,
        PLANET
    }

    public HeavenlyBody(String name, int rotation, BodyTypes bodyType){
        this.rotation = rotation;
        satellites = new HashSet<>();
        this.key = new Key(name, bodyType);
    }

    public String getName(){
        return getKey().name;
    }

    public int getRotation(){
        return this.rotation;
    }

    public boolean addSatellite(HeavenlyBody heavenlyBody){
        return this.satellites.add(heavenlyBody);
    }

    public HashSet<HeavenlyBody> getSatellites(){
        return new HashSet<>(this.satellites);
    }

    public BodyTypes getType(){
        return this.key.bodyType;
    }

    @Override
    public String toString(){
        return "Name: " + getName() + " | BodyType: " + getType() + " | Rotation: " + getRotation();
    }

    @Override
    /* these must be overwritten if being used as a key because otherwise the hashmap and
    hashset will not be comparing anything but the object reference in memory
    instead of the values that the object has, and you will get duplicates*/
    public int hashCode() {
        return this.key.hashCode();
    }

    @Override//add another part of this that would define whether the type is the same or not.
    public boolean equals(Object obj) {//by marking THIS as final, no other subclass of Heavenly body can override this method.
        if(obj instanceof HeavenlyBody){
            return this.key.equals(((HeavenlyBody) obj).key);
        }
        return false;
    }

    public static Key makeKey(String name, BodyTypes bodyType){
        return new Key(name, bodyType);
    }

    public Key getKey(){
        return this.key;
    }

    public static final class Key{
        private final String name;
        private final BodyTypes bodyType;

        private Key(String name, BodyTypes bodyType){
            this.name = name;
            this.bodyType = bodyType;
        }

        @Override
        public int hashCode() {
            return this.name.hashCode() + 57 + this.bodyType.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            if(obj instanceof HeavenlyBody.Key) {
                Key key = (Key) obj;
                return this.name.equals(key.name) && this.bodyType.equals(key.bodyType);
            }else{
                return false;
            }
        }


    }

}
