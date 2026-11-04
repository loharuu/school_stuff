public class proxyDoc implements document{
    private int id;
    private String dateOfCreation;
    private String cont;
    private openDoc openDoc;

    public proxyDoc(int id, String doc, String cont){
        this.id = id;
        this.dateOfCreation = doc;
        this.cont = cont;
        this.openDoc = new openDoc(id, doc, cont);
    }

    @Override
    public int getID() {
        return id;
    }

    @Override
    public String getDateOfCreation() {
        return dateOfCreation;
    }

    @Override
    public String getContent(user user) {
        acs asc = acs.getInstance();
        if(asc.isAllowed(user.getUser(), id)){
            return openDoc.getContent(user);
        }
        return "DENIED";
    }
}
