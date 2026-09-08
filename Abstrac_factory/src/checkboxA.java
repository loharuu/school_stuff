public class checkboxA extends checkbox{
    public checkboxA(String text) {
        super(text);
    }

    @Override
    void display() {
        System.out.println("(("+getText()+"))");
    }
}
