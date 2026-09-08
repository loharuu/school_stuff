import java.util.ArrayList;

public class depo extends component{
    private ArrayList<component> childs = new ArrayList<>();

    public depo(String name) {
        super(name);
    }

    @Override
    public void add(component component) {
        this.childs.add(component);
    }

    @Override
    public void remove(component component) {
        this.childs.remove(component);
    }

    @Override
    public component getChild(int i) {
        return this.childs.get(i);
    }
    @Override
    public void printData(){
        System.out.println(getIndent() + "<department name=\"" + name + "\">");
        indentlvl++;
        for(component child: this.childs){
            child.printData();
        }
        indentlvl--;
        System.out.println(getIndent() + "</department>");
    }
}
