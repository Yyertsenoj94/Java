package Test3D;

public class R_Matrix2D {
        public enum AXIS {X, Y, Z}; //You will only need this when you rotate on anything but the z axis (in 3D)
        static final double DEGREES_TO_RADIANS = 3.1415926535 / 180;
        float[][] matrix = {    {1.0f, 0.0f, 0.0f},
                                {0.0f, 1.0f, 0.0f},
                                {0.0f, 0.0f, 1.0f}};
        public R_Matrix2D(){

        }

        public float[] rotateVertex(float[] vertex, float degrees){
                setTranslation(degrees);

                float[] v_old = vertex;
                float[] v_new = new float[3];

                for(int i = 0; i < v_old.length; i++){
                        for(int j = 0; j < v_old.length; j++){
                                v_new[i] += v_old[j] * matrix[j][i];
                        }
                }

                resetToIdentity();
                return v_new;
        }

        public void resetToIdentity(){
                matrix[0][0] = 1.0f;
                matrix[1][0] = 0.0f;
                matrix[0][1] = 0.0f;
                matrix[1][1] = 1.0f;
        }

        private void setTranslation(float degrees){
                double radians = degrees * DEGREES_TO_RADIANS;
                matrix[0][0] = (float) Math.cos(radians);
                matrix[1][0] = (float) -Math.sin(radians);
                matrix[0][1] = (float) Math.sin(radians);
                matrix[1][1] = (float) Math.cos(radians);
        }

}
