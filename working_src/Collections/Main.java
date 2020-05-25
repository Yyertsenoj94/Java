package Collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Theatre theatre1 = new Theatre("Majestic", 8, 12);

        theatre1.reserveSeat("A02");

        List<Theatre.Seat> newSeats = new ArrayList<>(theatre1.getSeats());

        printList(newSeats);
        

//        Collections.shuffle(copySeats);
//        System.out.println("printing copySeats");
//        printSeats(copySeats);
//        System.out.println("===================================================");
//        System.out.println("Printing Theatre seats");
//        printSeats(theatre1.seats);
//
//
//        Theatre.Seat seatMin = Collections.min(copySeats);
//        Theatre.Seat seatMax = Collections.max(theatre1.seats);
//
//        System.out.println("Seat Min: " + seatMin.getSeat());
//        System.out.println("Seat Max: " + seatMax.getSeat());
//
//        sortList(copySeats);
//
//        printSeats(copySeats);



    }

    public static void printList(List<Theatre.Seat> list){

        for(Theatre.Seat s: list){
            System.out.println(" " + s.getSeat() + " " + s.getPrice());

        }

        System.out.println();
        System.out.println("================================================================");

    }



//    public static void sortList(List<? extends Theatre.Seat> list){
//        for(int i = 0; i < list.size(); i++){
//
//            for(int j = i+1; j < list.size(); j++){
//
//                if(list.get(i).compareTo(list.get(j)) >= 0){
//                    System.out.println("Greater results comparing i " + list.get(i).getSeat() + " to the j" + list.get(j).getSeat());
//                    Collections.swap(list, i, j);
//                }
//            }
//        }
//    }


}
