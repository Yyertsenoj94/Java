package Collections;
import java.text.Format;
import java.util.*;

public class Theatre {

    private String name;
    private List<Seat> seats = new ArrayList<>();

    public Theatre(String name, int rowNumber, int seatNumber){

        this.name = name;

        int lastRow = 'A' + rowNumber;

        for(char row = 'A'; row < lastRow; row ++){
            for(int seat = 1; seat < seatNumber + 1; seat++){
                double price = 12.00;
                if((row < 'D') && (seatNumber >= 4 && seatNumber <= 9)){
                    price = 14.00;
                }else if ((row > 'F' ) || (seatNumber < 4) || seatNumber > 9){
                    price = 7.00;
                }
                Seat newSeat = new Seat(row + String.format("%02d", seat), price);
                seats.add(newSeat);
            }
        }

    }

    public boolean reserveSeat(String seatNumber){
        Seat requestedSeat = new Seat(seatNumber, 0);
        int foundSeat = Collections.binarySearch(seats, requestedSeat, null);

        if(foundSeat >= 0){
            seats.get(foundSeat).reserveSeat();
            return true;
        }
        System.out.println("Seat " + seatNumber + " was not found");
        return false;
    }

    public boolean cancelReservation(String seatNumber){
        Seat requestedSeat = new Seat(seatNumber, 0);

        int foundSeat = Collections.binarySearch(seats, requestedSeat,null);
        if(foundSeat >= 0){
            seats.get(foundSeat).cancel();
            return true;
        }
        System.out.println("Seat " + seatNumber + " was not found");

        return false;
    }



    public class Seat implements Comparable<Seat>{

        private String seat;
        private boolean reserved = false;
        private double price = 0;

        public Seat(String seatNumber, double price){
            seat = seatNumber;
            this.price = price;
        }


        public boolean reserveSeat(){
            if(reserved){
                System.out.println("Seat " + seat + " is already reserved");
                return false;
            }else{
                reserved = true;
                System.out.println("Seat " + seat + " is now reserved for you.");
                return true;
            }
        }

        public boolean cancel(){
            if(reserved){
                reserved = false;
                System.out.println("Reservation for seat " +  seat + " was successfully cancelled");
                return true;
            }else{
                System.out.println("Seat " + seat + " was not reserved.");
                return false;
            }

        }

        public String getSeat(){
            return seat;
        }

        public double getPrice(){
            return price;
        }

        @Override
        public int compareTo(Seat seat) {
            return this.seat.compareToIgnoreCase(seat.seat);
        }
    }


    public Collection<Seat> getSeats(){
        return seats;
    }

}

