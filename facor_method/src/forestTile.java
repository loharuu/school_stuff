public class forestTile implements tile{
    String character;
    String desc;
    String type;

    public forestTile(String character, String desc, String type) {
        this.character = character;
        this.desc = desc;
        this.type = type;
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
}
