package Test3D;

public final class Functions {

    private static Window WINDOW;

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
        drawClippedLineSegment(s);
    }

    /* Functions to clip and draw line */
    private static void drawClippedLineSegment(LineSegment s){
        int left = 0;
        int right = 1;
        int top = 2;
        int bottom = 3;

        boolean display = false;
        boolean done = false;

        Point2D one = new Point2D(s.getX1(), s.getY1());
        Point2D two = new Point2D(s.getX2(), s.getY2());

        boolean[] code1;
        boolean[] code2;

        while(!done){
            code1 = encodePoint(one);
            code2 = encodePoint(two);

            if(acceptCode(code1, code2)){
                System.out.println("Accepting point x1: " + one.getX() + " y1: " +  one.getY());
                System.out.println("Accepting point x2: " + two.getX() + " y2: " + two.getY());

                done = true; //we are finished evaluating this line
                display = true; //and it can be drawn to the screen
            }else{
                if(rejectCode(code1, code2)){
                    done = true;
                }else{ //If not accepted or rejected, find intersection with a border.
                   swapIfNeeded(one, two, code1, code2); //swap once one is corrected //FIXME
                   double slope = (two.getY() - one.getY()) / (two.getX() - one.getX());

                   if(code1[left]){ //find Y intercept with left boundary
                       one.setY(one.getY() + slope * (WINDOW.getXWMin() - one.getX()));
                       one.setX(WINDOW.getXWMin()); //set x to be min to find y intercept
                   }else if(code1[right]){ //find Y intercept with right boundary
                       one.setY(one.getY() + slope * (WINDOW.getXWMax() - one.getX()));
                       one.setX(WINDOW.getXWMax());
                   }else if(code1[bottom]){ //find X intercept at bottom
                       one.setX(one.getX() + ((WINDOW.getYWMin() - one.getY()) / slope));
                       one.setY(WINDOW.getYWMin());
                   }else if(code1[top]){ //find X intercept at top.
                       one.setX(one.getX() + ((WINDOW.getYWMax() - one.getY()) / slope));
                       one.setY(WINDOW.getYWMax());
                   }
                }
            }
        }

        if(display) {
            /*  SCALE EACH POINT TO THE VIEWPORT WINDOW */
            System.out.println("One before scale");
            one.printPoint();
            System.out.println("Two before scale");
            two.printPoint();

            scaleToViewPort(one);
            scaleToViewPort(two);

            System.out.println("Printing one scaled");
            one.printPoint();
            System.out.println("Printing two scaled");
            two.printPoint();

            WINDOW.drawLine(one.getX(), one.getY(), two.getX(), two.getY());
        }
    }


    private static boolean[] encodePoint(Point2D point){
        boolean[] code = new boolean[4];

        if(point.getX() < WINDOW.getXWMin())
            code[0] = true; //LEFT
        if(point.getX() > WINDOW.getXWMax())
            code[1] = true; //RIGHT

        if(point.getY() < WINDOW.getYWMin())
            code[2] = true; //TOP
        if(point.getY() > WINDOW.getYWMax())
            code[3] = true; //BOTTOM

        return code;
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


    private static void swapIfNeeded(Point2D one, Point2D two, boolean[] c1, boolean[] c2){
        /* This function will swap points to be clipped once the first point is ok*/

        c1 = encodePoint(one); //refresh the code for new positioning of the point.

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

    private static void scaleToViewPort(Point2D p){
        double xConversionRatio = ( ((double) (WINDOW.getXVMax() - WINDOW.getXVMin())) / ((double) (WINDOW.getXWMax() - WINDOW.getXWMin())));
        System.out.println("X Conversion ratio: " + xConversionRatio);
        double xWindowPoint = p.getX() - WINDOW.getXWMin();
        System.out.println("Window X MIN: " + WINDOW.getXWMin());
        double xViewPortMin = WINDOW.getXVMin();
        System.out.println("Viewport X MIN: " + WINDOW.getXVMin());

        double yConversionRatio = ((double) (WINDOW.getYVMax() - WINDOW.getYVMin()) / (double) (WINDOW.getYWMax() - WINDOW.getYWMin()));
        double yWindowPoint = p.getY() - WINDOW.getYWMin();
        double yViewPortMin = WINDOW.getYVMin();

        p.setX((xConversionRatio * xWindowPoint) + xViewPortMin);
        p.setY((yConversionRatio * yWindowPoint) + yViewPortMin);

    }
    /* --------------------------------------------------------------------------------------*/



    /* Functions to bind window for drawing */
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
