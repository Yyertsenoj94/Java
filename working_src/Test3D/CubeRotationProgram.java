package Test3D;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Scanner;

public class CubeRotationProgram {
    static double incrementScale = .002f;
    static double incrementMove = 2.0f;
    static double incrementDegrees = 2.25f;

    static Window window = new Window(1000, 1000);

    static double zDegrees = 0.0f;
    static double xDegrees = 0.0f;
    static double yDegrees = 0.0f;
    static double aDegrees = 0.0f;
    static double horizontalMovement = 0.0f;
    static double maxV = 300;
    static double maxH = 700;
    static boolean hDirection = true;
    static boolean vDirection = false;
    static boolean scaleDirection = false;
    static double verticalMovement = 0.0f;
    static double scale = 1.0f;
    static double maxScale = 1.05;
    static double minScale = .50;
    static int counter = 0;
    static int cubeSize = 100;
    static final Scanner scanner = new Scanner(System.in);
    int pointsCounter = 0;

    public static void main(String[] args) {
        window.setLineColor(Color.WHITE);
        window.setViewPort(1000, 1000);
        Functions.bindWindow(window);

        window.clearScreen();
        window.setPointSize(50);
        window.drawXAxis();
        window.drawYAxis();

        Matrix3D pm;
        Matrix3D tMatrix;
        Matrix3D sMatrix;
        Matrix3D rzMatrix;
        Matrix3D rxMatrix;
        Matrix3D ryMatrix;
        Matrix3D raMatrix;
        Matrix3D rMatrix;
        Matrix3D matrix;

        Vector3D cameraOrigin = new Vector3D(10, 10, 20);

        Matrix3D cMatrix = Functions.getCameraMatrix(cameraOrigin);

        window.clearScreen();

        Cube3D cube = new Cube3D(cubeSize);

        double[] p1 = {100, 100, -50};
        double[] p2 = {-200, 200, -300};
        Functions.drawCube(cube);

        while (true){
            getKeys();
            tMatrix = Functions.getTranslationMatrix(horizontalMovement, verticalMovement, 1);
            sMatrix = Functions.getScaleMatrix(scale, scale, scale);

            rzMatrix = Functions.getRotationByAngle(Matrix.AXIS.Z_AXIS, zDegrees);
            rxMatrix = Functions.getRotationByAngle(Matrix.AXIS.X_AXIS, xDegrees);
            ryMatrix = Functions.getRotationByAngle(Matrix.AXIS.Y_AXIS, yDegrees);
            rMatrix = Functions.combine3Matrices(rzMatrix, rxMatrix, ryMatrix);

            //raMatrix = Functions.getArbitraryRotationMatrix(p1, p2, aDegrees);
          //  rMatrix = Functions.combine2Matrices(rMatrix, raMatrix);
            matrix = Functions.combine3Matrices(sMatrix, rMatrix, tMatrix);
            matrix = Functions.combine2Matrices(matrix, cMatrix);
            pm = Functions.getPerspectiveMatrix(-600); //put this at positive since we're supposed to be using a left hand system?
            /*
                   Project each vertex from 3d space to 2d Space
             */
            for(int i = 0 ; i < cube.getVertices().length; i++){
                cube.getTransformedVertices()[i] = Functions.transformVertex(cube.getVertices()[i], matrix);
                cube.getTransformedVertices()[i] = Functions.getProjectionVertex(cube.getTransformedVertices()[i], pm);
            }

            window.clearScreen(); //refresh screen
            Functions.drawCube(cube);
            window.pause(40);

            //Reset matrices to identity
            /*
            rzMatrix.setToIdentity();
            rxMatrix.setToIdentity();
            ryMatrix.setToIdentity();
            rMatrix.setToIdentity();
            raMatrix.setToIdentity();
            tMatrix.setToIdentity();
            matrix.setToIdentity();
            sMatrix.setToIdentity();
             */
        }
    }
    public static void randMove(){

        if(scaleDirection){
            scale += incrementScale;
        }else{
            scale -= incrementScale;
        }
        if(scale >= maxScale || scale <= minScale) {
            scaleDirection = !scaleDirection;
        }


        if(hDirection){
            horizontalMovement += incrementMove;
        }else{
            horizontalMovement -= incrementMove;
        }

        if(vDirection){
            verticalMovement += incrementMove;
        }else{
            verticalMovement -= incrementMove;
        }

        if(Math.abs(verticalMovement) >= maxV){
            vDirection = !vDirection;
        }
        if(Math.abs(horizontalMovement) >= maxH){
            hDirection = !hDirection;
        }

        xDegrees += incrementDegrees;
        yDegrees += incrementDegrees;
        zDegrees += incrementDegrees;
        aDegrees += incrementDegrees;

        if(xDegrees >= 360){
            xDegrees = 0;
        }
        if(yDegrees >= 360){
            yDegrees = 0;
        }
        if(zDegrees >= 360){
            zDegrees = 0;
        }
        if(aDegrees >= 360){
            aDegrees = 0;
        }


    }
    public static void getKeys(){

        if(window.getKeys()[KeyEvent.VK_UP]){
            verticalMovement += incrementMove;
        }

        if(window.getKeys()[KeyEvent.VK_LEFT]){
            horizontalMovement -= incrementMove;
        }

        if(window.getKeys()[KeyEvent.VK_DOWN]){
            verticalMovement -= incrementMove;
        }

        if(window.getKeys()[KeyEvent.VK_N]){
            aDegrees += incrementDegrees;
        }

        if(window.getKeys()[KeyEvent.VK_B]){
            aDegrees -= incrementDegrees;
        }

        if(window.getKeys()[KeyEvent.VK_RIGHT]){
            horizontalMovement += incrementMove;
        }

        if(window.getKeys()[KeyEvent.VK_D]){
            yDegrees += incrementDegrees;
        }

        if(window.getKeys()[KeyEvent.VK_A]){
            yDegrees -= incrementDegrees;
        }

        if(window.getKeys()[KeyEvent.VK_S]){
            xDegrees += incrementDegrees;
        }

        if(window.getKeys()[KeyEvent.VK_W]){
            xDegrees -= incrementDegrees;
        }

        if(window.getKeys()[KeyEvent.VK_Q]){
            zDegrees += incrementDegrees;
        }

        if(window.getKeys()[KeyEvent.VK_E]){
            zDegrees -= incrementDegrees;
        }

        if(window.getKeys()[KeyEvent.VK_ESCAPE]) {
            window.close();
        }

        if(window.getKeys()[KeyEvent.VK_U]) {
            scale += incrementScale;
        }

        if(window.getKeys()[KeyEvent.VK_I]){
            scale -= incrementScale;
        }
    }

}

