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

            //WINDOW CENTER
            private int wCenterX;
            private int wCenterY;

            //VIEWPORT DIMENSIONS
            private int viewPortXMin;
            private int viewPortXMax;
            private int viewPortYMax;
            private int viewPortYMin;
            private int viewPortWidth;
            private int viewPortHeight;

            //CENTER OF VIEWPORT
            private int vCenterX;
            private int vCenterY;

            //DIMENSION FOR POINT CIRCLE
            private int pointSize;

            //COLORS
            private Color lineColor;
            private Color pointColor;
            private Color backgroundColor;

            public Window(int width, int height){
                this.windowWidth = width;
                this.windowHeight = height;
                this.wCenterX = width / 2;
                this.wCenterY = height / 2;

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
                    viewPortYMax = (viewPortYMin + viewPortHeight);

                    setViewCenter();
                    refreshViewPort();
            }

            public void shiftViewPort(int x, int y){
                /*--------------Restrict the amount of shift to window boundaries--------------*/
                if(x < 0){
                    if(viewPortXMin + x < getXWMin())
                        x = viewPortXMin - getXWMin();
                }else{
                    if(viewPortXMax + x > getXWMax())
                        x = getXWMax() - viewPortXMax;
                }

                if (y < 0) {
                    if(viewPortYMin + y < getYWMin())
                        y = viewPortYMin - getYWMin();
                }else{
                    if(viewPortYMax + y > getYWMax())
                        y = getYWMax() - viewPortYMax;
                }
                /*------------------------------------------------*/

                /* Shift viewport */
                viewPortXMin += x;
                viewPortXMax += x;
                viewPortYMin -= y;
                viewPortYMax -= y;
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
                this.vCenterX = (viewPortXMax + viewPortXMin) / 2;
                this.vCenterY = (viewPortYMax + viewPortYMin) / 2;
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
                int x = vCenterX + ((int) point[0]) - pointSize / 2;
                int y = vCenterY - ((int) point[1]) - pointSize / 2;
                int size = pointSize;
                initPointColor();
                graphics.fillOval(x, y, size, size);
            }

            public void drawPoint(Point point){
                double[] p = {point.getX(), point.getY()};
                drawPoint(p);
            }

            public void drawPoint(Vector3D v){
                double[] p = {v.getX(), v.getY()};
                drawPoint(p);
            }

            public void drawLine(double x1, double y1, double x2, double y2){
                initLineColor();
                int X1 = vCenterX + (int) x1;
                int X2 = vCenterX + (int) x2;
                int Y1 = vCenterY - (int) y1;
                int Y2 = vCenterY - (int) y2;
                graphics.drawLine(X1, Y1, X2, Y2);
            }

            public void drawLine(LineSegment s){
                drawLine(s.getX1(), s.getY1(), s.getX2(), s.getY2());
            }

            public void drawXAxis(){
                initLineColor();
                graphics.drawLine(viewPortXMin, vCenterY, viewPortXMax, vCenterY);
            }

            public void drawYAxis(){
                initLineColor();
                graphics.drawLine(vCenterX, viewPortYMax, vCenterX, viewPortYMin);
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

            public int getWCenterX(){
                return wCenterX;
            }

            public int getWCenterY(){
                return wCenterY;
            }

            public int getVCenterX(){
                return vCenterX;
            }

            public int getVCenterY(){
                return vCenterY;
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
