package Test3D;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Window {

            private DrawingPanel panel;
            private Graphics graphics;
            private boolean[] keys = new boolean[1024];
            private int width;
            private int height;
            private int pointSize;
            private int centerX;
            private int centerY;
            private Color lineColor;
            private Color pointColor;
            private Color backgroundColor;

            public Window(int width, int height){
                this.width = width;
                this.height = height;
                panel = new DrawingPanel(width, height);
                graphics = panel.getGraphics();
                centerX = (int) (width / 2);
                centerY = (int) (height / 2);
                pointSize = 8;
                setLineColor(Color.WHITE);
                setBackgroundColor(Color.BLACK);
                initKeyListeners();
                for(boolean key: keys){
                    key = false; // initialize all values to false.
                }
            }

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

            public Graphics getGraphics(){
                return graphics;
            }

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

            public void drawXAxis(){
                initLineColor();
                graphics.drawLine(0, (height / 2), width, (height/2));
            }

            public void drawYAxis(){
                initLineColor();
                graphics.drawLine(width / 2, 0, width / 2, height);
            }

            public int getCenterX(){
                return centerX;
            }

            public int getCenterY(){
                return centerY;
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

            public boolean[] getKeys(){
                return keys;
            }

            public void close(){
                panel.close();
            }

            public void clearScreen(){
                graphics.setColor(backgroundColor);
                graphics.fillRect(0, 0, width, height);
                /*
                drawYAxis();
                drawXAxis();
                 */
            }

            public void pause(int milliseconds){
                panel.sleep(milliseconds);
            }

            public DrawingPanel getPanel(){
                return panel;
            }

            public void drawTriangle(Triangle triangle){
                int x1 = (int) (centerX + triangle.getVertices()[0].getX());
                int x2 = (int) (centerX + triangle.getVertices()[1].getX());
                int x3 = (int) (centerX + triangle.getVertices()[2].getX());
                int y1 = (int) (centerY - triangle.getVertices()[0].getY());
                int y2 = (int) (centerY - triangle.getVertices()[1].getY());
                int y3 = (int) (centerY - triangle.getVertices()[2].getY());
                initLineColor();
                graphics.drawLine(x1, y1, x2, y2);
                graphics.drawLine(x2, y2, x3, y3);
                graphics.drawLine(x3, y3, x1, y1);
            }

            private void initLineColor(){
                graphics.setColor(lineColor);
            }

            private void initPointColor(){
                graphics.setColor(pointColor);
            }

}
