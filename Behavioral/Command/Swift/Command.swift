
//===----------------------------------------------------------------------===//
// TextEditor
//===----------------------------------------------------------------------===//

class TextEditor {
    
    var executedCommands: [Command] = []
    var undoneCommands: [Command] = []
    
    func execute(_ command: Command, on textField: TextField) {
        var cmd = command
        cmd.saveAndExecute(on: textField)
        executedCommands.append(cmd)
    }
    func undo() {
        guard let command = executedCommands.popLast() else {
            print("Nothing to undo.")
            return
        }
        command.undo()
        undoneCommands.append(command)
    }
    func redo() {
        guard let command = undoneCommands.popLast() else {
            print("Nothing to redo.")
            return
        }
        command.redo()
        executedCommands.append(command)
    }
    
}

//===----------------------------------------------------------------------===//
// TextField
//===----------------------------------------------------------------------===//

class TextField {
    
    var text: String
    init(text: String) {
        self.text = text
    }
    
}

//===----------------------------------------------------------------------===//
// Command protocol
//===----------------------------------------------------------------------===//

protocol Command {
    
    var savedTextField: TextField! { get set }
    var savedText: String! { get set }
    
    func execute(on textField: TextField)
    mutating func saveAndExecute(on textField: TextField)
    func undo()
    func redo()
    
}
extension Command {
    
    mutating func saveAndExecute(on textField: TextField) {
        savedTextField = textField
        savedText = textField.text
        execute(on: textField)
    }
    func undo() {
        savedTextField.text = savedText
    }
    func redo() {
        execute(on: savedTextField)
    }
    
}

//===----------------------------------------------------------------------===//
// TextEditor commands
//===----------------------------------------------------------------------===//

struct UpperCaseCommand: Command {
    
    var savedTextField: TextField!
    var savedText: String!
    
    func execute(on textField: TextField) {
        textField.text = textField.text.uppercased()
    }
    
}
struct LowerCaseCommand: Command {
    
    var savedTextField: TextField!
    var savedText: String!
    
    func execute(on textField: TextField) {
        textField.text = textField.text.lowercased()
    }
    
}
struct ClearCommand: Command {
    
    var savedTextField: TextField!
    var savedText: String!
    
    func execute(on textField: TextField) {
        textField.text = ""
    }
    
}
struct EditCommand: Command {
    
    var savedTextField: TextField!
    var savedText: String!
    
    private let newText: String
    init(newText: String) {
        self.newText = newText
    }

    func execute(on textField: TextField) {
        textField.text = newText
    }
    
}

//===----------------------------------------------------------------------===//
// Demo
//===----------------------------------------------------------------------===//

let textEditor = TextEditor()
let textField = TextField(text: "Initial text")


print("""
    Editing text field: \(textField.text)
    ---
    """)
textEditor.execute(UpperCaseCommand(), on: textField)
print("UpperCaseCommand: \(textField.text)")
textEditor.execute(LowerCaseCommand(), on: textField)
print("LowerCaseCommand: \(textField.text)")
textEditor.execute(ClearCommand(), on: textField)
print("ClearCommand: \(textField.text)")
textEditor.execute(EditCommand(newText: "Updated Command"), on: textField)
print("EditCommand: \(textField.text)\n")


print("""
    Undoing all text field modifications
    ---
    """)
textEditor.undo()
print("Undo: \(textField.text)")
textEditor.undo()
print("Undo: \(textField.text)")
textEditor.undo()
print("Undo: \(textField.text)")
textEditor.undo()
print("Undo: \(textField.text)\n")


print("""
    Redoing all undone text field modifications
    ---
    """)
textEditor.redo()
print("Redo: \(textField.text)")
textEditor.redo()
print("Redo: \(textField.text)")
textEditor.redo()
print("Redo: \(textField.text)")
textEditor.redo()
print("Redo: \(textField.text)\n")
