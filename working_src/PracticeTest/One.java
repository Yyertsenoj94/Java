package PracticeTest;

public class One {
    public static void main(String[] args) {
        int suez = 10;
        int cairo = 15;
        int luxor = 20;
        int tanta = 25;

        System.out.println("Cities of Egypt");
        System.out.println(getX(suez, tanta));
        System.out.println(getX(getX(tanta, suez), suez));
        System.out.println(getX(getX(suez, luxor), cairo));
        System.out.println(getX(luxor+suez, tanta+cairo));
        System.out.println(getX(cairo, getX(tanta, suez)));
    }

    public static int getX(int value1, int value2){
        value2 = value2 - 10;
        if(value2 > value1){
            return value2;
        }
        return value1;
    }

}


