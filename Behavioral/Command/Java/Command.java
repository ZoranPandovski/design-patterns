public abstract class Command {

    protected TextField savedTextField;
    protected String savedText;

    public final void saveAndExecute(TextField textField) {
        this.savedTextField = textField;
        this.savedText = textField.getText();

        execute(textField);
        print("Executed");
    }

    public void undo() {
        savedTextField.setText(savedText);
        print("Undone");
    }

    public void redo() {
        execute(savedTextField);
        print("Redone");
    }

    private void print(String action) {
        System.out.println(action + ": \"" + this + "\", result: \"" + savedTextField + "\"");
    }

    public abstract void execute(TextField textField);
}