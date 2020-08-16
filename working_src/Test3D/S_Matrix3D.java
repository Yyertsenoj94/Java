package Test3D;

public class S_Matrix3D {
    private final float[][] matrix = {  {1.0f, 0.0f, 0.0f, 0.0f},
                                        {0.0f, 1.0f, 0.0f, 0.0f},
                                        {0.0f, 0.0f, 1.0f, 0.0f},
                                        {0.0f, 0.0f, 0.0f, 1.0f}};

    public S_Matrix3D(){

    }

    public float[] scaleMatrix(float[] vertex, float xScale, float yScale, float zScale){
        float[] newVertex = new float[4];
        setScale(xScale, yScale, zScale);
       for(int i = 0; i < vertex.length; i++){
           for(int j = 0; j < vertex.length; j++){
               newVertex[i] += vertex[j] * matrix[j][i];
           }
       }
       return newVertex;
    }

    private void setScale(float xScale, float yScale, float zScale){
        matrix[0][0] = xScale;
        matrix[1][1] = yScale;
        matrix[2][2] = zScale;
    }
}
