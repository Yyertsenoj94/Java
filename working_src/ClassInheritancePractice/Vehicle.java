package ClassInheritancePractice;
public class Vehicle {

    private String currentDirection;

    private double currentSpeed;

    private int currentGear;

    //main constructor for the vehicle class
    public Vehicle(){

        this.currentDirection = "None";
        this.currentGear = 1;
        this.currentSpeed = 0;

    }

    public String getCurrentDirection() {
        return currentDirection;
    }

    public double getCurrentSpeed() {
        return currentSpeed;
    }

    public int getCurrentGear() {
        return currentGear;
    }

    public void setCurrentDirection(String currentDirection) {
        this.currentDirection = currentDirection;
    }

    public void setCurrentSpeed(double currentSpeed) {
        this.currentSpeed = currentSpeed;
    }


    public void increaseSpeed(double speed){
        System.out.println("Increasing speed from " + currentSpeed + " mph, to " + (currentSpeed + speed) + " mph.");
        currentSpeed += speed;

        shiftGear(currentSpeed);

    }

    public void decreaseSpeed(double speed){
        System.out.println("Decreasing speed from " + currentSpeed + " mph, to " + (currentSpeed - speed) + " mph.");
        currentSpeed -= speed;

        shiftGear(currentSpeed);

    }

    //check to see what gear we should be in.
    public void shiftGear(double speed){

        //until we are in the correct gear, will upshift or downshift by one.
        while(gearPosition(speed) != currentGear){

            //if current gear is too low, upshift
            if(gearPosition(speed) > currentGear){
                upShift();
            //if current gear is too high, downshift
            }else{
                downShift();
            }

        }
    }

    //increase gear count by one.
    public void upShift(){
        System.out.println("Shifting gears from " + getGearTerm(currentGear) + " to " + getGearTerm(currentGear +1));
        currentGear += 1;
        System.out.println("Car_Class is now in " + getGearTerm(currentGear));
    }

    public void downShift(){
        System.out.println("Car_Class is downshifting from " + getGearTerm(currentGear) + " to " + getGearTerm(currentGear -1));
        currentGear -= 1;
        System.out.println("Car_Class is now in " + getGearTerm(currentGear));
    }

    //returns the gear position that needs to be in place for the speed the car is traveling.
    public int gearPosition(double speed){
        int position;

        if(speed < 0){
            position = -1;
        }else if(speed == 0){
            position = 0;
        }
        else if(speed < 15){
            position = 1;
        }else if (speed < 45){
            position = 2;
        }else if (speed < 60){
            position = 3;
        }else if(speed < 80){
            position = 4;
        }else{
            position = 5;
        }

        return position;
    }

    public String getGearTerm(int currentGear){
        String gear = "";

        switch (currentGear){
            case -1:
                gear = "Reverse";
                break;
            case 0:
                gear = "Neutral";
                break;
            case 1:
                gear = "1st";
                break;
            case 2:
                gear = "2nd";
                break;
            case 3:
                gear = "3rd";
                break;
            case 4:
                gear = "4th";
                break;
            case 5:
                gear = "5th";
                break;
        }

        return gear;
    }




}
