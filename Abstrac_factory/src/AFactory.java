public class AFactory extends UiFactory{
    @Override
    public button createButton(String text) {
        return new buttonA(text);
    }

    @Override
    public checkbox createCheckbox(String text) {
        return new checkboxA(text);
    }

    @Override
    public textField createTextField(String text) {
        return new textFieldA(text);
    }
}
