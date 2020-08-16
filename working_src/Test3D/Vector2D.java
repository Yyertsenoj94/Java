package Test3D;

public class Vector2D {

    private final float[] vector;

    public Vector2D(float x, float y){
       vector = new float[3];
       vector[0] = x;
       vector[1] = y;
       vector[2] = 1; //need this 3rd point.
    }

    public void scaleVector(float scalar){
        this.vector[0] *= scalar;
        this.vector[1] *= scalar;
    }

    public void addToVector(Vector2D vector){
        setX(this.getX() + vector.getX());
        setY(this.getX() + vector.getY());
    }

    public void subtractVector(Vector2D vector){
        setX(this.getX() - vector.getX());
        setY(this.getY() - vector.getY());
    }

    public Vector2D getVectorFromPoints(float[] p1, float[] p2){
        //A vector is just the tail point - head point
        return new Vector2D(p2[0] - p1[0], p2[1] - p1[1]);
    }


    public float getX(){
        return this.vector[0];
    }

    public float getY(){
        return this.vector[1];
    }

    public void setX(float x){
        this.vector[0] = x;
    }

    public void setY(float y){
        this.vector[1] = y;
    }
}
