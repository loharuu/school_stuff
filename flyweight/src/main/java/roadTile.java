import javafx.scene.image.Image;

public class roadTile implements tile {
    String character;
    String desc;
    String type;
    TileImage img;

    public roadTile(String character, String desc, String type, TileImage img) {
        this.character = character;
        this.desc = desc;
        this.type = type;
        this.img = img;
    }


    @Override
    public String getChar() {
        return character;
    }

    @Override
    public String getDesc() {
        return desc;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public void action() {
        System.out.println(character + "/" + desc);
    }

    @Override
    public TileImage getTileImage() {
        return img;
    }
}
