package Test3D;

public class LineSegment {
    private Point2D p1;
    private Point2D p2;
    private int x1;
    private int x2;
    private int y1;
    private int y2;

    public LineSegment(int x1, int y1, int x2, int y2){
       this.x1 = x1;
       this.x2 = x2;
       this.y1 = y1;
       this.y2 = y2;
    }

    public LineSegment(double x1, double y1, double x2, double y2){
        this((int) x1, (int) y1, (int) x2, (int) y2);
    }

    public LineSegment(Vector2D v1, Vector2D v2){
        this(v1.getX(), v1.getY(), v2.getX(), v2.getY());
    }

    public int getX1() {
        return x1;
    }

    public int getX2() {
        return x2;
    }

    public int getY1() {
        return y1;
    }

    public int getY2() {
        return y2;
    }

    public void printSegment(){
        System.out.println("X1: " + x1);
        System.out.println("Y1: " + y1);
        System.out.println("X2: " + x2);
        System.out.println("Y1: " + y2);
    }
}
