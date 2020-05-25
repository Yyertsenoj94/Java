package GraphicPrograms;
import java.awt.*;
public class TestTest {

    public static DrawingPanel dp = new DrawingPanel(400, 400);

    public static void main(String[] args){
            drawCircleSquare(dp.getGraphics(), 100, 100);
    }

    public static void drawCircleSquare(Graphics g, int width, int height){
        int x = (dp.getWidth() / 2) - width/2;
        int y = (dp.getWidth() / 2) - height/2;
        g.setColor(Color.BLACK);
        g.drawRect(x, y, width, height);
        g.setColor(Color.BLUE);
        g.drawOval(x, y, width, height);
        
    }

}