package Test3D;

import org.w3c.dom.ls.LSOutput;

import java.awt.*;

import static Test3D.Matrix.DEGREES_TO_RADIANS;

public final class Functions {

    private static Window WINDOW;


    /* Draw Functions
    /* --------------------------------------------------------------------------------------*/
    public static void drawPolygon2D(Polygon2D p){
        if(checkWindowBind())
            return;
       /*
        for(int i = 0; i < p.getLines().length; i++){
            WINDOW.drawLine(p.getLines()[i]);
        }
        */
        drawLines(p.getLines());
    }

    public static void drawLines(LineSegment[] lines){
        for(LineSegment l : lines){
            drawLine(l);
        }
    }

    public static void drawLine(LineSegment s){
        clipLine(s);
    }

    public static void drawCube(Cube3D cube){
        WINDOW.setLineColor(Color.MAGENTA);
        for(int i = 0; i < cube.getFaces().length; i++){
            for(int j = 0; j < cube.getFaces()[i].length - 1; j++){
                int x1 = (int) cube.getTransformedVertices()[cube.getFaces()[i][j]].getX();
                int x2 = (int) cube.getTransformedVertices()[cube.getFaces()[i][j + 1]].getX();
                int y1 = (int) cube.getTransformedVertices()[cube.getFaces()[i][j]].getY();
                int y2 = (int) cube.getTransformedVertices()[cube.getFaces()[i][j + 1]].getY();

                LineSegment temp =  new LineSegment(x1, y1, x2, y2);
                Functions.drawLine(temp);
                // window.drawLine(x1, y1, x2, y2);
            }
        }
        //drawVertices(window);
    }

    public static void drawVertices(Cube3D cube){
        WINDOW.setPointSize(20);
        WINDOW.setPointColor(Color.cyan);
        for(Vector3D v: cube.getTransformedVertices()){
            //window.setPointSize(10 + (int) getScale(v.getZ()));
            WINDOW.drawPoint(v);
        }
    } //TODO CONFIRM THIS WORKS
    /* --------------------------------------------------------------------------------------*/


    /* Clipping Functions
    /* --------------------------------------------------------------------------------------*/
    private static void clipLine(LineSegment s){
        int left = 0;
        int right = 1;
        int bottom = 2;
        int top = 3;

        boolean display = false;
        boolean done = false;

        Point one = new Point(s.getX1(), s.getY1());
        Point two = new Point(s.getX2(), s.getY2());

        //Converts to coordinate system originating at bottom left for clipping calculations
        convertToRealCoordinates(one);
        convertToRealCoordinates(two);

        // Variables for storing the information on whether each point is to the left, right, top or bottom
        boolean[] code1 = new boolean[4];
        boolean[] code2 = new boolean[4];

        while(!done){
            // set code for relation to viewport boundaries
            encodePoint(one, code1);
            encodePoint(two, code2);

            if(acceptCode(code1, code2)){
                done = true; //we are finished evaluating this line
                display = true; //and it can be drawn to the screen
            }else{
                if(rejectCode(code1, code2)){ //if both lines are true on left, right, above, or below, line does not intersect viewport
                    done = true;
                }else{ //If not accepted or rejected, find intersection with a border.
                   swapIfNeeded(one, two, code1, code2); //swap once the first moved into boundary
                   double slope = (two.getY() - one.getY()) / (two.getX() - one.getX());

                   if(code1[left]){ //find Y intercept with left boundary
                       one.setY(one.getY() + slope * (WINDOW.getXWMin() - one.getX())); //sets y equal to the intersection with a vertical boundary
                       one.setX(WINDOW.getXWMin()); //set x to be min to find y intercept
                   }else if(code1[right]){ //find Y intercept with right boundary
                       one.setY(one.getY() + slope * (WINDOW.getXWMax() - one.getX())); //sets y equal to the intersection with a vertical boundary
                       one.setX(WINDOW.getXWMax());
                   }else if(code1[bottom]){ //find X intercept at bottom
                       one.setX(one.getX() + ((WINDOW.getYWMin() - one.getY()) / slope)); //sets x equal to the intersection with a horizontal boundary
                       one.setY(WINDOW.getYWMin());
                   }else if(code1[top]){ //find X intercept at top.
                       one.setX(one.getX() + ((WINDOW.getYWMax() - one.getY()) / slope));  //sets x equal to the intersection with a horizontal boundary
                       one.setY(WINDOW.getYWMax());
                   }
                }
            }
        }

        if(display) {
            convertToCartesianCoordinate(one);
            convertToCartesianCoordinate(two);

            /*  SCALE EACH POINT TO THE VIEWPORT WINDOW */
            scaleToViewPort(one);
            scaleToViewPort(two);

            WINDOW.drawLine(one.getX(), one.getY(), two.getX(), two.getY());
        }
    }

    //converts point to being based off of 0,0 (Center of window)
    private static void convertToCartesianCoordinate(Point p){
        /*
               point being passed should be based on real window coordinates (rather than off the center of the window)
               This function will convert that point back to cartesian.
         */
        p.setX(p.getX() - WINDOW.getWCenterX()); //converts point back to x distance from center of screen
        p.setY(p.getY() - WINDOW.getWCenterY()); //converts point back to y distance from center of screen
    }

    /*
       By "Real" coordinates, it means coordinate system for clipping where bottom left of window is origin.
       Note that TOP left is where jpanel draws from. However, I use cartesian coordinates and add to a center x,y and invert "y" when drawing
    */
    private static void convertToRealCoordinates(Point p){
        /*
            The point being passed in is based on a centered (0, 0) system. So adding that to the center coordinate distance will convert to the actual
            coordinate distance relative to the bottom left of window.
        */
        p.setX(p.getX() + WINDOW.getWCenterX());
        p.setY(p.getY() + WINDOW.getWCenterY());
    }

    private static void encodePoint(Point point, boolean[] code) {
        code[0] = point.getX() < WINDOW.getXWMin();
        code[1] = point.getX() > WINDOW.getXWMax();
        code[2] = point.getY() < WINDOW.getYWMin();
        code[3] = point.getY() > WINDOW.getYWMax();
    }

    private static boolean acceptCode(boolean[] c1, boolean[] c2){
        for(int i = 0; i < c1.length; i++){
            if(c1[i] || c2[i]) //if either code has a one, we must return false as we cannot trivially accept this line as a whole
                return false;
        }
        return true; //otherwise the line encoding is 0 throughout, and it can be draw as is.
    }

    private static boolean rejectCode(boolean[] c1, boolean[] c2){
        for(int i = 0; i < c1.length; i++){
            if(c1[i] && c2[i]) //if both codes of a particular area are true, than both points are too far to one side to create an intersection.
                return true;
        }
        return false;
    }

    private static void swapIfNeeded(Point one, Point two, boolean[] c1, boolean[] c2){
        /* This function will swap points to be clipped once the first point is ok*/

        encodePoint(one, c1); //refresh the code for new positioning of the point.

        if(pointIsInside(c1)){
            double x2 = two.getX();
            double y2 = two.getY();

            //two takes on ones corrected values
            two.setX(one.getX());
            two.setY(one.getY());

            //one takes on two's uncorrected values to be fixed next time around.
            one.setX(x2);
            one.setY(y2);

            swapArrays(c1, c2);
        }
    }

    private static boolean pointIsInside(boolean[] c1){
        for (boolean b : c1) {
            if (b) {
                return true;
            }
        }
        return true;
    }

    private static void swapArrays(boolean[] c1, boolean[] c2){
        for(int i = 0 ; i < c1.length; i++){
            boolean tempValue = c2[i];
            c2[i] = c1[i];
            c1[i] = tempValue;
        }
    }

    private static void scaleToViewPort(Point p){
        double xConversionRatio = ( ((double) (WINDOW.getXVMax() - WINDOW.getXVMin())) / ((double) (WINDOW.getXWMax() - WINDOW.getXWMin())));

        double yConversionRatio = ((double) (WINDOW.getYVMax() - WINDOW.getYVMin()) / (double) (WINDOW.getYWMax() - WINDOW.getYWMin()));

        p.setX((xConversionRatio * p.getX()));
        p.setY((yConversionRatio * p.getY()));
    }
    /* --------------------------------------------------------------------------------------*/

    /* Matrix Multiplier Functions */
    /* --------------------------------------------------------------------------------------*/
    public static Matrix3D combine3Matrices(Matrix matrix1, Matrix matrix2, Matrix matrix3){
        Matrix3D combined;

        combined = combine2Matrices(matrix1, matrix2);
        combined = combine2Matrices(combined, matrix3);

        return combined;
    }

    public static Matrix3D combine2Matrices(Matrix matrix1, Matrix matrix2){
        double[][] composedArray = new double[matrix1.getRows()][matrix1.getColumns()];

        for(int i = 0; i < matrix1.getColumns(); i++) {
            for (int j = 0; j < matrix1.getRows(); j++) {
                for (int k = 0; k < matrix1.getColumns(); k++) {
                    composedArray[i][j] += matrix1.getMatrix()[i][k] * matrix2.getMatrix()[k][j];
                }
            }
        }
        return new Matrix3D(composedArray);
    }
    /* --------------------------------------------------------------------------------------*/

    /*Factory Matrix Functions
    /*-------------------------------------------------------------------------------------------------------*/
    public static Matrix3D getTranslationMatrix(double xTranslate, double yTranslate, double zTranslate){
        Matrix3D t_matrix = new Matrix3D();
        t_matrix.matrix[3][0] = xTranslate;
        t_matrix.matrix[3][1] = yTranslate;
        t_matrix.matrix[3][2] = zTranslate;
        return t_matrix;
    }

    public static Matrix3D getScaleMatrix(double xScale, double yScale, double zScale){
        Matrix3D scaleMatrix = new Matrix3D();
        scaleMatrix.matrix[0][0] = xScale;
        scaleMatrix.matrix[1][1] = yScale;
        scaleMatrix.matrix[2][2] = zScale;
        return scaleMatrix;
    }

    public static Matrix3D getArbitraryRotationMatrix(double[] vertex1, double[] vertex2, double angle){
        /* this function will create a rotation matrix based on the vector between two vertices passed into the function */
        Vector3D vector = new Vector3D(vertex2[0] - vertex1[0], vertex2[1] - vertex1[1], vertex2[2] - vertex1[2]);
        Vector3D unitVector = vector.getUnitVector();

        Matrix3D m;
        Matrix3D tm;
        Matrix3D xRm = new Matrix3D();
        Matrix3D yRm;
        Matrix3D zRm;

        double a = unitVector.getX();
        double b = unitVector.getY();
        double c = unitVector.getZ();

        double d;
        double cos;
        double sin;

        /*
             first, create the matrix that will translate the original POINT back to origin.
        */
        tm = getTranslationMatrix(-vertex1[0], -vertex1[1], -vertex1[2]);



        /*
              Second, the unit vector rotate around the x axis (a is 0, d is sqrt(b^2 + c^2) 2D pythagoras)
              to get the vector to lie on the XZ plane.
              sin = b / d. cos = c / d
        */
        d = Math.sqrt(b*b + c*c);

        if(d != 0){
            sin = b / d;
            cos = c / d;
            xRm = getRotationByTrigRatio(Matrix.AXIS.X_AXIS, sin, cos);
        }

        m = Functions.combine2Matrices(tm, xRm);


        /*
             Third, rotate unit vector around the Y axis to get the vector to lie on the Z Axis.
             "a" is still the same, representing x. Y is now not included.
             "c side" is now what d was since "d", the hypotenuse length, got rotated onto the z axis.
        */
        sin = -a; //If you draw this out, you will see the z axis is going down, making sin need to shrink.
        cos = d;

        yRm = getRotationByTrigRatio(Matrix.AXIS.Y_AXIS, sin, cos);
        m = Functions.combine2Matrices(m, yRm);



        /*
               Fourth, rotate the unit vector around the Z axis to get the desired rotation.
        */
        zRm = getRotationByAngle(Matrix.AXIS.Z_AXIS, angle);
        m = Functions.combine2Matrices(m, zRm);


        /*
               Finally, do inverse of rotations and do inverse of each rotation and translation. (BEFORE Z ROTATION)
        */
        yRm = Functions.getTransposedMatrix(yRm);
        m = Functions.combine2Matrices(m, yRm);

        xRm = Functions.getTransposedMatrix(xRm);
        m = Functions.combine2Matrices(m, xRm);

        tm = Functions.getTranslationMatrix(vertex1[0], vertex1[1], vertex1[2]); // Translate back to original vertex point.
        m = Functions.combine2Matrices(m, tm);

        return m;
    }


    public static Matrix3D getRotationByTrigRatio(Matrix.AXIS axis, double sin, double cos){
        Matrix3D rotationMatrix = new Matrix3D();
        if(axis == Matrix.AXIS.X_AXIS) {
            rotationMatrix.matrix[1][1] = cos;
            rotationMatrix.matrix[2][1] = -sin;
            rotationMatrix.matrix[1][2] = sin;
            rotationMatrix.matrix[2][2] = cos;

        }else if(axis == Matrix.AXIS.Y_AXIS){
            rotationMatrix.matrix[0][0] = cos;
            rotationMatrix.matrix[0][2] = -sin;
            rotationMatrix.matrix[2][0] = sin;
            rotationMatrix.matrix[2][2] = cos;

        }else{ //Rotate around Z axis(standard way of doing 2D)
            rotationMatrix.matrix[0][0] = cos;
            rotationMatrix.matrix[1][0] = -sin;
            rotationMatrix.matrix[0][1] = sin;
            rotationMatrix.matrix[1][1] = cos;
        }
        return rotationMatrix;
    }


    public static Matrix3D getRotationByAngle(Matrix.AXIS axis, double angle) {
        Matrix3D rotationMatrix = new Matrix3D();
        double radians = DEGREES_TO_RADIANS * angle;
        if (axis == Matrix.AXIS.X_AXIS) {
            rotationMatrix.matrix[1][1] = Math.cos(radians);
            rotationMatrix.matrix[2][1] = -Math.sin(radians);
            rotationMatrix.matrix[1][2] = Math.sin(radians);
            rotationMatrix.matrix[2][2] = Math.cos(radians);

        } else if (axis == Matrix.AXIS.Y_AXIS) {
            rotationMatrix.matrix[0][0] = Math.cos(radians);
            rotationMatrix.matrix[0][2] = -Math.sin(radians);
            rotationMatrix.matrix[2][0] = Math.sin(radians);
            rotationMatrix.matrix[2][2] = Math.cos(radians);

        } else { //Rotate around Z axis(standard way of doing 2D)
            rotationMatrix.matrix[0][0] = Math.cos(radians);
            rotationMatrix.matrix[1][0] = -Math.sin(radians);
            rotationMatrix.matrix[0][1] = Math.sin(radians);
            rotationMatrix.matrix[1][1] = Math.cos(radians);

        }
        return rotationMatrix;
    }


    public static Matrix3D getPerspectiveMatrix(double projectionDistance){
        //FIXME _ THIS MIGHT NEED TO BE UNDONE - I don't see the benefit in actually setting z to 0 since we don't use it when drawing.
        Matrix3D perspectiveMatrix = new Matrix3D();
        perspectiveMatrix.matrix[2][3] = 1/projectionDistance;
        perspectiveMatrix.matrix[3][3] = 1;

        return perspectiveMatrix;
    }


    public static Matrix3D getTransposedMatrix(Matrix matrix){
        double[][] transpose = new double[4][4];

        for(int i = 0; i < matrix.getRows(); i++){
            for(int j = 0; j < matrix.getColumns(); j++){
                transpose[j][i] = matrix.getMatrix()[i][j];
            }
        }

        return new Matrix3D(transpose);
    }
    /*-------------------------------------------------------------------------------------------------------*/

    /* Vertex Transformation Functions
    /* -----------------------------------------------------------------------------------------------------*/
    public static Vector3D transformVertex(Vector3D vertex, Matrix3D matrix) {
        Vector3D vOld= vertex;
        Vector3D vNew = Vector3D.getBlankVector();

        for (int i = 0; i < vOld.getArray().length; i++) {
            for (int j = 0; j < vOld.getArray().length; j++) {
                vNew.getArray()[i] += vOld.getArray()[j] * matrix.getMatrix()[j][i];
            }
        }

        return vNew;
    }

    public static Vector3D getProjectionVertex(Vector3D vertex, Matrix3D projectionMatrix){
        Vector3D vertexHomogenous = transformVertex(vertex, projectionMatrix);
        Vector3D projectedVertex = new Vector3D( vertexHomogenous.getX() / vertexHomogenous.getW(), vertexHomogenous.getY() / vertexHomogenous.getW(), vertexHomogenous.getZ() / vertexHomogenous.getW());
        return projectedVertex;
    }





    /* Functions to bind window for drawing */
    /* --------------------------------------------------------------------------------------*/
    public static void bindWindow(Window window){
        WINDOW = window;
    }

    private static boolean windowNotBound(){
        return WINDOW == null;
    }

    private static boolean checkWindowBind(){
        if(windowNotBound()){
            System.out.println("Error: Please bind a window to 'Functions' class");
            return true;
        }
        return false;
    }
    /* --------------------------------------------------------------------------------------*/

}
