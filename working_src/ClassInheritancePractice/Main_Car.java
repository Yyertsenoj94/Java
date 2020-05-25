package ClassInheritancePractice;

public class Main_Car {

    public static void main(String[] args){

        ElectricCar Tesla = new ElectricCar("Sedan", "Personal", "4-door",100, "Electric", 75, "Tesla", 0);

        System.out.println("The current speed of the " + Tesla.getModel() + " is " + Tesla.getCurrentSpeed());

        Tesla.increaseSpeed(20);

        Tesla.go(10);

        System.out.println("-------------------------------------------------------------------------------------------------");

        Tesla.decreaseSpeed(5);

        Tesla.go(100);

        System.out.println("-------------------------------------------------------------------------------------------------");

        Tesla.steerElectric("West");

        Tesla.go(50);

        System.out.println("-------------------------------------------------------------------------------------------------");

        Tesla.increaseSpeed(40);

        Tesla.go(10);

        System.out.println("-------------------------------------------------------------------------------------------------");

        Tesla.increaseSpeed(25);

        Tesla.go(10);

        System.out.println("-------------------------------------------------------------------------------------------------");

        Tesla.increaseSpeed(40);

        Tesla.go(20);

        System.out.println("-------------------------------------------------------------------------------------------------");


    }

}
