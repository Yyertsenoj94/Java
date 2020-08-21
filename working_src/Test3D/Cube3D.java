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

    public Cube3D(){
        for(Vector3D v: vertices){
           v.setX(v.getX() * 75);
           v.setY(v.getY() * 75);
           v.setZ(v.getZ() * 75);
        }

    }

    public void drawCube(Window window){
        Graphics g = window.getGraphics();
        int i = 0;
        int j = 0;

        for(i = 0; i < faces.length; i++){

            if(i == 0){
               g.setColor(Color.RED);
            }else if(i == 2){
                g.setColor(Color.BLUE);
            }else{
                g.setColor(Color.GRAY);
            }

            for(j = 0; j < faces[i].length - 1; j++){
                /*
                    Draw to the consecutive vertex point
                 */

                int x1 = window.getCenterX() + (int) vertices[faces[i][j]].getX();
                int x2 = window.getCenterX() + (int) vertices[faces[i][j + 1]].getX();
                int y1 = window.getCenterY() + (int) vertices[faces[i][j]].getY();
                int y2 = window.getCenterY() + (int) vertices[faces[i][j + 1]].getY();
                System.out.println("Connecting " + faces[i][j] + " to " + faces[i][j+1]);
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
