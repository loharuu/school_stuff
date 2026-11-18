import javafx.scene.image.Image;

public interface tile {
    String getChar();
    String getDesc();
    String getType();
    void action();

    TileImage getTileImage();
}
