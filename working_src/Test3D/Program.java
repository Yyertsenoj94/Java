package Test3D;


import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.*;

public class Program {

    static final Scanner scanner = new Scanner(System.in);
    int pointsCounter = 0;
    public static void main(String[] args) {
        Matrix2D tMatrix= new Matrix2D();
        Matrix2D sMatrix = new Matrix2D();
        Matrix2D rMatrix = new Matrix2D();
        Matrix2D matrix = new Matrix2D();

        Window window = new Window(800, 500);
        window.clearScreen();

        double incrementScale = .02f;
        double incrementMove = 5.0f;
        double incrementDegrees = 1.0f;

        double degrees = 0.0f;
        double horizontalMovement = 0.0f;
        double verticalMovement = 0.0f;
        double scale = 1.0f;

        double[][] triangleVertices = {  {0.0f, 0.0f, 1.0f},
                {100.0f, 0.0f, 1.0f},
                {100.0f, 200.0f, 1.0f}};

        Triangle triangle = new Triangle(triangleVertices);
        window.drawTriangle(triangle);
        window.setDrawColor(Color.RED);
        while (true){

            if(window.getKeys()[KeyEvent.VK_W]){
                verticalMovement += incrementMove;
            }

            if(window.getKeys()[KeyEvent.VK_A]){
                horizontalMovement -= incrementMove;
            }

            if(window.getKeys()[KeyEvent.VK_S]){
                verticalMovement -= incrementMove;
            }

            if(window.getKeys()[KeyEvent.VK_D]){
                horizontalMovement += incrementMove;
            }

            if(window.getKeys()[KeyEvent.VK_LEFT]){
                degrees += incrementDegrees;
            }

            if(window.getKeys()[KeyEvent.VK_RIGHT]){
                degrees -= incrementDegrees;
            }

            if(window.getKeys()[KeyEvent.VK_ESCAPE]) {
                window.close();
            }

            if(window.getKeys()[KeyEvent.VK_UP]) {
                scale += incrementScale;
            }

            if(window.getKeys()[KeyEvent.VK_DOWN]){
                scale -= incrementScale;
            }


            tMatrix = tMatrix.setTranslationMatrix(horizontalMovement, verticalMovement);
            sMatrix = sMatrix.setScaleMatrix(scale, scale);
            rMatrix = rMatrix.setRotationMatrix(degrees);

            matrix = matrix.combine3Matrices(sMatrix, rMatrix, tMatrix);

            window.clearScreen();
            window.drawTriangle(triangle);

            triangle = new Triangle(triangleVertices);

            for(int i = 0; i < triangle.getVertices().length; i++)
            {
                triangle.getVertices()[i] = matrix.transformVertex(triangle.getVertices()[i]);
            }

            window.pause(50);

            rMatrix = new Matrix2D();
            tMatrix = new Matrix2D();
            matrix = new Matrix2D();
            sMatrix = new Matrix2D();
        }

        /*
            Window window = new Window(800, 500);
            window.clearScreen();

            R_Matrix2D rMatrix = new R_Matrix2D();
            T_Matrix2D tMatrix = new T_Matrix2D();
            S_Matrix2D sMatrix = new S_Matrix2D();


            float incrementScale = .02f;
            float incrementMove = 5.0f;
            float incrementDegrees = 1.0f;

            float degrees = 0.0f;
            float horizontalMovement = 0.0f;
            float verticalMovement = 0.0f;
            float scale = 1.0f;

            float[][] triangleVertices = {  {0.0f, 0.0f, 1.0f},
                                            {100.0f, 0.0f, 1.0f},
                                            {100.0f, 200.0f, 1.0f}};

            Triangle triangle = new Triangle(triangleVertices);
            window.drawTriangle(triangle);
            window.setDrawColor(Color.RED);
            while(true){

                    if(window.getKeys()[KeyEvent.VK_W]){
                        verticalMovement += incrementMove;
                    }

                    if(window.getKeys()[KeyEvent.VK_A]){
                        horizontalMovement -= incrementMove;
                    }

                    if(window.getKeys()[KeyEvent.VK_S]){
                        verticalMovement -= incrementMove;
                    }

                    if(window.getKeys()[KeyEvent.VK_D]){
                        horizontalMovement += incrementMove;
                    }


                    if(window.getKeys()[KeyEvent.VK_LEFT]){
                        degrees += incrementDegrees;
                    }

                    if(window.getKeys()[KeyEvent.VK_RIGHT]){
                        degrees -= incrementDegrees;
                    }

                    if(window.getKeys()[KeyEvent.VK_ESCAPE]) {
                        window.close();
                    }

                    if(window.getKeys()[KeyEvent.VK_UP]) {
                        scale += incrementScale;
                    }

                    if(window.getKeys()[KeyEvent.VK_DOWN]){
                        scale -= incrementScale;
                    }

                    for(int i = 0; i < triangle.getVertices().length; i++)
                    {
                        triangle.getVertices()[i] = sMatrix.scaleVertex(triangle.getVertices()[i], scale, scale);
                        triangle.getVertices()[i] = rMatrix.rotateVertex(triangle.getVertices()[i], degrees);
                        triangle.getVertices()[i] = tMatrix.translateVertex(triangle.getVertices()[i], horizontalMovement, verticalMovement);
                    }
                window.clearScreen();
                window.drawTriangle(triangle);
                triangle = new Triangle(triangleVertices);

                System.out.println("Triangle vertex 1: " + triangle.getVertices()[0][0] + ", " + triangle.getVertices()[0][1]);
                System.out.println("Triangle vertex 2: " + triangle.getVertices()[1][0] + ", " + triangle.getVertices()[1][1]);
                System.out.println("Triangle vertex 3: " + triangle.getVertices()[2][0] + ", " + triangle.getVertices()[2][1]);
                window.pause(50);
            }


*/

    /*
        Window window = new Window(800, 800);
        window.setPointSize(200);
        float[] point = {20, 20, 1};

        window.setBackgroundColor(Color.BLACK);
        window.setDrawColor(Color.GREEN);
        window.clearScreen();
        window.drawPoint2D(point);

        T_Matrix2D tMatrix = new T_Matrix2D();
        System.out.println("Ready?");
        scanner.nextFloat();

        tMatrix.setTranslation(100, 100);
        point = tMatrix.translateVertex(point);
        window.clearScreen();
        window.drawPoint2D(point);
*/

/*
        float[][] outerPoints = new float[1440][3];
        float[][] innerPoints = new float[1440][3];
        float[][] triangleVertices = {{0, 0, 1},
                {200, 0, 1},
                {100, 400, 1}};

        int start;
        double degrees = .5;
        Window window = new Window(1800, 1200);
        window.setDrawColor(Color.RED);
        window.clearScreen();

        R_Matrix2D rMatrix = new R_Matrix2D();

        S_Matrix2D sMatrix = new S_Matrix2D();

        rMatrix.setTranslation((float) degrees);

        float scaleAmount = .998f;

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
            window.setDrawColor(Color.WHITE);
            window.drawTriangle(triangle);

            outerPoints[value1] = triangle.getVertices()[2];

            innerPoints[value1] = triangle.getVertices()[1];

            if(value1 < 360) {
                window.setDrawColor(Color.RED);
            }else if(value1 < 720) {
                window.setDrawColor(Color.BLUE);
            }else if(value1 < 1080){
                window.setDrawColor(Color.GREEN);
            }else{
                window.setDrawColor(Color.cyan);
            }

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
