package CodeWarriors;

public class PrimeNumber {

    public static void main(String[] args) {

        primeNumber(1227454352);

    }

    public static boolean primeNumber(int num){
        if(num <= 0){
            return false;
        }else if(num == 1){
            return false;
        }else{
            for(int i = 2; i < (num / 2); i++){
                if(num == i){
                    continue;
                }
                if(num % i == 0){
                    return false;
                }
            }
            return true;
        }

    }
}
