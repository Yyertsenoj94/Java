package PackageChallenge;

public class Fibonacci {

    public static void main(String[] args) {

        int fibonacci = fibonacci(10);

        System.out.println(fibonacci);

    }


    public static int fibonacci(int n){
        int result = 0;
        //default catch;
        switch(n){
            case 0:
                return 0;
            case 1:
                return 1;
        }
        for(int i = 0; i < n; i++){
            result = fibonacci(i) + fibonacci(i-1);
        }

        return result;
    }

}
