package ClassInheritancePractice;
public class Car_Inheritance extends Vehicle {

    private String carType; // sedan, suv, truck, sports car
    private String use; //commercial vs personal
    private String size; //2 door or 4 door
    private String model;

    public Car_Inheritance(String carType, String use, String size, String model){
        this.carType = carType;
        this.use = use;
        this.size = size;
        this.model = model;
    }

    public String getCarType() {
        return carType;
    }

    public String getUse() {
        return use;
    }

    public String getSize() {
        return size;
    }

    public String getModel() {
        return model;
    }
}
