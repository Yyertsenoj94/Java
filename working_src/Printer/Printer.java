package Printer;
import java.sql.SQLOutput;

public class Printer {

    private Toner toner;

    private Paper paper;

    private boolean isDuplex;

    private double tonerDrainRate;

    //constructor for printer including duplex
    public Printer(boolean isDuplex, int paperCapacity, double tonerCapacity, double tonerDrainRate){

        this.toner = new Toner(tonerCapacity);

        this.paper = new Paper(paperCapacity);
        this.tonerDrainRate = tonerDrainRate;
        this.isDuplex = isDuplex;

    }

    //feed number of pages to print paper.
    public void print(int totalPages) {

        if(isDuplex){
            //account for printing half the pages
           totalPages /= 2;

            //account for printing both sides per page
            //since the print is based on per page, we would need to multiply by two, to get the actual number
            //of sides printed, which would be the original paper amount.
            tonerDrainRate *= 2;
        }
        for (int currentPageNumber = 1; currentPageNumber <= totalPages; currentPageNumber++) {

            toner.drainToner(tonerDrainRate);
            System.out.println("----------------------");
            paper.usePaper(totalPages, currentPageNumber);
            System.out.println("-----------------------------------------------------------------------");
        }

    }


}
