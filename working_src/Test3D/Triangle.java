package Test3D;

import java.awt.*;

public class Triangle {
        private final double[][] vertices;
        public Triangle(double[][] vertices){
            this.vertices = vertices.clone();
        }

        public void drawTriangle(Color color, Window window){
                window.setDrawColor(color);
        }

        public double[][] getVertices(){
                return vertices;
        }
}
