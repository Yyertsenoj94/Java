package PracticeTest;

public class Four {

    public static void main(String[] args) {

        for(int i =0; i <= 15; i+=3){
            for(int j = i; j <= i+6; j+=2){
                System.out.print(j + " ");
            }
            System.out.println();
        }


        for(int i = 1; i <= 4; i++){
            int count = i;
            for(int j = i; j<= (i*i); j+=i){
                System.out.print(j + " ");
            }
            System.out.println();
        }

    }
}
