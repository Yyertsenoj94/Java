package PracticeTest;

public class Nine {

    public static void main(String[] args) {

        int i = 0;
        int j = 0;
        int k = 3;

        for (i = 0; i < 3; i++){
            if(i < 2){
                k-=i;
            }
            for(j = 4; j > 2; j--){
                System.out.println("i: " + i + " j: " + j + " k: " + k);
                if(i == 1 && j == 4){
                    k = k;
                    System.out.println("---i: " + i + " j: " + j + " k: " + k);
                }
                k += i * (j - 3);
            }
        }
        System.out.println("F:----i: " + i + " j: " + j + " k: " + k);
    }
}
