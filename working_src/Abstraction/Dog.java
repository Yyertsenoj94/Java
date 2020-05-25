package Abstraction;

public class Dog extends Animal {

    public Dog(String name){
        super(name);
    }

    @Override
    void eat() {
        System.out.println("The Dog is eating");
    }

    @Override
    void breath() {
        System.out.println("The dog pants");

    }

    @Override
    void sleep() {
        System.out.println("The dog sleeps");
    }

    public void bark(){
        System.out.println("Woof woof");
    }
}
