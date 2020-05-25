package MusicLibrary;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Album album = Album.createAlbum();

        System.out.println("Regular Menu");
        album.menu();

        System.out.println("Play Menu");
        album.play();
    }
}
