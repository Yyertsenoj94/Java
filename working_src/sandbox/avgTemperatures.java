package sandbox;

import java.util.Scanner;

public class avgTemperatures {

    static final Scanner scnr = new Scanner(System.in);
    public static void main(String[] args) {

        System.out.println("How many days were recorded?");
        int days = scnr.nextInt();
        int[] temps = new int[days];
        int sum = 0;
        double avg = 0;
        for(int i = 0; i < days; i++){
            System.out.println("Please input day: " + (i + 1));
            temps[i] = scnr.nextInt();
            sum += temps[i];
        }
        avg = (double) sum / days;
        System.out.printf("%.1f", avg);
        int count = 0;
        for(int s: temps){
            if(s > avg){
                count++;
            }
        }
        System.out.println("");
        System.out.println(count + " days were above average");


    }
}
