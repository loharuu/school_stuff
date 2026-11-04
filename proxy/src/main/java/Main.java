public class Main {
    public static void main(String[] args) {
        library lib = new library();
        lib.createDoc(1,"0001","How to rule the world using peasants");
        lib.createProxyDoc(2, "2030", "How to rule the world using AI");

        acs asc = acs.getInstance();

        user u1 = new user("nobody");
        user u2 = new user("important");

        asc.addToValid(u2.getUser(), 2);

        System.out.println(lib.getDoc(1).getContent(u2));
        System.out.println(lib.getDoc(2).getContent(u1));
        System.out.println(lib.getDoc(2).getContent(u2));


    }
}
