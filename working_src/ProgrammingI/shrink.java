package ProgrammingI;

import java.util.*;

public class shrink {

    public static void main(String[] args) {

        Scanner scnr = new Scanner(System.in);
        System.out.println("Please input first number");
        int first = scnr.nextInt();
        System.out.println("Please input second number");
        int second = scnr.nextInt();

        for(int i = first; i <= second; i++){
            for(int j = i; j <= second; j++){
                System.out.print(j);
            }
            System.out.println();
        }
    }

}
