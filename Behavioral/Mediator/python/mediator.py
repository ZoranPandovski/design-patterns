from __future__ import print_function

class User(object):
    def __init__(self, name, mediator):
        self.name = name
        self.mediator = mediator

    def send(self, message):
        mediator.ping(self.name, message)


class Mediator(object):
    def ping(self, name, message):
        print("User: {}: {}".format(name, message))

if __name__ == "__main__":
    mediator = Mediator()

    tom = User("Tom", mediator)
    mark = User("Mark", mediator)

    tom.send("What's up man?")
    mark.send("Not much!")
    
