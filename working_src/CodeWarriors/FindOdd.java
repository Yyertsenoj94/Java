package CodeWarriors;

public class FindOdd {


    public static void main(String[] args) {
        int[] test = {1, 1, 2, 3, 3, 5, 5, 5};
        int oddNumber = findIt(test);
        System.out.println(oddNumber);
    }


    public static int findIt(int[] a) {

        for(int i = 0; i < a.length; i++){
            int tempNumberInArray = a[i];
            int numberOfInstances = 0;
            for(int cycle = 0; cycle < a.length; cycle++){

                if(a[cycle] == a[i]){
                    numberOfInstances++;
                }
            }
            if((numberOfInstances % 2) > 0){
                return a[i];
            }

        }

        return 0;

    }
}
