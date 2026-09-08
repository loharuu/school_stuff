public class BFactory extends UiFactory{
    @Override
    public button createButton(String text) {
        return new buttonB(text);
    }

    @Override
    public checkbox createCheckbox(String text) {
        return new checkboxB(text);
    }

    @Override
    public textField createTextField(String text) {
        return new textFieldB(text);
    }
}
