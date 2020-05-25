package Class_Structures;

import java.util.ArrayList;
import java.util.List;

public class Gearbox {

    int numGears;
    int currentGear;
    List<Gear> gears;

    public Gearbox(int number){
        this.numGears = number;
        gears = new ArrayList<>();
        for(int i = 1; i < number+1; i++){
            Gear newGear = new Gear(i);
            gears.add(newGear);
        }
        if(gears.size() != 0){
            currentGear = 1;
        }
    }

    private class Gear{
        private int gearNumber;

        private Gear(int number){
            this.gearNumber = number;
        }

        private int getGearNumber(){
            return this.gearNumber;
        }
    }

    public boolean shiftUp(){
        if(currentGear + 1 <= gears.size()){
            currentGear++;
            System.out.println("Shifting from " + (currentGear-1) + " to " + currentGear);
            return true;
        }else{
            System.out.println("Grind");
            return false;
        }
    }

    public boolean shiftDown(){
        if(currentGear - 1 > 0){
            currentGear--;
            System.out.println("Shifting from " + (currentGear+1) + " to " + currentGear);
            return true;
        }else{
            System.out.println("Grind");
            return false;
        }
    }

    public void printGears(){
        for(Gear gear: gears){
            System.out.println(gear.getGearNumber());
        }
    }




}
