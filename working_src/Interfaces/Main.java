package Interfaces;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.print("Prior to changes\t\t");
        Monster Frankenstein = new Monster("Frankenstein", "Sword");
        System.out.println(Frankenstein.toString());
        System.out.println();
        System.out.println();

        System.out.print("Updating to Werewolf\t\t");
        Frankenstein.setName("Werewolf");
        Frankenstein.setWeapon("Teeth");
        System.out.println(Frankenstein.toString());
        System.out.println();
        System.out.println();
        System.out.print("Creating Young Frankenstein\t\t");
        Monster youngFrankenstein = new Monster("Young Frankenstein", "Scalpel");
        System.out.println(youngFrankenstein.toString());
        System.out.println();
        System.out.println();

        ArrayList<Object> savedSettings = Frankenstein.saveList();


        System.out.print("Loading Frankenstein's settings into youngFrankenstein...\t\t");
        youngFrankenstein.load(savedSettings);

        System.out.println(youngFrankenstein.toString());

    }


    public static ArrayList<String> readValues() {
        ArrayList<String> values = new ArrayList<String>();

        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        int index = 0;
        System.out.println("Choose\n" +
                "1 to enter a string\n" +
                "0 to quit");

        while (!quit) {
            System.out.println("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 0:
                    quit = true;
                    break;
                case 1:
                    System.out.println("Enter a string");
                    String stringInput = scanner.nextLine();
                    values.add(index, stringInput);
                    index++;
                    break;
            }

        }

        return values;

    }
}


