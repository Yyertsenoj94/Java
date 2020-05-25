package GraphicPrograms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Scanner;


public class test{

    public static final Scanner scanner = new Scanner(System.in);
    public static char key = '0';

    public static int[] pos = new int[2];
    public static int[] dir = new int[2];

    public static void main(String[] args) {
        DrawingPanel panel = new DrawingPanel(1000, 1000);

        int size = 50;
        int[] pos = new int[2];
        int[] dir = new int[2];

        pos[0] = 0;
        pos[1] = 0;
        dir[0] = 0;
        dir[0] = 0;


        Graphics g = panel.getGraphics();
        g.setColor(Color.black);
//        g.drawLine
        panel.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                move(panel, e.getKeyCode());
                show(panel, size);
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });


    }

    public static void move(DrawingPanel panel, int direction){
        switch (direction){
            case KeyEvent.VK_UP:
                pos[1] -=5;
                System.out.println("Up");
                break;
            case KeyEvent.VK_DOWN:
                pos[1] +=5;
                System.out.println("Down");
                break;
            case KeyEvent.VK_LEFT:
                pos[0] -=5;
                System.out.println("Left");
                break;
            case KeyEvent.VK_RIGHT:
                pos[0] +=5;
                System.out.println("Right");
                break;
            case KeyEvent.VK_Q:
               key = 'q';
               break;
            default:
                System.out.println("Nothing valid pressed");
        }
        Graphics g = panel.getGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, panel.getWidth(), panel.getHeight());
    }

    public static void show(DrawingPanel panel, int size){
        Graphics g = panel.getGraphics();
        g.setColor(Color.BLACK);
        g.fillOval(pos[0], pos[1], size, size);
    }
}


