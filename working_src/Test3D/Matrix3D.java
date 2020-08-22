package Test3D;


import java.util.Scanner;

public class Matrix3D extends Matrix {
       Scanner scanner = new Scanner((System.in));
       public Matrix3D(){
              super();
              super.set3DMatrix();
       }

       public Matrix3D(double[][] matrix){
              this();
              super.matrix = matrix;
       }

       public Matrix3D combine3Matrices(Matrix matrix1, Matrix matrix2, Matrix matrix3){
              Matrix3D combined = new Matrix3D();

              combined = combine2Matrices(matrix1, matrix2);
              combined = combine2Matrices(combined, matrix3);

              return combined;
       }

       public Matrix3D combine2Matrices(Matrix matrix1, Matrix matrix2){
              double[][] composedArray = new double[matrix1.getRows()][matrix1.getColumns()];

              for(int i = 0; i < matrix1.getColumns(); i++) {
                     for (int j = 0; j < matrix1.getRows(); j++) {
                            for (int k = 0; k < matrix1.getColumns(); k++) {
                                   composedArray[i][j] += matrix1.getMatrix()[i][k] * matrix2.getMatrix()[k][j];
                            }
                     }
              }
              return new Matrix3D(composedArray);
       }

       public Vector3D transformVertex(Vector3D vertex) {
              Vector3D vOld= vertex;
              Vector3D vNew = Vector3D.getBlankVector();

              for (int i = 0; i < vOld.getArray().length; i++) {
                     for (int j = 0; j < vOld.getArray().length; j++) {
                            vNew.getArray()[i] += vOld.getArray()[j] * this.getMatrix()[j][i];
                     }
              }

              return vNew;
       }
       public Matrix3D getArbitraryRotationMatrix(double[] vertex1, double[] vertex2, double angle){
              /* this function will create a rotation matrix based on the vector between two vertices passed into the function */
              Vector3D vector = new Vector3D(vertex2[0] - vertex1[0], vertex2[1] - vertex1[1], vertex2[2] - vertex1[2]);
              System.out.println("Unit Vector Dimensions");
              System.out.println("X: " + vector.getX());
              System.out.println("Y: " + vector.getY());
              System.out.println("Z " + vector.getZ());
              System.out.println("W: " + vector.getW());
              Vector3D unitVector = vector.getUnitVector();
              unitVector.printVector();
              Matrix3D m = new Matrix3D();
              Matrix3D tm = new Matrix3D();
              Matrix3D xRm = new Matrix3D();
              Matrix3D yRm = new Matrix3D();
              Matrix3D zRm = new Matrix3D();
              Matrix3D rm = new Matrix3D();

              double a = unitVector.getX();
              System.out.println("A is " + a);

              double b = unitVector.getY();
              double c = unitVector.getZ();
              double d;
              double cos;
              double sin;
              /*
                first, create the matrix that will translate the original POINT back to origin.
              */
              tm = tm.getTranslationMatrix(-vertex1[0], -vertex1[1], -vertex1[2]);
              /*
                     Second, the unit vector rotate around the x axis (a is 0, d is sqrt(b^2 + c^2) 2D pythagoras)
                     to get the vector to lie on the XZ plane.
                     sin = b / d. cos = c / d
               */

              d = Math.sqrt(b*b + c*c);

              if(d != 0){
                     sin = b / d;
                     cos = c / d;
                     xRm = getRotationByTrigRatio(AXIS.X_AXIS, sin, cos);
              }

              m = m.combine2Matrices(xRm, tm);

              /*
                     Third, rotate unit vector around the Y axis to get the vector to lie on the Z Axis.
                     "a" is still the same, representing x. Y is now not included.
                     "c side" is now what d was since "d", the hypotenuse length, got rotated onto the z axis.
               */
              System.out.println("M after tm and xRM");
              m.printMatrix();

              d = Math.sqrt(a*a + d*d); //d should now equal 1! because this is the same as sqrt(a^2 + b^2 + c^2) and since this is a unit vector, it will be 1.
              sin = -a; //If you draw this out, you will see the z axis is going down, making sin need to shrink.
              System.out.println("Sin is " + sin);
              cos = d;
              yRm = getRotationByTrigRatio(AXIS.Y_AXIS, sin, cos);

              System.out.println("Print Matrix");

              yRm.printMatrix();

              /* COMBINE MATRICES AGAIN */

              m = m.combine2Matrices(yRm, m);
              System.out.println("M after combo with yRM");
              m.printMatrix();
              /*
                     Fourth, rotate the unit vector around the Z axis to get the desired rotation.
              */
              zRm = rm.getRotationByAngle(AXIS.Z_AXIS, angle);
              m = m.combine2Matrices(m, zRm);

              /*
                     Finally, do inverse of rotations and do inverse of each rotation and translation. (BEFORE Z ROTATION)
               */
              yRm = getTransposedMatrix(yRm);
              xRm = getTransposedMatrix(xRm);
              m = m.combine3Matrices(m, yRm, xRm);

              tm = tm.getTranslationMatrix(vertex1[0], vertex1[1], vertex1[2]); // Translate back to original vertex point.

              m = m.combine2Matrices(tm, m);
              System.out.println("Final matrix");
              m.printMatrix();
              return m;
       }

       public Matrix3D getRotationByTrigRatio(AXIS axis, double sin, double cos){
              if(axis == AXIS.X_AXIS) {
                     matrix[1][1] = cos;
                     matrix[2][1] = -sin;
                     matrix[1][2] = sin;
                     matrix[2][2] = cos;

              }else if(axis == AXIS.Y_AXIS){
                     matrix[0][0] = cos;
                     matrix[0][2] = sin;
                     matrix[2][0] = -sin;
                     matrix[2][2] = cos;

              }else{ //Rotate around Z axis(standard way of doing 2D)
                     matrix[0][0] = cos;
                     matrix[1][0] = -sin;
                     matrix[0][1] = sin;
                     matrix[1][1] = cos;
              }
              return this;
       }

       public Matrix3D getRotationByAngle(AXIS axis, double angle) {
              double radians = DEGREES_TO_RADIANS * angle;
              if (axis == AXIS.X_AXIS) {
                     matrix[1][1] = Math.cos(radians);
                     matrix[2][1] = -Math.sin(radians);
                     matrix[1][2] = Math.sin(radians);
                     matrix[2][2] = Math.cos(radians);

              } else if (axis == AXIS.Y_AXIS) {
                     matrix[0][0] = Math.cos(radians);
                     matrix[0][2] = -Math.sin(radians);
                     matrix[2][0] = Math.sin(radians);
                     matrix[2][2] = Math.cos(radians);

              } else { //Rotate around Z axis(standard way of doing 2D)
                     matrix[0][0] = Math.cos(radians);
                     matrix[1][0] = -Math.sin(radians);
                     matrix[0][1] = Math.sin(radians);
                     matrix[1][1] = Math.cos(radians);

              }
              return this;
       }

       public Matrix3D getTranslationMatrix(double xTranslate, double yTranslate, double zTranslate){
              super.matrix[3][0] = xTranslate;
              super.matrix[3][1] = yTranslate;
              super.matrix[3][2] = zTranslate;
              return this;
       }

       public Matrix3D getScaleMatrix(double xScale, double yScale, double zScale){
              super.matrix[0][0] = xScale;
              super.matrix[1][1] = yScale;
              super.matrix[2][2] = zScale;
              return this;
       }

       public Matrix3D getPerspectiveMatrix(double projectionDistance){
              super.matrix[2][2] = 0; //set z value to 0 to plot onto the xy view plane
              /*
                      sets the w coordinate to z/d + 1, which is what we need to multiply x and z to.
               */
              super.matrix[2][3] = 1/projectionDistance;
              super.matrix[3][3] = 1;

              return this;
       }

       public static Vector3D getProjectionVertex(Vector3D vertex, Matrix3D projectionMatrix){
              Vector3D vertexHomogenous = projectionMatrix.transformVertex(vertex);
              Vector3D projectedVertex = new Vector3D( vertexHomogenous.getX() / vertexHomogenous.getW(), vertexHomogenous.getY() / vertexHomogenous.getW(), vertexHomogenous.getZ() / vertexHomogenous.getW());
              return projectedVertex;
       }


       @Override
       void setToIdentity() {
           super.set3DMatrix();
       }

       public Matrix3D getTransposedMatrix(Matrix matrix){
              double[][] transpose = new double[4][4];

              for(int i = 0; i < matrix.getRows(); i++){
                     for(int j = 0; j < matrix.getColumns(); j++){
                            transpose[j][i] = matrix.getMatrix()[i][j];
                     }
              }

              return new Matrix3D(transpose);
       }

}
