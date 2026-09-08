public class employee extends component{
    private double salary;
    public employee(String name, double salary) {
        super(name);
        this.salary = salary;
    }

    @Override
    public void add(component component) {
        throw new UnsupportedOperationException("Not supported");
    }

    @Override
    public void remove(component component) {
        throw new UnsupportedOperationException("Not supported");
    }

    @Override
    public component getChild(int index) {
        throw new UnsupportedOperationException("Not supported");
    }

    @Override
    public void printData() {
        System.out.println(getIndent() + "<employee>");
        indentlvl++;
        System.out.println(getIndent() + "<name>" + name + "</name>");
        System.out.println(getIndent() + "<salary>" + salary + "</salary>");
        indentlvl--;
        System.out.println(getIndent() + "</employee>");
    }
}
