public class checkboxB extends checkbox{
    public checkboxB(String text) {
        super(text);
    }

    @Override
    void display() {
        System.out.println("[["+getText()+"]]");
    }
}
