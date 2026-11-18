import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Scene;

import java.util.Random;

public class MapView extends Application {

    private static final int TILE_SIZE = 50;
    private final map map = game.createMap();
    private final int CANVAS_WIDTH = game.getX() * TILE_SIZE;
    private final int CANVAS_HEIGHT = game.getY() * TILE_SIZE;
    private Canvas canvas = new Canvas(CANVAS_WIDTH, CANVAS_HEIGHT);
    private GraphicsContext gc = canvas.getGraphicsContext2D();






    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Flyweight map");

        StackPane root = new StackPane();
        root.getChildren().add(canvas);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

        drawTiles();
    }

    private void drawTiles() {
        gc.clearRect(0, 0, CANVAS_WIDTH, CANVAS_HEIGHT);
        for (int i = 0; i < map.getX(); i++) {
            for (int j = 0; j < map.getY(); j++) {
                Image imageToDraw = map.getTileImage(i, j);
                gc.drawImage(imageToDraw, j * TILE_SIZE, i * TILE_SIZE, TILE_SIZE, TILE_SIZE);
            }
        }
    }




    public static void main(String[] args) {
        launch(args);
    }
}
