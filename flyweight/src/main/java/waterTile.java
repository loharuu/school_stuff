public class waterTile implements tile{
    String character;
    String desc;
    String type;
    TileImage img;

    public waterTile(String character, String desc, String type, TileImage img) {
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

    }

    @Override
    public TileImage getTileImage() {
        return img;
    }
}
