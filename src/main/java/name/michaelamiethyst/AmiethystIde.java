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
import name.michaelamiethyst.shapes.Point;

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
        primaryStage.setTitle("Amiethyst IDE");
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


        // draw rectangles with rounded corners -- very snazzy
        new Bubble(gc).atUpperLeftCorner(new Point(110, 60)).asSquare(30).paint();
    }
}
