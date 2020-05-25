package MusicLibrary;

import java.util.Scanner;

public class Song {
    private double duration;
    private String name;
    static Scanner scanner = new Scanner(System.in);
    private Song(String name, double duration){
        this.duration = duration;
        this.name = name;
    }

    public static Song createSong(){
        System.out.print("Please input name of song: \t");
        String name = scanner.nextLine();
        System.out.println();
        System.out.print("Please input duration of " + name + " \t");
        double duration = scanner.nextDouble();
        scanner.nextLine();
        System.out.println();
        return new Song(name, duration);
    }

    public String getSongName(Song song){
        return song.getName();
    }

    public String getName(){
        return this.name;
    }

    public double getDuration(){
        return this.duration;
    }

    public boolean modify(){
        int choice;
        do{
            System.out.println();
            System.out.println("1. Modify name of " + this.name);
            System.out.println("2. Modify duration of " + this.name);
            System.out.println("3. Exit");

            System.out.print("Please select an option listed above: \t");

            choice = scanner.nextInt();
            scanner.nextLine(); //reset scanner

            switch (choice){
                case 1:
                    System.out.print("Please input new name for " + this.name + ": \t");
                    setName(scanner.nextLine());
                    System.out.println();
                    return true;
                case 2:
                    System.out.print("Please input new duration for " + this.name + ": \t");
                    setDuration(scanner.nextDouble());
                    scanner.nextLine(); //reset scanner.
                    System.out.println();
                    return true;
                case 3:
                    System.out.println("Exiting....");
                    break;
                default:
                    System.out.print("Option not available, please try again: \t");
                    break;
            }

        }while(choice < 1 || choice > 3);

        return false;
    }

    private void setName(String name){
        this.name = name;
    }

    private void setDuration(double duration){
        this.duration = duration;
    }

}
