package MusicLibrary;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class SongCollection implements Player {

    static Scanner scanner = new Scanner(System.in);

    private String name;
    private List<Song> songs;

    public SongCollection(String name){
        this.name = name;
        this.songs = new ArrayList<>();
    }

    public void displayMenu(String collectionType){
        int choice = 0;
        do{
            System.out.println("1. Display current songs in " + this.name);
            System.out.println("2. Change name of " + collectionType);
            System.out.println("3. Update song list");
            System.out.println("4. Exit");

            System.out.print("Please select an option listed above: \t");
            choice = scanner.nextInt();
            scanner.nextLine();
            System.out.println();
            switch (choice){
                case 1:
                    printSongs();
                    break;
                case 2:
                    System.out.print("Please input new name for " + this.name + ": \t");
                    this.name = scanner.nextLine();
                    System.out.println();
                    break;
                case 3:
                    updateSongsMenu();
                    break;
                case 4:
                    System.out.println("Exiting....");
                    break;
                default:
                    System.out.print("Option not available, please try again: \t");

                    break;
            }

        }while(choice != 4);

    }

    public void updateSongsMenu(){

        int choice;
        do{
            System.out.println("1. Add song");
            System.out.println("2. Remove song");
            System.out.println("3. Modify song");
            System.out.println("4. Exit");

            System.out.print("Please select an option listed above: \t");
            choice = scanner.nextInt();
            scanner.nextLine();
            System.out.println();
            switch (choice){
                case 1:
                    if(addSong()){
                        System.out.println("Song was successfully added");
                    }else{
                        System.out.println("Song could not be added, please check to make sure it's not a duplicate");
                    }
                    break;
                case 2:
                    if(removeSong()){
                        System.out.println("Song was successfully removed");
                    }else{
                        System.out.println("Song could not be removed");
                    }
                    break;
                case 3:
                    modifySong();
                    break;
                case 4:
                    System.out.println("Exiting....");
                    break;
                default:
                    System.out.print("Option not available, please try again: \t");
                    break;
            }
        }while(choice != 4);

    }

    public boolean addSong(){
        Song song = Song.createSong();
        if(findSong(song.getName()) == -1){
            songs.add(song);
            return true;
        }
        return false;
    }

    public boolean removeSong(){
        if(songs == null || songs.isEmpty()){
            System.out.println("There are no songs to remove");
        }else
        printSongs();
        System.out.print("Type the number of song you would like to modify: \t");
        int index = scanner.nextInt();
        scanner.nextLine();
        System.out.println();
        if (index > songs.size() || index < 1){
            System.out.println("You did not make a valid selection");
            return false;
        }
        if(songs.contains(songs.get(index-1))){
            songs.remove(index-1);
            return true;
        }
        return false;
    }

    public boolean modifySong(){
        if(songs == null || songs.isEmpty()){
            System.out.println("There are no songs to modify");
            return false;
        }
        printSongs();
        System.out.print("Type the number of song you would like to modify: \t");
        int index = scanner.nextInt();
        scanner.nextLine();
        System.out.println();
        if (index > songs.size() || index < 1){
            System.out.println("You did not make a valid selection");
            return false;
        }

        return songs.get(index-1).modify();
    }


    public List<Song> getCollectionSongs(){
        return this.songs;
    }

    public String getCollectionName(){
        return this.name;
    }

    //returns total songs in this collection
    public int getTotalSongs(){
        return this.songs.size();
    }

    //method to return the total time duration of this song Collection.
    public double getTotalTimeDuration(){
        double totalDuration = 0.0;
        for(Song song: songs){
            totalDuration += song.getDuration();
        }
        return totalDuration;
    }

    public int findSong(String name){
        if(songs == null || songs.isEmpty()){
            return -1;
        }
        for(int i = 0; i < songs.size(); i++){
            if (songs.get(i).getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    public void printSongs(){
        System.out.println("Current songs in " + this.name);
        System.out.println("==================");
        if(songs != null && !songs.isEmpty()){
            int count = 1;
            for(Song song: songs){
                System.out.println(count + ": " + song.getName() + " - " + song.getDuration());
                count++;
            }
        }else{
            System.out.println("There are no songs to display");
        }
        System.out.println("==================");
        System.out.println();
    }

    public void modifyCollection(List<Song> songs){
        this.songs = songs;
    }

}
