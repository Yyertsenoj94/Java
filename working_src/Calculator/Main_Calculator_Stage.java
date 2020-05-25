package Calculator;
import java.util.Scanner;

public class Main_Calculator_Stage {

    public static void  main(String[] args){

        Calculator_stage newCalc = new Calculator_stage();

        int number1;
        int number2;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please input the first number");
        number1 = scanner.nextInt();

        scanner.nextInt();

        number2 = scanner.nextInt();


        newCalc.setFirstNumber(number1);

        newCalc.setSecondNumber(number2);

        newCalc.getAdditionResult();
        newCalc.getDivisionResult();
    }

}
