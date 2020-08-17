package Test3D;


public class Matrix3D extends Matrix {

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

       public double[] transformVertex(double[] vertex) {
              double[] vOld = vertex;
              double[] vNew = new double[4];

              for (int i = 0; i < vertex.length; i++) {
                     for (int j = 0; j < vertex.length; j++) {
                            vNew[i] += vOld[j] * this.getMatrix()[j][i];
                     }
              }

              return vNew;
       }

       @Override
       void setToIdentity() {
           super.set3DMatrix();
       }

       @Override
       Matrix getTransposedMatrix(Matrix matrix) {

              double[][] transpose = new double[4][4];

              for(int i = 0; i < matrix.getRows(); i++){
                     for(int j = 0; j < matrix.getColumns(); j++){
                            transpose[j][i] = matrix.getMatrix()[i][j];
                     }
              }

              return new Matrix3D(transpose);
       }
}
