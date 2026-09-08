public class buttonA extends button{

    public buttonA(String text) {
        super(text);
    }

    @Override
    void display() {
        System.out.println("("+getText()+")");
    }
}
