import sys

sys.dont_write_bytecode = True;

from Subscriber import Subscriber
from Publisher import Publisher


def main():
    pub = Publisher(['lunch', 'dinner'])
    bob = Subscriber('Bob')
    alice = Subscriber('Alice')
    john = Subscriber('John')

    pub.register("lunch", bob)
    pub.register("dinner", alice)
    pub.register("lunch", john)
    pub.register("dinner", john)

    pub.dispatch("lunch", "It's lunchtime!")
    pub.dispatch("dinner", "Dinner is served")

if __name__ == "__main__":
    main()
