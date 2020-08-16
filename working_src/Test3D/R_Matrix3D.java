package Test3D;

public class R_Matrix3D {
    enum Axis {X_AXIS, Y_AXIS, Z_AXIS};
    static final double DEGREES_TO_RADIANS = 3.1415926535 / 180;

    private final float[][] matrix = {  {1.0f, 0.0f, 0.0f, 0.0f},
                                        {0.0f, 1.0f, 0.0f, 0.0f},
                                        {0.0f, 0.0f, 1.0f, 0.0f},
                                        {0.0f, 0.0f, 0.0f, 1.0f}};


    public R_Matrix3D(){

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
}
