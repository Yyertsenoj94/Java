package RoomComposition;
public class Room {

    private Electronics electronics;
    private Food food;
    private Furniture furniture;
    private Light light;
    private Utilities utilities;
    private Structure structure;


    public Room(){

        this(new Electronics(), new Food(), new Furniture(), new Light(), new Utilities(), new Structure());

    }

    public Room(Electronics electronics, Food food, Furniture furniture, Light light, Utilities utilities, Structure structure) {
        this.electronics = electronics;
        this.food = food;
        this.furniture = furniture;
        this.light = light;
        this.utilities = utilities;
        this.structure = structure;
    }


    public Electronics getElectronics() {
        return electronics;
    }

    public Food getFood() {
        return food;
    }

    public Furniture getFurniture() {
        return furniture;
    }

    public Light getLight() {
        return light;
    }

    public Utilities getUtilities() {
        return utilities;
    }

    public Structure getStructure() {
        return structure;
    }
}
