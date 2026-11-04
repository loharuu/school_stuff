import java.util.HashMap;

public class library {
    HashMap<Integer, document> document = new HashMap<>();
    public void addDoc(int id, document doc){
        document.put(id, doc);
    }
    public void createDoc(int id, String doc, String cont){
        document docu = new openDoc(id, doc, cont);
        addDoc(id, docu);
    }
    public void createProxyDoc(int id, String doc, String cont){
        document docu = new proxyDoc(id, doc, cont);
        addDoc(id, docu);
    }
    public document getDoc(int id){
        return document.get(id);
    }
}
