public class UpperCase extends Command {

    @Override
    public void execute(TextField textField) {
        if (textField.getText() != null) {
            textField.setText(textField.getText().toUpperCase());
        }
    }

    @Override
    public String toString() {
        return "Upper case";
    }
}