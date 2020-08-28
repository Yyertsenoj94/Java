package Test3D;

public class Polygon2DTest {

    public static void main(String[] args) {
        Window window = new Window(800, 800);
        window.setViewPort(300, 300);
        System.out.println("Viewport x Min: " + window.getXVMin());
        System.out.println("Viewport x Max: " + window.getXVMax());
        System.out.println("Viewport y Min: " + window.getYVMin());
        System.out.println("Viewport y Max: " + window.getYVMax());

        window.clearScreen();

        Vector2D[] points = {
                new Vector2D(0.0f, 0.0f),
                new Vector2D(20.0f, 0.0f),
                new Vector2D(20.0f, 20.0f),
                /*
                new Vector2D(10.0f, -20.0f),
                new Vector2D(5.0f, -40.0f),
                new Vector2D(-5.0f, -59.0f),
                new Vector2D(-10.0f, -0.0f),
                new Vector2D(-20.0f, 20.0f),
                 */
        };

        Polygon2D p = new Polygon2D(points);

        p.scalePolygon(10);


        Functions.bindWindow(window);
        Functions.drawPolygon2D(p);
    }
}
