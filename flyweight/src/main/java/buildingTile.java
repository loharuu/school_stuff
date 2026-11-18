public class buildingTile implements tile{
    String charecter;
    String desc;
    String type;
    TileImage img;

    public buildingTile(String charecter, String desc, String type, TileImage img) {
        this.charecter = charecter;
        this.desc = desc;
        this.type = type;
        this.img = img;
    }

    @Override
    public String getChar() {
        return charecter;
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
