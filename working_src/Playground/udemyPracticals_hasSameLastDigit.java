package Playground;
public class udemyPracticals_hasSameLastDigit {

    public static void main(String[] args) {

        System.out.println(hasSameLastDigit(501, 341, 272));

    }

    public static boolean hasSameLastDigit(int x, int y, int z){
        boolean condition = false;

        int xLastDigit = 0;
        int yLastDigit = 0;
        int zLastDigit = 0;

        if(x >= 10 && x <= 1000 && y >= 10 && y <= 1000 && z >= 10 && z <= 1000){

            xLastDigit = x % 10;
            yLastDigit = y % 10;
            zLastDigit = z % 10;

            if(xLastDigit == yLastDigit){
                condition = true;
            }else if(xLastDigit == zLastDigit){
                condition = true;
            }else if(yLastDigit == zLastDigit){
                condition = true;
            }

        }


        return condition;


    }
}
