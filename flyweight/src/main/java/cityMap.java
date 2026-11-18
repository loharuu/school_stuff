import java.util.Random;

public class cityMap extends map{

    public cityMap(int x, int y) {
        super(x,y);
    }

    tile createTile() {
        int r = new Random().nextInt(3);
        return switch (r) {
            case (0) -> new roadTile("R", "", "road", TileImageFactory.getTileImage("road"));
            case (1) -> new buildingTile("B", "", "building",TileImageFactory.getTileImage("building"));
            default -> new forestTile("F", "", "forest",TileImageFactory.getTileImage("forest"));
        };
    }
}
