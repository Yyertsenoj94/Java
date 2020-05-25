package NewCollections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Theatre {

    String name;
    List<Seat> seats = new ArrayList<>();
    int numColumns;
    int numRows;
    static final Comparator<Seat> PRICE_COMPARISON = new Comparator<Seat>() {
        @Override
        public int compare(Seat seat1, Seat seat2) {
            if(seat1.getPrice() < seat2.getPrice()){
                return -1;
            }else if(seat1.getPrice() > seat2.getPrice()){
                return 1;
            }else{
                return 0;
            }
        }
    };


    public Theatre(String name, int rows, int columns){
        this.name = name;
        this.numColumns = columns;
        this.numRows = rows;

        int begRow = 'A';
        int endRow = begRow + rows;
        int rowRange = endRow - begRow;
        int premiumRow = begRow + ((rowRange / 2) - (rowRange / 4));
        int lowPremiumColumn = (numColumns / 2) - (numColumns / 4);
        int highPremiumColumn = (numColumns / 2) + (numColumns / 4);

        for(char a = 'A'; a < endRow; a++){
            for(int i = 1; i < numColumns; i++){
                double price = 12.00;
                if(a  < premiumRow && i < highPremiumColumn && i > lowPremiumColumn){
                    price = 14.00;
                }else if(a > premiumRow && i < lowPremiumColumn || i > highPremiumColumn){
                    price = 10.00;
                }
                Seat seat = new Seat(a + String.format("%02d", i), price);
                seats.add(seat);
            }
        }
    }

    public boolean reserveSeat(Seat seat){
        int index = findSeatIndex(seat);
        if(index >= 0){
            return seats.get(index).reserveSeat();
        }else{
            System.out.println("Seat does not exist");
            return false;
        }
    }

    public boolean cancelSeat(Seat seat){
        int index = findSeatIndex(seat);
        if(index >= 0){
            return seats.get(index).cancelSeat();
        }else{
            System.out.println("Seat does not exist");
            return false;
        }
    }

    public boolean addSeat(Seat seat){
        int index = findSeatIndex(seat);
        if(index >= 0){
            seats.add(seat);
           return true;
        }else{
            return false;
        }
    }

    public boolean removeSeat(Seat seat){
        int index = findSeatIndex(seat);
        if(index >= 0){
            return seats.remove(seat);
        }else{
            return false;
        }
    }

    public int findSeatIndex(Seat seat){
        return Collections.binarySearch(seats, seat);
    }

    public void printSeats(List<Seat> seats){
        System.out.println("============================================================================================");
        for(Seat seat: seats){
            System.out.print(seat.getSeatNumber() + ": " + seat.getPrice() + " | ");
        }
        System.out.println("============================================================================================");
    }



            public class Seat implements Comparable<Seat>{
                final String seatNumber;
                double price;
                boolean reserved;


                public Seat(String seatNumber, double price){
                    reserved = false;
                    this.seatNumber = seatNumber;
                    this.price = price;
                }

                private boolean reserveSeat(){
                    if(!reserved){
                        reserved = true;
                        System.out.printf("Seat reserved, please pay " + "$%.02f", this.price);
                        return true;
                    }else{
                        System.out.println("Sorry, this seat is already reserved");
                        return false;
                    }
                }

                private boolean cancelSeat(){
                    if(this.reserved){
                        reserved = false;
                        System.out.println("Seat cancelled");
                        return true;
                    }else{
                        System.out.println("Seat was not reserved");
                        return false;
                    }
                }

                private double getPrice(){
                    return this.price;
                }

                private String getSeatNumber(){
                    return this.seatNumber;
                }

                @Override
                public int compareTo(Seat seat) {
                   return this.seatNumber.compareToIgnoreCase(seat.seatNumber);
                }
            }

}
