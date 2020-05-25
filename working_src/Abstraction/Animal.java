package Abstraction;

public abstract class Animal {
    private String name;
    private boolean alive;

    public Animal(String name){
        name = name;
        alive = true;
    }

    public void speak(){
        System.out.println("Hello, I can speak");
    }

    abstract void eat();

    abstract void breath();

    abstract void sleep();


}
