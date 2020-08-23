package Test3D;

import java.awt.*;

public class Cube3D {

    private final Vector3D[] transformedVertices;

    private final Vector3D[] vertices = {
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
        transformedVertices = vertices.clone();
    }

    public void drawCube(Window window){
        window.setLineColor(Color.MAGENTA);
        for(int i = 0; i < faces.length; i++){
            for(int j = 0; j < faces[i].length - 1; j++){
                int x1 = (int) transformedVertices[faces[i][j]].getX();
                int x2 = (int) transformedVertices[faces[i][j + 1]].getX();
                int y1 = (int) transformedVertices[faces[i][j]].getY();
                int y2 = (int) transformedVertices[faces[i][j + 1]].getY();

                window.drawLine(x1, y1, x2, y2);
            }
        }
        drawVertices(window);
    }

    private void drawVertices(Window window){
        window.setPointColor(Color.cyan);
        for(Vector3D v: transformedVertices){
            window.setPointSize(10 + (int) getScale(v.getZ()));
            window.drawPoint(v);
        }
    }

    private double getScale(double z){
        double minZ = getMinZ();
        double maxZ = getMaxZ();
        return 50 * (z - minZ) / (maxZ - minZ);
    }

    private double getMinZ(){
        double minZ = transformedVertices[0].getZ();
        for(Vector3D v: transformedVertices){
            if(v.getZ() < minZ){
                minZ = v.getZ();
            }
        }
        return minZ;
    }

    private double getMaxZ(){
        double maxZ = transformedVertices[0].getZ();
        for(Vector3D v: transformedVertices){
            if(v.getZ() > maxZ){
                maxZ = v.getZ();
            }
        }
        return maxZ;
    }

    public void printVertices(Vector3D[] vertices){
       for(Vector3D v: vertices){ ;
           v.printVector();
       }
    }

    public Vector3D[] getVertices(){
        return vertices;
    }

    public Vector3D[] getTransformedVertices(){
        return transformedVertices;
    }
}
