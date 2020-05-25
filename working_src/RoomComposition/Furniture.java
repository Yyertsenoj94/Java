package RoomComposition;
public class Furniture {

    private boolean desk;
    private boolean chair;
    private boolean table;


    public Furniture(){
        this(true, true, true);
    }

    public Furniture(boolean desk, boolean chair, boolean table) {
        this.desk = desk;
        this.chair = chair;
        this.table = table;
    }


    public boolean isDesk() {
        return desk;
    }

    public boolean isChair() {
        return chair;
    }

    public boolean isTable() {
        return table;
    }
}
