package name.michaelamiethyst.shapes;

import javafx.scene.canvas.GraphicsContext;

public class Bubble {
    GraphicsContext gc;
    private Point upperLeftCorner;

    private int width;
    private int height;

    public Bubble(GraphicsContext paintToThis) {
        gc = paintToThis;
    }

    public Bubble atUpperLeftCorner(Point point) {
        upperLeftCorner = point;
        return this;
    }

    public Bubble asSquare(int widthAndHeight) {
        width = widthAndHeight;
        height = widthAndHeight;
        return this;
    }

    public Bubble paint() {
        gc.fillRoundRect(upperLeftCorner.x, upperLeftCorner.y, width, height, 10, 10);
        return this;
    }
}
