package Test3D;

public class T_Matrix2D {
         float[][] matrix = {{1.0f, 0.0f, 0.0f},
                            {0.0f, 1.0f, 0.0f},
                            {0.0f, 0.0f, 1.0f}};

         public T_Matrix2D(){
         }

         public void setTranslation(float xChange, float yChange){
             this.matrix[2][0] = xChange; //Catch the delta x
             this.matrix[2][1] = yChange; //Catch the delta y;
         }

        public float[] translateVertex(float[] vertex){
             float[] vOld = vertex;
             float[] vNew = new float[3];

            for(int i = 0; i < vertex.length; i++){
                for(int j = 0; j < vertex.length; j++){
                    vNew[i] += vOld[j] * matrix[j][i];
                }
            }

            return vNew;
        }


}
