package RoomComposition;
public class Structure {

    private int window;
    private int door;
    private int wall;
    private int floor;

    public Structure(){

        this.window = 2;
        this.door = 1;
        this.wall = 4;
        this.floor = 1;


    }

    public int getWindow() {
        return window;
    }

    public int getDoor() {
        return door;
    }

    public int getWall() {
        return wall;
    }

    public int getFloor() {
        return floor;
    }
}
