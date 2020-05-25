package Interfaces;

import java.util.ArrayList;

public class Monster implements iSaveable {

    private String name;
    private String weapon;
    private int health;
    private int numLives;

    public Monster(String name, String weapon){
        this.name = name;
        this.weapon = weapon;
        this.health = 100;
        this.numLives = 3;
    }

    public void setName(String name){
        this.name = name;
    }
    public void setWeapon(String weapon){
        this.weapon = weapon;
    }
    public void takeDamage(int damage){
        this.health -= damage;
        if(health <= 0){
            System.out.println("Player has died");
            reduceLives();
            System.out.println("You have " + numLives + " remaining");
        }
    }
    public void reduceLives(){
        this.numLives -= 1;
    }

    @Override
    public ArrayList<Object> saveList() {
        ArrayList<Object> saveList = new ArrayList<>();

        saveList.add(name);
        saveList.add(weapon);
        saveList.add(health);
        saveList.add(numLives);

        return saveList;
    }

    @Override
    public void load(ArrayList<Object> list) {

        this.name = (String) list.get(0);
        this.weapon = (String) list.get(1);
        this.health = (Integer) list.get(2);
        this.numLives = (Integer) list.get(3);
    }

    public String toString(){
        return "Name: " + this.name + "| Weapon: " + this.weapon + "| Health: " + this.health + "| Lives left: " + this.numLives + "";
    }

}
