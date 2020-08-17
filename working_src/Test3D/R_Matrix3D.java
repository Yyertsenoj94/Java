package Test3D;

public class R_Matrix3D {
    enum Axis {X_AXIS, Y_AXIS, Z_AXIS};

    private final int rows = 4;
    private final int columns = 4;
    static final double DEGREES_TO_RADIANS = 3.1415926535 / 180;

    private float[][] matrix = {  {1.0f, 0.0f, 0.0f, 0.0f},
            {0.0f, 1.0f, 0.0f, 0.0f},
            {0.0f, 0.0f, 1.0f, 0.0f},
            {0.0f, 0.0f, 0.0f, 1.0f}};

    public R_Matrix3D(){

    }

    public R_Matrix3D(float[][] matrix){
        this.matrix = matrix;
    }

    public float[][] getMatrix(){
        return matrix;
    }

    public float[] rotateMatrix(float[] vertex, float degrees, Axis axis){

        float[] newVertex = new float[4];
        setRotation(degrees * DEGREES_TO_RADIANS, axis);
        for(int i = 0; i < vertex.length; i++){
            for(int j = 0; j < vertex.length; j++){
                newVertex[i] += vertex[j] * matrix[j][i];
            }
        }
        return newVertex;
    }


    private void setRotation(double radians, Axis axis){
        if(axis == Axis.X_AXIS) {
            matrix[1][1] = (float) Math.cos(radians);
            matrix[2][1] = (float) -Math.sin(radians);
            matrix[1][2] = (float) Math.sin(radians);
            matrix[2][2] = (float) Math.cos(radians);

        }else if(axis == Axis.Y_AXIS){
            matrix[0][0] = (float) Math.cos(radians);
            matrix[0][2] = (float) -Math.sin(radians);
            matrix[2][1] = (float) Math.sin(radians);
            matrix[2][2] = (float) Math.cos(radians);

        }else{ //Rotate around Z axis(standard way of doing 2D)
            matrix[0][0] = (float) Math.cos(radians);
            matrix[1][0] = (float) -Math.sin(radians);
            matrix[0][1] = (float) Math.sin(radians);
            matrix[1][1] = (float) Math.cos(radians);
        }
    }

    public int getRows(){
        return rows;
    }

    public int getColumns(){
        return columns;
    }

    public R_Matrix3D getTransposedMatrix(){
        /*
            This function will swap the rows and columns which is necessary to get the inverse matrix of a rotation
        */
        float[][] transpose = new float[4][4];

        for(int i = 0; i < rows; i++){
           for(int j = 0; j < columns; j++){
               transpose[j][i] = matrix[i][j];
           }
        }

        return new R_Matrix3D(transpose);
    }

    public static R_Matrix3D getCompositionMatrix(R_Matrix3D matrix1, R_Matrix3D matrix2){

        float[][] composedArray = new float[4][4];

        for(int i = 0; i < matrix1.getColumns(); i++) {
            for (int j = 0; j < matrix1.getRows(); j++) {
                for (int k = 0; k < matrix1.getColumns(); k++) {
                    composedArray[i][j] = matrix1.getMatrix()[j][k] * matrix2.getMatrix()[k][j];
                }
            }
        }

        return new R_Matrix3D(composedArray);
    }

    public void printMatrix(){
        for(int i = 0; i < rows; i++){
            System.out.print("[");
            for(int j = 0; j < columns; j++){
                System.out.print(" " + matrix[i][j] + " " );
            }
            System.out.println("]");
        }
    }

}
