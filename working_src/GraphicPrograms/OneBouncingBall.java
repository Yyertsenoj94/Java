package GraphicPrograms;
/*
Author: Trey Jones
Author: Trey Jones
Date: 4/22/2020
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

public class OneBouncingBall {
    public static final Scanner CONSOLE = new Scanner(System.in);
    public static final Random RAND = new Random();

    public static void main(String[] args) {
        System.out.println("UTSA - Spring 2020 - CS1083 - Section 002 - Project 3 - written by Trey Jones");

        //========VARIABLE SETUP========//
        int windowWidth = 0; //TODO assign to 0 later
        int windowHeight = 0; //TODO assign to 0 later
        int ballSize = 0; //TODO assign to 0 later
        int bounceNumber = 0; //TODO assign to 0 later
        int speed = 0;
        int trace = -1;
        int bounceCounter = 0; //initialize for the bounce routine
        boolean itBounced = false; //initialize for the bounce routine

        //begin taking input from user.
        while(windowWidth % 100 != 0 || windowWidth > 500 || windowWidth < 300){
            System.out.print("What is the width of the window? (Multiple of 100, Max 500, Min 300)");
            windowWidth = CONSOLE.nextInt();
            System.out.println();
        }

        while(windowHeight % 100 != 0 || windowHeight < 300 | windowHeight > 700){
            System.out.print("What is the height of the window? (Multiple of 100, Max 700, Min 300)");
            windowHeight = CONSOLE.nextInt();
            System.out.println();
        }

        while(ballSize < 10 || ballSize > 50 || ballSize % 10 != 0){
            System.out.print("What's the ball size? (Multiple of 10, Max 50, Min 10)");
            ballSize = CONSOLE.nextInt();
            System.out.println();
        }

        while(bounceNumber < 10 || bounceNumber > 100){
            System.out.print("What's the expected number of bounces? (Max 100, Min 10)");
            bounceNumber = CONSOLE.nextInt();
            System.out.println();
        }

        while(speed < 1 || speed > 10){
            System.out.print("At what speed do you want it to be played? (Max 10, Min 1");
            speed = CONSOLE.nextInt();
            System.out.println();
        }

        while(trace < 0 || trace > 1){
            System.out.print("Do you want to leave the trace? (0 - No, 1 - Yes)");
            trace = CONSOLE.nextInt();
            System.out.println();
        }

        //declare and initialize colors
        Color[] colors = {Color.red, Color.green, Color.blue, Color.yellow, Color.pink,
                Color.ORANGE, Color.black, Color.gray, Color.magenta, Color.cyan};

        //declare and initialize ball position and direction
        int[] ballDirection = new int[2];
        int[] ballPosition = new int[2];


        DrawingPanel panel = new DrawingPanel(windowWidth, windowHeight);

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

            panel.sleep(100 - speed / 2);
        }

    }

    //initial function for randomizing the position, direction, and assigning a color.
    public static Color randomPlaceBall(DrawingPanel panel, int[] pos, int[] direction, int size, Color[] colors){
        int randomColor = RAND.nextInt(colors.length-1);
        int xRange = panel.getWidth() / size;
        int yRange = panel.getHeight() / size;

        //assign random integer times the size of the ball to obtain a valid window for the ball to start:
        pos[0] = RAND.nextInt(xRange) * size;
        pos[1] = RAND.nextInt(yRange) * size;

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
            //the following clears the screen to prevent tracing.
            g.setColor(Color.WHITE);
            g.fillRect(0, 0, panel.getWidth(), panel.getHeight());
        }else{
            //the following code allows for blinking across existing circles to see overlap movement.
            g.setColor(Color.WHITE);
            g.fillOval(pos[0], pos[1] , size, size);
            panel.sleep(40);
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

        //determine if collision occurred on X axis.
        if(direction[0] == 1){//ball was traveling right
            if(pos[0] + size > panel.getWidth() - size){//will collide with beginning edge
                bounced = true;
                direction[0] = -1; //switch direction
            }
        }else{//ball was travelling right
            if(pos[0] - size < 0){ //will collide with end edge
                bounced = true;
                direction[0] = 1; //switch directions
            }
        }

        //determine if collision occurred on the Y axis.
        if(direction[1] == -1){//ball was traveling up
            if(pos[1] - size < 0){//will collide with top edge
                bounced = true;
                direction[1] = 1; //switch direction
            }
        }else{//ball was travelling down
            if(pos[1] + size > panel.getHeight() - size){ //will collide with bottom edge
                bounced = true;
                direction[1] = -1; //switch directions
            }
        }

        //increment the x coordinate in the direction travelling
        if(direction[0] == 1){
            pos[0] += size;
        }else{
            pos[0] -= size;
        }

        //increment the y coordinate in the direction travelling
        if(direction[1] == 1){
            pos[1] += size;
        }else{
            pos[1] -= size;
        }

        return bounced;
    }

}
