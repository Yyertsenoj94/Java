package Sets;

public class Planet extends HeavenlyBody{

    public Planet(String name, int duration){
        super(name, duration, BodyTypes.PLANET);
    }

    @Override
    public boolean addSatellite(HeavenlyBody moon) {
       if(moon.getType().equals(BodyTypes.MOON)){
           return super.addSatellite(moon);
       }else{
           System.out.println("You cannot add " + moon.getType() + " to a " + BodyTypes.MOON);
           return false;
       }
    }


}
