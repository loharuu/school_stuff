public class openDoc implements document{
    private int id;
    private String dateOfCreation;
    private String cont;

    public openDoc(int id, String doc, String cont){
        this.id = id;
        this.dateOfCreation = doc;
        this.cont = cont;
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
        return cont;
    }
}
