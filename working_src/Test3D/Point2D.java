package Test3D;

public class Point2D {
        private double x;
        private double y;
        private double size;

        public Point2D(double x, double y, double size){
                this.x = x;
                this.y = y;
                this.size = size;
        }

        public Point2D(Vector2D vector){
                this(vector.getX(), vector.getY(), 10);
        }

        public void drawPoint(Window window){
                window.drawPoint(this);
        }

        public double getX(){
                return x;
        }

        public double getY(){
                return y;
        }

        public double getSize(){
                return size;
        }

        public void printPoint(){
                System.out.print(" X: " + this.x + " Y: " + this.y);

        }
}
