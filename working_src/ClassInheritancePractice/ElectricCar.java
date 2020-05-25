package ClassInheritancePractice;

public class ElectricCar extends Car_Inheritance {

    double batteryLife = 0;
    String engine;
    double maxSpeed;
    int milesTraveled;

    public ElectricCar(String carType, String use, String size, int batteryLife, String engine, double maxSpeed, String model, int milesTraveled){
        super(carType, use, size, model);
        this.batteryLife = batteryLife;
        this.engine = engine;
        this.maxSpeed = maxSpeed;
        this.milesTraveled = 0;
    }

    public void steerElectric(String direction){
        super.setCurrentDirection(direction);
        System.out.println("The Electric car is now traveling " + direction);

    }

    public void go(int time){
        milesTraveled += time * (super.getCurrentSpeed() / 60);
        System.out.println("The " + super.getModel() + " has traveled " + milesTraveled + " miles.");

        //drain battery
        drainBattery(super.getCurrentSpeed(), time);
    }

    //method to increase the vehicle speed - However, cannot exceed the maximum speed.
    @Override
    public void increaseSpeed(double speed){
        if(speed + super.getCurrentSpeed() <= maxSpeed){
            super.increaseSpeed(speed);
        }else{
            System.out.println("You are currently traveling at " + super.getCurrentSpeed() + ", you cannot increase" +
                    " speed by " + speed + ", because you will exceed the maximum speed of " + maxSpeed);
        }

    }
    //method to increase the vehicle speed - However, cannot be less than the minimum speed.
    @Override
    public void decreaseSpeed(double speed){
        if(speed < -10){
            System.out.println("You cannot travel more than 10 mph backwards");
        }else{
            super.decreaseSpeed(speed);
        }
    }

    public void checkBattery(double batteryLife){
        if(batteryLife < 10){
            System.out.println("Battery is low, current level is at " + batteryLife);
            chargeBattery();
        }else{
            //figure out how much longer they can go at this speed before needing to charge.
        }
    }

    public void drainBattery(double speed, int time){

        double drain;

        //arbitrary drain rate.
        drain = ((speed/20) / 2) * time;

        batteryLife -= drain;
        System.out.println("Battery is currently at " + batteryLife);
        //see if battery needs to be charged.
        checkBattery(batteryLife);
    }

    public void chargeBattery() {

        //stop the car
        decreaseSpeed(super.getCurrentSpeed());

        //charge the battery
        while (batteryLife < 100) {

            if ((100 - batteryLife) < 10) {
                System.out.println("Charging battery..." + " by " + (100 % batteryLife));
                batteryLife += (100 % batteryLife);
                System.out.println("Battery level at " + batteryLife);
            } else {
                batteryLife += 10;
                System.out.println("Charging battery..." + " by " + 10);
                System.out.println("Battery level at " + batteryLife);
            }

        }
    }

}
