package Test3D;

public class T_Matrix3D {

    private int rows;
    private int columns;
    private final float[][] matrix = {  {1.0f, 0.0f, 0.0f, 0.0f},
                                        {0.0f, 1.0f, 0.0f, 0.0f},
                                        {0.0f, 0.0f, 1.0f, 0.0f},
                                        {0.0f, 0.0f, 0.0f, 1.0f}};

    public float[] translateVertex(float[] vertex, float xTranslate, float yTranslate, float zTranslate){
        float[] newVertex = new float[4];
        setTranslation(xTranslate, yTranslate, zTranslate);
        for(int i = 0; i < vertex.length; i++){
            for(int j = 0; j < vertex.length; j++){
                newVertex[i] += vertex[j] * matrix[j][i];
            }
        }
        return newVertex;
    }

    public int getRows(){
        return rows;
    }

    public int getColumns(){
        return columns;
    }

    private void setTranslation(float x, float y, float z){
       matrix[4][0] = x;
       matrix[4][1] = y;
       matrix[4][2] = z;
    }


    public static R_Matrix3D getCompositionMatrix(T_Matrix3D matrix1, T_Matrix3D matrix2){
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

    public float[][] getMatrix(){
        return matrix;
    }
}
