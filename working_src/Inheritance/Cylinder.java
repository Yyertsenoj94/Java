package Inheritance;

public class Cylinder extends Circle {

    double height = 0;

    public Cylinder(double radius, double height){
        super(radius); // remember that the super constructor must be the first statement in the child constructor if being called.
        this.height = height;

    }

    public double getHeight(){
        return height;
    }

    public double getVolume(){
        return height * getArea();
    }
}
