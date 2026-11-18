import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class game extends Application {
    static int mapNumbr;
    static int x;
    static int y;
    /*private static game instance;

    public static synchronized game getInstance(){
        if(instance == null){
            instance = new game();
        }
        return instance;
    }*/


    public static map createMap(){
        switch (mapNumbr){
            case 1: return new cityMap(x, y);
            case 2: return new wildMap(x, y);
            default: throw new IllegalArgumentException("Unknown!");
        }
    }

    public static int getMapNumbr() {
        return mapNumbr;
    }

    public static void setMapNumbr(int mapNumbr) {
        game.mapNumbr = mapNumbr;
    }

    public static int getX() {
        return x;
    }

    public static void setX(int x) {
        game.x = x;
    }

    public static int getY() {
        return y;
    }

    public static void setY(int y) {
        game.y = y;
    }

    private static final int TILE_SIZE = 50;
    private final map map = game.createMap();
    private final int CANVAS_WIDTH = game.getX() * TILE_SIZE;
    private final int CANVAS_HEIGHT = game.getY() * TILE_SIZE;
    private Canvas canvas = new Canvas(CANVAS_WIDTH, CANVAS_HEIGHT);
    private GraphicsContext gc = canvas.getGraphicsContext2D();






    @Override
    public void start(Stage primaryStage) throws Exception {

        map.display();

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

