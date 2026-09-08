public class buttonB extends button{

    public buttonB(String text) {
        super(text);
    }

    @Override
    void display() {
        System.out.println("["+getText()+"]");
    }
}
