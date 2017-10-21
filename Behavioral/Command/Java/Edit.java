public class Edit extends Command {

    private final String value;

    public Edit(String value) {
        this.value = value;
    }

    @Override
    public void execute(TextField textField) {
        textField.setText(value);
    }

    @Override
    public String toString() {
        return "Edit text";
    }
}