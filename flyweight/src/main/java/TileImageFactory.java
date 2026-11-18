import java.util.HashMap;
import java.util.Map;

public class TileImageFactory {
    private static final Map<String, TileImage> images = new HashMap<>();
    public static TileImage getTileImage(String type){
        TileImage image = images.get(type);
        if(image == null){
            switch (type){
                case "building":
                    image = new TileImage("buildingTile.png");
                    break;
                case "forest":
                    image = new TileImage("forestTile.png");
                    break;
                case "road":
                    image = new TileImage("roadTile.png");
                    break;
                case "water":
                    image = new TileImage("waterTile.png");
                    break;
                case "swamp":
                    image = new TileImage("swampTile.png");
                    break;
            }
            images.put(type, image);
        }
        return image;
    }
}
