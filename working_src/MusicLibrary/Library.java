package MusicLibrary;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import java.util.Scanner;


public class Library {
    static final Scanner scanner = new Scanner(System.in);
    List<SongCollection> albums= new ArrayList<>();
    List<SongCollection> playlists = new ArrayList<>();
    String name;

    private Library(String name){
        this.name = name;
    }

    public void menu(){

        int choice;
        do{
            System.out.println("Main Menu");
            System.out.println("==================");
            System.out.println("1. Add Albums");
            System.out.println("2. Remove Albums");
            System.out.println("3. Modify Albums");
            System.out.println("4. Play Albums");
            System.out.println();
            System.out.println("5. Add Playlists");
            System.out.println("6. Remove Playlists");
            System.out.println("7. Modify Playlists");
            System.out.println("8. Play Playlists");
            System.out.println();
            System.out.println("9. Rename Library");
            System.out.println("10. Exit");
            System.out.println("==================");
            System.out.print("Please select an option listed above: \t");
            choice = scanner.nextInt();
            scanner.nextLine();
            System.out.println();
            switch (choice){
                case 1:
                    addCollection( albums, choice);
                case 2:
                    addCollection(playlists, choice);
                case 3:
                    System.out.print("Please type new name for library: \t");
                    this.name = scanner.nextLine();
                    System.out.println();
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.print("Option not available, please try again: \t");
            }
        }while(choice != 10);

    }

    public static Library createLibrary(){
        System.out.println("Library has been created");
        System.out.print("Please select a name for your library: \t");
        String name = scanner.nextLine();
        System.out.println();
        return new Library(name);
    }

    public void addCollection(List<SongCollection> collection, int type){
        SongCollection newCollection;
        if(type == 1){
            newCollection = Album.createAlbum();
        }else{
            newCollection = Playlist.createPlaylist();
        }
        collection.add(newCollection);
    }

    public void removeCollection(int type){
        if(type == 1){

        }
    }



}
