package Playground;
public class udemyPracticals_switchStatements {

    public static void main(String[] args) {

        int switchValue = 3;

        switch (switchValue) {

            case 1:
                System.out.println("Switch value was " + 1);
                break;
            case 2:
                System.out.println("Switch value was " + 2);
                break;
            case 3:
                System.out.println("Switch value was " + 3);
                break;
            case 4:
                System.out.println("Switch value was " + 4);
                break;
            default:
                System.out.println("Switch value was not 1 - 4");
                break;
        }
    }
}
