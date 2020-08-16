package Test3D;

public class S_Matrix2D {
        float[][] matrix = {    {1.0f, 0.0f, 0.0f},
                                {0.0f, 1.0f, 0.0f},
                                {0.0f, 0.0f, 1.0f}};

        public S_Matrix2D(){

        }

        private void setScale(float xScale, float yScale){
                matrix[0][0] = xScale;
                matrix[1][1] = yScale;
        }

        private void resetToIdentity(){
                matrix[0][0] = 1.0f;
                matrix[1][1] = 1.0f;
        }

        public float[] scaleVertex(float[] vertex, float xScale, float yScale){
                setScale(xScale, yScale);

                float[] v_new = new float[3];

                for(int i = 0; i < vertex.length; i++){
                        for(int j = 0; j < vertex.length; j++){
                                v_new[i] += vertex[j] * matrix[j][i];
                        }
                }

                resetToIdentity();
                return v_new;
        }

}
