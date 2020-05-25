package ProgrammingI;

import java.util.Scanner;

public class diamondWithArray {



    static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        int[] testArray = new int[4];
        testArray[(int) 2.3] = 4;


        System.out.println("Please enter letter");
        char letter = scanner.next().charAt(0);
        System.out.println("Please enter number");
        int size = scanner.nextInt();
        int[] letters = new int[size];
        int[] spaces = new int[size];

        int initialLetterCount = size / (size/2);
        int initialSpaceCount = (size / 2) - 1;
        for(int i = 0; i < size / 2; i++){
            letters[i] = initialLetterCount;
            spaces[i] = initialSpaceCount;
            initialLetterCount+=2;
            initialSpaceCount--;
        }

        for(int i = 0; i < size/2; i++){
            //print spaces
            for(int j = 0; j < spaces[i]; j++){
                System.out.print(" ");
            }
            //print letters
            for(int k = 0; k < letters[i]; k++){
                System.out.print(letter);
            }
            System.out.println();
        }

        for(int i = (size / 2) - 1; i >= 0; i--){
            //print spaces
            for(int j = 0; j < spaces[i]; j++){
                System.out.print(" ");
            }
            //print letters
            for(int k = 0; k < letters[i]; k++){
                System.out.print(letter);
            }
            System.out.println();
        }
    }
}
