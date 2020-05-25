package GraphicPrograms;
import java.awt.*;
import java.util.Scanner;

public class ScreenSaver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input a text to display");
        String text = scanner.nextLine();

        int colorVariable = 0;
        DrawingPanel panel = new DrawingPanel(500, 500);
        Graphics g = panel.getGraphics();

        int red = 255;
        int green = 255;
        int blue = 255;

        Color newColor = new Color(red, green, blue);

        while (true) {
            int x = 500;
            int y = 500;
            while (x > 0 && y > 0) {

                g.setColor(Color.BLACK);
                g.fillRect(0, 0, 500, 500);
                g.setColor(new Color(red, green, blue));
                g.drawString(text.concat(" " + red + " " + green + " " + blue), x, y);

                if (red == 0) {
                    red = 255;
                }
                if (blue == 0) {
                    blue = 255;
                }
                if (green == 0) {
                    green = 255;
                }

                if (colorVariable == 0) {
                    red -= 5;
                } else if (colorVariable == 1) {
                    green -= 5;
                } else {
                    blue -= 5;
                }
                x--;
                y--;
                panel.sleep(50);
                colorVariable++;
                if(colorVariable > 2){
                    colorVariable = 0;
                }
            }
        }
    }
}
