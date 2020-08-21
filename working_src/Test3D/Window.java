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
            private Color drawColor;
            private Color backgroundColor;

            public Window(int width, int height){
                this.width = width;
                this.height = height;
                panel = new DrawingPanel(width, height);
                graphics = panel.getGraphics();
                centerX = (int) (width / 2);
                centerY = (int) (height / 2);
                pointSize = 8;
                setDrawColor(Color.WHITE);
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
            public void setDrawColor(Color color){
                this.drawColor = color;
            }

            public void setPointSize(int size){
                this.pointSize = size;
            }
            public Graphics getGraphics(){
                return graphics;
            }
            public void drawPoint2D(double[] point){
                graphics.setColor(drawColor);
                graphics.fillOval((int) (centerX + point[0] - (pointSize / 2)), (int) (centerY - point[1] - (pointSize / 2)), (int) pointSize, (int) pointSize);
            }

            public void drawXAxis(){
                initDrawColor();
                graphics.drawLine(0, (height / 2), width, (height/2));
            }

            public void drawYAxis(){
                initDrawColor();
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
                int x1 = (int) (centerX + triangle.getVertices()[0][0]);
                int x2 = (int) (centerX + triangle.getVertices()[1][0]);
                int x3 = (int) (centerX + triangle.getVertices()[2][0]);
                int y1 = (int) (centerY - triangle.getVertices()[0][1]);
                int y2 = (int) (centerY - triangle.getVertices()[1][1]);
                int y3 = (int) (centerY - triangle.getVertices()[2][1]);
                initDrawColor();
                graphics.drawLine(x1, y1, x2, y2);
                graphics.drawLine(x2, y2, x3, y3);
                graphics.drawLine(x3, y3, x1, y1);
            }

            private void initDrawColor(){
                graphics.setColor(drawColor);
            }


}
