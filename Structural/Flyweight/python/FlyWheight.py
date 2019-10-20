class FlyWheight():

    def __init__(self, shared_state):
        self.shared_state = shared_state


class Context():

    def __init__(self, unique_state, flywheight: FlyWheight):
        self.unique_state = unique_state
        self.flywheight = flywheight

    def __repr__(self):
        return "unique: %s - shared: %s" % (self.unique_state, self.flywheight.shared_state)

class FlyWheightFactory():

    def __init__(self):
        self.flywheights = []

    def get_flyweight(self, shared_state) -> FlyWheight:

        flywheights = list(filter(lambda x: x.shared_state ==
                                  shared_state, self.flywheights))
        if len(flywheights) > 0:
            return flywheights[0]
        else:
            flywheight = FlyWheight(shared_state)
            self.flywheights.append(flywheight)
            return flywheight

    @property
    def total(self):
        return len(self.flywheights)


class Client():

    def __init__(self, flywheight_factory: FlyWheightFactory):
        self.flywheight_factory = flywheight_factory
        self.contexts = []

    def get_context(self, unique_state, shared_state) -> Context:
        
        flywheight = self.flywheight_factory.get_flyweight(shared_state)
        context = Context(unique_state, flywheight)
        self.contexts.append(context)
        
        return context


def main():
    flywheight_factory = FlyWheightFactory()
    client = Client(flywheight_factory)

    shared_states = ['Alpha', 'Beta', 'Gamma']
    unique_states = list(range(10))

    contexts = [client.get_context(x, y) for x in unique_states for y in shared_states]

    print("Contexts:", len(contexts))
    print("Flywheights:", flywheight_factory.total)
    

if __name__ == "__main__":
    main() 