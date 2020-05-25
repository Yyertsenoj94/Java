package GraphicPrograms;
import java.awt.*;

public class fibonacci {

    public static void main(String[] args) {
        int frameSize = 800;
        int arcAngle = -180;
        int start = 0;
        int xCenter = frameSize / 2;
        int yCenter = frameSize / 2;
        DrawingPanel panel = new DrawingPanel(frameSize, frameSize);
        Graphics g = panel.getGraphics();
        int colorPicker = 0;
        Color color;

       int tempRadius;
       int prevRadius = 0;
       int currentRadius = 10;
       int nextRadius = 20;
        

        while(currentRadius < 200){
                //----SET COLOR-------------
                switch (colorPicker){
                    case 0:
                        color = Color.red;
                        break;
                    case 1:
                        color = Color.green;
                        break;
                    case 2:
                        color = Color.pink;
                        break;
                    default:
                        color = Color.blue;
                };
                g.setColor(color);
                //----SET COLOR-------------

                //----DRAW ARC--------------
                if(start == 0){
                    g.drawArc(xCenter - currentRadius, yCenter - currentRadius, currentRadius * 2, currentRadius * 2, start, arcAngle);
                    start = 180;
                }else{
                    g.drawArc(xCenter - prevRadius, yCenter - currentRadius, currentRadius * 2, currentRadius * 2, start, arcAngle);
                    start = 0;
                }


                prevRadius = currentRadius;
                currentRadius = nextRadius;
                nextRadius +=10;

                //end Fibonacci  calculation

                colorPicker++;
                if(colorPicker == 4)
                    colorPicker = 0;
                //----DRAW ARC--------------
        }
    }
}
