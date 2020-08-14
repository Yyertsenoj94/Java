package Test3D;

public class S_Matrix2D {
        float[][] matrix = {    {0.0f, 0.0f, 0.0f},
                                {0.0f, 0.0f, 0.0f},
                                {0.0f, 0.0f, 1.0f}};

        public S_Matrix2D(){

        }

        public void setScale(float xScale, float yScale){
                matrix[0][0] = xScale;
                matrix[1][1] = yScale;
        }

        public float[] scaleVertex(float[] vertex){
                float[] v_new = new float[3];

                for(int i = 0; i < vertex.length; i++){
                        for(int j = 0; j < vertex.length; j++){
                                v_new[i] += vertex[j] * matrix[j][i];
                        }
                }

                return v_new;
        }

}
