package sandbox;

public class fibonacci {

    public static void main(String[] args) {
        int start = 1;
        int last = 0;
        int last2 = 0;

        for(int i = 0; i < 100; i++){
            System.out.println(start);
            last2 = last;
            last = start;
            start = last + last2;
        }

    }

}
