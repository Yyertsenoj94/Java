package Test3D;

import java.awt.*;
import java.util.*;

public class Program {

    static final Scanner scanner = new Scanner(System.in);
    int pointsCounter = 0;
    public static void main(String[] args) {
        float[][] outerPoints = new float[1440][3];
        float[][] innerPoints = new float[1440][3];
        float[][] triangleVertices = {{0, 0, 1},
                {600, 0, 1},
                {100, 500, 1}};


        int start;
        double degrees = 1;
        Window window = new Window(1800, 1200);
        window.setDrawColor(Color.GREEN);
        window.clearScreen();
        R_Matrix2D rMatrix = new R_Matrix2D();
        S_Matrix2D sMatrix = new S_Matrix2D();
        rMatrix.setTranslation((float) degrees);
        float scaleAmount = .995f;

        float[] vertexTest = {300, 400};
        window.setPointSize(30);

        //window.drawPoint2D(vertexTest);

        Triangle triangle = new Triangle(triangleVertices);

        window.drawTriangle(triangle);

        System.out.println("Ready to translate?");;

        start = scanner.nextInt();

        window.setPointSize(2);

        int value1 = 0, value2 = 1440;
        sMatrix.setScale(scaleAmount, scaleAmount);
        while(value1 < value2) {
            for (int i = 0; i < triangle.getVertices().length; i++) {

                triangle.getVertices()[i] = rMatrix.rotateVertex(triangle.getVertices()[i]);
                triangle.getVertices()[i] = sMatrix.scaleVertex(triangle.getVertices()[i]);

                System.out.print("x1: " + triangle.getVertices()[1][0] + "\t");
                System.out.print("y1: " + triangle.getVertices()[1][1] + "\t");

                System.out.print("x2: " + triangle.getVertices()[2][0] + "\t");
                System.out.println("y2: " + triangle.getVertices()[2][0]);

            }

            window.clearScreen();

            window.drawTriangle(triangle);

            outerPoints[value1] = triangle.getVertices()[2];

            innerPoints[value1] = triangle.getVertices()[1];

            for(float[] p: innerPoints){
                window.drawPoint2D(p);
            }
            for(float[] p: outerPoints){
                window.drawPoint2D(p);
            }

            window.pause(3);
            value1++;
        }
        /*
        while(value1 < value2){

            if(direction){
                sMatrix.setScale(scaleAmount, scaleAmount);
            }else{
                sMatrix.setScale(deScaleAmount, deScaleAmount);
            }

            if (Math.abs(vertexTest[0]) >= 400 || Math.abs(vertexTest[0]) <= 100) {
                direction = !direction;
            }

            vertexTest = rMatrix.rotateVertex(vertexTest);
            vertexTest = sMatrix.scaleVertex(vertexTest);
            window.clearScreen();
            window.drawPoint2D(vertexTest);
            window.pause(1);
            value1 += degrees;
        }
        */

/*
        float[][] triangleVertices = {{0, 0, 1},
                {200, 0, 1},
                {200, 400, 1}};
        float transX;
        float transY;
        Triangle triangle = new Triangle(triangleVertices);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello\n");
        T_Matrix2D t_Matrix = new T_Matrix2D();
        window.drawTriangle(triangle);
        System.out.println("Please input the amount you wish to translate x by: ");
        transX = scanner.nextFloat();
        System.out.println("Please input the amount you wish to translate y by: ");
        transY = scanner.nextFloat();
        t_Matrix.setTranslation(transX, transY);
        for(int i = 0; i < 3; i++){
            triangle.getVertices()[i] = t_Matrix.translateVertex(triangle.getVertices()[i]);
        }
        window.clearScreen();
        window.drawTriangle(triangle);
    }
    */
    }
}
