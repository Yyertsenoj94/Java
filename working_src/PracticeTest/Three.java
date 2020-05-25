package PracticeTest;

public class Three {

    public static void main(String[] args) {

        System.out.println("Paris");
        methodA();
        methodB();
        methodC();
        methodD();

    }

    public static void methodA(){
        methodB();
        System.out.println("Bordeaux");
    }

    public static void methodB(){
        System.out.println("Rouen");
        methodD();
    }

    public static void methodC(){
        methodA();
        System.out.println("Toulouse");
    }

    public static void methodD(){
        System.out.println("Nice");
    }

}
