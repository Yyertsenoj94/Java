package Test3D;

public class Vector2D {

    private double x;
    private double y;
    private double z;

    public Vector2D(double x, double y, double z){
       this.x = x;
       this.y = y;
       this.z = z; //need this 3rd point.
    }

    public Vector2D(double x, double y){
        this(x, y, 1);
    }

    public void scaleVector(float scalar){
        this.x *= scalar;
        this.y *= scalar;
    }

    public void addToVector(Vector2D vector){
        setX(this.x + vector.getX());
        setY(this.y + vector.getY());
    }

    public void subtractVector(Vector2D vector){
        setX(this.x - vector.getX());
        setY(this.y - vector.getY());
    }

    public Vector2D getVectorFromPoints(double[] p1, double[] p2){
        //A vector is just the tail point - head point
        return new Vector2D(p2[0] - p1[0], p2[1] - p1[1]);
    }

    public double[] getArrayFromVector(){
        double[] array = {this.x, this.y, 1};
        return array;
    }

    public double getX(){
        return this.x;
    }

    public double getY(){
        return this.y;
    }

    public void setX(double x){
        this.x = x;
    }

    public void setY(double y){
        this.y = y;
    }

    public void printVector(){
        System.out.print("X: " + this.x + " Y: " + this.y);
    }
}
