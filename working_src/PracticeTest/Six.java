package PracticeTest;

import java.util.Scanner;

public class Six {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("0 Red");
        System.out.println("1 Green");
        System.out.println("2 Blue");

        int choice = scanner.nextInt();

        while (choice < 0 || choice > 2){
            System.out.println("Incorrect, try again");
            choice = scanner.nextInt();
        }
        if(choice == 0){
            System.out.println("Red");
        }else if(choice == 1){
            System.out.println("Green");

        }else{
            System.out.println("Blue");
        }


    }
}
