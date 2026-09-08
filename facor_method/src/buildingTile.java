public class buildingTile implements tile{
    String charecter;
    String desc;
    String type;

    public buildingTile(String charecter, String desc, String type) {
        this.charecter = charecter;
        this.desc = desc;
        this.type = type;
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
}
