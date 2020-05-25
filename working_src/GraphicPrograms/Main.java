package GraphicPrograms;

import java.awt.*;

public class Main {

    public static void main(String[] args) {

        System.out.println("Test");
        int height = 400;
        int width = 500;

        DrawingPanel panel = new DrawingPanel(width, height);
        Graphics g = panel.getGraphics();

        int outRectWidth = width * 3 / 4;
        int outRectHeight = height * 3 / 4;
        int outRectX =  ((width) - (outRectWidth)) / 2;
        int outRectY = ((height) - (outRectHeight)) / 2;

        int inRectWidth = width / 2;
        int inRectHeight = height / 2;
        int inRectX = (width - inRectWidth) / 2;
        int inRectY = (height - inRectHeight) / 2;
        g.fillRect(inRectX, inRectY, inRectWidth, inRectHeight);
        g.setColor(Color.WHITE);
        g.drawString("Hello", 250, 200);
//        //draw outer rectangle
//        //does this need to be here?
//        g.drawRect(inRectX, inRectY, inRectWidth, inRectHeight);





    }
}
