package MusicLibrary;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Album extends SongCollection implements Player {
    private Album(String name){
        super(name);
    }

    public static Album createAlbum(){
        System.out.print("Please input a name for new album: \t");
        return new Album(scanner.nextLine());
    }

    public void printSongList(){
        System.out.println(getAlbumName() + "Song List:");
        super.printSongs();
    }

    public String getAlbumName(){
        return super.getCollectionName();
    }

    public void menu(){
        super.displayMenu("album");
    };


    private int playMenu(){
        System.out.println("Album Player");
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
                        System.out.println("You have reached the end of the album");
                        forward = false;
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
                        System.out.println("You have reached the beginning of the album");
                        forward = true;
                    }
                    break;
                case 3:
                    if(forward){
                        System.out.println("Now playing " + iterator.previous().getName());
                        forward = false;
                    }else{
                        System.out.println("Now playing " + iterator.next().getName());
                        forward = true;
                    }
                    break;
                case 4:
                    shuffle(super.getCollectionSongs());
                    iterator = super.getCollectionSongs().listIterator();
                    break;
                case 5:
                    System.out.println("Queue:");
                    int prior = iterator.previousIndex();
                    if(forward){
                        prior -= 1;
                    }
                    ListIterator<Song> priorIter = super.getCollectionSongs().listIterator();

                    while(priorIter.nextIndex() <= prior){
                        System.out.println(priorIter.next().getName());
                    }
                    if(priorIter.hasNext()){
                        System.out.println(priorIter.next().getName() + " (Now Playing)");
                        if(priorIter.hasNext()){
                            System.out.println(priorIter.next().getName() + " (Up Next)");
                        }
                    }
                    while(priorIter.hasNext()){
                        System.out.println(priorIter.next().getName());
                    }
                    System.out.println();
                    break;
                case 6:
                    System.out.println("Exiting album player...");
                    break;
                default:
                    System.out.print("Option not available, please try again: \t");
                    break;
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
        super.modifyCollection(shuffled);
    }
}
