package Test3D;

import java.util.Vector;

public class Triangle {

        private double minX;
        private double minY;
        private double maxX;
        private double maxY;

        private final Vector2D[] vertices = {
                new Vector2D(-1.0f, 0.0f),
                new Vector2D(.5f, 0.0f),
                new Vector2D(0.0f, .5f)
        };

        public Triangle(double size){
                for(int i = 0; i < vertices.length; i++){
                        vertices[i].setX(vertices[i].getX() * size);
                        vertices[i].setY(vertices[i].getY() * size);
                }
        }

        public Vector2D getRotationPoint(){
                setMinMax();
                double x;
                double y;
                x = getMiddleX();
                y = getMiddleY();
                return new Vector2D(x, y);
        }

        public void drawTriangle(Window window){
                int i;
                for(i = 0; i < vertices.length - 1; i++){
                       window.drawLine(vertices[i].getX(), vertices[i].getY(), vertices[i+1].getX(), vertices[i+1].getY());
                }
                window.drawLine(vertices[i].getX(), vertices[i].getY(), vertices[0].getX(), vertices[0].getY());
        }

        private void setMinMax(){
                double minX = vertices[0].getX();
                double maxX = vertices[0].getX();
                double minY = vertices[0].getY();
                double maxY = vertices[0].getY();

                for(Vector2D v: vertices) {
                        if (v.getX() < minX)
                            minX = v.getX();

                        if (v.getX() > maxX)
                                maxX = v.getX();

                        if (v.getY() < minY)
                                minY = v.getY();

                        if (v.getY() > maxY)
                                maxY = v.getY();
                }
                this.minX = minX;
                this.minY = minY;
                this.maxX = maxX;
                this.maxY = maxY;
        }

        private double getMiddleY(){
                return (maxY + minY) / 2;
        }

        private double getMiddleX(){
                return (maxX + minX) / 2;
        }

        public void printVertices(){
                for(int i = 0 ; i < vertices.length; i++){
                       vertices[i].printVector();
                }
        }

        public Vector2D[] getVertices(){
                return vertices;
        }
}
