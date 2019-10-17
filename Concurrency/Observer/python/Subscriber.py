import sys

sys.dont_write_bytecode = True;

class Subscriber:
    def __init__(self, name):
        self.name = name

    def update(self, message):
        print('{} got message "{}"'.format(self.name, message))
        
