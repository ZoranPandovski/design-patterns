public class LowerCase extends Command {

    @Override
    public void execute(TextField textField) {
        if (textField.getText() != null) {
            textField.setText(textField.getText().toLowerCase());
        }
    }

    @Override
    public String toString() {
        return "Lower case";
    }
}