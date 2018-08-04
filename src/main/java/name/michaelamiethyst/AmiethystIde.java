package name.michaelamiethyst;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;
import name.michaelamiethyst.shapes.Bubble;

/**
 * Stub 2d Canvas API calls from Oracle Docs.
 *
 * @see <a href="https://docs.oracle.com/javafx/2/canvas/jfxpub-canvas.htm">Canvas Tutorial</a>
 */
public class AmiethystIde extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // prepare canvas
        Canvas canvas = new Canvas(300, 250);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        drawShapes(gc);

        // put canvas into group
        Group root = new Group();
        root.getChildren().add(canvas);

        // prepare stage
        primaryStage.setTitle("Drawing Operations Test");
        // wrap Group root into a scene and add to stage
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    private void drawShapes(GraphicsContext gc) {
        // prep palette
        gc.setFill(Color.GREEN);
        gc.setStroke(Color.BLUE);

        // draw line as a slash '/'
        gc.setLineWidth(5);
        gc.strokeLine(40, 10, 10, 40);

        // draw circles
        gc.fillOval(10, 60, 30, 30);
        gc.strokeOval(60, 60, 30, 30);

        // draw rectangles with rounded corners -- very snazzy
        new Bubble().atUpperLeftPoint(new Point(110, 60)).asSquare(30);
        gc.fillRoundRect(110, 60, 30, 30, 10, 10);
        //gc.strokeRoundRect(160, 60, 30, 30, 10, 10);

        // draw two rows of pac-mans
        gc.fillArc(10, 110, 30, 30, 45, 240, ArcType.OPEN);
        gc.fillArc(60, 110, 30, 30, 45, 240, ArcType.CHORD);
        gc.fillArc(110, 110, 30, 30, 45, 240, ArcType.ROUND);
        gc.strokeArc(10, 160, 30, 30, 45, 240, ArcType.OPEN);
        gc.strokeArc(60, 160, 30, 30, 45, 240, ArcType.CHORD);
        gc.strokeArc(110, 160, 30, 30, 45, 240, ArcType.ROUND);

        // draw two hour-glass shapes as four points that criss-cross each other
        gc.fillPolygon(new double[]{10, 40, 10, 40},
                new double[]{210, 210, 240, 240}, 4);
        gc.strokePolygon(new double[]{60, 90, 60, 90},
                new double[]{210, 210, 240, 240}, 4);
        // draw 'Z' shape manually as series of four points
        gc.strokePolyline(new double[]{110, 140, 110, 140},
                new double[]{210, 210, 240, 240}, 4);
    }
}
