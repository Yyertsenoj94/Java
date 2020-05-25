package Polymorphism;
public class Poly_Car {

public static void main(String[] args){

    for(int i = 1; i < 10; i++){
        MainCar loopCar = getRandomCar();

        loopCar.accelerate();
        loopCar.startEngine();
    }

}

public static MainCar getRandomCar(){

    int random;

    random = (int) (Math.random() * 4) + 1;

    switch(random){

        case 1:
            return new MainCar("Base", 2);
        case 2:
            return new Toyota();
        case 3:
            return new Mercedes();
        case 4:
            return new Camaro();
    }

    return null;
}


}

class MainCar{
    private boolean engine;
    private int wheels;
    private int cylinders;
    private String name;

    public MainCar(String name, int cylinders){
        this.engine = true;
        this.wheels = 4;
        this.cylinders = cylinders;
        this.name = name;
    }

    public void startEngine(){
        System.out.println("Base startEngine called...");
        System.out.println("Car " + name + " with " + cylinders + " cylinders is starting engine");
    }

    public void accelerate(){
        System.out.println("Base acceleration called...");
        System.out.println("Car " + name + " with " + wheels + " wheels is accelerating");
    }

    public String getName(){
        return name;
    }

    public int getCylinders(){
        return cylinders;
    }

    public boolean isEngine() {
        return engine;
    }

    public int getWheels() {
        return wheels;
    }

}

class Toyota extends MainCar{

    public Toyota(){
        super("Toyota", 4);
}
    @Override
    public void startEngine(){
        System.out.println("Toyota startEngine called...");
        System.out.println("Car " + super.getName() + " with " + super.getCylinders() + " cylinders is starting engine");

    }

    @Override
    public void accelerate(){
        System.out.println("Toyota accelerate called...");
        System.out.println("Car " + super.getName() + " with " + super.getWheels() + " wheels is accelerating");
    }

}

class Mercedes extends MainCar{

    public Mercedes(){
        super("Mercedes", 6);
    }
    @Override
    public void startEngine(){
        System.out.println("Mercedes startEngine called...");
        System.out.println("Car " + super.getName() + " with " + super.getCylinders() + " cylinders is starting engine");

    }

    @Override
    public void accelerate(){
        System.out.println("Mercedes accelerate called...");
        System.out.println("Car " + super.getName() + " with " + super.getWheels() + " wheels is accelerating");
    }

}

class Camaro extends MainCar{

    public Camaro(){
        super("Camaro", 8);
    }
    @Override
    public void startEngine(){
        System.out.println(getClass().getSimpleName() + " startEngine called...");
        System.out.println("Car " + super.getName() + " with " + super.getCylinders() + " cylinders is starting engine");

    }

    @Override
    public void accelerate(){
        System.out.println("Camaro accelerate called...");
        System.out.println("Car " + super.getName() + " with " + super.getWheels() + " wheels is accelerating");
    }

}
