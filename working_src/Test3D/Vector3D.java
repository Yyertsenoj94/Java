package Test3D;
public class Vector3D {

        private double[] point = new double[4];

        public Vector3D(double x, double y, double z){
                point[0] = x;
                point[1] = y;
                point[2] = z;
                point[3] = 1.0f;
        }

        private Vector3D(){
                this(0.0f, 0.0f, 0.0f);
                point[3] = 0.0f;
        }

        public static Vector3D getBlankVector(){
                return new Vector3D();
        }

        public void setX(double x){
                point[0] = x;
        }

        public void setY(double y){
                point[1] = y;
        }

        public void setZ(double z){
                point[2] = z;
        }

        public double getX(){
                return point[0];
        }

        public double getY(){
                 return point[1];
        }

        public double getZ(){
                return point[2];
        }

        public double getW() { return  point[3]; }

        public double getMagnitude(){
                double x = getX();
                double y = getY();
                double z = getZ();
                return Math.sqrt((x*x) + (y*y) + (z*z));
        }


        public Vector3D getVectorFromPoints(double[] p1, double[] p2){
                //A vector is just the tail point - head point

                return new Vector3D(p2[0] - p1[0], p2[1] - p1[1], p2[2] - p1[2]);

        }

        public Vector3D getUnitVector(){
                double magnitude = getMagnitude();
                Vector3D unitVector = new Vector3D(0.0f, 0.0f, 0.0f);

                        unitVector.setX(getX() / magnitude);
                        unitVector.setY(getY() / magnitude);
                        unitVector.setZ(getZ() / magnitude);

               return unitVector;
        }

        public static Vector3D getCrossProductVector(Vector3D aVector, Vector3D bVector){
               Vector3D crossProductVector = new Vector3D(0.0f, 0.0f, 0.0f);

                crossProductVector.setX(aVector.getY() * (bVector.getZ() - aVector.getZ()) * bVector.getY());
                crossProductVector.setY(aVector.getZ() * (bVector.getX() - aVector.getX()) * bVector.getZ());
                crossProductVector.setZ(aVector.getX() * (bVector.getY() - aVector.getY() * bVector.getX()));

               return crossProductVector;
        }

        public double getDotProduct(Vector3D aVector, Vector3D bVector){
                return aVector.getX() * bVector.getX() + aVector.getY() * bVector.getY() + aVector.getZ() * bVector.getZ();
        }

        public double getDotProduct(Vector3D aVector, Vector3D bVector, float radianAngle){
               return aVector.getMagnitude() * bVector.getMagnitude() * (float) Math.cos(radianAngle);
        }

        public double getRadianAngle(Vector3D aVector, Vector3D bVector){
                double aMagnitude =  aVector.getMagnitude();
                double bMagnitude =  bVector.getMagnitude();
                double dotProd = getDotProduct(aVector, bVector);

                return Math.acos(dotProd / (aMagnitude * bMagnitude));
        }

        public double[] getArray(){
                return point;
        }

        public void printVector(){
                System.out.print("X: " + getX() + " Y: " + getY() + " Z: " + getZ() + " W: " + getW() + "\n");
        }

}
