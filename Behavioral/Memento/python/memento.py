class Originator:
    _state = None

    class Memento:
        def __init__(self, state):
            self._state = state

        def setState(self, state):
            self._state = state

        def getState(self):
            return self._state

    def __init__(self, state = None):
        self._state = state

    def set(self, state):
        if state != None:
            self._state = state

    def createMemento(self):
        return self.Memento(self._state)

    def restore(self, memento):
        self._state = memento.getState()
        return self._state

class Caretaker:
    pointer = 0
    savedStates = []
    def saveMemento(self, element):
        self.pointer  += 1
        self.savedStates.append(element)

    def getMemento(self, index):
        return self.savedStates[index-1]

    def undo(self):
        if self.pointer > 0:
            self.pointer -= 1
            return self.getMemento(self.pointer)
        else:
            return None

    def redo(self):
        if self.pointer < len(self.savedStates):
            self.pointer += 1
            return self.getMemento(self.pointer)
        else:
            return None



caretaker = Caretaker()
originator = Originator()


#Testing code
originator.set("Message")
caretaker.saveMemento(originator.createMemento())
print(originator.restore(caretaker.getMemento(caretaker.pointer)))
originator.set("Typo")
caretaker.saveMemento(originator.createMemento())
print(originator.restore(caretaker.getMemento(caretaker.pointer)))
originator.set(caretaker.undo())
print(originator.restore(caretaker.getMemento(caretaker.pointer)))
originator.set(caretaker.redo())
print(originator.restore(caretaker.getMemento(caretaker.pointer)))
