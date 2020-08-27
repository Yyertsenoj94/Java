package Test3D;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Window {
            //Java panel and graphics
            private DrawingPanel panel;
            private Graphics graphics;

            //KEY ARRAY FOR KEY STROKES
            private boolean[] keys = new boolean[1024];

            //WINDOW DIMENSIONS
            private int windowWidth;
            private int windowHeight;

            //VIEWPORT DIMENSIONS
            private int viewPortXMin;
            private int viewPortXMax;
            private int viewPortYMax;
            private int viewPortYMin;
            private int viewPortWidth;
            private int viewPortHeight;

            //CENTER OF VIEWPORT
            private int centerX;
            private int centerY;

            //DIMENSION FOR POINT CIRCLE
            private int pointSize;

            //COLORS
            private Color lineColor;
            private Color pointColor;
            private Color backgroundColor;

            public Window(int width, int height){
                this.windowWidth = width;
                this.windowHeight = height;

                panel = new DrawingPanel(width, height);
                graphics = panel.getGraphics();

                setViewPort(width, height);
                setViewCenter();
                setPointSize(8);
                setLineColor(Color.WHITE);
                setBackgroundColor(Color.BLACK);
                initKeyListeners();
                initKeys();


            }


            // VIEWPORT FUNCTIONS
            public void setViewPort(int width, int height){
                    if(width > windowWidth) {
                        viewPortWidth = windowWidth; //prevent larger viewport
                    }else{
                        viewPortWidth = width;
                    }

                    if(height > windowHeight) {
                        viewPortHeight = windowHeight;
                    }else{
                        viewPortHeight = height;
                    }
                    viewPortXMin = (windowWidth - width) / 2;
                    viewPortXMax = viewPortXMin + viewPortWidth;

                    viewPortYMin = (windowHeight - height) / 2;
                    viewPortYMax = (viewPortYMin + height);

                    setViewCenter();
                    refreshViewPort();
            }

            public void drawViewPortFrame(){
                initLineColor();
                graphics.drawLine(viewPortXMin, viewPortYMin, viewPortXMax, viewPortYMin); //draw top;
                graphics.drawLine(viewPortXMin, viewPortYMax, viewPortXMax, viewPortYMax); //draw bottom
                graphics.drawLine(viewPortXMin, viewPortYMin, viewPortXMin, viewPortYMax); //draw left;
                graphics.drawLine(viewPortXMax, viewPortYMin, viewPortXMax, viewPortYMax); //draw right;
            }

            private void setViewCenter(){
                this.centerX = (viewPortXMax + viewPortXMin) / 2;
                this.centerY = (viewPortYMax + viewPortYMin) / 2;
            }

            private void refreshViewPort(){
                drawViewPortFrame();
                drawXAxis();
                drawYAxis();
            }


            //SETTERS FOR DRAWING
            public void setBackgroundColor(Color color){
        this.backgroundColor = color;
        clearScreen();
    }

            public void setLineColor(Color color){
                this.lineColor = color;
            }

            public void setPointColor(Color color){
                this.pointColor = color;
            }

            public void setPointSize(int size){
                this.pointSize = size;
            }


           //DRAW FUNCTIONS
            public void drawPoint(double[] point){
                int x = centerX + ((int) point[0]) - pointSize / 2;
                int y = centerY - ((int) point[1]) - pointSize / 2;
                int size = pointSize;
                initPointColor();
                graphics.fillOval(x, y, size, size);
            }

            public void drawPoint(Point2D point){
                double[] p = {point.getX(), point.getY()};
                drawPoint(p);
            }

            public void drawPoint(Vector3D v){
                double[] p = {v.getX(), v.getY()};
                drawPoint(p);
            }

            public void drawLine(double x1, double y1, double x2, double y2){
                initLineColor();
                int X1 = centerX + (int) x1;
                int X2 = centerX + (int) x2;
                int Y1 = centerY - (int) y1;
                int Y2 = centerY - (int) y2;
                graphics.drawLine(X1, Y1, X2, Y2);
            }

            public void drawLine(LineSegment s){
                drawLine(s.getX1(), s.getY1(), s.getX2(), s.getY2());
            }

            public void drawXAxis(){
                initLineColor();
                graphics.drawLine(viewPortXMin, centerY, viewPortXMax, centerY);
            }

            public void drawYAxis(){
                initLineColor();
                graphics.drawLine(centerX, viewPortYMax, centerX, viewPortYMin);
            }


            //INITIALIZERS FOR DRAWING
            private void initLineColor(){
        graphics.setColor(lineColor);
    }

            private void initPointColor(){
                graphics.setColor(pointColor);
            }

            private void initKeyListeners(){
                  panel.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                //DO NOTHING
            }

            @Override
            public void keyPressed(KeyEvent e) {
                keys[e.getKeyCode()] = true;
            }

            @Override
            public void keyReleased(KeyEvent e) {
                keys[e.getKeyCode()] = false;
            }
        });
            }

            private void initKeys(){
                for(boolean key: keys){
                    key = false; // initialize all values to false.
                }
            }




            //GETTERS
            public int getXVMin(){
               return viewPortXMin;
            }

            public int getXVMax(){
                return viewPortXMax;
            }

            public int getYVMax(){
                return viewPortYMax;
            }

            public int getYVMin(){
                return viewPortYMin;
            }

            public int getXWMin(){
                return 0;
            }

            public int getXWMax(){
                return windowWidth;
            }

            public int getYWMin(){
                return 0;
            }

            public int getYWMax(){
                return windowHeight;
            }

            public int getCenterX(){
                return centerX;
            }

            public int getCenterY(){
                return centerY;
            }

            public int getPointSize(){
                return pointSize;
            }

            public boolean[] getKeys(){
                return keys;
            }



            //OTHER WINDOW FUNCTIONS
            public void pause(int milliseconds){
                panel.sleep(milliseconds);
            }

            public void close(){
                panel.close();
            }

            public void clearScreen(){
                graphics.setColor(backgroundColor);
                graphics.fillRect(0, 0, windowWidth, windowHeight);
                refreshViewPort();
            }

}
