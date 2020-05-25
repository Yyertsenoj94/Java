package CodeWarriors;

public class evenOddOutlier {

    public static void main(String[] args) {
        int[] integerArray = {1, 4, 6, 8, 10, 12, 14};
        System.out.println(find(integerArray));
    }

    static int find(int[] integers) {
        int evenCount = 0;
        for(int i = 0; i <= 2; i++){
            if(integers[i] % 2 == 0){
                evenCount++;
            }
        }
        switch(evenCount){
            case 0:
            case 1:
                while(true){
                    for(int i: integers){
                        if(i % 2 == 0){
                            return i;
                        }
                    }
                }
            case 2:
            case 3:
                while(true){
                    for(int i: integers){
                        if(!(i % 2 == 0)){
                            return i;
                        }
                    }
                }
        }

        return 0;
    }
}
