package Sets;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        HashMap<HeavenlyBody.Key, HeavenlyBody> solarSystem = new HashMap<>();

        Set<HeavenlyBody> planets = new HashSet<>();



        //Planets
        Planet newPlanet = new Planet("Earth", 282);
        solarSystem.put(newPlanet.getKey(), newPlanet);

        newPlanet = new Planet("Saturn", 282);
        solarSystem.put(newPlanet.getKey(), newPlanet);

        newPlanet = new Planet("Jupiter", 282);
        solarSystem.put(newPlanet.getKey(), newPlanet);

        newPlanet = new Planet("Mars", 282);
        solarSystem.put(newPlanet.getKey(), newPlanet);

        newPlanet = new Planet("Pluto", 282);
        solarSystem.put(newPlanet.getKey(), newPlanet);


        //Moons
        Moon newMoon = new Moon("Earth's Moon", 365);
        solarSystem.put(newMoon.getKey(), newMoon);

        newMoon = new Moon("Jupiter's Moon", 365);
        solarSystem.put(newMoon.getKey(), newMoon);

        newMoon = new Moon("Mars' Moon", 365);
        solarSystem.put(newMoon.getKey(), newMoon);

        newMoon = new Moon("Pluto's Moon", 365);
        solarSystem.put(newMoon.getKey(), newMoon);

        newMoon = new Moon("Saturn's Moon", 365);
        solarSystem.put(newMoon.getKey(), newMoon);


        //Stars
        Star newStar = new Star("Earth's Star", 210);
        solarSystem.put(newStar.getKey(), newStar);

        newStar = new Star("Jupiter's Star", 210);
        solarSystem.put(newStar.getKey(), newStar);

        newStar = new Star("Mars' Star", 210);
        solarSystem.put(newStar.getKey(), newStar);

        newStar = new Star("Pluto's Star", 210);
        solarSystem.put(newStar.getKey(), newStar);

        newStar = new Star("Earth's Moon's Star", 210);
        solarSystem.put(newStar.getKey(), newStar);

        newStar = new Star("Earth", 202);
        solarSystem.put(newStar.getKey(), newStar);

        //Add a star to the earth's moon, and the EARTH too, the last one should fail.
        solarSystem.get(HeavenlyBody.makeKey("Earth's Moon", HeavenlyBody.BodyTypes.MOON)).addSatellite(newStar); //should succeed
        solarSystem.get(HeavenlyBody.makeKey("Earth", HeavenlyBody.BodyTypes.PLANET)).addSatellite(newStar); // should fail

        //test comparisons
        Planet neptune = new Planet("Neptune", 1);
        Star poseidon = new Star("Poseidon", 2);


        Set<HeavenlyBody> moons = new HashSet<>();
        Set<HeavenlyBody> stars = new HashSet<>();

        for(HeavenlyBody.Key key: solarSystem.keySet()){
            if(solarSystem.get(key).getType() == HeavenlyBody.BodyTypes.MOON){
                moons.add(solarSystem.get(key));
            }else if(solarSystem.get(key).getType() == HeavenlyBody.BodyTypes.PLANET){
                planets.add(solarSystem.get(key));
            }else if(solarSystem.get(key).getType() == HeavenlyBody.BodyTypes.STAR){
                stars.add(solarSystem.get(key));
            }
        }

        System.out.println("Printing Planets");

        for(HeavenlyBody heavenlyBody: planets){
            System.out.println(heavenlyBody.toString());
        }

        System.out.println("Printing Moons");
        for(HeavenlyBody heavenlyMoon: moons){
            System.out.println(heavenlyMoon.toString());
        }

        System.out.println("Printing Stars");
        for(HeavenlyBody heavenlyStar: stars){
            System.out.println(heavenlyStar.toString());
        }



    }
}
