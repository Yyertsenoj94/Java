package Test3D;

public class Polygon2D {
        private Vector2D[] points;
        private LineSegment[] lines;

    public Polygon2D(){

        this.points = new Vector2D[]{ //default is a square.
               new Vector2D(-1.0f, 1.0f),
               new Vector2D(1.0f, 1.0f),
               new Vector2D(1.0f, -0.0f),
               new Vector2D(-1.0f, -1.0f),
        };

    }

    public Polygon2D(Vector2D[] points){
        this.points = points;
        initLineSegments();
    }


    public Polygon2D(double[] xPoints, double[] yPoints){
               points = new Vector2D[xPoints.length];
              for(int i = 0; i < points.length; i++){
                  points[i] = new Vector2D(xPoints[i], yPoints[i]);
              }
              initLineSegments();
    }

    private void initLineSegments(){
        lines = new LineSegment[points.length];
        int lineCount = 0;
        int i;
        for(i = 0; i < points.length-1; i++){
            lines[lineCount] = new LineSegment(points[i], points[i+1]);
            lineCount++;
        }
        lines[lineCount] = new LineSegment(points[i], points[0]);
    }

    public void scalePolygon(double scale){
            for(Vector2D v: points){
                v.setX(v.getX() * scale);
                v.setY(v.getY() * scale);
            }
            initLineSegments(); //REFRESH THE LINE SEGMENTS TO REFLECT NEW POINTS
    }

    public Vector2D[] getPoints(){
            return points;
    }

    public LineSegment[] getLines(){
            return lines;
    }

}
