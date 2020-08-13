package Test3D;

import java.awt.*;

public class Triangle {
        private final float[][] vertices;
        public Triangle(float[][] vertices){
            this.vertices = vertices;
        }

        public void drawTriangle(Color color, Window window){
                window.setDrawColor(color);
        }

        public float[][] getVertices(){
                return vertices;
        }
}
