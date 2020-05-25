package PackageChallenge;

public class Series {

    public static void main(String[] args){

        System.out.println(fibonacci(10));

    }


    public static int nSum (int n){
        int sum = 0;
        for(int i = 0; i <= n; i++){
            sum += i;
        }

        return sum;
    }

    public static double factorial(int n){
        int product = 1;

        for(int i = 1; i <= n; i++){
            product *= i;

        }

        return (double) product;
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
