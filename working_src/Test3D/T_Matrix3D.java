package Test3D;

public class T_Matrix3D {

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

    private void setTranslation(float x, float y, float z){
       matrix[4][0] = x;
       matrix[4][1] = y;
       matrix[4][2] = z;
    }

}
