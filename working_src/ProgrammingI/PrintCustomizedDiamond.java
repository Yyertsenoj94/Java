
package ProgrammingI;
import java.util.Scanner;

public class PrintCustomizedDiamond {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a letter: ");
        char letter = scanner.next().charAt(0);
        int num = 0;
        while(num < 6 || (num % 2 != 0)) {
            System.out.print("Enter a size (even number no less than 6): ");
            num = scanner.nextInt();
        }
        System.out.println();
        int outer = 2;
        int inner = num / 2; //initialize inner
        int letterCount = num / inner; // number of letters printed will be total num divided by the inner loop reps (e.g. 6 / 3 = 2)
        int spaceCount = inner - 1; //initialize number of letters

        while(outer > 0){
            inner = num / 2; // reset inner loop
            while(inner > 0){
                int i = 0;
                int j = 0;
                while(i < spaceCount){ // print out all spaces
                    System.out.print(" ");
                    i++;
                }
                while(j < letterCount){ // print out all letters
                    System.out.print(letter);
                    j++;
                }
                System.out.println(); // print new line
                inner--;
                //the following determines whether to increase spaces or decrease spaces depending if on the first or second outer loop.
                if(outer > 1 && inner != 0){
                    spaceCount--; // if on first loop, spaces decrease
                    letterCount+=2; // if on first loop, letters increase
                }else if (outer == 1 && inner != 0){
                    spaceCount++; // if on second loop, spaces increase
                    letterCount-=2; // if on second loop, letters decrease
                }
            }
            outer--;
        }
    }
}
