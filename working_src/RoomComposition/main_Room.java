package RoomComposition;
public class main_Room {

    public static void main(String[] args){

        Room room = new Room();

        room.getElectronics().getComputer();
        room.getElectronics().getPhone();
        room.getElectronics().getSpeaker();
        room.getElectronics().getTv();

        System.out.println("------------------------");

        room.getFood().cookFood();
        room.getFood().makeCoffee();

        System.out.println("------------------------");

        room.getUtilities().automateAC();

        System.out.println("------------------------");

        room.getUtilities().turnLightOn();
        room.getUtilities().turnLightOff();

        System.out.println("------------------------");

        System.out.println("Process executed Successfully");
    }


}
