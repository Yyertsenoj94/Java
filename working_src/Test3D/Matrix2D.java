package Test3D;

public class Matrix2D extends Matrix {

    public Matrix2D(){
        super();
        super.set2DMatrix();
    }

    public Matrix2D(double[][] array){
        super.set2DMatrix();
        super.matrix = array;
    }

    public static Matrix2D getRotationMatrixAroundPoint(Vector2D point, double degrees){
        Matrix2D inverseTranslationM = Matrix2D.getTranslationMatrix(-point.getX(), -point.getY());
        Matrix2D rotationM = Matrix2D.getRotationMatrixOrigin(degrees);
        Matrix2D translationM = Matrix2D.getTranslationMatrix(point.getX(), point.getY());

        return Matrix2D.combine3Matrices(inverseTranslationM, rotationM, translationM);
    }

    public static Matrix2D getRotationMatrixOrigin(double degrees){
        Matrix2D matrix = new Matrix2D();
        double radians = degrees * DEGREES_TO_RADIANS;
        matrix.getMatrix()[0][0] = (float) Math.cos(radians);
        matrix.getMatrix()[1][0] = (float) -Math.sin(radians);
        matrix.getMatrix()[0][1] = (float) Math.sin(radians);
        matrix.getMatrix()[1][1] = (float) Math.cos(radians);
        return matrix;
    }

    public static Matrix2D getScaleMatrix(double xScale, double yScale){
        Matrix2D matrix = new Matrix2D();
        matrix.getMatrix()[0][0] = xScale;
        matrix.getMatrix()[1][1] = yScale;
        return matrix;
    }

    /*          TRANSLATION FUNCTIONS           */
    public static Matrix2D getTranslationMatrix(double xChange, double yChange){
        Matrix2D matrix = new Matrix2D();
        matrix.getMatrix()[2][0] = xChange; //Catch the delta x
        matrix.getMatrix()[2][1] = yChange; //Catch the delta y;
        return matrix;
    }

    public Vector2D transformVertex(Vector2D vertex){
        double[] vOld = vertex.getArrayFromVector();
        double[] vNew = new double[3];

        for(int i = 0; i < vOld.length; i++){
            for(int j = 0; j < vOld.length; j++){
                vNew[i] += vOld[j] * this.getMatrix()[j][i];
            }
        }

        return new Vector2D(vNew[0], vNew[1], vNew[2]);

    }

    public int getRows(){
        return super.getRows();
    }

    public int getColumns(){
        return super.getColumns();
    }

    public double[][] getMatrix(){
        return super.matrix;
    }

    public static Matrix2D combine3Matrices(Matrix matrix1, Matrix matrix2, Matrix matrix3){
        Matrix2D combined = new Matrix2D();
        combined = Matrix2D.combine2Matrices(matrix1, matrix2);
        combined = combine2Matrices(combined, matrix3);

        return combined;
    }
    public static Matrix2D combine2Matrices(Matrix matrix1, Matrix matrix2){

        double[][] composedArray = new double[matrix1.getRows()][matrix1.getColumns()];

        for(int i = 0; i < matrix1.getColumns(); i++) {
            for (int j = 0; j < matrix1.getRows(); j++) {
                for (int k = 0; k < matrix1.getColumns(); k++) {
                    composedArray[i][j] += matrix1.getMatrix()[i][k] * matrix2.getMatrix()[k][j];
                }
            }
        }
        return new Matrix2D(composedArray);
    }

    public void printArray(double[][] array){
        for(int i = 0 ; i < array.length; i++){
            System.out.print("[");
            for(int j = 0; j < array.length; j++){
                System.out.print(" " + array[i][j] + " ");
            }
            System.out.println("]");
        }
    }

    public Matrix2D getTransposedMatrix(Matrix matrix){
        double[][] transpose = new double[3][3];

        for(int i = 0; i < matrix.getRows(); i++){
            for(int j = 0; j < matrix.getColumns(); j++){
                transpose[j][i] = matrix.getMatrix()[i][j];
            }
        }

        return new Matrix2D(transpose);
    }

    public void setToIdentity(){
        super.set2DMatrix();
    }
}
