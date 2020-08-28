package Test3D;


import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.*;

public class Program {

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
    static int cubeSize = 20;
    static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        window.setLineColor(Color.RED);
        window.clearScreen();
        Matrix3D pm = new Matrix3D();
        Cube3D cube = new Cube3D(cubeSize);
//        cube.drawCube(window);





        while (true){

            getKeys();

            for(int i = 0 ; i < cube.getVertices().length; i++){
//                cube.getVertices()[i] = matrix.transformVertex(cube.getVertices()[i]);
                cube.getVertices()[i] = Matrix3D.getProjectionVertex(cube.getVertices()[i], pm);
            }

            scanner.nextFloat();

            window.clearScreen();
            cube.drawCube(window);
//            cube = new Cube3D(cubeSize);

            window.pause(40);

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
            System.out.printf("Switching");
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

       if(window.getKeys()[KeyEvent.VK_RIGHT]){
           horizontalMovement += incrementMove;
       }

       if(window.getKeys()[KeyEvent.VK_D]){
           yDegrees -= incrementDegrees;
           aDegrees -= incrementDegrees;
       }

       if(window.getKeys()[KeyEvent.VK_A]){
           yDegrees += incrementDegrees;
           aDegrees += incrementDegrees;
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
