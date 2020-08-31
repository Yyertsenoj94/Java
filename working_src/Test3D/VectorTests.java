package Test3D;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class VectorTests {
    //Variables for movement
    static final double incrementScale = .002f;
    static final double incrementMove = 2.0f;
    static final double incrementDegrees = 2.25f;

    //Matrix translation state variables
    static double zDegrees = 0.0f;
    static double xDegrees = 0.0f;
    static double yDegrees = 0.0f;
    static double aDegrees = 0.0f;
    static double horizontalMovement = 0.0f;
    static double verticalMovement = 0.0f;
    static double scale = 0.0f;


    static Matrix3D pm;
    static Matrix3D tMatrix = new Matrix3D();
    static Matrix3D sMatrix = new Matrix3D();
    static Matrix3D rzMatrix = new Matrix3D();
    static Matrix3D rxMatrix = new Matrix3D();
    static Matrix3D ryMatrix = new Matrix3D();
    static Matrix3D rMatrix = new Matrix3D();
    static Matrix3D matrix = new Matrix3D();

    static Window window = new Window(600,600);

    static final Vector3D[] vectors = new Vector3D[5];
    static final ArrayList<Matrix3D> matrices = new ArrayList<>();

    public static void main(String[] args) {
        window.setViewPort(600, 600);
        window.setLineColor(Color.magenta);
        window.clearScreen();
        Functions.bindWindow(window);

        double[] originArray = {0, 0, 1};
        //double[] nArray = {-200, 200, 0};
        double[] xArray = {200, 0, 1};
        double[] yArray = {0, 200, 0};
        double[] zArray = {0, 0, -500};

        Matrix3D p_matrix = Functions.getPerspectiveMatrix(-1200);


        Vector3D origin = new Vector3D(originArray);

        Vector3D x = new Vector3D(xArray);

        Vector3D y = new Vector3D(yArray);

        Vector3D z = new Vector3D(zArray);

        Vector3D cpVector = Functions.getCrossProductVector(z, y);

        matrices.add(p_matrix);
        matrices.add(sMatrix);
        matrices.add(tMatrix);
        matrices.add(rxMatrix);
        matrices.add(ryMatrix);
        matrices.add(rzMatrix);
        matrices.add(rMatrix);
        matrices.add(matrix);

        while(true) {
            getKeys();

            vectors[0] = origin;
            vectors[1] = x;
            vectors[2] = y;
            vectors[3] = z;
            vectors[4] = cpVector;

            tMatrix = Functions.getTranslationMatrix(horizontalMovement, verticalMovement, 1);
            rzMatrix = Functions.getRotationByAngle(Matrix.AXIS.Z_AXIS, zDegrees);
            rxMatrix = Functions.getRotationByAngle(Matrix.AXIS.X_AXIS, xDegrees);
            ryMatrix = Functions.getRotationByAngle(Matrix.AXIS.Y_AXIS, yDegrees);
            rMatrix = Functions.combine3Matrices(rzMatrix, rxMatrix, ryMatrix);
            matrix = Functions.combine3Matrices(sMatrix, rMatrix, tMatrix);
            p_matrix = Functions.getPerspectiveMatrix(800);

            for(int i = 0; i < vectors.length; i++){
                vectors[i] = Functions.transformVertex(vectors[i], matrix);
                vectors[i] = Functions.getProjectionVertex(vectors[i], p_matrix);

                if(i == 1){
                    window.setLineColor(Color.GREEN); //x axis
                }else if(i == 2) {
                    window.setLineColor(Color.BLUE); //y axis
                }else if(i == 3){
                    if(vectors[i].getZ() >= 0){
                        window.setLineColor(Color.MAGENTA);
                    }else{
                        window.setLineColor(Color.CYAN);
                    }
                }else if(i == 4){
                    window.setLineColor(Color.YELLOW);
                }

                Functions.drawVector(vectors[0], vectors[i]);
                window.setLineColor(Color.WHITE);
            }

            vectors[4].printVector();
            Functions.drawScaledVertices(vectors);

            tMatrix.setToIdentity();
            sMatrix.setToIdentity();
            rMatrix.setToIdentity();
            rzMatrix.setToIdentity();
            ryMatrix.setToIdentity();
            rxMatrix.setToIdentity();
            matrix.setToIdentity();


            window.pause(10);
            window.clearScreen();
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
