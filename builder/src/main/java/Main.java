public class Main {
    public static void main(String[] args) {
        computerDirector gamingDirector = new computerDirector(new gamingComputerBuilder());
        computerDirector officeDirector = new computerDirector(new officeComputerBuilder());

        gamingDirector.constructComputer();
        officeDirector.constructComputer();

        gamingDirector.printComputer();
        officeDirector.printComputer();
    }
}
