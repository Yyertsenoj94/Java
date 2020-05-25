package NewCollections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
            Theatre theatre = new Theatre("Globe", 12, 10);
            theatre.printSeats(theatre.seats);
            List<Theatre.Seat> shuffledSeats = new ArrayList<>(theatre.seats);
            Collections.shuffle(shuffledSeats);
            System.out.println("Printing shuffled seats");
            theatre.printSeats(shuffledSeats);

            Collections.sort(shuffledSeats);

            System.out.println("Printing re-sorted shuffled seats");
            theatre.printSeats(shuffledSeats);

            System.out.println("Printing seats based on price");
            List<Theatre.Seat> priceOrderSeats = new ArrayList<>(theatre.seats);

            Collections.sort(priceOrderSeats, theatre.PRICE_COMPARISON);
            theatre.printSeats(priceOrderSeats);

    }
}
