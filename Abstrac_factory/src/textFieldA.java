public class textFieldA extends textField{

    public textFieldA(String text) {
        super(text);
    }

    @Override
    void display() {
        System.out.println("(|"+getText()+"|)");
    }
}
