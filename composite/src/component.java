public abstract class component {
    protected String name;
    protected static int indentlvl = 0;

    public component(String name) {
        this.name = name;
    }

    protected String getIndent() {
        return "  ".repeat(indentlvl);
    }

    public abstract void add(component component);
    public abstract void remove(component component);
    public abstract component getChild(int index);
    public abstract void printData();
}
