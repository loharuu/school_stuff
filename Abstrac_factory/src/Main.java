public class Main {
    public static void main(String[] args) {
        UiFactory a = new AFactory();
        UiFactory b = new BFactory();


        button a_btn = a.createButton("button");
        button b_btn = b.createButton("buttonnottob");
        checkbox a_chb = a.createCheckbox("chekbok");
        checkbox b_chb = b.createCheckbox("bokchek");
        textField a_txt = a.createTextField("ext");
        textField b_txt = b.createTextField("extra extt");

        a_btn.display();
        a_chb.display();
        a_txt.display();
        System.out.println();
        b_btn.display();
        b_chb.display();
        b_txt.display();
        System.out.println();
        a_chb.setText("newtxt");
        b_txt.setText("newtxt~2");
        a_chb.display();
        b_txt.display();

    }
}