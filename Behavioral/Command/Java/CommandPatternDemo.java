public class CommandPatternDemo {

    public static void main(String[] args) {
        TextEditor textEditor = new TextEditor();
        TextField textField = new TextField("Initial text");

        System.out.println("\nEditing text field: " + textField);
        textEditor.execute(new UpperCase(), textField);
        textEditor.execute(new LowerCase(), textField);
        textEditor.execute(new Clear(), textField);
        textEditor.execute(new Edit("Updated text"), textField);

        System.out.println("\nUndoing all text field modifications:");
        textEditor.undo();
        textEditor.undo();
        textEditor.undo();
        textEditor.undo();

        System.out.println("\nRedoing all undone text field modifications:");
        textEditor.redo();
        textEditor.redo();
        textEditor.redo();
        textEditor.redo();
    }
}