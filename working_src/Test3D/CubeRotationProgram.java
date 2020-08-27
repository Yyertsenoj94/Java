package Test3D;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Scanner;

public class CubeRotationProgram {
    static double incrementScale = .002f;
    static double incrementMove = 2.0f;
    static double incrementDegrees = 1.75f;

    static Window window = new Window(1800, 1200);
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
        Matrix3D pm = new Matrix3D();

        window.clearScreen();
        window.setPointSize(50);
        window.drawXAxis();
        window.drawYAxis();

        pm = pm.getPerspectiveMatrix(-800);

        Matrix3D tMatrix= new Matrix3D();
        Matrix3D sMatrix = new Matrix3D();

        Matrix3D rzMatrix = new Matrix3D();
        Matrix3D rxMatrix = new Matrix3D();
        Matrix3D ryMatrix = new Matrix3D();
        Matrix3D raMatrix = new Matrix3D(); //arbitrary axis

        Matrix3D rMatrix = new Matrix3D();
        Matrix3D matrix = new Matrix3D();

        raMatrix.setWindow(window);

        window.clearScreen();

        Cube3D cube = new Cube3D(cubeSize);

        //double[] p1 ={cube.getVertices()[4].getX(), cube.getVertices()[4].getY(), cube.getVertices()[4].getZ(), cube.getVertices()[4].getW()};
        //double[] p2 = {cube.getVertices()[7].getX(), cube.getVertices()[7].getY(), cube.getVertices()[7].getZ(), cube.getVertices()[7].getW()};

        double[] p1 = {0, -200, 300};
        double[] p2 = {0, 200, 300};

        cube.drawCube(window);
        while (true){

            getKeys();

            tMatrix = tMatrix.getTranslationMatrix(horizontalMovement, verticalMovement, 1);
            sMatrix = sMatrix.getScaleMatrix(scale, scale, scale);
            rzMatrix = rzMatrix.getRotationByAngle(Matrix.AXIS.Z_AXIS, zDegrees);
            rxMatrix = rxMatrix.getRotationByAngle(Matrix.AXIS.X_AXIS, xDegrees);
            ryMatrix = ryMatrix.getRotationByAngle(Matrix.AXIS.Y_AXIS, yDegrees);
            rMatrix = rMatrix.combine3Matrices(rzMatrix, rxMatrix, ryMatrix);
            raMatrix = raMatrix.getArbitraryRotationMatrix(p1, p2, aDegrees);
            rMatrix = rMatrix.combine2Matrices(rMatrix, raMatrix);

            matrix = matrix.combine3Matrices(sMatrix, rMatrix, tMatrix);
            /*
                   Project each vertex from 3d space to 2d Space
             */

            for(int i = 0 ; i < cube.getVertices().length; i++){
                cube.getTransformedVertices()[i] = matrix.transformVertex(cube.getVertices()[i]);
                cube.getTransformedVertices()[i] = Matrix3D.getProjectionVertex(cube.getTransformedVertices()[i], pm);
            }

            window.clearScreen();

            cube.drawCube(window);

            window.pause(40);

            rzMatrix.setToIdentity();
            rxMatrix.setToIdentity();
            ryMatrix.setToIdentity();
            rMatrix.setToIdentity();
            raMatrix.setToIdentity();
            tMatrix.setToIdentity();
            matrix.setToIdentity();
            sMatrix.setToIdentity();

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
            verticalMovement -= incrementMove;
        }

        if(window.getKeys()[KeyEvent.VK_LEFT]){
            horizontalMovement -= incrementMove;
        }

        if(window.getKeys()[KeyEvent.VK_DOWN]){
            verticalMovement += incrementMove;
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

