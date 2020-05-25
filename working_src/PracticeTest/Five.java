package PracticeTest;

public class Five {

    public static void main(String[] args) {
        for(int i = 0; i <= 24; i++){
            System.out.print(i + " ");
            if((i+1) % 5 == 0){
                System.out.println();
            }
        }

        int count = 0;

        for(int j = 0; j < 25; j++){
            System.out.print(count);
            if((j+1) % 5 == 0){
                System.out.println();
            }
            count++;
            if(count > 2){
                count = 0;
            }
        }
    }



}
