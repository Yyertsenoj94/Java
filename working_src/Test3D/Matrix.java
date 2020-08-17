package Test3D;

public abstract class Matrix {
    enum AXIS {X_AXIS, Y_AXIS, Z_AXIS};
    static final double DEGREES_TO_RADIANS = 3.1415926535 / 180;

    private int rows;
    private int columns;

    private double [][] matrix2D ={ {1.0f, 0.0f, 0.0f},
                                    {0.0f, 1.0f, 0.0f},
                                    {0.0f, 0.0f, 1.0f}};

    private double [][] matrix3D =  {   {1.0f, 0.0f, 0.0f, 0.0f},
                                        {0.0f, 1.0f, 0.0f, 0.0f},
                                        {0.0f, 0.0f, 1.0f, 0.0f},
                                        {0.0f, 0.0f, 0.0f, 1.0f}};
    public double [][] matrix;

    public Matrix(){

    }

    public void set3DMatrix(){
        this.matrix = matrix3D;
        columns = 4;
        rows = 4;
    }

    public void set2DMatrix(){
        this.matrix = matrix2D;
        columns = 3;
        rows = 3;
    }

    public double[][] getMatrix(){
        return matrix;
    }

    public int getRows(){
        return rows;
    }

    public int getColumns(){
        return columns;
    }


    public static void printMatrix(Matrix matrix){
            for(int i = 0; i < matrix.getRows(); i++){
                System.out.print("[");
                for(int j = 0; j < matrix.getColumns(); j++){
                    System.out.print(" " + matrix.getMatrix()[i][j] + " " );
                }
                System.out.println("]");
            }
    }

    abstract void setToIdentity();

    abstract Matrix getTransposedMatrix(Matrix matrix);

}
