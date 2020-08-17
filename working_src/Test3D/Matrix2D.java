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

    public Matrix2D setRotationMatrix(double degrees){
        double radians = degrees * DEGREES_TO_RADIANS;
        matrix[0][0] = (float) Math.cos(radians);
        matrix[1][0] = (float) -Math.sin(radians);
        matrix[0][1] = (float) Math.sin(radians);
        matrix[1][1] = (float) Math.cos(radians);
        return this;
    }


    public Matrix2D setScaleMatrix(double xScale, double yScale){
        super.matrix[0][0] = xScale;
        super.matrix[1][1] = yScale;

        return this;
    }

    /*          TRANSLATION FUNCTIONS           */
    public Matrix2D setTranslationMatrix(double xChange, double yChange){
        super.matrix[2][0] = xChange; //Catch the delta x
        super.matrix[2][1] = yChange; //Catch the delta y;
        return this;
    }

    public double[] transformVertex(double[] vertex){
        double[] vOld = vertex;
        double[] vNew = new double[3];

        for(int i = 0; i < vertex.length; i++){
            for(int j = 0; j < vertex.length; j++){
                vNew[i] += vOld[j] * this.getMatrix()[j][i];
            }
        }

        return vNew;
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

    public Matrix2D getCompositionMatrix(Matrix matrix1, Matrix matrix2){
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
    /*
    float[][] matrix = {{1.0f, 0.0f, 0.0f},
                        {0.0f, 1.0f, 0.0f},
                        {x2, y2, 1.0f}};

     */

    //new [(x + x2),(y + y2), 1]
}
