package ImportantPractice;
public class Main_Point {

    public static void main(String [] args){

        Point initialPoint = new Point(8, 4);

        initialPoint.getX();

        initialPoint.getY();

        System.out.println("The distance between initial point: (" + initialPoint.getX() + ", " + initialPoint.getY() + ") and (0,0) is: " + initialPoint.distance());


        System.out.println("The distance between initial point: (" + initialPoint.getX() + ", " + initialPoint.getY() + ") and (" + 4 + ", " + 1 + ") is " + initialPoint.distance(4, 1));

        Point newPoint = new Point(4, 1);

        System.out.println("The distance between initial point: (" + initialPoint.getX() + ", " + initialPoint.getY() + ") and (" + newPoint.getX() + ", " + newPoint.getY() + ") is " + initialPoint.distance(newPoint));

        Point defaultPoint = new Point();

        System.out.println("The distance between initial point: (" + initialPoint.getX() + ", " + initialPoint.getY() + ") and (" + defaultPoint.getX() + ", " + defaultPoint.getY() + ") is " + initialPoint.distance(defaultPoint));
    }

}
