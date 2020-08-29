package Test3D;


import java.util.Scanner;

public class Matrix3D extends Matrix {
       Window window;

       public Matrix3D(){
              super();
              super.set3DMatrix();
       }

       public Matrix3D(double[][] matrix){
              this();
              super.matrix = matrix;
       }

       @Override
       void setToIdentity() {
           super.set3DMatrix();
       }

}
