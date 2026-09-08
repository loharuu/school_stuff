public class textFieldB extends textField{

    public textFieldB(String text) {
        super(text);
    }

    @Override
    void display() {
        System.out.println("[|"+getText()+"|]");
    }
}
