package Test3D;

public final class Functions {

    private static Window WINDOW;

    public static void drawPolygon2D(Polygon2D p){
        if(checkWindowBind())
            return;

        for(int i = 0; i < p.getLines().length; i++){
            WINDOW.drawLine(p.getLines()[i]);
        }

    }

    public static void drawLines(LineSegment[] lines){
        for(LineSegment l : lines){
            drawLine(l);
        }
    }

    public static void drawLine(LineSegment s){
        drawClippedLineSegment(s);
    }

    private static void drawClippedLineSegment(LineSegment s){
        boolean display = false;
        boolean done = false;

        int x1 = s.getX1();
        int y1 = s.getY1();
        boolean[] code1;

        int x2 = s.getX2();
        int y2 = s.getY2();
        boolean[] code2;

        while(!done){
            code1 = encodePoint(x1, y1);
            code2 = encodePoint(x2, y2);

            if(acceptCode(code1, code2)){
                done = true; //we are finished evaluating this line
                display = true; //and it can be drawn to the screen
            }
        }

        if(display) { //FIXME WE NEED TO CONVERT TO VIEWPORT DIMENSIONS PRIOR TO DISPLAY.
            WINDOW.drawLine(s.getX1(), s.getY1(), s.getX2(), s.getY2());
        }
    }


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

    private static boolean[] encodePoint(int x1, int y1){
        boolean code[] = new boolean[4];

        if(x1 < WINDOW.getXWMin())
            code[0] = true;
        if(x1 > WINDOW.getXWMax())
            code[2] = true;
        if(y1 < WINDOW.getYWMin())
            code[1] = true;
        if(y1 > WINDOW.getYWMax())
            code[3] = true;

        return code;
    }

    private static boolean acceptCode(boolean[] c1, boolean[] c2){
        for(int i = 0; i < c1.length; i++){
            if(c1[i] || c2[i]) //if either code has a one, we must return false as we cannot trivially accept this line as a whole
                return false;
        }
        return true; //otherwise the line encoding is 0 throughout, and it can be draw as is.
    }

    private static boolean rejectLine(boolean[] c1, boolean[] c2){
        for(int i = 0; i < c1.length; i++){
            if(c1[i] && c2[i]) //if both codes of a particular area are true, than both points are too far to one side to create an intersection.
                return true;
        }
        return false;
    }

}
