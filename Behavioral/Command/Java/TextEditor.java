import java.util.*;

public class TextEditor {

    private final Stack<Command> executedCommands = new Stack<>();
    private final Stack<Command> undoneCommands = new Stack<>();

    public void execute(Command command, TextField textField) {
        command.saveAndExecute(textField);
        executedCommands.add(command);
    }

    public void undo() {
        if (executedCommands.isEmpty()) {
            System.out.println("No commands to undo...");
            return;
        }

        Command command = executedCommands.pop();
        command.undo();
        undoneCommands.add(command);
    }

    public void redo() {
        if (undoneCommands.isEmpty()) {
            System.out.println("No commands redo...");
            return;
        }

        Command command = undoneCommands.pop();
        command.redo();
        executedCommands.add(command);
    }
}