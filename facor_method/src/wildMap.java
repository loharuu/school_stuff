import java.util.Random;

public class wildMap extends map{

    public wildMap(int x, int y) {
        super(x,y);
    }

    tile createTile() {
        int r = new Random().nextInt(3);
        return switch (r) {
            case (0) -> new waterTile("W", "", "water");
            case (1) -> new swampTile("S", "", "swamp");
            default -> new forestTile("F", "", "forest");
        };
    }
}