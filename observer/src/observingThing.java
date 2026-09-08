public class observingThing implements observer{
    String txt;
    public observingThing(String txt) {
        this.txt = txt;
    }

    @Override
    public void update(int temp) {
        System.out.println(txt+", Temp rn: "+temp);
    }
}
