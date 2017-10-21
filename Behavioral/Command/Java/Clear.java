public class Clear extends Command {

    @Override
    public void execute(TextField textField) {
        textField.setText(null);
    }

    @Override
    public String toString() {
        return "Clear";
    }
}