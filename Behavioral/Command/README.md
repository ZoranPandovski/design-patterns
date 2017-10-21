# Command Pattern

> Encapsulate a request as an object, thereby letting you parameterize clients with different requests, queue or log requests, and support undoable operations.

Command pattern provides the caller (in this case `TextEditor`) and an object which has all the logic inside it needed to perform some specific tasks (in this case `Command`) against a target object (in this case `TextField`). The caller does not know anything about the command itself, only that it can execute it. Due to this, every command can be modified freely and the caller code will stay the same.

In most implementations of command pattern, the command provides `undo` and `redo`, actions. Due to this, the command pattern is mostly used when developing applications which make use of command history, for example a text or image editors.

For more information, Wikipedia provides a great overview of the pattern: [Wikipedia Article](https://en.wikipedia.org/wiki/Command_pattern)