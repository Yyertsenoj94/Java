package MusicLibrary;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Playlist extends SongCollection implements Player {

    private Playlist(String name){
        super(name);
    }

    public static Playlist createPlaylist(){
        System.out.print("Please input a name for new playlist: \t");
        return new Playlist(scanner.nextLine());
    }

    public String getPlaylistName(){
        return super.getCollectionName();
    }

    public void menu(){
        super.displayMenu("playlist");
    }

    public void printSongList(){
        System.out.println(getPlaylistName() + "Song List:");
        super.printSongs();
    }

    private int playMenu(){
        System.out.println("Playlist Player");
        System.out.println("1. Play next");
        System.out.println("2. Play previous");
        System.out.println("3. Repeat Song");
        System.out.println("4. Shuffle Songs");
        System.out.println("5. Current Queue");
        System.out.println("6. Exit Player");

        System.out.print("Please select an option listed above: \t");
        int choice = scanner.nextInt();
        scanner.nextLine();
        System.out.println();
        return choice;
    }

    @Override
    public void play() {
        ListIterator<Song> iterator = super.getCollectionSongs().listIterator();
        boolean forward = true;
        int choice;
        do{
            choice = playMenu();
            switch (choice){
                case 1:
                    if(iterator.hasNext()){
                        if(!forward){
                            iterator.next();
                            forward = true;
                        }
                        System.out.println("Now playing " + iterator.next().getName());
                    }else{
                        System.out.println("You have reached the end of the playlist");
                    }
                    break;
                case 2:
                    if(iterator.hasPrevious()){
                        if(forward){
                            iterator.previous();
                            forward = false;
                        }
                        System.out.println("Now playing " + iterator.previous().getName());
                    }else{
                        System.out.println("You have reached the beginning of the playlist");
                    }
                    break;
                case 3:
                    if(forward){
                        System.out.println("Now playing" + iterator.previous().getName());
                        forward = false;
                    }else{
                        System.out.println("Now playing" + iterator.next().getName());
                        forward = true;
                    }
                    break;
                case 4:
                    shuffle(super.getCollectionSongs());
                    break;
                case 5:
                    System.out.println("Queue:");
                    int prior = iterator.previousIndex();
                    ListIterator<Song> priorIter = super.getCollectionSongs().listIterator();

                    while(priorIter.nextIndex() <= prior){
                        System.out.println(priorIter.next().getName());
                    }
                    if(priorIter.hasNext()){
                        System.out.println(priorIter.next().getName() + " (Now Playing)");
                        if(priorIter.hasNext()){
                            System.out.println(priorIter.next() + " (Up Next)");
                        }
                    }
                    while(priorIter.hasNext()){
                        System.out.println(priorIter.next());
                    }
                    break;
                case 6:
                    System.out.println("Exiting playlist player...");
                    break;
                default:
                    System.out.print("Option not available, please try again: \t");
            }

        }while(choice != 6);
    }

    @Override
    public void shuffle(List<Song> songs) {
            int random = 0;
            List<Song> shuffled = new ArrayList<>();

            for(int i = 0; i < super.getTotalSongs(); i++){

                do{
                    random = (int) (Math.random() * i);

                }while(random > shuffled.size());
                shuffled.add(random, super.getCollectionSongs().get(i));
            }
            songs = shuffled;
    }

}
