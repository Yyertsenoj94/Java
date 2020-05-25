package GraphicPrograms;
/*
Author: Trey Jones
Date: 4/21/2020
The purpose of the program is to animate a
ball bouncing withing a frame for a given
number of iterations. the ball will be randomly placed
and will not be allowed to go outside the bounds of the frame
at any given time. The color of the ball will be random. The user
will also specify the window frame, ball size, the speed of the ball
and whether or not the ball will leave a trace behind.
 */
import java.util.Scanner;
import java.awt.*;
import java.util.Random;

public class myBouncingBall {
    public static final Scanner CONSOLE = new Scanner(System.in);
    public static final Random RAND = new Random();

    public static void main(String[] args) {
        System.out.println("UTSA - Spring 2020 - CS1083 - Section 002 - Project 3 - written by Trey Jones");

        //========VARIABLE SETUP========//
        int windowWidth = 400; //TODO assign to 0 later
        int windowHeight = 500; //TODO assign to 0 later
        int ballSize = 25; //TODO assign to 0 later
        int bounceNumber = 100; //TODO assign to 0 later
        int speed = 0; //TODO assign to 0 later
        int trace = 0; //TODO initialize to -1 to cause input loop to occur
        int bounceCounter = 0; //initialize for the bounce routine
        boolean itBounced = false; //initialize for the bounce routine

        //declare and initialize colors
        Color[] colors = {Color.red, Color.green, Color.blue, Color.yellow, Color.pink,
                Color.ORANGE, Color.black, Color.gray, Color.magenta, Color.cyan};

        //declare and initialize ball position and direction
        int[] ballDirection = new int[2];
        int[] ballPosition = new int[2];


        DrawingPanel panel = new DrawingPanel(windowWidth, windowHeight);

        //DELETE THIS LATER
        Graphics g = panel.getGraphics(); //DELETE THIS LATER
        g.setColor(Color.black); //DELETE THIS LATER
        g.fillRect(0, 0, panel.getWidth(), panel.getHeight());

        //set initial position, direction, and assign color prior to starting loop.
        Color assignedColor = randomPlaceBall(panel, ballPosition, ballDirection, ballSize, colors);
        System.out.println("Bounces: " + bounceCounter);
        while(bounceCounter < bounceNumber){

            showBall(panel, ballPosition, ballSize, assignedColor, trace);


            itBounced = moveBall(panel, ballPosition, ballDirection, ballSize);

            if(itBounced){
                bounceCounter++;
                System.out.println("Bounces: " + bounceCounter);
            }

            panel.sleep(1);
        }

    }

    //initial function for randomizing the position, direction, and assigning a color.
    public static Color randomPlaceBall(DrawingPanel panel, int[] pos, int[] direction, int size, Color[] colors){
        int randomColor = RAND.nextInt(colors.length-1);

        //assign random integer between restraints of the window to obtain starting ball position
        pos[0] = RAND.nextInt(panel.getWidth() - size) + 1;
        pos[1] = RAND.nextInt(panel.getHeight() - size) + 1;

        //assign valid random direction for starting out the bounce routine
        while(direction[0] == 0){
            direction[0] = RAND.nextInt(3) - 1;
        }
        while(direction[1] == 0){
            direction[1] = RAND.nextInt(3) - 1;
        }

        return colors[randomColor];
    }

    /*the following method shows the ball in the current position with it's color, and will
    include trace if required.
     */
    public static void showBall(DrawingPanel panel, int[] pos, int size, Color color, int trace){
        Graphics g = panel.getGraphics();
        if(trace == 0){
            g.setColor(Color.black);
            g.fillRect(0, 0, panel.getWidth(), panel.getHeight());
        }

        g.setColor(color);
        g.fillOval(pos[0], pos[1] , size, size);
    }

    /*the following method will check for ball bounce and then move the ball.
       I check the ball location first to prevent movement out of bounds. if ball is touching a side
       then I change it's direction as needed.
       Then after checking or changing direction, the ball will move again in the current direction (or new
       direction if it bounced)
     */
    public static boolean moveBall(DrawingPanel panel, int[] pos, int[] direction, int size){
        boolean bounced = false;

        //the following two if statements evaluate whether the ball is bouncing at the current moment
        if((pos[0] == (panel.getWidth() - size)) || (pos[0] == 0)){//collision on x coordinate limits, need to change direction
            bounced = true;
            if(direction[0] == 1){
                direction[0] = -1;
            }else{
                direction[0] = 1;
            }
        }
        if((pos[1] == (panel.getHeight() - size)) || (pos[1] == 0)){//collision on y coordinate limits, need to change direction
            bounced = true;
            if(direction[1] == 1){
                direction[1] = -1;
            }else{
                direction[1] = 1;
            }
        }

        //move to next position
        if(direction[0] == 1){
            pos[0]++;//increment x coordinate if travelling right
        }else{
            pos[0]--;//else decrement if travelling left
        }

        if(direction[1] == 1){
            pos[1]++;//increment y if travelling up
        }else{
            pos[1]--;//else decrement if travelling down
        }

        return bounced;
    }


}

