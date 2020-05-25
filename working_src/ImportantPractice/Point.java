package ImportantPractice;
public class Point {

    private int x;

    private int y;


    public Point(){

        this(2, 3);

    }

    public Point(int x, int y){

        this.x = x;
        this.y = y;

    }

    public int getX(){

        return x;

    }

    public void setX(int x){

        this.x = x;

    }


    public int getY()
    {
        return y;

    }

    public void setY(int y)
    {
        this.y = y;

    }

    //method to square an integer.
    public double squared(int z)
    {
        return z * z;

    }


    //-----------------MAIN CONSTRUCTOR -------------------------------------------------
    public double distance(int x, int y){

        double distance = Math.sqrt((squared(this.x - x) + (squared(this.y - y))));

        return distance;

    }

    //----------------DEFAULT CONSTRUCTOR------------------------------------------------
//default method for distance: returning the distance between (x, y) and (0,0) - calling the original distance constructor.
    public double distance (){

       return distance(0,0);
    }

    //CONSTRUCTOR THAT PASSES A POINT P OBJECT.
    //calls the original constructor to pass point P x and y values.
    //multiple point methods are used in this (need getters for the x and y values of the new passed point.
    public double distance(Point p){

        double thisDistance = distance(p.getX(), p.getY());

        return thisDistance;

    }



}


