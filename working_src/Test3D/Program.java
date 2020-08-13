package Test3D;

import Sudoku.Matrix;

import java.awt.*;
import java.util.*;

public class Program {

    public static void main(String[] args){
        float[][] triangleVertices = {  {0, 0, 1},
                                        {200, 0, 1},
                                        {200, 400, 1}};

        float transX;
        float transY;

        Triangle triangle = new Triangle(triangleVertices);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Hello\n");
        T_Matrix2D t_Matrix = new T_Matrix2D();

        Window window = new Window(1000, 1000);
        window.setDrawColor(Color.white);
        window.clearScreen();

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

}
