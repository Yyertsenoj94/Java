package Test3D;

import java.awt.*;

public class Cube3D {
    //public ArrayList<Vector3D> vertices = new ArrayList<>();
    private Vector3D[] vertices = {
            new Vector3D(1, 1,1),
            new Vector3D(-1, 1, 1),
            new Vector3D(-1, -1, 1),
            new Vector3D(1, -1, 1),
            new Vector3D( -1, 1, -1),
            new Vector3D(1, 1, -1),
            new Vector3D(1, -1, -1),
            new Vector3D(-1, -1, -1)
    };

    private int[][] faces = { //defines the order of the edges that need to be connected
            {0, 1, 2 ,3},
            {5, 0, 3, 6},
            {4, 5, 6, 7},
            {1, 4, 7, 2},
            {5, 4, 1, 0},
            {3, 2, 7, 6}
    };

    public Cube3D(int size){
        for(Vector3D v: vertices){
           v.setX(v.getX() * size);
           v.setY(v.getY() * size);
           v.setZ(v.getZ() * size);
        }

    }

    public void drawCube(Window window){
        Graphics g = window.getGraphics();
        int i = 0;
        int j = 0;
        g.setColor(Color.MAGENTA);
        for(i = 0; i < faces.length; i++){

            for(j = 0; j < faces[i].length - 1; j++){
                /*
                    Draw to the consecutive vertex point
                 */

                int x1 = window.getCenterX() + (int) vertices[faces[i][j]].getX();
                int x2 = window.getCenterX() + (int) vertices[faces[i][j + 1]].getX();
                int y1 = window.getCenterY() + (int) vertices[faces[i][j]].getY();
                int y2 = window.getCenterY() + (int) vertices[faces[i][j + 1]].getY();
                /*
                int x1 = window.getCenterX() + (int) vertices[faces[i][j]].getX();
                int x2 = window.getCenterX() + (int) vertices[faces[i][j + 1]].getX();
                int y1 = window.getCenterY() + (int) vertices[faces[i][j]].getY();
                int y2 = window.getCenterY() + (int) vertices[faces[i][j + 1]].getY();
                */
                g.drawLine(x1, y1, x2, y2);

            }

        }

    }

    public Vector3D[] getVertices(){
        return vertices;
    }
}
