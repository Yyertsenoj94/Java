package PracticeTest;

public class Two {

    public static void main(String[] args) {
        int i = 0;

        while( i < 3){
            for(int j = i; j < 3; j++){
                System.out.print("$");
            }
            System.out.print(" ");
            ++i;
        }
    }

}
