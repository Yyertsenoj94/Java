package ProgrammingI;
import java.util.Random;

public class RandomNumber {
    static final Random random = new Random();

    public static void main(String[] args) {
        int digit;
        for(int i = 0; i < 10; i++){
            digit = random.nextInt(50)+1;
            if(digit < 20){
                System.out.println(digit + " is less than 20");
            }else if(digit > 40){
                System.out.println(digit + " is greater than 40");
            }else{
                System.out.println("20 <= " + digit + " <= 40");
            }
        }

        int i = 0;

    }

}
