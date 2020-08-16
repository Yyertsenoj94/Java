package Test3D;

public class Vector3D {

        private float[] point = new float[4];

        public Vector3D(float x, float y, float z){
                point[0] = x;
                point[1] = y;
                point[2] = z;
                point[3] = 1.0f;
        }

        public void setX(float x){
                point[0] = x;
        }

        public void setY(float y){
                point[1] = y;
        }

        public void setZ(float z){
                point[2] = z;
        }

        public float getX(){
                return point[0];
        }

        public float getY(){
                return point[1];
        }

        public float getZ(){
                return point[2];
        }

        public float getMagnitude(){
                double x = (double) getX();
                double y = (double) getY();
                double z = (double) getZ();
                return (float) Math.sqrt((x*x) + (y*y) + (z*z));
        }


        public Vector3D getVectorFromPoints(float[] p1, float[] p2){
                //A vector is just the tail point - head point

                return new Vector3D(p2[0] - p1[0], p2[1] - p1[1], p2[2] - p1[2]);

        }

        public Vector3D getUnitVector(){
                float magnitude = getMagnitude();
                Vector3D unitVector = new Vector3D(0.0f, 0.0f, 0.0f);

                        unitVector.setX(getX() / magnitude);
                        unitVector.setY(getY() / magnitude);
                        unitVector.setZ(getZ() / magnitude);

               return unitVector;
        }

        public Vector3D getCrossProductVector(Vector3D aVector, Vector3D bVector){
               Vector3D crossProductVector = new Vector3D(0.0f, 0.0f, 0.0f);

                crossProductVector.setX(aVector.getY() * (bVector.getZ() - aVector.getZ()) * bVector.getY());
                crossProductVector.setY(aVector.getZ() * (bVector.getX() - aVector.getX()) * bVector.getZ());
                crossProductVector.setZ(aVector.getX() * (bVector.getY() - aVector.getY() * bVector.getX()));

               return crossProductVector;
        }

        public float getDotProduct(Vector3D aVector, Vector3D bVector){
                return aVector.getX() * bVector.getX() + aVector.getY() * bVector.getY() + aVector.getZ() * bVector.getZ();
        }

        public float getDotProduct(Vector3D aVector, Vector3D bVector, float radianAngle){
               return aVector.getMagnitude() * bVector.getMagnitude() * (float) Math.cos(radianAngle);
        }

        public float getRadianAngle(Vector3D aVector, Vector3D bVector){
                double aMagnitude =  (double) aVector.getMagnitude();
                double bMagnitude = (double) bVector.getMagnitude();
                double dotProd = (double) getDotProduct(aVector, bVector);

                return (float) Math.acos(dotProd / (aMagnitude * bMagnitude));
        }

}
